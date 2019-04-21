package com.example.demo;

/**
 * Created by teacher-samsung on 20.04.2019.
 */
public class Student {
    String name;
    String lastName;
    String firstName;
    int age;
    int course;
    boolean pass;
    public Student(){}
    public Student(String name, int age){
        this.name=name;
        this.age=age;
    }
    public String toString(){
        return name+" ("+age+"лет)";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

}
