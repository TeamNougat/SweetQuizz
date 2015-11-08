package fr.isen.teamnougat.sweetquizz.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.isen.teamnougat.sweetquizz.R;
import fr.isen.teamnougat.sweetquizz.SweetQuizz;
import fr.isen.teamnougat.sweetquizz.adapters.ThemesListAdapter;

/**
 * Created by dhawo on 08-Nov-15.
 */
public class SelectionFragment extends Fragment {
    private boolean isListView;
    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    private ThemesListAdapter mAdapter;

    public boolean isListView() {
        return isListView;
    }

    public void setIsListView(boolean isListView) {
        this.isListView = isListView;
    }

    public RecyclerView getmRecyclerView() {
        return mRecyclerView;
    }

    public StaggeredGridLayoutManager getmStaggeredLayoutManager() {
        return mStaggeredLayoutManager;
    }

    public ThemesListAdapter getmAdapter() {
        return mAdapter;
    }

    ThemesListAdapter.OnItemClickListener onItemClickListener = new ThemesListAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View v, int position) {

        }
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isListView = true;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.selection_layout,container,false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) getView().findViewById(R.id.list);
        mRecyclerView.setHasFixedSize(true);
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredLayoutManager);
        mAdapter = new ThemesListAdapter(SweetQuizz.getAppContext());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(onItemClickListener);
    }
}
