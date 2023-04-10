package com.example.sspi.svnitsportsmanagment.Sports;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.example.sspi.svnitsportsmanagment.MainActivity;
import com.example.sspi.svnitsportsmanagment.R;
import com.example.sspi.svnitsportsmanagment.SportsAndDep.DepartmentFragment;
import com.example.sspi.svnitsportsmanagment.SportsAndDep.SportsFragment;
import com.example.sspi.svnitsportsmanagment.databinding.ActivitySportBinding;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class SportActivity extends AppCompatActivity {

    ActivitySportBinding binding;
    SportActivity activity;
    private ViewPagerAdapter adapter;
    String sportName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySportBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = this;

        initView();

        //fetching the clicked sports from the previous activity
        sportName = getIntent().getStringExtra("SportName");
        binding.sportName.setText(sportName);



    }

    //setting up the tabs
    private void initView() {
        setupViewPager(binding.viewPagerSport);


        new TabLayoutMediator(binding.tabLayoutSport, binding.viewPagerSport,
                (tab, position) -> {
                    tab.setText(adapter.mFragmentTitleList.get(position));
                }).attach();

        for (int i = 0; i < binding.tabLayoutSport.getTabCount(); i++) {

            TextView tv = (TextView) LayoutInflater.from(SportActivity.this)
                    .inflate(R.layout.custom_tab, null);

            binding.tabLayoutSport.getTabAt(i).setCustomView(tv);
        }
    }

    private void setupViewPager(@NonNull ViewPager2 viewPager) {
        adapter = new ViewPagerAdapter(activity.getSupportFragmentManager(),
                activity.getLifecycle());
        adapter.addFragment(new TeamsFragment(), "Teams");
        adapter.addFragment(new PlayersFragment(), "Players");


        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(1);

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