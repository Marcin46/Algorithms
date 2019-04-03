package com.company.Minimum;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Minimum {
    private List<Integer> randomList = new ArrayList<>();
    private int size;

    public Minimum(int s) {
        try {
            this.size = s;
            if (size > 100000)
                throw new MyException("Over size");
        }catch(MyException e){
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public void loadData() {
        for (int i = 0; i < size; i++) {
            Random random = new Random();
            randomList.add(random.nextInt(10 + 1 + 10) - 10);
        }
    }

    public void print()
    {
        for (int x: randomList) {
            System.out.print(x + ", ");
        }
        System.out.println();
    }

    public int solution () {

            int i = 1;
            try {
            while (randomList.contains(i)) {
                i++;
                if (i > 1000000 || i < -1000000)
                    throw new MyException("Not in range");
            }
        }catch(MyException e){
                System.out.println("Exception: " + e.getMessage());
            }
        return i;
    }

    public static void main()
    {
        Minimum testMin = new Minimum(20);
        testMin.loadData();
        testMin.print();
        System.out.println("Solution = " + testMin.solution());
        System.out.println("\n---\n");
    }
}
