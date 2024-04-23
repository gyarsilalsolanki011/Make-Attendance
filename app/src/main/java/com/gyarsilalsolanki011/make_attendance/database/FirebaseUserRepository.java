package com.gyarsilalsolanki011.make_attendance.database;

import java.util.ArrayList;

public class FirebaseUserRepository {
    String name,sub_roll, branch, sem, email;

    public FirebaseUserRepository(){

    }
    public void addData(ArrayList<String> arrDataList, Integer whoReg) {

        name = arrDataList.get(0);
        sub_roll = arrDataList.get(1);
        branch = arrDataList.get(2);
        sem = arrDataList.get(3);
        email = arrDataList.get(4);
    }
}
