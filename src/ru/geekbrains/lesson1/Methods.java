package ru.geekbrains;

import java.util.Scanner;

public class Methods {

    //3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значение переменной А");
        int a = scanner.nextInt();
        System.out.println("Введите значение переменной В");
        int b = scanner.nextInt();
        System.out.println("Введите значение переменной C");
        int c = scanner.nextInt();
        System.out.println("Введите значение переменной D");
        int d = scanner.nextInt();
        int result = a * (b + (c / d));
        System.out.println("Результат - " + result);
    }

    //4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;

    public boolean check(int a, int b){
        int s = a + b;
        return s >= 10 && s <= 20;
    }

    //5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.

    private static boolean number(int num) {
        return num >= 0;
    }

    //6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;

    private static boolean negative_number(int num) {
        return num < 0;
    }

    //7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;

    private static String userName(String name) {
        return "Привет, " + name;
    }
}
