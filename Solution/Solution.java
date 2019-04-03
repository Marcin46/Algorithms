package com.company.Solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {
    private float target;
    private float[] arr;

    public Solution(float t, float[] a) {
        this.target = t;
        this.arr = a;
    }

    void loadRandomData() {
        for (int i = 0; i < arr.length; i++) {
            Random random = new Random();
            arr[i] = random.nextInt(10 + 1);
        }
    }

    void print() {
        for (int i = 0; i < arr.length; i++)
            System.out.println(i + " - " + arr[i]);
    }

    float[] solution()
    {
        if (arr == null || arr.length < 2) {
            return null;
        }

        Map<Float, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            float minuend = target - arr[i];
            if (indexMap.get(minuend) != null) {
                return new float[]{i, indexMap.get(minuend)};
            }
            indexMap.put(arr[i], i);
        }

        return null;
    }

    public static void main()
    {
        float[] tab = new float[10];
        Solution testSol = new Solution(10, tab);
        testSol.loadRandomData();
        tab = testSol.solution();
        System.out.println(tab[0] + " " + tab[1]);
        System.out.println();
        testSol.print();
        System.out.println("\n---\n");
    }
}

