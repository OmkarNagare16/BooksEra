package com.example.booksera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.example.booksera.Adapter.ToDoAdapter;
import com.example.booksera.Model.TodoModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class task extends AppCompatActivity implements OnDialogCloseListner {

    public static String username;
    private  RecyclerView recyclerView;
    private  FloatingActionButton mFab;

    private FirebaseFirestore firestore;
    private ToDoAdapter adapter;

    private List<TodoModel> mList;
    private Query query;
    private ListenerRegistration listenerRegistration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        recyclerView = findViewById(R.id.recyclerview);
        mFab = findViewById(R.id.floatingActionButton);
        firestore = FirebaseFirestore.getInstance();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(task.this));

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNewTask.username=username;
                AddNewTask.newInstance().show(getSupportFragmentManager(), AddNewTask.TAG);
            }
        });
        mList = new ArrayList<>();
        adapter = new ToDoAdapter(task.this, mList);


        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new TouchHelper(adapter));
        itemTouchHelper.attachToRecyclerView(recyclerView);



        showData();
        recyclerView.setAdapter(adapter);
    }

    private  void showData() {
       query= firestore.collection("task").orderBy("time" , Query.Direction.DESCENDING);

       listenerRegistration= query.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                    for(DocumentChange documentChange : value.getDocumentChanges()){
                        if(documentChange.getType() == DocumentChange.Type.ADDED){
                            String id = documentChange.getDocument().getId();
                            TodoModel todoModel = documentChange.getDocument().toObject(TodoModel.class).withId(id);

                            if(todoModel.getUsername().equals(username))
                            mList.add(todoModel);
                            adapter.notifyDataSetChanged();

                        }
                    }
            listenerRegistration.remove();
            }
        });
    }
    @Override
    public void onDialogClose(DialogInterface dialogInterface) {
        mList.clear();
        showData();
        adapter.notifyDataSetChanged();
    }
}