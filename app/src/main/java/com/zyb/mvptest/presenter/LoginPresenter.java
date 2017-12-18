package com.zyb.mvptest.presenter;

import com.zyb.mvptest.contract.ILoginContract;
import com.zyb.mvptest.model.LoginModel;

/**
 * Created by zhangyb on 2017/3/8.
 */
public class LoginPresenter extends ILoginContract.AbstractLoginPresenter implements LoginModel.ILoginResultListener {

    private LoginModel loginModel;

    public LoginPresenter() {
        loginModel = LoginModel.getInstance();
        loginModel.setLoginListener(this);
    }

    @Override
    public void login() {
        String userName = mIView.getUserName();
        String password = mIView.getUserPassword();

        loginModel.Login(userName, password);
        mIView.showLoadingDialog();
    }

    @Override
    public void loginSuccess() {
        mIView.dismissLoadingDialog();
        mIView.ToMainActivity();
    }

    @Override
    public void loginFailed() {
        mIView.dismissLoadingDialog();
        mIView.showFailedToast();
    }
}
