package com.example.todo_list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TodoListAdapter extends RecyclerView.Adapter {

    private ArrayList<Todo> todoList = new ArrayList<>();

    public static class TodoViewHolder extends RecyclerView.ViewHolder {
        private CheckBox checkBox;
        private TextView name;
        private TextView date;
        private Button deleteButton;

        public TodoViewHolder(View view) {
            super(view);
            checkBox = view.findViewById(R.id.todoCheckBox);
            name = view.findViewById(R.id.todoText);
            date = view.findViewById(R.id.date);
            deleteButton = view.findViewById(R.id.deleteButton);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Date date = todoList.get(position).getDate();
        ((TodoViewHolder) holder).checkBox.setChecked(todoList.get(position).getChecked());
        ((TodoViewHolder) holder).checkBox.setOnClickListener(v -> this.checkItem(position));
        ((TodoViewHolder) holder).name.setText(todoList.get(position).getName());
        ((TodoViewHolder) holder).date.setText(new SimpleDateFormat("dd/MM/yyyy").format(date));
        ((TodoViewHolder) holder).deleteButton.setOnClickListener(v -> this.removeItem(position));
    }

    @Override
    public int getItemCount() { return this.todoList.size(); }

    /**
     * Add item to the todoList
     * @param todo
     */
    public void addItem(Todo todo) {
        this.todoList.add(todo);
        this.notifyDataSetChanged();
    }

    /**
     * Remove item of todoList with position
     * @param position
     */
    private void removeItem(int position) {
        this.todoList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, this.getItemCount());
    }

    /**
     * Check item of todoList with position
     * @param position
     */
    private void checkItem(int position) { this.todoList.get(position).check(); }

}
