package com.epam.javacourse.homework2;

class Sqrt {
    public int mySqrt(int x) {
        int a = 1;
        int b = x;

        while(a <= b){
            int c = (a + b) / 2;

            if(x / c == c){
                return c;
            } else if(c > x / c){
                b = c - 1;
            } else {
                a = c + 1;
            }
        }

        return b;
    }
}
