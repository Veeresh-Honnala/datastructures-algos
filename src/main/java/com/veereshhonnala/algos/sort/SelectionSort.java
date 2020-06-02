package com.veereshhonnala.algos.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO:need to implement selection sort
public class SelectionSort {
    public static void main(String args[]) throws IOException {
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

    public static int[] sort(int[] arr1) {
        int[] arr = arr1.clone();
        int n = arr.length;
        System.out.println(" n  " + n);
        int minIdx = 0;
        for (int i = 0; i < n; i++) {
            minIdx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[minIdx] > arr[j])
                    minIdx = j;

            System.out.print(" minIdx " + minIdx);
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
        System.out.println();
        return arr;
    }


}
