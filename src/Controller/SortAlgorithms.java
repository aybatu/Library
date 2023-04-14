/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Sorting;

/**
 * Implements Bubble Sorting for comparable objects.
 *
 * @author aybatukerkukluoglu
 * @param <T> generic type for all object types
 */
public class SortAlgorithms<T extends Comparable<T>> implements Sorting<T> {

    /**
     * Just a simple constructor
     */
    public SortAlgorithms() {

    }

    @Override
    public void insertionSorting(T[] arr) {
         int n = arr.length;
        for (int i = 1; i < n; ++i) {
            T key = arr[i];
            int j = i - 1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * Sorting interface method to sort comparable object arrays.
     *
     * @param arr an object array to sort.
     */
    @Override
    public void bubbleSorting(T[] arr) {
        //a simple for loop goes through last element to first element.
        for (int i = arr.length - 1; i > 0; i--) {
            //another for loop to move each biggest number to end one by one.
            for (int j = 0; j < i; j++) {
                //if arr[j] compared to arr[j+1] bigger it returns negative value, and changes two value places.
                if (arr[j + 1].compareTo(arr[j]) < 0) {
                    //temp is assigned for the next object
                    T temp = arr[j + 1];
                    //next object is swapped with the previous object.
                    arr[j + 1] = arr[j];
                    //previous object swapped with the next object.
                    arr[j] = temp;
                }
            }
        }
    }
    
}
