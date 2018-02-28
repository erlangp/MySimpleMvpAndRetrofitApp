package com.herokuapp.erlangparasu.myappsimplemvpwithretrofit.view.main;

import android.support.annotation.NonNull;

import com.herokuapp.erlangparasu.myappsimplemvpwithretrofit.data.remote.IApiService;
import com.herokuapp.erlangparasu.myappsimplemvpwithretrofit.data.remote.RetrofitHelper;
import com.herokuapp.erlangparasu.myappsimplemvpwithretrofit.model.search_repository.ExampleRB;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by erlangparasu on 2/23/18.
 */

public class MainPresenter implements MainContract.Presenter {

    private boolean mIsActive;

    private MainContract.View mView; // MVP View

    // Constructor ---------------------------------------------------------------------------------

    public MainPresenter(MainContract.View view) {
        mView = view;
    }

    // Implements Presenter ------------------------------------------------------------------------

    @Override
    public void subscribe() {
        mView.showActivityTitle("Main");
        mIsActive = true;
    }

    @Override
    public void unsubscribe() {
        mIsActive = false;
    }

    @Override
    public void onActionSettingsClick() {
        mView.showToast("Settings menu clicked");
        mView.showSettingsActivity();
    }

    @Override
    public void onFabClick(String textToSearch) {
        mView.showToast("FAB clicked");

        if (!mIsActive) {
            return;
        }

        if (textToSearch.isEmpty()) {
            mView.showToast("Search field cannot be empty");
            return;
        }

        loadAsyncRepository(textToSearch);
    }

    @Override
    public void onTextClick() {
        String timestamp = String.valueOf(Calendar.getInstance().getTimeInMillis());
        mView.showText("TextView clicked. Timestamp: " + timestamp + ".");
    }

    // Custom methods ------------------------------------------------------------------------------

    private void loadAsyncRepository(String repositoryName) {
        mView.showText("Searching. Please wait...");
        RetrofitHelper.getInstance()
                .create(IApiService.class)
                .searchRepository(repositoryName)
                .enqueue(new Callback<ExampleRB>() {
                    @Override
                    public void onResponse(@NonNull Call<ExampleRB> call, @NonNull Response<ExampleRB> response) {
                        mView.showText(""); // Reset text
                        ExampleRB exampleRB = response.body();
                        if (exampleRB == null) {
                            mView.showText("ERROR_1");
                            mView.showSnackbar("Failed to get repository [1]");
                            return;
                        }
                        mView.showData(exampleRB.getItems());
                    }

                    @Override
                    public void onFailure(@NonNull Call<ExampleRB> call, @NonNull Throwable t) {
                        mView.showText("ERROR_2");
                        mView.showSnackbar("Failed to get repository [2]");
                    }
                });
    }
}
