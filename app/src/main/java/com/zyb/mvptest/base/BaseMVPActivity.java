package com.zyb.mvptest.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

/**
 * Created by zhangyb on 2017/12/18.
 */

public abstract class BaseMVPActivity<P extends BasePresenter> extends FragmentActivity implements IBaseView {
    public P mPresenter;

    public ProgressDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = (P) initPresenter();
        mPresenter.attachView(this);

        loadingDialog = new ProgressDialog(this);
        loadingDialog.setMessage("请稍后...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    public void showLoadingDialog() {
        loadingDialog.show();
    }

    @Override
    public void dismissLoadingDialog() {
        loadingDialog.dismiss();
    }
}
