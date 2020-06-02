package com.veereshhonnala.algos.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort {


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strArr[] = br.readLine().split("\\u0020");
        int n = strArr.length;
        int[] intArr = new int[n];
        for (int i = 0; i < n; i++)
            intArr[i] = Integer.parseInt(strArr[i]);
        sort(intArr, 0, n - 1);
        for (int i = 0; i < n; i++)
            System.out.print(intArr[i] + " ");
    }

    static void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static int partition(int[] arr, int l, int r) {
        int pVal = arr[r];
        int i = l - 1;
        for (int j = l; j < r; j++)
            if (arr[j] < pVal)
                swap(arr, j, ++i);

        swap(arr, r, ++i);
        return i;
    }

    static void sort(int[] arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);
            sort(arr, l, p - 1);
            sort(arr, p + 1, r);
        }
    }
}
