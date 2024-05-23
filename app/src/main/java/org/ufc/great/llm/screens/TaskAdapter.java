package org.ufc.great.llm.screens;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.cadastrollmtest.R;

import java.util.List;

public class TaskAdapter extends ArrayAdapter<Task> {

    private Context context;
    private List<Task> tasks;

    public TaskAdapter(Context context, List<Task> tasks) {
        super(context, R.layout.activity_tela_1_list_item_task, tasks);
        this.context = context;
        this.tasks = tasks;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate the layout for a single task item
        @SuppressLint("ViewHolder") View view = LayoutInflater.from(context).inflate(R.layout.activity_tela_1_list_item_task, parent, false);

        // Get references to the views in the layout
        TextView taskTextView = view.findViewById(R.id.taskTextView);
        TextView dateTextView = view.findViewById(R.id.dateTextView);
        CheckBox checkBox = view.findViewById(R.id.taskCheckBox);

        // Get the Task object for the current position
        Task task = tasks.get(position);

        // Set the task text, date, and checked state
        taskTextView.setText(task.getTaskName());
        dateTextView.setText(task.getDate());
        checkBox.setChecked(task.isChecked());

        // Return the view
        return view;
    }
}
