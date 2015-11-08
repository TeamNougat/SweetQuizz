package fr.isen.teamnougat.sweetquizz.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import fr.isen.teamnougat.sweetquizz.R;

public class SelectionFragment extends Fragment {
    private boolean isListView;
    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;


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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_toggle) {
            if(isListView == true){
                getmStaggeredLayoutManager().setSpanCount(2);
                item.setIcon(R.drawable.ic_action_list);
                setIsListView(false);
            }
            else{
                getmStaggeredLayoutManager().setSpanCount(1);
                item.setIcon(R.drawable.ic_action_grid);
                setIsListView(true);
            }
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isListView = true;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.selection_layout,container,false);
        setHasOptionsMenu(true);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) getView().findViewById(R.id.list);
        mRecyclerView.setHasFixedSize(true);
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredLayoutManager);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.menu_main, menu);
    }
}
