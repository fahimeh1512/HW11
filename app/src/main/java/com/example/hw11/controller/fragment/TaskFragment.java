package com.example.hw11.controller.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.text.format.DateFormat;

import com.example.hw11.R;
import com.example.hw11.model.State;
import com.example.hw11.model.Task;

import java.util.Date;

public class TaskFragment extends DialogFragment {
    private EditText mTitleEdtTxt;
    private EditText mDescriptionEdtTxt;
    private Button mDateButton;
    private Button mTimeButton;
    private CheckBox mStateChkBox;

    private static final String ARG_TASK_TITLE = "task_title";
    private static final String ARG_TASK_DESCRIPTION = "task_description";
    private static final String ARG_TASK_DATE = "task_date";
    private static final String ARG_TASK_STATE = "task_state";

    private Task mTask;

    public TaskFragment() {
        // Required empty public constructor
    }

    public static TaskFragment newInstance(String title, String description, Date date, State state)
    {
        TaskFragment fragment = new TaskFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TASK_TITLE, title);
        args.putString(ARG_TASK_DESCRIPTION,description);
        //??
        args.putSerializable(ARG_TASK_DATE, date);
        //??
        args.putSerializable(ARG_TASK_STATE, state);
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View view = inflater.inflate(R.layout.fragment_task, null);

        findViews(view);
        initialize();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setNegativeButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setNeutralButton("Edit",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        
                    }
                }).setView(view);

        return builder.create();
    }

     @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //.....
        }
    }

    private void findViews(View view) {
        mTitleEdtTxt = view.findViewById(R.id.task_title);
        mDescriptionEdtTxt = view.findViewById(R.id.task_description);
        mDateButton = view.findViewById(R.id.btn_date);
        mTimeButton = view.findViewById(R.id.btn_time);
        mStateChkBox = view.findViewById(R.id.chkbx_state);
    }

    private void initialize() {
        String title = getArguments().getString(ARG_TASK_TITLE);
        String description = getArguments().getString(ARG_TASK_DESCRIPTION);
        Date date = (Date) getArguments().getSerializable(ARG_TASK_DATE);
        State state = (State) getArguments().getSerializable(ARG_TASK_STATE);

        mTitleEdtTxt.setText(title);
        mTitleEdtTxt.setTextColor(Color.GRAY);
        mTitleEdtTxt.setEnabled(false);
        mDescriptionEdtTxt.setText(description);
        mDescriptionEdtTxt.setTextColor(Color.GRAY);
        mDescriptionEdtTxt.setEnabled(false);


        String day          = (String) DateFormat.format("dd",   date); // 20
        String monthString  = (String) DateFormat.format("MMM",  date); // Jun
        String year         = (String) DateFormat.format("yyyy", date); // 2013
        String dateString = monthString + " " + day + " " + year;
        mDateButton.setText(dateString);
        mDateButton.setTextColor(Color.GRAY);
        mDateButton.setClickable(false);

        String hour          = (String) DateFormat.format("HH",   date); // 20
        String minute          = (String) DateFormat.format("mm",   date); // 20
        //String second          = (String) DateFormat.format("ss",   date); // 20
        String timeString = hour + ":" + minute;
        mTimeButton.setText(timeString);
        mTimeButton.setTextColor(Color.GRAY);
        mTimeButton.setClickable(false);

        //Every enum has both a name() and a valueOf(String) method.
        String stateString = state.name();
        mStateChkBox.setText(stateString);
        mStateChkBox.setTextColor(Color.GRAY);
        mStateChkBox.setClickable(false);
    }
}