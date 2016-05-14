package com.jehandadk.home24.selection;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.jehandadk.home24.R;
import com.jehandadk.home24.base.BaseActivity;
import com.jehandadk.home24.models.Article;
import com.jehandadk.home24.models.ArticleListResponse;

import java.util.List;

public class SelectionActivity extends BaseActivity {
    public static final String KEY_ARTICLE_LIST = "ARTICLE_LIST";

    private ArticleListResponse data;
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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
