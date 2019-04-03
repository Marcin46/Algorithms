package com.company.SortTime;
import java.util.Random;

public class TestSortTime {

    public void test(String type) {
        int tab1[] = new int[10000];
        for (int i = 0; i < tab1.length; i++) {
            tab1[i] = i;
        }

        int tab2[] = new int[10000];
        int j = 0;
        for (int i = tab1.length - 1; i > 0; i--) {
            tab2[j] = i;
            j++;
        }

        int tab3[] = new int[10000];
        for (int i = 0; i < tab1.length; i++) {
            Random random = new Random();
            tab3[i] = random.nextInt(10000 + 1);
        }

        Sort t;

        switch (type) {
            case "Q": {
                t = new QuickSort();
                System.out.println("QUICK SORT");
                break;
            }
            case "I": {
                t = new InsertionSort();
                System.out.println("INSERTION SORT");
                break;
            }
            case "S": {
                t = new SelectionSort();
                System.out.println("SELECTION SORT");
                break;
            }
            case "M": {
                t = new MergeSort();
                System.out.println("MERGE SORT");
                break;
            }
            case "B": {
                t = new BubbleSort();
                System.out.println("BUBBLE SORT");
                break;
            }
            default:{
                t = null;
            }
        }
        System.out.println("O: " + t.measureTime(tab1));
        System.out.println("P: " + t.measureTime(tab2));
        System.out.println("R: " + t.measureTime(tab3));
    }

    public static void main()
    {
        TestSortTime t = new TestSortTime();
        t.test("I");
        t.test("S");
        t.test("B");
        t.test("M");
        t.test("Q");
    }
}
