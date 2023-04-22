/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.List;

/**
 *
 * @author aybatukerkukluoglu
 */
public class SearchAlgorithms implements Search {

    /**
     * Empty Constructor.
     */
    public SearchAlgorithms() {
    }

    /**
     * Implements binary search for requested target
     *
     * @param list object array list to search through.
     * @param target is the object to search.
     * @param start starting point to start search.
     * @param end end point to search up to.
     * @return
     */
    @Override
    public int binarySearch(List list, String target, int start, int end) {
        //simple if statement.
        if (start <= end) {//guard condition if starting point is lower or equal to end point it is true.
            //mid point found by start point added up to end point and divided by two.
            int mid = (start + end) / 2;
            //compare value checks the middle object by assigned toString return by target value.
            int comValue = target.toLowerCase().compareTo(list.get(mid).toString().toLowerCase());

            //if compared value is "0" the compared elements are the same ones.
            if (comValue == 0) {
                //returns mid as index.
                return mid;
            } else if (comValue < 0) {//if the comparison value is negative then the target is less then the middle.
                //middle - 1 is decleared as new end point to search target in smaller values by
                // using a recursive function call method.
                return binarySearch(list, target, start, mid - 1);
            } else {
                //else the target must be highed then the middle point.
                //start point is shifted to middle + 1 point to search object in bigger values.
                return binarySearch(list, target, mid + 1, end);
            }
        }

        //Target cannot be found returns "-1".
        return -1;
    }

    /**
     * Simple linear search.
     * Method is inactive, can be deleted or can be implemented instead of binary search method.
     * @param list list of objects to search.
     * @param target object to search.
     * @return index of the object in the list.
     */
    @Override
    public int linearSearch(List list, String target) {
        //index is initially -1 if the object index cannot be found will be returned -1.
        int index = -1;
        //a simple for loop.
        for (int i = 0; i < list.size(); i++) {
            //if it matches the target search it is true.
            if (list.get(i).toString().toLowerCase().equals(target)) {
                //returns index of the element.
                index = i;
                return index;
            }
        }
        //returns index.
        return index;
    }

}
