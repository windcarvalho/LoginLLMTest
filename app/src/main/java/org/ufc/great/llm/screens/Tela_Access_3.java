package org.ufc.great.llm.screens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.loginllmtestgpt4.R;
import com.google.android.material.navigation.NavigationView;

public class Tela_Access_3 extends AppCompatActivity {
    private DrawerLayout drawer;
    private NavigationView navigationView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_access_3);

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
                        int id = item.getItemId();

                        if (id == R.id.nav_home) {
                            // Abrir Página Inicial
                        } else if (id == R.id.nav_promotions) {
                            // Abrir Promoções
                        } else if (id == R.id.nav_orders) {
                            // Abrir Meus Pedidos
                        } else if (id == R.id.nav_cart) {
                            // Abrir Meu Carrinho
                        } else if (id == R.id.nav_account) {
                            // Abrir Minha Conta
                        } else if (id == R.id.nav_logout) {
                            // Executar Logout
                        }

                        drawer.closeDrawers();
                        return true;
                    }
                });
    }
}