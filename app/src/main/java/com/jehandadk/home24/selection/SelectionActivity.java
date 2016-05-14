package com.jehandadk.home24.selection;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jehandadk.home24.R;
import com.jehandadk.home24.base.BaseActivity;
import com.jehandadk.home24.models.Article;
import com.jehandadk.home24.models.ArticleListResponse;
import com.jehandadk.home24.reviews.ReviewsActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SelectionActivity extends BaseActivity {
    public static final String KEY_ARTICLE_LIST = "ARTICLE_LIST";
    static final ButterKnife.Action<View> SET_VISIBLE = new ButterKnife.Action<View>() {
        @Override
        public void apply(@NonNull View view, int index) {
            view.setVisibility(View.VISIBLE);
        }
    };
    static final ButterKnife.Action<View> SET_INVISIBLE = new ButterKnife.Action<View>() {
        @Override
        public void apply(@NonNull View view, int index) {
            view.setVisibility(View.INVISIBLE);
        }
    };
    @BindView(R.id.img_article)
    ImageView imgArticle;
    @BindView(R.id.txt_reviews_counter)
    TextView txtReviewsCounter;
    @BindViews({R.id.btn_like, R.id.btn_dislike, R.id.img_article})
    List<View> beforeReviews;
    @BindViews({R.id.btn_done, R.id.txt_empty})
    List<View> afterReviews;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private int likeCount = 0;
    private List<Article> articles;
    private int currArticle = -1;

    public static Intent newIntent(Activity act, ArticleListResponse data) {
        Intent intent = new Intent(act, SelectionActivity.class);
        intent.putExtra(KEY_ARTICLE_LIST, getGson().toJson(data));
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        ButterKnife.bind(this);

        articles = getGson()
                .fromJson(getIntent().getStringExtra(KEY_ARTICLE_LIST), ArticleListResponse.class)
                .getEmbedded()
                .getArticles();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        showNextArticle();
        updateCounter();

    }

    protected void showNextArticle() {
        if (++currArticle >= articles.size()) {
            showEmptyView();
            return;
        }
        Glide.with(this)
                .load(articles.get(currArticle).getMedia().get(0).getUri())
                .crossFade(1500)
                .into(imgArticle);
        Glide.with(this).load(articles.get((currArticle + 1) % articles.size())
                .getMedia().get(0).getUri())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .preload();
    }

    private void showEmptyView() {
        ButterKnife.apply(afterReviews, SET_VISIBLE);
        ButterKnife.apply(beforeReviews, SET_INVISIBLE);
    }

    @OnClick(R.id.btn_like)
    public void likeArticle() {
        articles.get(currArticle).setLiked(true);
        likeCount++;
        updateCounter();
        showNextArticle();
    }

    private void updateCounter() {
        txtReviewsCounter.setText(likeCount + "/" + articles.size());
    }

    @OnClick(R.id.btn_dislike)
    public void dislikeArticle() {
        articles.get(currArticle).setDisliked(true);
        showNextArticle();
    }

    @OnClick(R.id.btn_done)
    public void openReviews() {
        startActivity(ReviewsActivity.newIntent(this, articles));
    }

}
