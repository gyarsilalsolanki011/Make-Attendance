package com.gyarsilalsolanki011.make_attendance.activities.modal;

public class AttendanceModal {
    public String name;
    public int present, absent;

    public AttendanceModal(String name, int present, int absent) {

        this.name = name;
        this.present = present;
        this.absent = absent;

    }

    AttendanceModal() {

    }

}
