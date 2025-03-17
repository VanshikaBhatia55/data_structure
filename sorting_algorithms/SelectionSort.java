package data_structure.sorting_algorithms;

import java.util.Scanner;

public class SelectionSort {
    public static void selectionSort(int[] scores) {
        int n = scores.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] examScores = new int[n];
        for (int i = 0; i < n; i++) {
            examScores[i] = input.nextInt();
        }
        selectionSort(examScores);
        for (int score : examScores) {
            System.out.print(score + " ");
        }
    }
}
