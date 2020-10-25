package ru.geekbrains.Lesson3;
// 1. Написать программу, которая загадывает случайное число от 0 до 9,
// и пользователю дается 3 попытки угадать это число.
// При каждой попытке компьютер должен сообщить больше ли указанное пользователем
// число чем загаданное, или меньше. После победы или проигрыша выводится запрос
// – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).

import java.util.Scanner;

public class Lesson3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Игра угадай число! Отгадайте число от 0 до 9 за 3 попытки");
        System.out.println("Введите число от 0 до 9");
        int hiddenNumber = (int) (Math.random() * 10);
        do {
            for (int i = 1; i < 4; i++){
                System.out.println("Введите число");
                int number = scanner.nextInt();
                if (number == hiddenNumber) {
                    System.out.println("Поздравляю, Вы угадали!");
                    break;
                }
                if (number > hiddenNumber) {
                    System.out.println("Загаданное число меньше");
                } else System.out.println("Загаданное число больше");
                System.out.println("Количество попыток - " + i);
                if (i == 3) { System.out.println("Вы проиграли"); }
            }
            System.out.println("Хотите начать заново? Нажмите 1");
        } while (scanner.nextInt() == 1);
    }
}
