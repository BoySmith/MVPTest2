package com.zyb.mvptest.presenter;

import com.zyb.mvptest.contract.IBookContract;
import com.zyb.mvptest.model.BookModel;

import java.util.List;

/**
 * Created by zhangyb on 2017/3/8.
 */
public class BookPresenter extends IBookContract.AbstractBookPresenter implements BookModel.IGetBookResultListener {

    private BookModel bookModel;

    public BookPresenter() {
        bookModel = BookModel.getInstance();
        bookModel.setGetBookResultListener(this);
    }

    @Override
    public void getBookList() {
        mIView.showLoadingDialog();
        bookModel.getBookList();
    }

    @Override
    public void getBookSuccess(List<String> bookList) {
        mIView.dismissLoadingDialog();
        mIView.showBookList(bookList);
    }
}
