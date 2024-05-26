package org.ufc.great.llm.screens;

public class Task_CL_3 {
    private String task;
    private String date;
    private boolean checked;

    public Task_CL_3(String task, String date, boolean checked) {
        this.task = task;
        this.date = date;
        this.checked = checked;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
