/*Разбиение массива на подмассивы:
        __
        Описание: Имеется массив чисел. Необходимо разбить его на подмассивы так, чтобы сумма чисел в каждом подмассиве была меньше или равна заданному значению X.
        Почему это процедурное программирование: Можно создать процедуру, которая будет принимать массив и значение X, а затем последовательно формировать подмассивы, следуя определенной логике. Это позволяет выделить процесс создания каждого подмассива в отдельную подпрограмму, делая основной код более чистым и понятным.
        __
        Разбиение массива на подмассивы:**
__
Задание: Напишите функцию, которая принимает массив чисел и значение X. Функция должна возвращать массив подмассивов так, чтобы сумма чисел в каждом подмассиве была меньше или равна X.
Входные данные:
Массив чисел длиной N.
Число X.
Выходные данные:
Массив подмассивов.*/
package splitarray;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 9, 8, 7, 8, 9, 5, 6, 5, 4, 7, 9};


        int[][] splittedArr = split(arr, 10);
        System.out.println();
        for (int i = 0; i < splittedArr.length; i++) {
            System.out.print("[");
            for (int j = 0; j < splittedArr[i].length; j++) {
                System.out.print(splittedArr[i][j] + " ");
            }
            System.out.print("]");
        }

    }

    public static int[][] split(int[] arr, int x) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        int sumCounter = 0;
        for (int i = 0; i < arr.length; i++) {
            sumCounter += arr[i];
            sub.add(arr[i]);
            if (i == arr.length - 1 || arr[i] >= x) {
                result.add(new ArrayList<>(List.of(arr[i])));
                System.out.print(sumCounter + "<=" + x + " ");
                sumCounter = 0;
                sub.clear();
            } else if (sumCounter + arr[i + 1] > x) {
                result.add(new ArrayList<>(sub));
                System.out.print(sumCounter + "<=" + x + " ");
                sumCounter = 0;
                sub.clear();
            }
        }
        return result.stream().map(l -> l.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
    }
}