package ru.geekbrains.lesson6;

//1. Создать классы Собака и Кот с наследованием от класса Животное.
//2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
//В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания),
//или высоту (для прыжков).
//3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.;
//прыжок: кот 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
//4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в
//консоль. (Например, dog1.run(150); -> результат: run: true)
//5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение
//на бег может быть 400 м., у другой 600 м.

abstract class Animals {
    protected int length1;
    protected double height1;
    abstract void run(int length);
    abstract void jump(double height);
    abstract void swim(int length);

    static void resultAnimal(Object obj, boolean result) {
        System.out.println(obj.getClass().getName() + " - " + result);
    }
}
class Cat extends Animals {
    @Override
    void run(int length) {
        boolean result = length <= 200;
        if (result) length1 = length;
        resultAnimal(this,result);
    }
    @Override
    void jump(double height) {
        boolean result = height <= 2;
        if (result) height1 = height;
        resultAnimal(this,result);
    }
    @Override
    void swim(int length) {
        System.out.println("Кот не может плавать");
    }
}
class Dog extends Animals {
    private int swim;
    private int maxLength;
    Dog() {
        maxLength = Math.random() > 0.5 ? 400 : 600;
    }
    int getMaxLength() {
        return maxLength;
    }
    @Override
    void swim(int length) {
        boolean result = length <= 10;
        if (result) swim = length;
        resultAnimal(this,result);
    }
    @Override
    void run(int length) {
        boolean result = length <= maxLength;
        if (result) length1 = length;
        resultAnimal(this,result);
    }
    @Override
    void jump(double height) {
        boolean result = height <= 0.5;
        if (result) height1 = height;
        resultAnimal(this,result);
    }
}
public class AnimalsDate {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Animals cat = new Cat();
        dog.run(450);
        cat.run(150);
        dog.jump(1);
        cat.jump(3);
        dog.swim(10);
        cat.swim(10);
    }
}