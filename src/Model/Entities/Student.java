/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entities;


/**
 *
 * @author aybatukerkukluoglu
 */
public class Student implements Comparable<Student> {
    //PROPERTIES OF A STUDENT
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    
    /**
     * Student constructor
     * @param id an integer for student ID
     * @param firstName a string for a student name
     * @param lastName a string for a student last name
     * @param address a string for a student address
     */
    public Student(int id, String firstName, String lastName, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    /**
     * Provides the student ID
     * @return an integer as student id
     */
    public int getId() {
        return id;
    }
    /**
     * Provides the student first name
     * @return a string as student name. 
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Provides the student last name
     * @return a string as student last name.
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Provides the student address
     * @return a string as student address.
     */
    public String getAddress() {
        return address;
    }
    
    @Override
    public int compareTo(Student o) {
        return toString().compareTo(o.toString()); 
    }
    
    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }

    
}
