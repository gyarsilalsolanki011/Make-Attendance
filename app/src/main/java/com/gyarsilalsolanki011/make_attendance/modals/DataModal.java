package com.gyarsilalsolanki011.make_attendance.modals;

public class DataModal {
    String name, sub_roll, branch, sem, email;

    public DataModal(String name, String sub_roll, String branch, String sem, String email) {

        this.name = name;
        this.sub_roll = sub_roll;
        this.branch = branch;
        this.sem = sem;
        this.email = email;

    }

    public  DataModal() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSub_roll() {
        return sub_roll;
    }

    public void setSub_roll(String sub_roll) {
        this.sub_roll = sub_roll;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
