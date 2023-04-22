/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 * Implements Bubble Sorting for comparable objects.
 *
 * @author aybatukerkukluoglu
 * @param <T> generic type for all object types
 */
public class SortAlgorithms<T extends Comparable<T>> implements Sorting<T> {

    /**
     * Just a simple constructor.
     */
    public SortAlgorithms() {

    }

    /**
     * Method sorts comparable objects by insertion sort algorithm.
     *
     * Method is inactive, can be deleted or can be implemented instead of
     * mergeSort method.
     *
     * @param arr an array of objects.
     */
    @Override
    public void insertionSorting(T[] arr) {
        //array capacity stored in variable 'n'
        int n = arr.length;
        //a simple for loop
        for (int i = 1; i < n; ++i) {
            //gets object in index 'i' stores it in key.
            T key = arr[i];
            // gets index of before key object and stores in 'j'
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
     * Method is inactive, can be deleted or can be implemented instead of mergeSort method.
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

    /**
     * Sorts comparable objects with divideMerge sorting method.
     *
     * @param arr an array of objects.
     */
    @Override
    public void divideMerge(T[] arr) {
        //if arr length 1 there is no need to sort and it cannot bi divided.
        if (arr.length > 1) {
            //first half size of the arr stored in 'firstHalfSize' variable.
            int firstHalfSize = arr.length / 2;
            //Generic type Comparable array created with the size of 'firstHalfSizel'
            T[] firstHalf = (T[]) new Comparable[firstHalfSize];
            //'arr' first half copied into 'firstHalf' array
            System.arraycopy(arr, 0, firstHalf, 0, firstHalfSize);

            //Method does it till it has one element for divided parts by using recursion method.
            divideMerge(firstHalf);

            //Remain element count of array is stored in 'secondHalfSize' variable.
            int secondHalfSize = arr.length - firstHalfSize;
            //new second half Generic type array created with the size of second half.
            T[] secondHalf = (T[]) new Comparable[secondHalfSize];
            //arr copied from 'firstHalfSize' to end and copy is moved to 'secondHalf' array.
            System.arraycopy(arr, firstHalfSize, secondHalf, 0, secondHalfSize);

            //Method does it till it has one element for divided parts by using recursion method.
            divideMerge(secondHalf);
            //All parameters is sent to mergeSort method.
            mergeSort(firstHalf, secondHalf, arr);
        }
    }

    /**
     * Used by divide merge method.
     *
     * @param a first half of the array.
     * @param b second half of the array.
     * @param s target array to sort.
     */
    @Override
    public void mergeSort(T[] a, T[] b, T[] s) {
        //counter for array 'a'
        int counterA = 0;
        //counter for array 'b'
        int counterB = 0;
        //counter for array 's'
        int counterS = 0;

        //a simple while loop
        while (counterA < a.length && counterB < b.length) {// while counterA and B smaller than the length of arrays it will keep looping
            if (a[counterA].compareTo(b[counterB]) < 0) {//if array 'a' element at index counterA less then array 'b' element at counterB index
                // element in array s at index counterS replaced with the element in array 'a' at index counterA.
                s[counterS] = a[counterA];
                //counterA increased by 1.
                counterA++;
            } else {
                //element in array 's' at index 'counterS' replaced with element in array 'b' at index 'counterB'
                s[counterS] = b[counterB];
                //counterB increased by 1.
                counterB++;
            }
            //coutnerS increased by 1.
            counterS++;
        }
        //if there is remain element in array "a" replace elements in array 's' with array'a' elements.
        while (counterA < a.length) {
            s[counterS] = a[counterA];
            counterA++;
            counterS++;
        }
        //if there is remain elements in array 'b' replaces elements in array 's' with array 'b' elements.
        while (counterB < b.length) {
            s[counterS] = b[counterB];
            counterB++;
            counterS++;
        }

    }

}
