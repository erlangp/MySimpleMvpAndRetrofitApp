package com.herokuapp.erlangparasu.myappsimplemvpwithretrofit.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.herokuapp.erlangparasu.myappsimplemvpwithretrofit.R;
import com.herokuapp.erlangparasu.myappsimplemvpwithretrofit.model.search_repository.Item;
import com.herokuapp.erlangparasu.myappsimplemvpwithretrofit.view.settings.SettingsActivity;

import java.lang.ref.WeakReference;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    public static final int REQUEST_CODE_SETTINGS = 1;

    private ConstraintLayout mConstraintLayout;
    private Toolbar mToolbar;
    private EditText mEditText;
    private TextView mTextView;
    private FloatingActionButton mFab;

    private MainContract.Presenter mPresenter;
    private ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainPresenter(new WeakReference<>(this).get());

        initViews();
        setupViews();
    }

    private void initViews() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mConstraintLayout = (ConstraintLayout) findViewById(R.id.constraint_layout_root);
        mEditText = (EditText) findViewById(R.id.edit_text_search);
        mTextView = (TextView) findViewById(R.id.text_view_1);
        mFab = (FloatingActionButton) findViewById(R.id.fab);
    }

    private void setupViews() {
        setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onTextClick();
            }
        });

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textToSearch = mEditText.getText().toString();
                mPresenter.onFabClick(textToSearch);
            }
        });
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            mPresenter.onActionSettingsClick();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        // Do nothing.
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSettingsActivity() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivityForResult(intent, REQUEST_CODE_SETTINGS);
    }

    @Override
    public void showActivityTitle(String title) {
        mActionBar.setTitle(title);
    }

    @Override
    public void showText(String text) {
        mTextView.setText(text);
    }

    @Override
    public void showData(List<Item> items) {
        // Append text
        int number = 0;
        for (Item item : items) {
            number++;

            mTextView.append(String.valueOf(number));
            mTextView.append(" ");
            mTextView.append(item.getFullName());

            if (number < items.size()) {
                mTextView.append("\n");
                mTextView.append("\n");
            }
        }
    }

    @Override
    public void showSnackbar(String message) {
        Snackbar.make(mConstraintLayout, message, Snackbar.LENGTH_SHORT)
                .show();
    }
}
