package com.nexis.loginanimasyon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity2 extends AppCompatActivity {

    BottomNavigationView bottomnavi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bottomnavi= findViewById(R.id.bnavim);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new Homefrag()).commit();
        bottomnavi.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new Homefrag()).commit();
                        break;
                    case R.id.search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new Searchfrag()).commit();
                        break;
                    case R.id.person:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new Personfrag()).commit();
                        break;

                }
                return false;
            }
        });
    }

    public void onBackPressed(){
        Intent geriIntent = new Intent(MainActivity2.this, MainActivity.class);
        finish();
        startActivity(geriIntent);
    }
}