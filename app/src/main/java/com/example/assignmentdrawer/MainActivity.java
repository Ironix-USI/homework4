package com.example.assignmentdrawer;

import android.net.Uri;
import android.os.Bundle;

import com.example.assignmentdrawer.ui.beans.BeansFragment;
import com.example.assignmentdrawer.ui.club.ClubFragment;
import com.example.assignmentdrawer.ui.menu.MenuFragment;
import com.example.assignmentdrawer.ui.our_coffee.OurCoffeeFragment;
import com.example.assignmentdrawer.ui.shop.ShopFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener,
        OurCoffeeFragment.OnFragmentInteractionListener,
        MenuFragment.OnFragmentInteractionListener,
        BeansFragment.OnFragmentInteractionListener,
        ClubFragment.OnFragmentInteractionListener,
        ShopFragment.OnFragmentInteractionListener {
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, getString(R.string.pick_our_menu), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_our_coffee, R.id.nav_menu, R.id.nav_club,
                R.id.nav_beans, R.id.nav_shop)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();
        Fragment fragment = null;
        ActionBar actionBar = getSupportActionBar();
        switch(id) {
            case R.id.nav_our_coffee:
                displayToast(getString(R.string.pick_our_coffee));
                fragment = new OurCoffeeFragment();
                actionBar.setTitle(getString(R.string.menu_our_coffee));
                break;
            case R.id.nav_menu:
                displayToast(getString(R.string.pick_our_menu));
                fragment =  new MenuFragment();
                actionBar.setTitle(getString(R.string.menu_our_menu));
                break;
            case R.id.nav_beans:
                displayToast(getString(R.string.pick_beans));
                fragment = new BeansFragment();
                actionBar.setTitle(getString(R.string.menu_beans));

                break;
            case R.id.nav_club:
                displayToast(getString(R.string.pick_club));
                fragment = new ClubFragment();
                actionBar.setTitle(getString(R.string.menu_club));
                break;
            case R.id.nav_shop:
                displayToast(getString(R.string.pick_shop));
                fragment = new ShopFragment();
                actionBar.setTitle(getString(R.string.menu_shop));
                break;
        }
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.nav_host_fragment, fragment);
            ft.addToBackStack(null);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
        }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}



