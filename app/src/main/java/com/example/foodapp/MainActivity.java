package com.example.foodapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Home").setIcon(R.drawable.icon_home));
        tabLayout.addTab(tabLayout.newTab().setText("Order").setIcon(R.drawable.icon_order));
        tabLayout.addTab(tabLayout.newTab().setText("Profile").setIcon(R.drawable.icon_profile));
        displayFragment(0);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                displayFragment(tabLayout.getSelectedTabPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
    private void displayFragment (int selectedTabposition) {
        Fragment fragment = null;
        switch (selectedTabposition) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new OrderFragment();
                break;
            case 2:
                fragment = new ProfileFragment();
                break;
        }
        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.contents, fragment);
        fragmentTransaction.commit();
    }
}

