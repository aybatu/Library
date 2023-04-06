/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controller;

import java.util.List;

/**
 *Search interface has some methods to search objects lists.
 * @author aybatukerkukluoglu
 * @param <T> Generic type any object with compatible comparable interface.
 */
public interface Search<T extends Comparable<T>> {
    /**
     * Implements binary search for requested target
     * @param list object array list to search through.
     * @param target is the object to search.
     * @param start starting point to start search.
     * @param end end point to search up to.
     * @return 
     */
    public int binarySearch(List<T> list, String target, int start, int end);
}
