package com.jehandadk.home24.start;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.jehandadk.home24.R;
import com.jehandadk.home24.api.IApiClient;
import com.jehandadk.home24.base.BaseActivity;
import com.jehandadk.home24.base.ICancellableTask;
import com.jehandadk.home24.models.ArticleListResponse;
import com.jehandadk.home24.selection.SelectionActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class StartActivity extends BaseActivity implements ICancellableTask {

    private static final long DELAY = 200;
    private static final long DURATION = 2000;
    @Inject
    IApiClient api;
    @BindView(R.id.img_logo)
    ImageView imgLogo;
    Subscription subscription;
    private boolean animated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);
        getMainComponent().inject(this);
    }

    @OnClick(R.id.btn_start)
    public void loadData() {
        onLoadingStarted(this);
        subscription = api.getArticles(10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ArticleListResponse>() {
                    @Override
                    public void onCompleted() {
                        onLoadingFinished(StartActivity.this);
                    }

                    @Override
                    public void onError(Throwable e) {
                        onLoadingFinished(StartActivity.this);
                        showError(getString(R.string.msg_err_internet));
                    }

                    @Override
                    public void onNext(ArticleListResponse articleListResponse) {
                        startActivity(SelectionActivity.newIntent(StartActivity.this, articleListResponse));
                    }
                });
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (!hasFocus || animated) {
            return;
        }
        animate();
        super.onWindowFocusChanged(hasFocus);
    }

    private void animate() {
        animateLogo();
        animateInAllViews();
    }

    private void animateInAllViews() {
        ViewGroup container = (ViewGroup) findViewById(R.id.container);

        for (int i = 0; i < container.getChildCount(); i++) {
            View v = container.getChildAt(i);
            if (v.getId() == imgLogo.getId()) continue;
            ViewCompat.animate(v)
                    .scaleY(1).scaleX(1)
                    .translationY(50).alpha(1)
                    .setStartDelay(DELAY)
                    .setDuration(DURATION).
                    setInterpolator(new DecelerateInterpolator()).start();
        }
    }

    private void animateLogo() {
        ViewCompat.animate(imgLogo)
                .translationY(-100)
                .setStartDelay(DELAY)
                .setDuration(DURATION).setInterpolator(
                new DecelerateInterpolator(1.2f)).start();
    }

    @Override
    public void cancelled() {
        if (subscription == null) return;
        subscription.unsubscribe();
    }
}
