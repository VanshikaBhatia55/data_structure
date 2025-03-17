package data_structure.sorting_algorithms;

import java.util.Scanner;

public class MergeSort {
    public static void mergeSort(double[] prices) {
        if (prices.length < 2) {
            return;
        }
        int mid = prices.length / 2;
        double[] left = new double[mid];
        double[] right = new double[prices.length - mid];

        System.arraycopy(prices, 0, left, 0, mid);
        System.arraycopy(prices, mid, right, 0, prices.length - mid);

        mergeSort(left);
        mergeSort(right);
        merge(prices, left, right);
    }

    private static void merge(double[] prices, double[] left, double[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                prices[k++] = left[i++];
            } else {
                prices[k++] = right[j++];
            }
        }
        while (i < left.length) {
            prices[k++] = left[i++];
        }
        while (j < right.length) {
            prices[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        double[] bookPrices  = new double[n];
        for (int i = 0; i < n; i++) {
            bookPrices[i] = input.nextDouble();
        }
        mergeSort(bookPrices);
        for (double price : bookPrices) {
            System.out.print(price + " ");
        }
    }
}
