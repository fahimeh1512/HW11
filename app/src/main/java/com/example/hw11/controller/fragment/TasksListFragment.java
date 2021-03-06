package com.example.hw11.controller.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hw11.R;
import com.example.hw11.model.Task;
import com.example.hw11.repository.IRepository;
import com.example.hw11.repository.TaskRepository;

import java.util.List;

public class TasksListFragment extends Fragment {

    private static final String ARG_POSITION = "fragment_position";

    private int mPosition;
    private RecyclerView mRecyclerView;
    private IRepository mRepository;

    public TasksListFragment() {
        // Required empty public constructor
    }

    public static TasksListFragment newInstance(int position) {
        TasksListFragment fragment = new TasksListFragment();
        Bundle args = new Bundle();
        // Sets current position as argument
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            // Gets fragment's current position
            mPosition = getArguments().getInt(ARG_POSITION);
        }

        // Gets instance of repository
        mRepository = TaskRepository.getInstance();
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
        TaskAdapter taskAdapter = new TaskAdapter(mRepository.getTasks());
        mRecyclerView.setAdapter(taskAdapter);
    }

    private class TaskHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private TextView mDate;
        private Task mTask;

        public TaskHolder(@NonNull View itemView) {

            super(itemView);
            findViews(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TaskFragment taskFragment = TaskFragment.newInstance(
                            mTask.getTitle(), mTask.getDescription(),
                            mTask.getDate(), mTask.getState());
                    taskFragment.show(getActivity().getSupportFragmentManager(), "task fragment");
                }
            });
        }

        private void findViews(View view) {
            mTitle = view.findViewById(R.id.task_title);
            mDate = view.findViewById(R.id.task_date);
        }

        private void bindTask(Task task) {
            mTask = task;
            mTitle.setText(mTask.getTitle());
            //mDate.setText(mTask.getDate().toString());
        }
    }

    private class TaskAdapter extends RecyclerView.Adapter<TaskHolder> {
        private List<Task> mTasks;

        public TaskAdapter(List<Task> tasks) {
            mTasks = tasks;
        }

        public List<Task> getTasks() {
            return mTasks;
        }

        public void setTasks(List<Task> tasks) {
            mTasks = tasks;
        }

        @NonNull
        @Override
        public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.task, parent, false);

            return new TaskHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
            Task task = mTasks.get(position);
            holder.bindTask(task);
        }

        @Override
        public int getItemCount() {
            return mTasks.size();
        }
    }
}