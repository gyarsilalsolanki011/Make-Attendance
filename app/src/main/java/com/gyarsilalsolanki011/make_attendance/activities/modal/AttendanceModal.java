package com.gyarsilalsolanki011.make_attendance.activities.modal;

public class AttendanceModal {

    public String fullName;
    public Integer present, absent, percentage;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getPresent() {
        return present;
    }

    public void setPresent(int present) {
        this.present = present;
    }

    public int getAbsent() {
        return absent;
    }

    public void setAbsent(int absent) {
        this.absent = absent;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public AttendanceModal(String name, int present, int absent, int percentage) {

        this.fullName = name;
        this.present = present;
        this.absent = absent;
        this.percentage = percentage;

    }

    AttendanceModal() {

    }

}
