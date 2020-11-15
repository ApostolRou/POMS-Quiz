package com.example.qaa;



import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Firebase {

    private DatabaseReference myRef;

    public void writeToDatabase() {
        myRef = FirebaseDatabase.getInstance().getReference();
        myRef.push().setValue("Hello, World!");

    }
}