package org.ufc.great.llm.screens;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.menulateralllmtest.R;
import com.google.android.material.navigation.NavigationView;

public class Tela_2 extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    private AppBarConfiguration appBarConfiguration;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_2);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Configuração do Navigation Drawer
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_tela_2);


        //inicio_teste
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_promotions, R.id.nav_orders, R.id.nav_cart,
                R.id.nav_account, R.id.nav_logout)
                .setDrawerLayout(drawerLayout)
                .build();

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_promotions, R.id.nav_orders, R.id.nav_cart,
                R.id.nav_account, R.id.nav_logout)
                .setDrawerLayout(drawerLayout)
                .build();

        NavigationUI.setupActionBarWithNavController(this, Navigation.findNavController(this, R.id.nav_host_fragment_tela_2), appBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, Navigation.findNavController(this, R.id.nav_host_fragment_tela_2));
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(Navigation.findNavController(this, R.id.nav_host_fragment_tela_2), drawerLayout);
    }
}