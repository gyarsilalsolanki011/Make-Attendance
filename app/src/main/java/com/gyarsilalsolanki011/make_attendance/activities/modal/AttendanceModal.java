package com.gyarsilalsolanki011.make_attendance.activities.modal;

public class AttendanceModal {

    String fullName;
    public Integer present, absent, percentage;

    public AttendanceModal(int absent, String name, int percentage, int present) {

        this.fullName = name;
        this.present = present;
        this.absent = absent;
        this.percentage = percentage;

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getPresent() {
        return present;
    }

    public void setPresent(Integer present) {
        this.present = present;
    }

    public Integer getAbsent() {
        return absent;
    }

    public void setAbsent(Integer absent) {
        this.absent = absent;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }
}
