package com.herokuapp.erlangparasu.myappsimplemvpwithretrofit.view.main;


import com.herokuapp.erlangparasu.myappsimplemvpwithretrofit.BasePresenter;
import com.herokuapp.erlangparasu.myappsimplemvpwithretrofit.BaseView;
import com.herokuapp.erlangparasu.myappsimplemvpwithretrofit.model.search_repository.Item;

import java.util.List;

/**
 * Created by erlangparasu on 2/23/18.
 */

public interface MainContract {

    interface View extends BaseView<Presenter> {

        void showToast(String message);

        void showSettingsActivity();

        void showActivityTitle(String title);

        void showText(String text);

        void showData(List<Item> items);

        void showSnackbar(String message);
    }

    interface Presenter extends BasePresenter {

        void onActionSettingsClick();

        void onFabClick(String textToSearch);

        void onTextClick();
    }
}
