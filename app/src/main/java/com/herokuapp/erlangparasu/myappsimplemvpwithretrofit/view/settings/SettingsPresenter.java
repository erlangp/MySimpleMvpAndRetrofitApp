package com.herokuapp.erlangparasu.myappsimplemvpwithretrofit.view.settings;

/**
 * Created by erlangparasu on 2/23/18.
 */

public class SettingsPresenter implements SettingsContract.Presenter {

    private static final String TAG = "Tag." + SettingsPresenter.class.getSimpleName();

    private SettingsContract.View mView; // MVP View

    public SettingsPresenter(SettingsContract.View view) {
        mView = view;
    }

    @Override
    public void subscribe() {
        mView.showActivityTitle("Settings");
        mView.showToast("Welcome to Settings Activity");
    }

    @Override
    public void unsubscribe() {
    }
}
