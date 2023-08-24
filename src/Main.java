/*Часть 2: Паттерны проектирования
__
Фабричный метод:
Реализуйте паттерн Фабричный метод на языке Python для создания геометрических фигур.
 Создайте класс ShapeFactory, имеющий метод create_shape(), который возвращает объекты
  различных геометрических фигур.
__
Адаптер:
Создайте класс ElectricSocket, который имеет метод supply_electricity(voltage).
 Реализуйте класс USPlugAdapter, который адаптирует розетку стандарта США к европейскому стандарту.
  Создайте объекты и продемонстрируйте передачу электроэнергии через адаптер.
__
Стратегия:
Реализуйте паттерн Стратегия на языке Python для сортировки списка чисел. Создайте класс SortStrategy,
 имеющий метод sort(numbers), и несколько конкретных стратегий для различных методов сортировки (например,
  пузырьковая сортировка, сортировка выбором).
__
Декоратор:
Создайте класс Coffee с методом cost(), возвращающим стоимость кофе. Реализуйте декораторы Sugar и Milk,
 которые добавляют сахар и молоко к кофе, соответственно. Создайте объект кофе и последовательно примените
  к нему декораторы, затем выведите общую стоимость.*/

import Decorator.*;
import Strategy.BubbleSortStrategy;
import Strategy.SelectionSortStrategy;
import Strategy.Sorter;
import adapter.AmericanSocket;
import adapter.EuroSocket;
import adapter.SimpleAmericanSocket;
import adapter.USPlugAdapter;
import factory.ShapeFactory;
import factory.ShapeType;
import factory.figures.Shape;

public class Main {
    public static void main(String[] args) {
        /*
         * Фабричный метод
         */
        System.out.println("Фабричный метод");
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.create_shape(ShapeType.CIRCLE);
        shape.shapeIs();

        /*
         * Адаптер
         */
        System.out.println("Адаптер");
        AmericanSocket americanSocket = new SimpleAmericanSocket();
        EuroSocket euroSocket = new USPlugAdapter(americanSocket);
        euroSocket.supply_electricity();

        /*
         * Стратегия
         */
        System.out.println("Стратегия");
        int[] arr = {3, 6, 5, 4, 7, 8, 9, 5, 5, 7, 7, 9};
        Sorter sorter = new Sorter();
        sorter.setSorting(new BubbleSortStrategy());
        sorter.runSorting(arr);
        for (int i:arr)
            System.out.print(i+" ");
        System.out.println();
        arr = new int[]{3, 6, 5, 4, 7, 8, 9, 5, 5, 7, 7, 9};
        sorter.setSorting(new SelectionSortStrategy());
        sorter.runSorting(arr);
        for (int i:arr)
            System.out.print(i+" ");

        /*
         * Декоратор
         */
        System.out.println("\nДекоратор");
        ICoffee iCoffee=new CoffeeWithSugar(new CoffeeWithMilk(new Coffee()));
        System.out.println("Итого:"+iCoffee.cost());
    }
}