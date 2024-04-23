package com.gyarsilalsolanki011.make_attendance.database;

import android.util.Log;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.gyarsilalsolanki011.make_attendance.database.modal.User;

public class FirebaseUserRepository implements UserRepository{

    private final FirebaseFirestore database = FirebaseFirestore.getInstance();
    User userObject = new User();
    private  final CollectionReference studentCollection = database.collection("student");
    private  final CollectionReference facultyCollection = database.collection("faculty");
    private final static String TAG = "FIREBASE USER REPOSITORY";
    @Override
    public Task<DocumentSnapshot> getUserData() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        if (userObject.whoLogin){
            return studentCollection.document(user.getUid()).get();
        } else {
            return facultyCollection.document(user.getUid()).get();
        }
    }

    @Override
    public void setUserData(User userData) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null){
            Task<Void> task;
            if (userObject.whoLogin) {
                task = studentCollection.document(user.getUid()).set(userData.toMap());
                task.addOnFailureListener(e -> Log.e(TAG, e.toString()));
            } else {
                task = facultyCollection.document(user.getUid()).set(userData.toMap());
                task.addOnFailureListener(e -> Log.e(TAG, e.toString()));
            }
            task.addOnSuccessListener(e -> Log.d(TAG, "Data set success"));
        }
    }
}
