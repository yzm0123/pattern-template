package com.gupaoedu.vip.pattern.template.course;

public class NetworkCourseTest {
    public static void main(String[] args) {
        System.out.println("----java课程------");
        NetworkCourse javaCourse = new JavaCourse();
        javaCourse.createCourse();
        System.out.println("----BigData1课程------");
        NetworkCourse bigData1 = new BigDataCourse(true);
        bigData1.createCourse();
        System.out.println("----BigData2课程------");
        NetworkCourse bigData2 = new BigDataCourse(false);
        bigData2.createCourse();
    }
}
