package com.zyb.mvptest.contract;

import com.zyb.mvptest.base.BasePresenter;
import com.zyb.mvptest.base.IBaseView;

/**
 * Created by zhangyb on 2017/3/8.
 * function
 */
public interface ILoginContract {

    /*
    * LoginPresenter 继承此抽象类，并实现 login()
    * */
    abstract class AbstractLoginPresenter extends BasePresenter<ILoginView> {
        public abstract void login();
    }

    /*
    * LoginView 实现此接口
    * */
    interface ILoginView extends IBaseView {
        String getUserName();

        String getUserPassword();

        void ToMainActivity();

        void showFailedToast();
    }
}
