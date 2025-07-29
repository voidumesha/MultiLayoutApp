package com.example.multilayoutapp;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.nav_frame) {
                startActivity(new Intent(this, FrameActivity.class));
                return true;
            } else if (itemId == R.id.nav_constraint) {
                startActivity(new Intent(this, FormActivity.class));
                return true;
            } else if (itemId == R.id.nav_relative) {
                startActivity(new Intent(this, DashboardActivity.class));
                return true;
            }

            return false;
        });

    }
}
