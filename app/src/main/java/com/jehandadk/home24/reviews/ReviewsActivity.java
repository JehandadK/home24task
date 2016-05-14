package com.jehandadk.home24.reviews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.jehandadk.home24.R;
import com.jehandadk.home24.base.BaseActivity;
import com.jehandadk.home24.models.Article;

import java.util.List;


public class ReviewsActivity extends BaseActivity {

    public static final String KEY_ARTICLE_LIST = "ARTICLE_LIST";
    private List<Article> articles;

    public static Intent newIntent(Activity act, List<Article> data) {
        Intent intent = new Intent(act, ReviewsActivity.class);
        intent.putExtra(KEY_ARTICLE_LIST, getGson().toJson(data));
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
