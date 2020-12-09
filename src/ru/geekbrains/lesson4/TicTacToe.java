package ru.geekbrains.lesson4;
// 1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку;
// 2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
// 3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4.
// Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
// 4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
public class TicTacToe {
    private static final char[][] MAP = new char[3][3];
    private static final char USER = 'X';
    private static final char PC = '0';
    private static final char DEFAULT = '_';

    static void fillMap() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                MAP[i][j] = DEFAULT;
            }
        }
    }

    static void printMap(){
        System.out.print("  ");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < 3; j++){
                System.out.print(MAP[i][j] + "|");
            }
            System.out.println();
        }
    }

    static boolean move(int x, int y, char player){
        try {
            if (MAP[x][y] == DEFAULT) {
                MAP[x][y] = player;
                return true;
            } else {
                return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    static boolean isVictory(char player) {
        return false;
    }

    public static void main(String[] args) {
        fillMap();
        printMap();
    }
}
