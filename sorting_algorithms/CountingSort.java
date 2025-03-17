package data_structure.sorting_algorithms;

import java.util.Scanner;

public class CountingSort {
    public static void countingSort(int[] ages) {
        int maxAge = 18; // Assuming ages range from 10 to 18
        int minAge = 10;
        int range = maxAge - minAge + 1;

        // Create count array
        int[] count = new int[range];
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Reconstruct the sorted array
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                ages[index++] = i + minAge;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] studentAges = new int[n];
        for (int i = 0; i < n; i++) {
            studentAges[i] = input.nextInt();
        }
        countingSort(studentAges);
        for (int age : studentAges) {
            System.out.print(age + " ");
        }
    }
}
