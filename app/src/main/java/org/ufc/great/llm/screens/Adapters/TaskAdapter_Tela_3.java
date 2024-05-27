package org.ufc.great.llm.screens.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listadetarefasllmtest.R;

import org.ufc.great.llm.screens.Task_Tela_3;

import java.util.List;

public class TaskAdapter_Tela_3 extends ArrayAdapter<Task_Tela_3> {

    public TaskAdapter_Tela_3(@NonNull Context context, @NonNull List<Task_Tela_3> tasks) {
        super(context, 0, tasks);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_tela_3_list_item_task, parent, false);
        }

        Task_Tela_3 currentTask = getItem(position);

        CheckBox checkBox = listItemView.findViewById(R.id.checkbox);
        TextView taskTextView = listItemView.findViewById(R.id.task_text);
        TextView dateTextView = listItemView.findViewById(R.id.date_text);

        checkBox.setChecked(currentTask.isChecked());
        taskTextView.setText(currentTask.getTask());
        dateTextView.setText(currentTask.getDate());

        return listItemView;
    }
}
