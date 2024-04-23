package com.gyarsilalsolanki011.make_attendance.database;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.gyarsilalsolanki011.make_attendance.database.modal.User;

public interface UserRepository {
    Task<DocumentSnapshot> getUserData();
    void setUserData(User user);
}
