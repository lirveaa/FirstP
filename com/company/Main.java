package com.company;//package com.company;
import java.util.Scanner;
import java.util.TreeMap;

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
        }
        else {
            try {
                System.out.println("Incorrect input error!");
                System.exit(0);
            } catch (Exception e) {
                System.out.println("Incorrect input error!");

            }
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
                        try {
                            result = op1/op2;
                        }
                        catch (Exception e){
                            System.out.println("Can't divide to Zero!");
                            return;
                        }

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
        int result = 0;


        if (num1 > 10 || num2 > 10) {
            System.out.println("Incorrect input!");
        } else {
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":

                    if (num2 == 0) {
                        try {
                            result = num1/num2;
                        }
                        catch (Exception e){
                            System.out.println("Can't divide to Zero!");
                            return;
                        }

                    }


                    result = num1 / num2;
                    break;
                default:
                    System.out.println("Incorrect input!");
            }

            System.out.println(ToRomanNum.toRoman(result));
        }
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



// Program to convert Roman
// Numerals to Numbers


class ToRomanNum {

    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }

    public final static String toRoman(int number) {
        int l = map.floorKey(number);
        if (number == l) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number - l);
    }


    }

