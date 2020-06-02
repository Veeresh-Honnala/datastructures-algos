package com.veereshhonnala.algos.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BobbleSort {


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter int array");
        String[] str = br.readLine().split(" ");
        int n = str.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(str[i]);
        int[] arr2 = sort(arr);
        for (int i = 0; i < n; i++)
            System.out.print(arr2[i] + " ");

    }

    public static int[] sort(int arr[]) {
        int n = arr.length;
        int jn = 0;
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            jn = n - i - 1;
            for (int j = 0; j < jn; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }

            }
        }
        return arr;
    }
}