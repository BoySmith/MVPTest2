package com.zyb.mvptest.base;

/**
 * Created by zhangyb on 2017/12/14.
 */

public interface IBaseView {
    BasePresenter initPresenter();

    void showLoadingDialog();

    void dismissLoadingDialog();
}
