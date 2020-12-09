package ru.geekbrains.lesson7;

//1. Расширить задачу про котов и тарелки с едой
//2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды,
//а кот пытается съесть 15-20)
//3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось поесть
//(хватило еды), сытость = true
//4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину
//сыт (это сделано для упрощения логики программы)
//5. Создать массив котов и тарелку с едой, попросить всех котов поесть из этой тарелки
//и потом вывести информацию о сытости котов в консоль
//6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
//Задача немного видоизменена: реализован 24х часовой цикл кормления. Разные коты имеют разный аппетит,
//если кот голоден, но еды не хватает,
//она будет автоматически добавлена в кормушку (утопично, конечно, но почему бы и нет).

public class FeedCats {

    private static int TIME = 0;

    public static void main(String[] args) {

        Cat[] cat = new Cat[3];
        cat[0] = new Cat("Рыжик", 300, 6);
        cat[1] = new Cat("Барсик", 200, 7);
        cat[2] = new Cat("Мурзик", 100, 8);

        Plate plate = new Plate(600);
        System.out.println("Коты: " + cat[0].getName() + ", " + cat[1].getName() + " и " + cat[2].getName() + " хотят есть каждые " + cat[0].getSatietyTime() + ", " + cat[1].getSatietyTime() + " и " + cat[2].getSatietyTime() + " часов");
        System.out.println("В миске " + plate.getFood() + " грамм еды. Будут ли накормлены коты.\n");

        do {
            for (Cat i : cat) {
                if (i.getSatiety() == 0) {
                    if (!plate.checkFood(i.getAppetite())) {
                        plate.increaseFood();
                    }
                    i.eat(plate);
                    System.out.println("Кот " + i.getName() + " съел " + i.getAppetite() + " граммов корма и проголодается через " + (i.getSatiety()) + " часов");
                }
                i.setSatiety(i.getSatiety() - 1);
            }
            System.out.println("\nКоты ели " + TIME + " часа(ов) назад. В миске осталось " + plate.getFood() + " граммов корма.\n");
            TIME++;
        } while (TIME <= 24);
    }
}

class Plate {

    private int food;

    int getFood() {
        return food;
    }
    Plate(int food) {
        this.food = food;
    }
    void decreaseFood(int n) {
        food -= n;
    }
    void increaseFood() {
        this.food += 400;
        System.out.println("В миску добавили 400 грамм корма");
    }
    boolean checkFood(int n) {
        return (food - n) >= 0;
    }
}

class Cat {

    private String name;
    private int appetite;
    private int satietyTime;
    private int satiety;

    String getName() {
        return name;
    }

    int getAppetite() {
        return appetite;
    }

    int getSatietyTime() {
        return satietyTime;
    }

    int getSatiety() {
        return satiety;
    }

    void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    Cat(String name, int appetite, int satietyTime) {

        this.name = name;
        this.appetite = appetite;
        this.satietyTime = satietyTime;
        this.satiety = 0;
    }

    void eat(Plate p) {
        p.decreaseFood(appetite);
        satiety += satietyTime;
    }
}