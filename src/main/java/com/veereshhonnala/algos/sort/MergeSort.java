package com.veereshhonnala.algos.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort {
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

    public static void sort(int[] arr, int l, int r) {

        if (r > l) {  //3 >0,
            int p = (int) (l + r) / 2; //1
            sort(arr, l, p); //0,1
            sort(arr, p + 1, r);//1,3
            merge(arr, l, p, r);
        }

    }

    public static void merge(int[] arr, int l, int p, int h) {
        int n1 = p - l + 1;
        int[] L = new int[n1];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];

        int n2 = h - p;
        int[] R = new int[n2];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[p + j + 1];

        int k = l;
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        //copy n1 remaining element;
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        //copy n2 remaining element;

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}


