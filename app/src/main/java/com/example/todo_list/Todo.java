package com.example.todo_list;

import java.util.Date;

public class Todo {

    private String name;
    private Date date;
    private Boolean checked;

    public Todo(String name, Date date) {
        this.name = name;
        this.date = date;
        this.checked = false;
    }

    public String getName() { return this.name; }

    public Date getDate() { return this.date; }

    public Boolean getChecked() { return this.checked; }

    public void check() { this.checked = !this.checked; }

}
