package com.zyb.mvptest.base;

/**
 * Created by zhangyb on 2017/12/15.
 */

public abstract class BasePresenter<V> {
    public V mIView;

    public void attachView(V v) {
        mIView = v;
    }

    public void detachView() {
        mIView = null;
    }
}
