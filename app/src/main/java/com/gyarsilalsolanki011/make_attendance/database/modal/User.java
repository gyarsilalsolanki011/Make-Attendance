package com.gyarsilalsolanki011.make_attendance.database.modal;

import com.gyarsilalsolanki011.make_attendance.database.UserType;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User {
    String email, fullName, rollNumber, branch, subject;
    UserType type;
    Integer present, absent, percentage;

    public User(@NotNull String fullName, @NotNull Integer present, @NotNull Integer absent, @NotNull Integer percentage) {
        this.present = present;
        this.absent = absent;
        this.percentage = percentage;
        this.fullName = fullName;
    }

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

    public  static User student(@NotNull String email, @NotNull String fullName, @NotNull String rollNumber, @NotNull String branch) {
        return  new User(email, fullName, rollNumber, branch,  UserType.Student);
    }

    public static User faculty(@NotNull String email, @NotNull String fullName, @NotNull String subject, @NotNull String branch) {
        return  new User(email, fullName, subject, branch, UserType.Faculty);
    }

    public  static User Attendance(@NotNull String fullName, @NotNull Integer present, @NotNull Integer absent, @NotNull Integer percentage) {
        return  new User(fullName, present, absent, percentage);
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

    public Map<String, Object> toMapAttendance() {
        Map<String, Object> data = new HashMap<>();
        data.put("fullName", this.fullName);
        data.put("present", this.email);
        data.put("absent", this.branch);
        data.put("percentage", this.subject);
        return data;
    }

    public User fromMapAttendance(Map<String, Object> data) {
        return new User(
                (String) Objects.requireNonNull(data.get("fullName")),
                (Integer) Objects.requireNonNull(data.get("present")),
                (Integer) Objects.requireNonNull(data.get("absent")),
                (Integer) Objects.requireNonNull(data.get("percentage"))
        );
    }
}
