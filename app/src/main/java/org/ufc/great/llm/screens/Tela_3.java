package org.ufc.great.llm.screens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.example.cadastrollmtest.R;
import com.google.android.material.navigation.NavigationView;

public class Tela_3 extends AppCompatActivity {
    private DrawerLayout drawer;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_3);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        // Handle navigation view item clicks here.
                        int id = item.getItemId();

                        // You can perform different actions based on the item selected
                        // For example:
                        if (id == R.id.nav_home) {
                            // Open Home Fragment or Activity
                        } else if (id == R.id.nav_promotions) {
                            // Open Promotions Fragment or Activity
                        } else if (id == R.id.nav_orders) {
                            // Open Orders Fragment or Activity
                        } else if (id == R.id.nav_cart) {
                            // Open Cart Fragment or Activity
                        } else if (id == R.id.nav_account) {
                            // Open Account Fragment or Activity
                        } else if (id == R.id.nav_logout) {
                            // Perform Logout action
                        }

                        drawer.closeDrawers();
                        return true;
                    }
                });
    }
}