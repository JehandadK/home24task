package com.jehandadk.home24.base;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jehandadk.home24.App;
import com.jehandadk.home24.R;
import com.jehandadk.home24.modules.MainComponent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jehandad.kamal on 5/14/2016.
 */
public abstract class BaseActivity extends AppCompatActivity implements LoadingListener {

    final AtomicInteger loaderCount = new AtomicInteger(0);
    ProgressDialog mProgressDialog;
    private boolean isResumed = false;

    public static Gson getGson() {
        return new GsonBuilder().create();
    }

    @Override
    protected void onPause() {
        super.onPause();
        isResumed = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        isResumed = true;
        if (loaderCount.get() > 0) showProgressDialog();
        else hideProgressDialog();
    }

    @Override
    public void onLoadingStarted() {
        int i = loaderCount.incrementAndGet();
        if (i > 0 && isResumed && mProgressDialog == null) showProgressDialog();
    }

    @Override
    public void onLoadingFinished() {
        if (loaderCount.decrementAndGet() == 0)
            hideProgressDialog();
    }

    private void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            try {
                mProgressDialog.dismiss();
            } catch (Exception e) {
            }
        }
        mProgressDialog = null;
    }

    private void showProgressDialog() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setCancelable(true);
        mProgressDialog.setMessage(getString(R.string.msg_loading));
        mProgressDialog.show();
    }

    protected App getApp() {
        return (App) getApplication();
    }

    protected MainComponent getMainComponent() {
        return getApp().getMainComponent();
    }

    protected void showError(String string) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }
}
