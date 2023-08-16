
/*Императивное программирование:
        Задача 1: Подсчет суммы четных чисел от 1 до N. Напишите программу, используя цикл, которая находит сумму всех четных чисел в диапазоне от 1 до заданного числа N.
        Задача 2: Поиск наименьшего числа в списке. Напишите программу, которая находит наименьшее число в заданном списке с помощью цикла.

        Декларативное программирование:
        Задача 3: Вычисление факториала числа. Напишите программу, которая находит факториал заданного числа N с использованием рекурсии или встроенных функций.
        Задача 4: Поиск уникальных элементов в списке. Напишите программу, которая создает новый список, содержащий только уникальные элементы из исходного списка.*/

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Подсчет суммы четных чисел от 1 до N. -> " + imperativeEvenSum(10));//1
        System.out.println("Поиск наименьшего числа в списке. -> " + imperativeMinFind(new int[]{3, 5, 6, 8, 1, 9, 4, 10}));//2
        System.out.println("Вычисление факториала числа. -> "+factorial(5));//3
        System.out.println("Поиск уникальных элементов в списке. -> "+uniDigitsList(Arrays.asList(1, 2, 3, 4, 3, 7, 8, 5, 2, 1, 4, 5, 2, 3, 6, 9)));//4

    }

    public static List<Integer> uniDigitsList(List<Integer> list) {
        Set<Integer> set = new LinkedHashSet<>();
        for(var number: list){
            boolean isRep =set.add(number);
            if (!isRep) set.remove(number);
        }
        return new ArrayList<>(set);
    }

    public static int factorial(int f) {
        if (f <= 1)
            return 1;
        else
            return IntStream.rangeClosed(2, f).reduce((x, y) -> x * y).getAsInt();
    }

    public static int imperativeMinFind(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < 7; i++)
            if (min > arr[i + 1]) min = arr[i + 1];
        return min;
    }

    public static int imperativeEvenSum(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++)
            if (i % 2 == 0) sum = sum + i;
        return sum;
    }

}