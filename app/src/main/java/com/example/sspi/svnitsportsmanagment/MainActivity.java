package com.example.sspi.svnitsportsmanagment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.sspi.svnitsportsmanagment.SportsAndDep.DepartmentFragment;
import com.example.sspi.svnitsportsmanagment.SportsAndDep.SportsFragment;
import com.example.sspi.svnitsportsmanagment.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MainActivity activity;
    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = MainActivity.this;
        initView();

    }


    //setting up the tabs
    private void initView() {
        setupViewPager(binding.viewPagerHome);


        new TabLayoutMediator(binding.tabLayoutHome, binding.viewPagerHome,
                (tab, position) -> {
                    tab.setText(adapter.mFragmentTitleList.get(position));
                }).attach();

        for (int i = 0; i < binding.tabLayoutHome.getTabCount(); i++) {

            TextView tv = (TextView) LayoutInflater.from(MainActivity.this)
                    .inflate(R.layout.custom_tab, null);

            binding.tabLayoutHome.getTabAt(i).setCustomView(tv);
        }
    }

    private void setupViewPager(@NonNull ViewPager2 viewPager) {
        if(activity != null){

            adapter = new ViewPagerAdapter(activity.getSupportFragmentManager(),
                    activity.getLifecycle());
            adapter.addFragment(new SportsFragment(), "Sports");
            adapter.addFragment(new DepartmentFragment(), "Departments");


            viewPager.setAdapter(adapter);
            viewPager.setOffscreenPageLimit(1);
        }

    }


    class ViewPagerAdapter extends FragmentStateAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getItemCount() {
            return mFragmentList.size();
        }
    }
}