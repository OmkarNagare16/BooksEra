package com.example.booksera.Model;

import com.google.firebase.firestore.Exclude;

import androidx.annotation.NonNull;

public class Taskid {

    @Exclude
    public String Taskid;

    public <T extends  Taskid> T withId(@NonNull final String id){
        this.Taskid =id;
        return  (T) this;

    }


}

