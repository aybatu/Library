/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entities;

import Utils.Constant;

/**
 *
 * @author aybatukerkukluoglu
 */
public class Student implements Comparable<Student> {

    //PROPERTIES OF A STUDENT
    private String id;
    private String firstName;
    private String lastName;
    private String address;

    /**
     * Student constructor
     *
     * @param id an integer for student ID
     * @param firstName a string for a student name
     * @param lastName a string for a student last name
     * @param address a string for a student address
     */
    public Student(String id, String firstName, String lastName, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    /**
     * Provides the student ID
     *
     * @return an integer as student id
     */
    public String getId() {
        return id;
    }

    /**
     * Provides the student first name
     *
     * @return a string as student name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Provides the student last name
     *
     * @return a string as student last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Provides the student address
     *
     * @return a string as student address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Makes object comparable for sort in a order.
     *
     * @param o another object to compare.
     * @return an integer as a comparison result.
     */
    @Override
    public int compareTo(Student o) {
        //Compares object's toString method return with provided another Student object toString method return
        return toString().compareTo(o.toString());
    }

    /**
     * Overrides 'toString' when object called by itself provides student full
     * name or ID.
     *
     * @return a string for the student full name or ID.
     */
    @Override
    public String toString() {
        //byStudentName set true returns student name in lower case
        if (Constant.StudentSearch.byStudentName) {
            return this.firstName.toLowerCase() + " " + this.lastName.toLowerCase();
        } else {
            //byStudentName set false return student id as a String.
            return id;
        }
    }

}
