package com.veereshhonnala.algos.search;


public class BinarySearch {
    public static void main(String args[]) {

        final double v = (10 / 2);

        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++)
            arr[i] = i;
        binarySearch(arr, 49);

    }


    static int binarySearch(int arr[], int value) {
        int l = 0, h = arr.length - 1;
        while (l <= h) {
            int p = l + (int) Math.ceil((double) (h - l) / 2);
            if (arr[p] == value)
                return p;
            if (arr[p] > value)
                h = p - 1;
            else
                l = p + 1;
        }
        return -1;
    }
}
