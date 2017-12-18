package com.zyb.mvptest.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zyb.mvptest.R;
import com.zyb.mvptest.base.BaseMVPActivity;
import com.zyb.mvptest.base.BasePresenter;
import com.zyb.mvptest.contract.ILoginContract;
import com.zyb.mvptest.presenter.LoginPresenter;

/**
 * Created by zhangyb on 2017/3/8.
 * function:
 */

public class LoginActivity extends BaseMVPActivity<ILoginContract.AbstractLoginPresenter>
        implements ILoginContract.ILoginView, View.OnClickListener {

    private EditText userNameEditText;
    private EditText passwordEditText;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userNameEditText = (EditText) findViewById(R.id.userNameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        mPresenter.login();
    }

    @Override
    public BasePresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    public String getUserName() {
        return userNameEditText.getText().toString();
    }

    @Override
    public String getUserPassword() {
        return passwordEditText.getText().toString();
    }

    @Override
    public void ToMainActivity() {
        startActivity(new Intent(this, BookActivity.class));
    }

    @Override
    public void showFailedToast() {
        Toast.makeText(this, "登陆失败，请重新检测你的用户名或密码", Toast.LENGTH_SHORT).show();
    }
}
