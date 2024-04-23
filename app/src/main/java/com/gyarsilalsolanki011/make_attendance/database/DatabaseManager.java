package com.gyarsilalsolanki011.make_attendance.database;

import com.gyarsilalsolanki011.make_attendance.modals.DataModal;
import java.util.ArrayList;

public class DatabaseManager {
    String name,sub_roll, branch, sem, email;

    public DatabaseManager(){

    }
    public void addData(ArrayList<String> arrDataList, Integer whoReg) {

        name = arrDataList.get(0);
        sub_roll = arrDataList.get(1);
        branch = arrDataList.get(2);
        sem = arrDataList.get(3);
        email = arrDataList.get(4);



        DataModal dataModal = new DataModal(name, sub_roll, branch, sem, email);


    }
}
