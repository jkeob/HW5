/******************************************************************
 *
 *   Jacob / 001
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {

        // ADD YOU CODE HERE -- DON'T FORGET TO ADD YOR NAME AT TOP OF FILE
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();

        // loop through list1 and put each value into the hashtable
        // the key here is just the index, and the value is the element from list1
        for (int i = 0; i < list1.length; i++) {
            hashtable.put(i, list1[i]);
        }

        // now loop through list2 to check if each value is in the hashtable
        for (int i = 0; i < list2.length; i++) {
            // if we find a value in list2 that isn't in the hashtable it's not a subset
            if (!hashtable.contains(list2[i])) {
                return false;
            }
        }



        return true;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        // ADD YOUR CODE HERE
        //sort it first with insertion sort
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }

        System.out.println(array[array.length-(k)]);

        //count back from the end of the array
        return array[array.length-k];
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {

        // ADD YOU CODE HERE
        //combine the two arrays.
        int[] arrayCombined = new int[array1.length+array2.length];

        for (int i = 0; i < array1.length ; i++) {
            arrayCombined[i] = array1[i];
        }
        for (int i = 0; i <array2.length; i++) {
            arrayCombined[i+array1.length] = array2[i];
        }

        //insertion sort them
        for (int i = 1; i < arrayCombined.length; i++) {
            int key = arrayCombined[i];
            int j = i - 1;

            while (j >= 0 && arrayCombined[j] > key) {
                arrayCombined[j + 1] = arrayCombined[j];
                j--;
            }

            arrayCombined[j + 1] = key;
        }



        return arrayCombined;
    }

}
