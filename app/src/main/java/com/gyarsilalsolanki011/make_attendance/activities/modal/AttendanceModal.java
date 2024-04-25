package com.gyarsilalsolanki011.make_attendance.activities.modal;

public class AttendanceModal {

    public String fullName;
    public Integer present, absent, percentage;

    public AttendanceModal(String name, int present, int absent, int percentage) {

        this.fullName = name;
        this.present = present;
        this.absent = absent;
        this.percentage = percentage;

    }

}
