package org.ufc.great.llm.screens.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.cadastrollmtest.R;

import org.ufc.great.llm.screens.Task_Tela_1;

import java.util.List;

public class TaskAdapterAccess_Tela_1 extends ArrayAdapter<Task_Tela_1> {

    private Context context;
    private List<Task_Tela_1> taskTela1s;

    public TaskAdapterAccess_Tela_1(Context context, List<Task_Tela_1> taskTela1s) {
        super(context, R.layout.activity_tela_access_1_list_item_task, taskTela1s);
        this.context = context;
        this.taskTela1s = taskTela1s;
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
        Task_Tela_1 taskTela1 = taskTela1s.get(position);

        // Set the task text, date, and checked state
        taskTextView.setText(taskTela1.getTaskName());
        dateTextView.setText(taskTela1.getDate());
        checkBox.setChecked(taskTela1.isChecked());

        // Return the view
        return view;
    }
}
