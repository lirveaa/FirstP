package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        String[] roman_num = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        System.out.println("Input number: ");
        Scanner sc = new Scanner(System.in);
        String op1 = sc.next();
        String operator = sc.next();
        String op2 = sc.next();

        CheckNum ck = new CheckNum();
        if(ck.check(roman_num, op1,op2,operator)){
            Calc cl = new Calc();
            cl.Calc_romans(op1,operator,op2);
        }
        else{
            Calc cl = new Calc();
            cl.Calculate(Integer.parseInt(op1), Integer.parseInt(op2),operator);
        }


        sc.close();
    }

}

class CheckNum {
    public boolean check(String[] arr, String op1, String op2, String operator) {
        // check if the specified element
        // is present in the array or not
        // using Linear Search method
        boolean status = false;
        boolean test1 = false;
        for (String element : arr) {
            if (element.equals(op1)) {
                test1 = true;
                break;
            }
        }
        boolean test2 = false;
        for (String element : arr) {
            if (element.equals(op2)) {
                test2 = true;
                break;
            }
        }
        if (test1 && test2) {
            status = true;
        } else if (!test1 && !test2) {
            status = false;
        } else {
            System.out.println("Error!");
        }

        return status;
    }
}

class Calc {
    public void Calculate(int op1, int op2, String operator) {
        int result = 0;


        if (op1 > 10 || op2 > 10) {
            System.out.println("Incorrect input!");
        } else {
            switch (operator) {
                case "+":
                    result = op1 + op2;
                    break;
                case "-":
                    result = op1 - op2;
                    break;
                case "*":
                    result = op1 * op2;
                    break;
                case "/":
                    if (op2 == 0) {
                        System.out.println("Can't divide to Zero!");
                        return;
                    }
                    result = op1 / op2;
                    break;
                default:
                    System.out.println("Incorrect input!");
            }

            System.out.println(result);
        }

}


    public void Calc_romans(String op1, String operator, String op2) {
        int num1 = roman_int(op1);
        int num2 = roman_int(op2);
        Calculate(num1, num2, operator);
    }

    int roman_int(String ch) {
        int num = 0;
        switch (ch) {
            case "I":
                num = 1;
                break;
            case "II":
                num = 2;
                break;
            case "III":
                num = 3;
                break;
            case "IV":
                num = 4;
                break;
            case "V":
                num = 5;
                break;
            case "VI":
                num = 6;
                break;
            case "VII":
                num = 7;
                break;
            case "VIII":
                num = 8;
                break;
            case "IX":
                num = 9;
                break;
            case "X":
                num = 10;
                break;
            default:
                System.out.println("invalid input");

        }
        return num;

    }
}