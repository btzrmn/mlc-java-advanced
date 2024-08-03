package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SmartArray array = new SmartArray();
//        array.add(8);
        array.forEach(i -> System.out.println(i));

        CustomStack stack = new CustomStack();
        stack.push(50);
        System.out.println(stack.pop());
        stack.push(51);
        System.out.println(stack.peek());
        stack.push(52);
        stack.push(53);
        System.out.println(stack.peek());
        stack.forEach(i -> System.out.println("Stack " + i));
    }
}