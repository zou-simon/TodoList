package com.example.todo_list.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.todo_list.R;
import com.example.todo_list.Todo;

import java.util.Calendar;
import java.util.Date;

public class TabNew extends Fragment {

    private TabList tabList;

    Button addButton;
    EditText editTextName;
    DatePicker datePicker;

    public TabNew(TabList tabList) { this.tabList = tabList; }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        View view = inflater.inflate(R.layout.tab_new, container, false);

        addButton = view.findViewById(R.id.addButton);
        editTextName = view.findViewById(R.id.editTextName);
        datePicker = view.findViewById(R.id.datePicker);

        Calendar calendar = Calendar.getInstance();

        addButton.setOnClickListener(v -> {
            String name = editTextName.getText().toString();

            calendar.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
            Date date = calendar.getTime();

            Todo todo = new Todo(name, date);
            tabList.getTodoList().addItem(todo);
        });

        return view;
    }
}
