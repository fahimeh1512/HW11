package com.example.hw11.controller;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.hw11.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TasksListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TasksListFragment extends Fragment {

    private static final String ARG_POSITION = "fragment_position";

    private int mPosition;
    private RecyclerView mRecyclerView;

    public TasksListFragment() {
        // Required empty public constructor
    }

    public static TasksListFragment newInstance(int position) {
        TasksListFragment fragment = new TasksListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPosition = getArguments().getInt(ARG_POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tasks_list, container, false);
        findViews(view);
        initViews();

        return view;
    }


    private void findViews(View view) {
        mRecyclerView = view.findViewById(R.id.recycler_view_tasks_list);
    }

    private void initViews() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    private class TaskHolder extends RecyclerView.ViewHolder {
        public TaskHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}