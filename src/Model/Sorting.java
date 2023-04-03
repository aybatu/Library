package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */



/**
 *An interface to sort objects
 * @author aybatukerkukluoglu
 * @param <T> Generic Type for objects
 */
public interface Sorting<T extends Comparable<T>> {
    /**
     * Implements bubble sorting method for objects
     * @param arr object array to sort.
     */
    public void bubbleSorting(T[] arr);
  
}
