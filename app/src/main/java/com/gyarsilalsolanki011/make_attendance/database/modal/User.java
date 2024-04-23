package com.gyarsilalsolanki011.make_attendance.database.modal;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User {
    String email, fullName, rollNumber, branch, subject;
    public Boolean whoLogin;

    public User(){ }

    public User(@NotNull String email, @NotNull String fullName, @NotNull String sub_0r_Roll, @NotNull String branch, @NotNull Boolean whoLogin) {
        this.email = email;
        this.fullName = fullName;
        this.branch = branch;
        this.whoLogin = whoLogin;
        if (whoLogin) this.rollNumber = sub_0r_Roll;
        else this.subject = sub_0r_Roll;
    }

    public  static User student(@NotNull String email, @NotNull String fullName, @NotNull String branch, @NotNull String rollNumber) {
        return  new User(email, fullName, branch, rollNumber, true);
    }

    public static User faculty(@NotNull String email, @NotNull String fullName, @NotNull String branch, @NotNull String subject) {
        return  new User(email, fullName, branch, subject, false);
    }

    public Map<String, Object> toMap() {
        Map<String, Object> data = new HashMap<>();
        data.put("fullName", this.fullName);
        data.put("email", this.email);
        data.put("branch", this.branch);
        if (whoLogin) data.put("rollNumber", this.rollNumber);
        else data.put("subject", this.subject);
        return data;
    }

    public User fromMap(Map<String, Object> data) {
        String roll_or_subject;

        if (whoLogin) {
            roll_or_subject = (String) Objects.requireNonNull(data.get("rollNumber"));
        } else {
            roll_or_subject = (String) Objects.requireNonNull(data.get("subject"));
        }
        return new User(
                (String) Objects.requireNonNull(data.get("email")),
                (String) Objects.requireNonNull(data.get("fullName")),
                (String) Objects.requireNonNull(data.get("branch")),
                roll_or_subject,
                whoLogin
        );
    }

}
