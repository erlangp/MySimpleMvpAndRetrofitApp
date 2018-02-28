package com.herokuapp.erlangparasu.myappsimplemvpwithretrofit.view.detail;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.herokuapp.erlangparasu.myappsimplemvpwithretrofit.R;

public class DetailActivity extends AppCompatActivity implements DetailContract.View {

    private static final String TAG = "Tag." + DetailActivity.class.getSimpleName();

    private DetailContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mPresenter = new DetailPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

    @Override
    public void setPresenter(DetailContract.Presenter presenter) {
    }

    @Override
    public void showActivityTitle(String title) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(title);
    }
}
