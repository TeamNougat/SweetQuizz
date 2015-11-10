package fr.isen.teamnougat.sweetquizz.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import fr.isen.teamnougat.sweetquizz.R;
import fr.isen.teamnougat.sweetquizz.adapters.QuizzListAdapter;
import fr.isen.teamnougat.sweetquizz.adapters.ThemesListAdapter;
import fr.isen.teamnougat.sweetquizz.fragments.QuizzSelectionFragment;
import fr.isen.teamnougat.sweetquizz.fragments.ThemesSelectionFragment;
import fr.isen.teamnougat.sweetquizz.listeners.ServerListener;
import fr.isen.teamnougat.sweetquizz.model.quizz.ServerQuizzes;
import fr.isen.teamnougat.sweetquizz.model.theme.Themes;


public class MainActivity extends AppCompatActivity implements ServerListener, ThemesListAdapter.OnItemClickListener, QuizzListAdapter.OnItemClickListener {
    private static String TAG = MainActivity.class.getSimpleName();
    private Toolbar mToolbar;
    private ThemesSelectionFragment themesSelectionFragment;
    private QuizzSelectionFragment quizzSelectionFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        themesSelectionFragment  = new ThemesSelectionFragment();
        android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.parentLayout, themesSelectionFragment, "SelectionFragment");
        transaction.commit();

        buildNavDrawer();
    }

    @Override
    public void onItemClick(View view, int position) {
        if(quizzSelectionFragment != null){
            Intent intent = new Intent(this, QuizzActivity.class);
            intent.putExtra("name",quizzSelectionFragment.getmAdapter().getQuizzAtPosition(position).getName());
            startActivity(intent);
        }else{
            quizzSelectionFragment = QuizzSelectionFragment.newInstance(themesSelectionFragment.getmAdapter().getThemeAtPosition(position).name);
            android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.parentLayout, quizzSelectionFragment);
            transaction.commit();
        }
    }

    @Override
      public void onThemesRetrieved(Themes themes){
        themesSelectionFragment.setmAdapter(new ThemesListAdapter(this, themes));
        themesSelectionFragment.getmAdapter().setOnItemClickListener(this);
    }

    @Override
    public void onQuizzesRetrieved(ServerQuizzes quizzes){
        if(quizzSelectionFragment != null){
            quizzSelectionFragment.setmAdapter(new QuizzListAdapter(this,quizzes));
            quizzSelectionFragment.getmAdapter().setOnItemClickListener(this);
        }
    }

    @Override
    public void onBackPressed() {
        if(quizzSelectionFragment != null){
            android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.parentLayout,themesSelectionFragment);
            transaction.commit();
            quizzSelectionFragment = null;
        }
        else{
            super.onBackPressed();
        }
    }

    public void buildNavDrawer(){
        new DrawerBuilder().withActivity(this).build();

        //if you want to update the items at a later time it is recommended to keep it in a variable
        final PrimaryDrawerItem item1 = new PrimaryDrawerItem().withName(R.string.drawer_item_home);
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withName(R.string.drawer_item_stats);

        // Create the AccountHeader
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                //.withHeaderBackground(R.drawable.header)
                .addProfiles(
                        new ProfileDrawerItem().withName("Sweet Quizz").withIcon(getResources().getDrawable(R.mipmap.ic_launcher))
                )
                .build();

        //create the drawer and remember the `Drawer` result object
        final Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withTranslucentStatusBar(true)
                .withToolbar(mToolbar)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),
                        item2
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem == item1) {
                            onBackPressed();
                        }
                        return true;
                    }
                })
                .withAccountHeader(headerResult)
                .build();
    }
}