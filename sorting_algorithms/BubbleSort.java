package data_structure.sorting_algorithms;

import java.util.Scanner;

public class BubbleSort {
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (marks[i - 1] > marks[i]) {
                    // Swap marks[i - 1] and marks[i]
                    int temp = marks[i - 1];
                    marks[i - 1] = marks[i];
                    marks[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] marks = new int[n];
        for (int i = 0; i < n; i++) {
            marks[i] = input.nextInt();
        }
        bubbleSort(marks);
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
    }
}
