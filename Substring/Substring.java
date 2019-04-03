package com.company.Substring;

public class Substring {
    public static int substring(String A, String B) {

        StringBuilder tmp = new StringBuilder(A);
        int iter = 1;
        while (tmp.length() < B.length()) {
            tmp.append(A);
            iter++;
        }

        if (tmp.indexOf(B) != -1) {
            return iter;
        }

        // prefix
        tmp.append(A);
        ++iter;
        if (tmp.indexOf(B) != -1) {
            return iter;
        }

        //suffix
        tmp.insert(0, A);
        ++iter;
        if (tmp.indexOf(B) != -1) {
            return iter;
        }

        return -1;
    }

    /*
    public static int sub(String A, String B) {

        String tmp = A;
        int iter = 1;
        while (tmp.length() < B.length()) {
            tmp += A;
            iter++;
        }

        if (tmp.contains(B)) {
            return iter;
        }

        //prefix
        tmp += A;
        if (tmp.contains(B)) {
            return ++iter;
        }

        //suffix
        tmp = A + tmp;
        if (tmp.contains(B)) {
            return ++iter;
        }
        return -1;
    }
    */

    public static void main() {
        Substring S = new Substring();
        System.out.println(S.substring("abcd", "cdabcdab"));
        System.out.println("\n---\n");
    }
}
