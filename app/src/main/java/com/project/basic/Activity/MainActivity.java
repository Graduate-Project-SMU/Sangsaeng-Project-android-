package com.project.basic.Activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.project.basic.Fragment.CustomViewPagerAdapter;
import com.project.basic.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);

        CustomViewPagerAdapter mPagerAdapter = new CustomViewPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(mPagerAdapter);
        viewPagerTab.setCustomTabView(mPagerAdapter);
        viewPagerTab.setViewPager(viewPager);
        viewPager.setCurrentItem(0);
    }

}
