package org.ufc.great.llm.screens.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.cadastrollmtest.R;

import org.ufc.great.llm.screens.Task_Tela_2;

import java.util.ArrayList;

public class TaskAdapter_Tela_2 extends ArrayAdapter<Task_Tela_2> {

    public TaskAdapter_Tela_2(Context context, ArrayList<Task_Tela_2> tasks) {
        super(context, 0, tasks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Task_Tela_2 task = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_tela_2_list_item_task, parent, false);
        }

        CheckBox taskCheckBox = convertView.findViewById(R.id.taskCheckBox);
        TextView taskText = convertView.findViewById(R.id.taskText);
        TextView taskDate = convertView.findViewById(R.id.taskDate);

        taskCheckBox.setChecked(task.isChecked());
        taskText.setText(task.getTask());
        taskDate.setText(task.getDate());

        return convertView;
    }
}