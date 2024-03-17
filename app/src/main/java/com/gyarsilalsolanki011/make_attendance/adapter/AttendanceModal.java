package com.gyarsilalsolanki011.make_attendance.adapter;

import android.widget.Button;

public class AttendanceModal {
    String name;
    int present, absent;

    public AttendanceModal(String name, int present, int absent) {

        this.name = name;
        this.present = present;
        this.absent = absent;

    }

}
