package com.jehandadk.home24.base;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jehandadk.home24.App;
import com.jehandadk.home24.R;
import com.jehandadk.home24.api.GsonFactory;
import com.jehandadk.home24.modules.MainComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jehandad.kamal on 5/14/2016.
 */
public abstract class BaseActivity extends AppCompatActivity implements ILoadingListener, DialogInterface.OnDismissListener, DialogInterface.OnCancelListener {

    final AtomicInteger loaderCount = new AtomicInteger(0);
    ProgressDialog mProgressDialog;
    List<ICancellableTask> tasks = new ArrayList<>();
    private boolean isResumed = false;

    public static Gson getGson() {
        return GsonFactory.getGson();
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
    public void onLoadingStarted(ICancellableTask task) {
        int i = loaderCount.incrementAndGet();
        tasks.add(task);
        if (i > 0 && isResumed && mProgressDialog == null) showProgressDialog();
    }

    @Override
    public void onLoadingFinished(ICancellableTask task) {
        tasks.remove(task);
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
        mProgressDialog.setOnCancelListener(this);
        mProgressDialog.setOnDismissListener(this);
        mProgressDialog.show();
    }


    @Override
    public void onCancel(DialogInterface dialog) {
        for (ICancellableTask task : tasks) {
            task.cancelled();
        }
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        tasks.clear();
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
