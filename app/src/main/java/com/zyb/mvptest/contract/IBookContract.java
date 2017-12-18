package com.zyb.mvptest.contract;

import com.zyb.mvptest.base.BasePresenter;
import com.zyb.mvptest.base.IBaseView;

import java.util.List;

/**
 * Created by zhangyb on 2017/3/8.
 * function:关联 LoginPresenter 和 LoginActivity(也就是view) 的契约接口类，定义了两个类需要实现的接口。
 */
public interface IBookContract {

    /*
    * LoginPresenter 实现此接口
    * */
    abstract class AbstractBookPresenter extends BasePresenter<IBookView> {
        public abstract void getBookList();
    }

    /*
    * LoginView 实现此接口
    * */
    interface IBookView extends IBaseView {
        void showBookList(List<String> books);
    }
}
