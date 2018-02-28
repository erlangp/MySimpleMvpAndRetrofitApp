package com.herokuapp.erlangparasu.myappsimplemvpwithretrofit.view.detail;

/**
 * Created by erlangparasu on 2/23/18.
 */

public class DetailPresenter implements DetailContract.Presenter {

    private static final String TAG = "Tag." + DetailPresenter.class.getSimpleName();

    private DetailContract.View mView; // MVP View

    public DetailPresenter(DetailContract.View view) {
        mView = view;
    }

    @Override
    public void subscribe() {
        mView.showActivityTitle("Detail");
    }

    @Override
    public void unsubscribe() {
    }
}
