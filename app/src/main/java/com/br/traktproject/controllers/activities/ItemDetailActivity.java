package com.br.traktproject.controllers.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.br.traktproject.R;
import com.br.traktproject.controllers.fragments.ItemDetailFragment;
import com.br.traktproject.entities.Episode;
import com.br.traktproject.entities.Season;
import com.br.traktproject.util.AppUtil;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Ezequiel Messore on 23/09/2016.
 * ezequielmessore.developer@gmail.com
 */
public class ItemDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);
        Season season = getIntent().getParcelableExtra(ItemDetailFragment.SEASON);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            //Adding one because it begins the season zero api
            int numberSeason = season.getNumber() + 1;
            actionBar.setTitle(AppUtil.getStringFromResourceWithText(this, R.string.text_name_season, String.valueOf(numberSeason)));
        }
        ItemDetailFragment fragment = ItemDetailFragment.newInstance(season);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.item_detail_container, fragment).commit();
    }

}
