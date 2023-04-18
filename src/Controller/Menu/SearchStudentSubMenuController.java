/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Menu;

import Controller.SearchAlgorithms;
import Controller.Student.StudentFactory;
import Model.Entities.Student;
import Utils.Utils;
import View.ShowStudentInfoView;
import java.util.List;

/**
 *
 * @author aybatukerkukluoglu
 */
public class SearchStudentSubMenuController {

    //PROPERTIES
    //new binarysearch object.
    private final SearchAlgorithms bS = new SearchAlgorithms();
    //new Utils object
    private final Utils iU = new Utils();
    //NewShowStudentView object
    private final ShowStudentInfoView sSIV = new ShowStudentInfoView();

    /**
     * Empty constructor.
     */
    public SearchStudentSubMenuController() {
    }

    /**
     * Request a prompt user to enter an ID for student.
     *
     * @param prompt String student ID.
     */
    public void requestStudentID(String prompt) {

        //Book title request
        String student = iU.getString(prompt);
        //Called method searches for the book name through the book list.
        searchForAStudent(student);
    }

    public void searchStudentID(String studentInfo) {

        //Called method searches for the book name through the book list.
        searchForAStudent(studentInfo);
    }

    public void requestStudentName(String prompt) {

        //Book title request
        String student = iU.getString(prompt);
        //Called method searches for the book name through the book list.
        searchForAStudent(student);
    }

    private void searchForAStudent(String studentInfo) {

        //new student factory
        StudentFactory sF = new StudentFactory();
        //new sorted book array list stored in bookList variable.
        List<Student> studentList = sF.sortedStudentList();

        //Requested book index stored in bookIndex
        int studentIndex = bS.binarySearch(studentList, studentInfo, 0, studentList.size() - 1);

        //If book index is not found return -1.
        if (studentIndex == -1) {
            System.out.println("Sorry, we could not found provided info: " + studentInfo + " registered in library system.");
        } else {
            //Index is found prompts the information of the book.
            sSIV.showStudentInfo(studentList.get(studentIndex));

        }

    }
}
