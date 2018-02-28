package com.herokuapp.erlangparasu.myappsimplemvpwithretrofit.view.detail;


import com.herokuapp.erlangparasu.myappsimplemvpwithretrofit.BasePresenter;
import com.herokuapp.erlangparasu.myappsimplemvpwithretrofit.BaseView;

/**
 * Created by erlangparasu on 2/23/18.
 */

public interface DetailContract {

    interface View extends BaseView<Presenter> {
        void showActivityTitle(String title);
    }

    interface Presenter extends BasePresenter {
    }
}
