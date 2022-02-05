package com.example.todo_list.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todo_list.R;
import com.example.todo_list.TodoListAdapter;

public class TabList extends Fragment {

    private TodoListAdapter todoListAdapter = new TodoListAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        View view = inflater.inflate(R.layout.tab_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.todoList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(todoListAdapter);

        return view;
    }

    public TodoListAdapter getTodoList() { return this.todoListAdapter; };

}
