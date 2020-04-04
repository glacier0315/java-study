package com.glacier.factory;

import com.glacier.bean.Room;
import com.glacier.bean.Student;

import java.util.*;

/**
 * @author glacier
 * @version v1.0.0
 * @Date 2017-09-24  20:38:05
 */
public class Factory {

    private Factory() {
        super();
    }


    public static Student createStudent(int i) {
        Student student = new Student();
        student.setName("name_" + i);
        student.setSex(i % 2);
        Calendar calendar = Calendar.getInstance();
        if (i % 2 == 0) {
            calendar.add(Calendar.DAY_OF_MONTH, i % 3);
        } else {
            calendar.add(Calendar.DAY_OF_MONTH, -i % 3);
        }
        student.setBirthDay(calendar.getTime());
        Map<String, String> map = new HashMap<>();
        for (int j = 0; j < i; j++) {
            map.put(String.valueOf(j), "map_" + j);
        }
        student.setMap(map);

        List<String> list = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            list.add("list_" + j);
        }
        student.setList(list);
        Room room = new Room();
        room.setName("room_" + i);
        student.setRoom(room);
        return student;
    }
}
