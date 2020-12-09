package ru.geekbrains.lesson5;

//1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
//2. Конструктор класса должен заполнять эти поля при создании объекта;
//3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
//4. Создать массив из 5 сотрудников
//Пример:
//Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
//persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
//persArray[1] = new Person(...);
//...
//persArray[4] = new Person(...);
//5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;

public class Person {
    private String fio;
    private String post;
    private String email;
    private String tel;
    private double salary;
    private int age;

    public Person(String fio, String post, String email, String tel, double salary, int age) {
        this.fio = fio;
        this.post = post;
        this.email = email;
        this.tel = tel;
        this.salary = salary;
    }

    int GetAge() {
        return this.age;
    }

    void Show() {
        System.out.println(this.fio + " " + this.post + " " + this.email + " " + this.tel + " " + this.salary + " " + this.age);
    }

    public class Main {
        public Main() {
        }

        public void main(String[] args) {
            Person[] persArray = new Person[]{new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000.0D, 30), new Person("Prtrov Petr", "cashier", "PPetrov@mailbox.com", "897777777", 40000.0D, 40), new Person("Vladimirov Vladimir", "loader", "VVladimirov@mailbox.com", "899777777", 50000.0D, 50), new Person("Sidorov Sidor", "manager", "SSidorov@mailbox.com", "899977777", 60000.0D, 60), new Person("Artemor Artem", "handyman", "AArtemor@mailbox.com", "899997777", 70000.0D, 70)};
            Person[] var3 = persArray;
            int var4 = persArray.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                Person item = var3[var5];
                if (item.GetAge() > 40) {
                    item.Show();
                }
            }
        }
    }
}