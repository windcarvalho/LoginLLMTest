package org.ufc.great.llm.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.loginllmtestgpt4.R;
import com.google.android.material.navigation.NavigationView;

public class Tela_Access_2 extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_access_2);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        // Configuração do Navigation Drawer
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_promotions, R.id.nav_orders, R.id.nav_cart,
                R.id.nav_account, R.id.nav_logout)
                .setDrawerLayout(drawerLayout)
                .build();

//        NavigationUI.setupActionBarWithNavController(this, Navigation.findNavController(this, R.id.nav_view), appBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, Navigation.findNavController(this, R.id.nav_view));
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(Navigation.findNavController(this, R.id.nav_view), drawerLayout);
    }
}