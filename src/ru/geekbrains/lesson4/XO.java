package ru.geekbrains.lesson4;

import java.util.Random;
import java.util.Scanner;

public class XO {

        // игра крестики и нолики

        private static final char USER ='X';
        private static final char PC = 'O';
        private static final char DEFAULT = '_';
        private static final int Size = 4;
        private static char[][] field = new char[Size][Size];

        public static void main(String[] args) {                                                        // запуск программы
            mainMenu();
        }

    // меню игры
        private static void mainMenu() {
            System.out.println("Игра крестики нолики \nНажмите 1 и ВВОД для начала игры " +
                    "\nНажмите 2 и ВВОД для выхода из игры ");
            int mode = 0;
            Scanner in = new Scanner(System.in);
            mode = in.nextInt();
            switch (mode) {
                case 1: {
                    Game();
                    break;
                }
                case 2: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Ошибка. Попробуй еще раз");
                }
            }
        }

        private static void Game() {
            int count = 0;
            initField();
            while (true) {
                printField();
                userStep(USER, 0);
                count++;
                if (checkWin(USER)) {
                    System.out.println("Вы победили!");
                    printField();
                    break;
                }
                aiStep();
                count++;
                if (checkWin(PC)) {
                    System.out.println("Вы проиграли!");
                    printField();
                    break;
                } else {
                    System.out.println("НИЧЬЯ!");
                  }
                if (count == Math.pow(Size, 2)) {
                    printField();
                    break;
                }
            }
        }

    // заполнение поля
        private static void initField() {
            for (int i = 0; i < Size; i++) {
                for (int j = 0; j < Size; j++) {
                    field[i][j] = DEFAULT;
                }
            }
        }
    // печать поля
        private static void printField() {
            for (int i = 0; i <= Size; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
            for (int i = 0; i < Size; i++) {
                System.out.print((i + 1) + " ");
                for (int j = 0; j < Size; j++) {
                    System.out.print(field[i][j] + " ");
                }
                System.out.println();
            }
        }
    // ход игрока
        private static void userStep(char Sign, int UserNumb) {
            int x;
            int y;
            do {
                if (UserNumb == 0) {
                    System.out.println("Введите координаты x и y от 1 до " + Size + " после ввода каждой координаты нажимайте клавишу ВВОД");
                } else {
                    System.out.println("Игрок " + UserNumb + " Введите координаты x и y от 1 до " + Size + " после ввода каждой координаты нажимайте клавишу ВВОД");
                }
                Scanner sc = new Scanner(System.in);
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
            }
            while (CellBusy(x, y));
            field[x][y] = Sign;
        }

        private static void aiStep() {
            int x = -1;
            int y = -1;
            boolean ai_win = false;
            boolean user_win = false;

    // выигрышный ход
            for (int i = 0; i < Size; i++) {
                for (int j = 0; j < Size; j++) {
                    if (!CellBusy(i, j)) {
                        field[i][j] = PC;
                        if (checkWin(PC)) {
                            x = i;
                            y = j;
                            ai_win = true;
                        }
                        field[i][j] = DEFAULT;
                    }
                }
            }
   // проверка последнего хода
            if (!ai_win) {
                for (int i = 0; i < Size; i++) {
                    for (int j = 0; j < Size; j++) {
                        if (!CellBusy(i, j)) {
                            field[i][j] = USER;
                            if (checkWin(USER))
                            {
                                x = i;
                                y = j;
                                user_win = true;
                            }
                            field[i][j] = DEFAULT;
                        }
                    }
                }
            }
   // свободный ход
            if (!ai_win && !user_win) {
                do {
                    Random rnd = new Random();
                    x = rnd.nextInt(Size);
                    y = rnd.nextInt(Size);
                }
                while (CellBusy(x, y));
            }
            field[x][y] = PC;
        }

        private static boolean CellBusy(int x, int y) {
            if (x < 0 || y < 0 || x > Size - 1 || y > Size - 1) {
                return false;
            }
            return field[x][y] != DEFAULT;
        }
    // сравнение по линии
        private static boolean checkLine(int start_x, int start_y, int dx, int dy, char Sign) {
            for (int i = 0; i < Size; i++) {
                if (field[start_x + i * dx][start_y + i * dy] != Sign)
                    return false;
            }
            return true;
        }
    // проверка строк
        private static boolean checkWin(char Sign) {
            for (int i = 0; i < Size; i++) {
                if (checkLine(i, 0, 0, 1, Sign)) return true;
    // проверяем столбцы
                if (checkLine(0, i, 1, 0, Sign)) return true;
            }
   // проверяем диагонали
            if (checkLine(0, 0, 1, 1, Sign)) return true;
            if (checkLine(0, Size - 1, 1, -1, Sign)) return true;
            return false;
        }

}

