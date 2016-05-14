package com.jehandadk.home24.start;

import android.os.Bundle;

import com.jehandadk.home24.R;
import com.jehandadk.home24.api.IApiClient;
import com.jehandadk.home24.base.BaseActivity;
import com.jehandadk.home24.models.ArticleListResponse;
import com.jehandadk.home24.selection.SelectionActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class StartActivity extends BaseActivity {

    @Inject
    IApiClient api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);
        getMainComponent().inject(this);
    }

    @OnClick(R.id.btn_start)
    public void loadData() {
        onLoadingStarted();
        api.getArticles(10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ArticleListResponse>() {
                    @Override
                    public void onCompleted() {
                        onLoadingFinished();
                    }

                    @Override
                    public void onError(Throwable e) {
                        onLoadingFinished();
                        showError(getString(R.string.msg_err_internet));
                    }

                    @Override
                    public void onNext(ArticleListResponse articleListResponse) {
                        startActivity(SelectionActivity.newIntent(StartActivity.this, articleListResponse));
                    }
                });
    }
}
