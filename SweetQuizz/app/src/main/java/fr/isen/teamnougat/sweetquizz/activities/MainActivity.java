package fr.isen.teamnougat.sweetquizz.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import fr.isen.teamnougat.sweetquizz.R;
import fr.isen.teamnougat.sweetquizz.fragments.DrawerFragment;
import fr.isen.teamnougat.sweetquizz.fragments.HomeFragment;
import fr.isen.teamnougat.sweetquizz.fragments.SelectionFragment;
import fr.isen.teamnougat.sweetquizz.fragments.ThemesSelectionFragment;


public class MainActivity extends AppCompatActivity implements DrawerFragment.FragmentDrawerListener {
    private static String TAG = MainActivity.class.getSimpleName();
    private Toolbar mToolbar;
    private DrawerFragment drawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (DrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.main_layout), mToolbar);
        drawerFragment.setDrawerListener(this);


        ThemesSelectionFragment newFragment = new ThemesSelectionFragment();
        android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.parentLayout, newFragment);
        transaction.commit();

        displayView(0);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                title = getString(R.string.title_home);
                break;
            case 1:
                //
                break;
            case 2:
                //
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }
}