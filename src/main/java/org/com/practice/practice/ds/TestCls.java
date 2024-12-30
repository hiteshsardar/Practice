package org.com.practice.practice.ds;

public class TestCls {
    public static boolean solve(String s) {

        // define 2 pointers (forward pointer and backward pointer and compare characters accordingly)
        int leftIndex = 0;
        int rightIndex = s.length() - 1;

        while (leftIndex < rightIndex) {
            if(s.charAt(leftIndex) != s.charAt(rightIndex)) {
                break;
            }
            leftIndex++;
            rightIndex--;
        }

        if(leftIndex >= rightIndex)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        int no = 1234;
        System.out.println(no/10);
     }
}
