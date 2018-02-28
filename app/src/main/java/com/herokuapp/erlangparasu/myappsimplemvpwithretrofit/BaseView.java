package com.herokuapp.erlangparasu.myappsimplemvpwithretrofit;

/**
 * Created by erlangparasu on 2/23/18.
 */

public interface BaseView<T> {

    void setPresenter(T presenter);
}
