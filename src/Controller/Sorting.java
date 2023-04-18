package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
/**
 * An interface to sort objects
 *
 * @author aybatukerkukluoglu
 * @param <T> Generic Type for objects
 */
public interface Sorting<T extends Comparable<T>> {

    /**
     * Implements bubble sorting method for objects
     *
     * @param arr object array to sort.
     */
    public void bubbleSorting(T[] arr);

    /**
     * Method sorts comparable objects by insertion sort algorithm
     *
     * @param arr an array of objects.
     */
    public void insertionSorting(T[] arr);

    /**
     * Sorts comparable objects with divideMerge sorting method.
     *
     * @param arr an array of objects.
     */
    public void divideMerge(T[] arr);

    /**
     * Used by divide merge method.
     *
     * @param a first half of the array.
     * @param b second half of the array.
     * @param s sorted array.
     */
    public void mergeSort(T[] a, T[] b, T[] s);
}
