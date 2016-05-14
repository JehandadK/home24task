package com.jehandadk.home24.reviews;

import android.support.annotation.IntDef;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jehandadk.home24.R;
import com.jehandadk.home24.models.Article;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by jehandad.kamal on 5/14/2016.
 */
public class ArticlesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int GRID = 0;
    public static final int LIST = 1;
    protected List<Article> list;
    ItemClickedListener listener;
    int displayType = GRID;

    public ArticlesAdapter(List<Article> list, ItemClickedListener listener) {
        this.list = list;
        this.listener = listener;
        setHasStableIds(true);
    }

    public ArticlesAdapter(ItemClickedListener listener) {
        this(new ArrayList<Article>(), listener);
    }

    @Override
    public int getItemViewType(int position) {
        return displayType;
    }

    @Override
    public long getItemId(int position) {
        switch (displayType) {
            case LIST:
                return list.size() + position;
            case GRID:
        }
        return position;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public List<Article> getList() {
        return list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (displayType) {
            case GRID:
                return new GridHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article_grid, null));
            case LIST:
                return new ListHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article_list, null));

        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (displayType) {
            case GRID:
                onBindGridViewHolder((GridHolder) holder, list.get(position));
                break;
            case LIST:
                onBindListViewHolder((ListHolder) holder, list.get(position));
                break;
        }
    }

    public void setViewType(@DisplayMode int type) {
        this.displayType = type;
//        notifyDataSetChanged();
    }

    public void onBindGridViewHolder(GridHolder holder, Article item) {
        Glide.with(holder.itemView.getContext()).load(item.getMedia().get(0).getUri())
                .placeholder(R.drawable.img_placeholder_loading)
                .crossFade()
                .into(holder.imgProduct);
        if (item.isLiked()) holder.imgProduct.setBackgroundResource(R.drawable.bg_green);
        if (item.isDisliked()) holder.imgProduct.setBackgroundResource(R.drawable.bg_red);
    }

    public void onBindListViewHolder(ListHolder holder, Article item) {
        Glide.with(holder.itemView.getContext()).load(item.getMedia().get(0).getUri())
                .placeholder(R.drawable.img_placeholder_loading)
                .crossFade()
                .into(holder.imgProduct);
        if (item.isLiked()) {
            holder.txtLike.setBackgroundResource(R.drawable.bg_green);
            holder.txtLike.setText(holder.txtLike.getResources().getString(R.string.like));
        }
        if (item.isDisliked()) {
            holder.txtLike.setBackgroundResource(R.drawable.bg_red);
            holder.txtLike.setText(holder.txtLike.getResources().getString(R.string.dislike));
        }
        holder.txtProductTitle.setText(item.getTitle());
    }

    public void addAll(List<Article> newItems) {
        list.addAll(newItems);
        notifyDataSetChanged();
    }

    public void setAll(List<Article> newItems) {
        list.clear();
        list.addAll(newItems);
        notifyDataSetChanged();
    }

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({GRID, LIST})
    public @interface DisplayMode {
    }

    public interface ItemClickedListener {
        void onItemClicked(Article item);
    }

    public class GridHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_product)
        public ImageView imgProduct;

        public GridHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class ListHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_product)
        public ImageView imgProduct;
        @BindView(R.id.txt_product_title)
        public TextView txtProductTitle;
        @BindView(R.id.txt_like)
        public TextView txtLike;

        public ListHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
