package com.example.latihanfragmen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private Fragment selectedFragmen = new MovieFragment();
    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.activitymain_bottomnav);
        bottomNav.setOnNavigationItemSelectedListener(this);

        loadFragment(selectedFragmen);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.menu_movie:
                selectedFragmen = new MovieFragment();
                break;
            case R.id.menu_tvShow:
                selectedFragmen = new TvShowkFragment();
                break;
        }
        return loadFragment(selectedFragmen);
    }

    private boolean loadFragment(Fragment selectedFragmen) {
        if(selectedFragmen != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activitymain_container, selectedFragmen)
                    .commit();
            return true;
        }else
            return false;
    }

}
