package com.veereshhonnala.algos.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsertionSort {
    public static void main(String ar[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int n = strArr.length;
        int[] intArr = new int[n];
        for (int i = 0; i < n; i++)
            intArr[i] = Integer.parseInt(strArr[i]);

        int[] sortedArr = sort(intArr);
        for (int i = 0; i < n; i++)
            System.out.print(sortedArr[i] + " ");
    }


    private static int[] sort(int arr1[]) {
        int[] arr = arr1.clone();
        int n = arr.length;
        int j = 0;
        int key;
        //12, 11, 13, 5, 6
        for (int i = 1; i < n; i++) {
            j = i - 1;
            key = arr[i];
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }


        return arr;
    }
}
