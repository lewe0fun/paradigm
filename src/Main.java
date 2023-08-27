import java.util.Arrays;

/*
Рекурсивная сумма: Напишите рекурсивную функцию, которая вычисляет сумму всех чисел от 1 до n.
Например, для n = 5 результат должен быть 1 + 2 + 3 + 4 + 5 = 15.
*
Факториал: Напишите рекурсивную функцию для вычисления факториала числа n.
Факториал числа n обозначается как n! и равен произведению всех положительных целых чисел от 1 до n.
 *
Фибоначчи через рекурсию: Напишите рекурсивную функцию для вычисления числа Фибоначчи с индексом n.
Напоминаю, что последовательность Фибоначчи определяется как:
 F(0) = 0, F(1) = 1 и F(n) = F(n-1) + F(n-2) для n > 1.
 *
 Функция-редуктор: Напишите функцию-редуктор (или функцию свертки),
 которая принимает начальное значение и список чисел,
 а затем возвращает произведение всех чисел в списке.
 Используйте эту функцию для вычисления произведения чисел в списке.
*/
public class Main {
    public static void main(String[] args) {
        int digit = 5;
        System.out.println("Сумма от 1 до " + digit + " = " + sum(digit));
        System.out.println("Факториал числа " + digit + " = " + factorial(digit));
        System.out.println(digit+" число Фибоначчи = "+fibonacci(10));
        System.out.println("Произведение чисел в списке "+reducer(1,new int[]{1,2,3,4,5,6,7,8,9}));
    }

public static int reducer(int value,int[]arr){
    return Arrays.stream(arr).reduce(value, Integer::sum);
}
    static int sum(int n) {
        if (n < 1)
            return 0;
        return n + sum(n - 1);
    }

    public static int factorial(int f) {
        if (f <= 1) {
            return 1;
        } else {
            return f * factorial(f - 1);
        }
    }

    private static int fibonacci(int index) {
        if (index <= 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        } else if (index == 2) {
            return 1;
        } else {
            return fibonacci(index - 1) + fibonacci(index - 2);
        }
    }

}