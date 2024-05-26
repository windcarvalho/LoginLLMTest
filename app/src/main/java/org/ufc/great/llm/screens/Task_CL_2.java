package org.ufc.great.llm.screens;

public class Task_CL_2 {
    private String name;
    private String date;
    private boolean checked;

    public Task_CL_2(String name, String date) {
        this.name = name;
        this.date = date;
        this.checked = false;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
