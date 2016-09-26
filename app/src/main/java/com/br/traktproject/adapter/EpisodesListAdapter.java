package com.br.traktproject.adapter;

import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.br.traktproject.R;
import com.br.traktproject.entities.Episode;

import java.util.List;

/**
 * Created by Ezequiel Messore on 23/09/2016.
 * ezequielmessore.developer@gmail.com
 */

public class EpisodesListAdapter extends BaseAdapter {

    public EpisodesListAdapter(List<? extends Parcelable> list) {
        super(list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_episodes, parent, false);
        return new EpisodeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        final EpisodeViewHolder holder = (EpisodeViewHolder) viewHolder;
        final Episode episode = (Episode) getList().get(position);
        final TextDrawable drawable = TextDrawable.builder().buildRound("E" + episode.getNumber(),
                ContextCompat.getColor(getContext(), android.R.color.darker_gray));
        holder.mIvRadius.setImageDrawable(drawable);
        holder.mTvNameEpisode.setText(episode.getTitle());
    }

    private class EpisodeViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mIvRadius;
        private final TextView mTvNameEpisode;

        public EpisodeViewHolder(View view) {
            super(view);
            mIvRadius = (ImageView) view.findViewById(R.id.ivRadius);
            mTvNameEpisode = (TextView) view.findViewById(R.id.tvNameEpisode);

        }
    }
}
