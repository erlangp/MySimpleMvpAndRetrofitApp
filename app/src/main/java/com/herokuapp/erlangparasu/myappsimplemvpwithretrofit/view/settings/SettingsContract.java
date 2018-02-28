package com.herokuapp.erlangparasu.myappsimplemvpwithretrofit.view.settings;


import com.herokuapp.erlangparasu.myappsimplemvpwithretrofit.BasePresenter;
import com.herokuapp.erlangparasu.myappsimplemvpwithretrofit.BaseView;

/**
 * Created by erlangparasu on 2/23/18.
 */

public interface SettingsContract {

    interface View extends BaseView<Presenter> {

        void showToast(String message);

        void showActivityTitle(String title);
    }

    interface Presenter extends BasePresenter {
    }
}
