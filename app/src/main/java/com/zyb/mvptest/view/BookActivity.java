package com.zyb.mvptest.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zyb.mvptest.R;
import com.zyb.mvptest.base.BaseMVPActivity;
import com.zyb.mvptest.base.BasePresenter;
import com.zyb.mvptest.contract.IBookContract;
import com.zyb.mvptest.contract.IBookContract.IBookView;
import com.zyb.mvptest.presenter.BookPresenter;

import java.util.List;

/**
 * Created by zhangyb on 2017/12/14.
 * function:
 */

public class BookActivity extends BaseMVPActivity<IBookContract.AbstractBookPresenter> implements IBookView {

    private ListView bookListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        bookListView = (ListView) findViewById(R.id.book_list_view);
        loadingDialog = new ProgressDialog(this);
        loadingDialog.setMessage("请稍后...");

        mPresenter.getBookList();
    }

    @Override
    public BasePresenter initPresenter() {
        return new BookPresenter();
    }

    @Override
    public void showBookList(List<String> books) {
        bookListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, books));
    }
}
