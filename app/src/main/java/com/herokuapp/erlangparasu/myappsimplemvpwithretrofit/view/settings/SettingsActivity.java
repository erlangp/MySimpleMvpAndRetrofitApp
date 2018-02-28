package com.herokuapp.erlangparasu.myappsimplemvpwithretrofit.view.settings;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.herokuapp.erlangparasu.myappsimplemvpwithretrofit.R;

public class SettingsActivity extends AppCompatActivity implements SettingsContract.View {

    private static final String TAG = "Tag." + SettingsActivity.class.getSimpleName();

    private SettingsContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        mPresenter = new SettingsPresenter(this);
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
    public void setPresenter(SettingsContract.Presenter presenter) {
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showActivityTitle(String title) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(title);
    }
}
