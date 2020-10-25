package ru.geekbrains.lesson1;

public class DataTypes {
    public static void main(String[] args) {

        // 2. Создать переменные всех пройденных типов данных, и инициализировать их значения

        // целые
        byte b1 = 127; // 1b [-128, 127]
        short s = 32767; // 2b [-32768, 32767] 2 ** 15
        int i = 2_000_000_000; // 4b 2 ** 31 (2 * 10 ** 9)
        long l = 2_000_000_000_000_000_000L; // 8b 2 ** 63 (9 * 10 ** 18)

        // вещественные
        float f = 0.6f; // 4b
        double d1 = 0.14; // 8b

        boolean bool = true; // true, false

        char sym = '&'; // \'"
        char sum1 = '\'';
        String strHello = "Hello, World!";
    }
}
