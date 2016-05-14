package com.jehandadk.home24.reviews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.reflect.TypeToken;
import com.jehandadk.home24.R;
import com.jehandadk.home24.base.BaseActivity;
import com.jehandadk.home24.models.Article;

import java.util.List;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;


public class ReviewsActivity extends BaseActivity {

    public static final String KEY_ARTICLE_LIST = "ARTICLE_LIST";
    @BindInt(R.integer.cols_products_grid)
    int coloumns;
    @BindView(R.id.list_articles)
    RecyclerView listArticles;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private ArticlesAdapter adapter;
    private List<Article> articles;
    private boolean isDislplayedAsGrid = false;

    public static Intent newIntent(Activity act, List<Article> data) {
        Intent intent = new Intent(act, ReviewsActivity.class);
        intent.putExtra(KEY_ARTICLE_LIST, getGson().toJson(data));
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        articles = getGson().fromJson(getIntent().getStringExtra(KEY_ARTICLE_LIST), new TypeToken<List<Article>>() {
        }.getType());

        adapter = new ArticlesAdapter(articles, null);
        listArticles.setAdapter(adapter);
        listArticles.setHasFixedSize(false);
        showAsGrid();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_reviews, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menuGrid:
                showAsGrid();
                return true;
            case R.id.menuList:
                showAsList();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showAsGrid() {
        if (isDislplayedAsGrid) return;
        adapter.setViewType(ArticlesAdapter.GRID);
        listArticles.setLayoutManager(new StaggeredGridLayoutManager(coloumns, StaggeredGridLayoutManager.VERTICAL));
        isDislplayedAsGrid = true;
    }

    private void showAsList() {
        if (!isDislplayedAsGrid) return;
        adapter.setViewType(ArticlesAdapter.LIST);
        listArticles.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        isDislplayedAsGrid = false;
    }

}
