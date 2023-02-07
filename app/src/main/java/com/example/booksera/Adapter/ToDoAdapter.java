package com.example.booksera.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.booksera.AddNewTask;
import com.example.booksera.Model.TodoModel;
import com.example.booksera.R;
import com.example.booksera.task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.MyViewHolder> {


    private List<TodoModel> todoList;
    private task taskActivity;
    private FirebaseFirestore firestore;
    public String task;

    public ToDoAdapter(task Task ,List<TodoModel> todoList){
        this.todoList=todoList;
        taskActivity=Task;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(taskActivity).inflate(R.layout.each_task , parent , false);

        firestore = FirebaseFirestore.getInstance();
        return new MyViewHolder(view);
    }

    public void deleteTask(int position){
        TodoModel todoModel =todoList.get(position);
        firestore.collection("task").document(todoModel.Taskid).delete();
        todoList.remove(position);
        notifyItemRemoved(position);
    }

    public Context getContext(){
        return taskActivity;
    }
    public void editTask(int position){

        TodoModel todoModel =todoList.get(position);

        Bundle bundle =new Bundle();
        bundle.putString("task" ,todoModel.getTask());
        bundle.putString("due" ,todoModel.getDue());
        bundle.putString("id" ,todoModel.Taskid);


        AddNewTask addNewTask =new AddNewTask();
        addNewTask.setArguments(bundle);
        addNewTask.show(taskActivity.getSupportFragmentManager() ,addNewTask.getTag());




    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        TodoModel todoModel = todoList.get(position);
        holder.mCheckBox.setText(todoModel.getTask());
        holder.mDueDate.setText("Due On " + todoModel.getDue());

        holder.mCheckBox.setChecked(toBoolean(todoModel.getStatus()));

        holder.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked)
                {
                    firestore.collection("task").document(todoModel.Taskid).update("status" , 1);
                }else
                {
                    firestore.collection("task").document(todoModel.Taskid).update("status" , 0);
                }
            }
        });



    }

    private boolean toBoolean(int status){
        return status != 0;
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView mDueDate;
        CheckBox mCheckBox;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mDueDate=itemView.findViewById(R.id.due_date);
            mCheckBox=itemView.findViewById(R.id.mcheckbox);

        }
    }


}
