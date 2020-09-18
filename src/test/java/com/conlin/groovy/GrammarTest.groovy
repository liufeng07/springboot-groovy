package com.conlin.groovy

class GrammarTest {
    static void main(String[] args) {
        //--------------
        printf("hello world");
        //--------------
        def a =1
        printf(a.getClass().getName());
        //--------------
        def range = 1..6
        println(range)
        println(range.get(2))
        //--------------
        for (def index =0;index<10;index++){
            println index;
        }
    }
}
