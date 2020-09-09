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

import com.example.hw11.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager;
    private TabLayout mTodoTab;
    private TabLayout mDoingTab;
    private TabLayout mDoneTab;

    private enum mStates { Todo, Doing, Done;
        private static int mValue;

        public static void setValue(int value) {
            mValue = value;
        }

        public static mStates getValue() {
            return values()[mValue];
        }
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        //setListeners();
        initViews();
    }

    private void findViews() {
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_pager);
        TabLayout.Tab mTodoTab = mTabLayout.getTabAt(0);
        TabLayout.Tab mDoingTab = mTabLayout.getTabAt(1);
        TabLayout.Tab mDoneTab = mTabLayout.getTabAt(2);

        // FOR STATES
        /*mStates.setValue(2);
        mStates n = mStates.getValue();*/
    }

    private void initViews() {
        TasksAdapter tasksAdapter = new TasksAdapter(this);
        mViewPager.setAdapter(tasksAdapter);
    }
    private void setListeners() {
        /*mTodoTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, mStates.getValue(), Toast.LENGTH_SHORT).show();
            }
        });*/
    }

   /* public static mStates getState() {
        *//*mStates state = new mStates(1);*//*
        return mStates.values()[0];
    }*/

    private class TasksAdapter extends FragmentStateAdapter {
        private int mNumOfTabs;

        public TasksAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            mNumOfTabs = mStates.values().length;
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