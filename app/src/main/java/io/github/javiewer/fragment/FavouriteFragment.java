package io.github.javiewer.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import io.github.javiewer.JAViewer;
import io.github.javiewer.adapter.MovieAdapter;

/**
 * Project: JAViewer
 */

public class FavouriteFragment extends RecyclerFragment<LinearLayoutManager> {

    public static final int UPDATE_RECYCLER_LIST = 0xab;

    private static RecyclerView.Adapter adapter;

    public static void update() {
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.setLayoutManager(new LinearLayoutManager(this.getContext()));
        this.setAdapter(adapter=new MovieAdapter(JAViewer.CONFIGURATIONS.getStarredMovies(), this.getActivity()));
        mRefreshLayout.setEnabled(false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        adapter = null;
    }
}
