package cn.com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test02 {
    public static void main(String[] args) {
        List<SchoolBoy> schoolBoys = new ArrayList<>(3);
        List<SchoolBoy> schoolBoys1 = new ArrayList<>(3);
        SchoolBoy boy1 = new SchoolBoy();
        boy1.setGirlId("1");
        boy1.setId("10");
        boy1.setName("小明");
        schoolBoys.add(boy1);

        SchoolBoy boy2 = new SchoolBoy();
        boy2.setGirlId("2");
        boy2.setId("11");
        boy2.setName("小豪");
        schoolBoys1.add(boy2);

        SchoolBoy boy3 = new SchoolBoy();
        boy3.setGirlId("3");
        boy3.setId("12");
        boy3.setName("小白");
        schoolBoys.add(boy3);
        schoolBoys1.add(boy3);

        List<Girl> girls = new ArrayList<>(3);
        Girl girl1 = new Girl();
        girl1.setId("1");
        girl1.setName("小英");

        Girl girl2 = new Girl();
        girl2.setId("2");
        girl2.setName("小美");

        Girl girl3 = new Girl();
        girl3.setId("3");
        girl3.setName("小花");
        girls.add(girl1);
        girls.add(girl2);
        girls.add(girl3);

        List<SchoolBoy> list = schoolBoys.stream().map(schoolBoy -> girls.stream()
                .filter(girl -> schoolBoy.getGirlId().equals(girl.getId())).findFirst().map(girl -> {
                    schoolBoy.setGrilName(girl.getName());
                    return schoolBoy;
                }).orElse(null)).collect(Collectors.toList());
        System.out.println(list.toString());
        List<SchoolBoy> list1 = schoolBoys.stream()
                .map(schoolBoy -> schoolBoys1.stream()
                        .filter(schoolBoy1 -> schoolBoy.getGirlId().equals(schoolBoy1.getGirlId())).findFirst()
                        .map(schoolBoy1 -> {
                            schoolBoy.setGrilName("110110");
                            return schoolBoy;
                        }).orElseGet(() -> {
                            schoolBoy.setGrilName("schoolBoy");
                            return schoolBoy;
                        }))
                .collect(Collectors.toList());
        System.out.println(list1.toString());
        List<SchoolBoy> list2 = schoolBoys1.stream()
                .map(schoolBoy1 -> schoolBoys.stream()
                        .filter(schoolBoy -> schoolBoy.getGirlId().equals(schoolBoy1.getGirlId())).findFirst()
                        .map(schoolBoy -> {
                            schoolBoy.setGrilName("110110");
                            return schoolBoy;
                        }).orElseGet(() -> {
                            schoolBoy1.setGrilName("schoolBoy1");
                            return schoolBoy1;
                        }))
                .collect(Collectors.toList());
        System.out.println(list2.toString());
        List<SchoolBoy> list3 = list1.stream()
                .map(schoolBoy -> list2.stream()
                        .filter(schoolBoy1 -> !schoolBoy.getGirlId().equals(schoolBoy1.getGirlId())).findFirst()
                        .map(schoolBoy1 -> {
                            System.out.println("00000->" + schoolBoy.getGirlId());
                            if (schoolBoy.getGirlId() == null) {
                                return schoolBoy1;
                            } else {
                                return schoolBoy;
                            }
                        }).orElse(null))
                .collect(Collectors.toList());
        System.out.println(list3.toString());
    }
}
