/*
* Copyright 2016 Sanjay Singh.

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
*
* */
package com.samset.materialnavigationdrawer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.samset.materialnavigationdrawer.adapter.NavigationDrawerAdapter;
import com.samset.materialnavigationdrawer.fragments.HomeFragment;
import com.samset.materialnavigationdrawer.listeners.OnItemClickListener;

/*
By Sanjay Singh
* */
public class MainActivity extends AppCompatActivity implements OnItemClickListener{
    private String Name = "Samset";
    private int Icon = R.drawable.ic_avtar;
    private Toolbar toolbar;
    private RelativeLayout drawer_pane;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView drawerRecycler;
    private NavigationDrawerAdapter adapter;
    private static String[] titles = null;
    private static int[] icons = {
            R.drawable.ic_home, R.drawable.ic_android, R.drawable.ic_facebook,
            R.drawable.ic_twitter, R.drawable.ic_dropbox, R.drawable.ic_camera, R.drawable.ic_audiotrack,
            R.drawable.ic_video, R.drawable.ic_wifi,R.drawable.ic_call,R.drawable.ic_gallery,
            R.drawable.ic_cloudy,R.drawable.ic_power};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titles=getResources().getStringArray(R.array.nav_drawer_labels);
        setInitilization();
        setToolbar();
        setNavigationDrawer();
        beginTransction(HomeFragment.getInstance());
    }


    private void setInitilization() {

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.tool1);
        drawerRecycler = (RecyclerView) findViewById(R.id.left_drawer);
    }

    private void setToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);

            final ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowHomeEnabled(true);
                actionBar.setDisplayShowTitleEnabled(true);
                actionBar.setDisplayUseLogoEnabled(false);
                actionBar.setHomeButtonEnabled(true);
            }
        }
    }

    private synchronized void setNavigationDrawer() {

        layoutManager = new LinearLayoutManager(this);
        drawerRecycler.setLayoutManager(layoutManager);
        adapter = new NavigationDrawerAdapter(this, titles, icons, Name, Icon);
        drawerRecycler.setAdapter(adapter);
        adapter.setListner(this);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                supportInvalidateOptionsMenu();
            }
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                if (slideOffset > .55) {
                    onDrawerOpened(drawerView);

                } else if (slideOffset < .45) {
                    onDrawerClosed(drawerView);
                }
            }
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                supportInvalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onItemClick(View view, final int position) {
        mDrawerLayout.closeDrawer(drawerRecycler);
        mDrawerLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                beginTransction(HomeFragment.getInstance());
                Toast.makeText(MainActivity.this, "You click " + titles[position - 1], Toast.LENGTH_SHORT).show();
            }
        }, 300);

    }


    private void beginTransction(Fragment fragment) {

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.mainContainer,fragment).commit();

    }
}
