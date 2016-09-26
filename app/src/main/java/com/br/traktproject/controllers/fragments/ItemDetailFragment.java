package com.br.traktproject.controllers.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.br.traktproject.R;
import com.br.traktproject.adapter.EpisodesListAdapter;
import com.br.traktproject.entities.Season;
import com.squareup.picasso.Picasso;

/**
 * Created by Ezequiel Messore on 23/09/2016.
 * ezequielmessore.developer@gmail.com
 */

public class ItemDetailFragment extends Fragment {
    public static final String SEASON = "season";

    public static ItemDetailFragment newInstance(Season season) {
        ItemDetailFragment fragment = new ItemDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(SEASON, season);
        fragment.setArguments(args);
        return fragment;
    }

    public ItemDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.season_detail, container, false);

        if (getSeason() != null) {
            bindElementsActivity(getActivity());
            bindElements(rootView);
        }

        return rootView;
    }

    private void bindElementsActivity(FragmentActivity activity) {
        final ImageView imageBack = (ImageView) activity.findViewById(R.id.ivBack);
        if (imageBack != null) {
            Picasso.with(getContext()).load(getSeason().getImage().getPoster().getFull()).fit().centerCrop().into(imageBack);
        }
    }

    private void bindElements(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvEpisodes);
        recyclerView.setAdapter(new EpisodesListAdapter(getSeason().getEpisodeList()));
    }

    public Season getSeason() {
        return getArguments().getParcelable(SEASON);
    }

}
