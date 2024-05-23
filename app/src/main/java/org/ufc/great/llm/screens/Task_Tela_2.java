package org.ufc.great.llm.screens;

public class Task_Tela_2 {

    private String task;
    private String date;
    private boolean isChecked;

    public Task_Tela_2(String task, String date, boolean isChecked) {
        this.task = task;
        this.date = date;
        this.isChecked = isChecked;
    }

    public String getTask() {
        return task;
    }

    public String getDate() {
        return date;
    }

    public boolean isChecked() {
        return isChecked;
    }

}
