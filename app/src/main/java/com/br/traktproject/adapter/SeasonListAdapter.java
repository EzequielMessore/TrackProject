package com.br.traktproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.br.traktproject.R;
import com.br.traktproject.controllers.activities.ItemDetailActivity;
import com.br.traktproject.controllers.fragments.ItemDetailFragment;
import com.br.traktproject.entities.Season;
import com.br.traktproject.util.AppUtil;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.view.View.GONE;


/**
 * Created by Ezequiel Messore on 23/09/2016.
 * ezequielmessore.developer@gmail.com
 */

public class SeasonListAdapter extends BaseAdapter {

    private boolean mTwoPane;
    private FragmentActivity mFragmentActivity;

    public SeasonListAdapter(List<Season> seasonList, boolean twoPane, FragmentActivity fragmentActivity) {
        super(seasonList);
        mTwoPane = twoPane;
        mFragmentActivity = fragmentActivity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_season, parent, false);
        return new SeasonListAdapter.SeasonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        final SeasonListAdapter.SeasonViewHolder holder = (SeasonListAdapter.SeasonViewHolder) viewHolder;
        final Season season = (Season) getList().get(position);
        Picasso.with(getContext())
                .load(season.getImage().getPoster().getFull()).fit()
                .centerCrop()
                .into(holder.mIvPortrait, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.mProgressBar.setVisibility(GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });
        //Adding one because it begins the season zero api
        final int numberSeason = season.getNumber() + 1;
        holder.mTvNameSeason.setText(AppUtil.getStringFromResourceWithText(getContext(), R.string.text_name_season, String.valueOf(numberSeason)));
        holder.mTvRating.setText(AppUtil.formatNumber(season.getRating()));
        holder.mTvVotes.setText(String.valueOf(season.getVotes()));
        holder.mTvEpisodeCount.setText(String.valueOf(season.getEpisodeCount()));
        holder.mTvAiredEpisodes.setText(String.valueOf(season.getAiredEpisodes()));
        holder.mTvFirstAired.setText(AppUtil.formatDate(season.getFirstAired()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTwoPane) {
                    ItemDetailFragment fragment = ItemDetailFragment.newInstance(season);
                    mFragmentActivity.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.item_detail_container, fragment)
                            .commit();
                } else {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, ItemDetailActivity.class);
                    intent.putExtra(ItemDetailFragment.SEASON, season);
                    context.startActivity(intent);
                }
            }
        });
    }

    public class SeasonViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mIvPortrait;
        private final TextView mTvNameSeason;
        private final TextView mTvRating;
        private final TextView mTvVotes;
        private final TextView mTvEpisodeCount;
        private final TextView mTvAiredEpisodes;
        private final TextView mTvFirstAired;
        private final ProgressBar mProgressBar;


        public SeasonViewHolder(View view) {
            super(view);
            mIvPortrait = (ImageView) view.findViewById(R.id.ivPortrait);
            mTvNameSeason = (TextView) view.findViewById(R.id.tvNameSeason);
            mTvRating = (TextView) view.findViewById(R.id.tvRating);
            mTvVotes = (TextView) view.findViewById(R.id.tvVotes);
            mTvEpisodeCount = (TextView) view.findViewById(R.id.tvEpisodeCount);
            mTvAiredEpisodes = (TextView) view.findViewById(R.id.tvAiredEpisodes);
            mTvFirstAired = (TextView) view.findViewById(R.id.tvFirstAired);
            mProgressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        }
    }
}
