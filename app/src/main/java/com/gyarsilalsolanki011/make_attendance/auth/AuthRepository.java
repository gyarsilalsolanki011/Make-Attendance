package com.gyarsilalsolanki011.make_attendance.auth;

interface AuthRepository {
    Object getCurrentUser();
    Object register(String email, String password);
    Object login(String email, String password);
    void logout();
}
