package com.example.storeapp.data.network;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseConnect {

    public final static FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
    final static DatabaseReference ref= FirebaseDatabase.getInstance().getReference();

}
