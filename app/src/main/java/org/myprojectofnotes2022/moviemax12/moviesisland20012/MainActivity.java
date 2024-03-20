package org.myprojectofnotes2022.moviemax12.moviesisland20012;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigationView = findViewById(R.id.bottom_navigationId);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_Id , new HomeFragment()).commit();
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.homeId_navigation:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.fireId_navigation:
                        selectedFragment = new FireFragment();
                        break;
                    case R.id.favoriteId_navigation:
                        selectedFragment = new FavouriteFragment();
                        break;
                    case R.id.profileId_navigation:
                        selectedFragment = new ProfileFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_Id ,
                        selectedFragment).commit();
                return true;
            }
        });

    }

}