package com.gyarsilalsolanki011.make_attendance.auth;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FirebaseAuthRepository implements AuthRepository{

    final FirebaseAuth auth = FirebaseAuth.getInstance();
    @Override
    public Object getCurrentUser() {
        return auth.getCurrentUser();
    }

    @Override
    public Task<AuthResult> register(String email, String password) {
        return auth.createUserWithEmailAndPassword(email, password);
    }

    @Override
    public Task<AuthResult> login(String email, String password) {
        return auth.signInWithEmailAndPassword(email, password);
    }

    @Override
    public void logout() { auth.signOut();}
}
