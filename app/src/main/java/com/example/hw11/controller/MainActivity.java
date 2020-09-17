package com.example.hw11.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hw11.R;
import com.example.hw11.model.State;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import static com.google.android.material.snackbar.Snackbar.*;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager;
    private FloatingActionButton mFloatingActionButton;
    private TabLayout mTodoTab;
    private TabLayout mDoingTab;
    private TabLayout mDoneTab;


    // Intent needed for each activity
    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        initViews();
        setListeners();
    }

    private void findViews() {
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_pager);
        mFloatingActionButton = findViewById(R.id.fab);
        TabLayout.Tab mTodoTab = mTabLayout.getTabAt(0);
        TabLayout.Tab mDoingTab = mTabLayout.getTabAt(1);
        TabLayout.Tab mDoneTab = mTabLayout.getTabAt(2);

        // FOR STATES
        /*mStates.setValue(2);
        mStates n = mStates.getValue();*/
    }

    private void initViews() {
        // Sets adapter for view pager
        TasksAdapter tasksAdapter = new TasksAdapter(this);
        mViewPager.setAdapter(tasksAdapter);
    }

    private void setListeners() {
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    // Adapter for view pager
    private class TasksAdapter extends FragmentStateAdapter {
        private int mNumOfTabs;

        public TasksAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            // Gets number of tabs from length of state array
            mNumOfTabs = State.values().length;
        }



        @NonNull
        @Override
        public Fragment createFragment(int position) {
            TasksListFragment tasksListFragment = TasksListFragment.newInstance(position);
            return tasksListFragment;
        }

        @Override
        public int getItemCount() {
            return mNumOfTabs;
        }
    }
}