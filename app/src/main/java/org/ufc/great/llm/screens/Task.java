package org.ufc.great.llm.screens;

public class Task {
    private String taskName;
    private String date;
    private boolean isChecked;

    public Task(String taskName, String date) {
        this.taskName = taskName;
        this.date = date;
        this.isChecked = false;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
