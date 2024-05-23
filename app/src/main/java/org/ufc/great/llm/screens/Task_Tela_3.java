package org.ufc.great.llm.screens;

public class Task_Tela_3 {
    private boolean isChecked;
    private String task;
    private String date;

    public Task_Tela_3(boolean isChecked, String task, String date) {
        this.isChecked = isChecked;
        this.task = task;
        this.date = date;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public String getTask() {
        return task;
    }

    public String getDate() {
        return date;
    }
}
