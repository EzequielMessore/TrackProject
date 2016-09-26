package com.br.traktproject.controllers.activities;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.br.traktproject.R;
import com.br.traktproject.adapter.SeasonListAdapter;
import com.br.traktproject.entities.Season;
import com.br.traktproject.interfaces.OnErrorListener;
import com.br.traktproject.interfaces.OnSuccessListener;
import com.br.traktproject.service.SeasonService;

import java.util.List;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by Ezequiel Messore on 23/09/2016.
 * ezequielmessore.developer@gmail.com
 */

public class ItemListActivity extends AppCompatActivity {

    private boolean mTwoPane;
    private RecyclerView mRecyclerView;
    private View mFrameLayout;
    private ContentLoadingProgressBar mProgressBar;
    private TextView mTvError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        mRecyclerView = (RecyclerView) findViewById(R.id.item_list);
        mFrameLayout = findViewById(R.id.frameLayout);
        mProgressBar = (ContentLoadingProgressBar) findViewById(R.id.progressBar);
        mTvError = (TextView) findViewById(R.id.tvError);
        assert mRecyclerView != null;
        if (findViewById(R.id.item_detail_container) != null) {
            mTwoPane = true;
        }

        SeasonService.getInstance(new OnSuccessListener<List<Season>>() {
            @Override
            public void onSuccess(final List<Season> seasons) {
                configureAdapter(seasons);
                mFrameLayout.setVisibility(VISIBLE);
                mProgressBar.hide();
                mTvError.setVisibility(GONE);
            }
        }, new OnErrorListener<Exception>() {
            @Override
            public void onError(Exception error) {
                Snackbar.make(ItemListActivity.this.findViewById(android.R.id.content), error.getMessage(),
                        Snackbar.LENGTH_SHORT).show();
                mProgressBar.hide();
                mTvError.setText(error.getMessage());
            }
        }).getSeasons();

    }

    private void configureAdapter(List<Season> seasonList) {
        mRecyclerView.setAdapter(new SeasonListAdapter(seasonList, mTwoPane, this));
    }

}
