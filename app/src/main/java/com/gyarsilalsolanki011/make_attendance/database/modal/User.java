package com.gyarsilalsolanki011.make_attendance.database.modal;

import com.gyarsilalsolanki011.make_attendance.database.UserType;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User {
    String email, fullName, rollNumber, branch, subject;
    UserType type;

    public User(@NotNull String email, @NotNull String fullName, @NotNull String sub_0r_Roll, @NotNull String branch, @NotNull UserType type) {
        this.email = email;
        this.fullName = fullName;
        this.branch = branch;
        this.type = type;
        if (type.equals(UserType.Student)){
            this.rollNumber = sub_0r_Roll;
        } else {
            this.subject = sub_0r_Roll;
        }
    }

    public  static User student(@NotNull String email, @NotNull String fullName, @NotNull String branch, @NotNull String rollNumber) {
        return  new User(email, fullName, branch, rollNumber, UserType.Student);
    }

    public static User faculty(@NotNull String email, @NotNull String fullName, @NotNull String branch, @NotNull String subject) {
        return  new User(email, fullName, branch, subject, UserType.Faculty);
    }

    public Map<String, Object> toMapStudent() {
        Map<String, Object> data = new HashMap<>();
        data.put("fullName", this.fullName);
        data.put("email", this.email);
        data.put("branch", this.branch);
        data.put("rollNumber", this.rollNumber);
        return data;
    }

    public User fromMapStudent(Map<String, Object> data) {
        return new User(
                (String) Objects.requireNonNull(data.get("email")),
                (String) Objects.requireNonNull(data.get("fullName")),
                (String) Objects.requireNonNull(data.get("branch")),
                (String) Objects.requireNonNull(data.get("rollNumber")),
                UserType.valueOf((String) data.get("type"))
        );
    }

    public Map<String, Object> toMapFaculty() {
        Map<String, Object> data = new HashMap<>();
        data.put("fullName", this.fullName);
        data.put("email", this.email);
        data.put("branch", this.branch);
        data.put("subject", this.subject);
        return data;
    }

    public User fromMapFaculty(Map<String, Object> data) {
        return new User(
                (String) Objects.requireNonNull(data.get("email")),
                (String) Objects.requireNonNull(data.get("fullName")),
                (String) Objects.requireNonNull(data.get("branch")),
                (String) Objects.requireNonNull(data.get("subject")),
                UserType.valueOf((String) data.get("type"))
        );
    }
}
