package com.company.Matrix;
import java.lang.Object;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;


public class Matrix<T> {

    private int rows;
    private int columns;
    public Object data[][];

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        @SuppressWarnings("unchecked") T[][] array = (T[][]) new Object[rows][columns];
        data = array;

    }
    public Matrix(Object[][]data){
        this.data = data;
        this.rows = data.length;
        this.columns = data[0].length;
    }


    public void insertRandomIntegerData()
    {
        Random random = new Random();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++) {
                data[i][j] = random.nextInt(10 + 1);
            }
        }
    }

    public Matrix<?> add(Matrix<?> M2){

        if (this.rows != M2.rows || this.columns != M2.columns)
            throw new RuntimeException("Unequal rows and columns.");

        @SuppressWarnings("unchecked") Matrix<?> addedM = new Matrix(this.rows, this.columns);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if(M2.data[i][j] instanceof Integer)
                    addedM.data[i][j] = (int)this.data[i][j] + (int)M2.data[i][j];
                if(M2.data[i][j] instanceof String)
                    addedM.data[i][j] = (String)this.data[i][j] + (String)M2.data[i][j];

            }
        }

        return addedM;
    }

    @Override
    public String toString() {
        LinkedList<Object> l = new LinkedList<>();
        for(int i = 0; i < this.data.length; i++) {
            l.clear();
            for(int j = 0; j < this.data[i].length; j++) {
                l.add(data[i][j]);
            }
            Iterator<Object> it = l.iterator();
            while(it.hasNext()) {
                System.out.print(it.next() + "\t");
            }
            System.out.println();
        }
        return "";
    }

    public static void main()
    {
        Matrix<Integer> M1 = new Matrix<>(3, 3);
        Matrix<Integer> M2 = new Matrix<>(3, 3);

        M1.insertRandomIntegerData();
        System.out.println(M1);
        M2.insertRandomIntegerData();
        System.out.println(M2);

        @SuppressWarnings("unchecked") Matrix<Integer> addedM = (Matrix<Integer>) M1.add(M2);
        System.out.println(addedM);


        String [][] s1 = {{"d","s","w"},{"d","s","w"},{"d","s","w"}};
        String [][] s2 = {{"r","t","y"},{"u","i","o"},{"a","s","d"}};
        Matrix<String> S1 = new Matrix<String>(s1);
        Matrix<String> S2 = new Matrix<String>(s2);
        System.out.println(S1);
        System.out.println(S2);

        @SuppressWarnings("unchecked") Matrix<String> addedS = (Matrix<String>) S1.add(S2);
        System.out.println(addedS);
        System.out.println("---\n");
    }
}