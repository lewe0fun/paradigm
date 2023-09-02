import java.util.Arrays;

//Задача 1: Напишите программу, которая находит все простые числа в заданном диапазоне.
//Задача 2: Напишите программу, которая сортирует список чисел методом сортировки слиянием.
public class Main {
    public static void main(String[] args) {
        showPrimes(10, 50);
        int[] sortArr = {43, 456, 46, 479, 36, 107};
        int[] result = mergeSort(sortArr);
        System.out.println("\n\nМетод сортировки слиянием:\n"+Arrays.toString(result));
    }

    public static void showPrimes(int a, int b) {
        int i, j;
        boolean isPrime;
        System.out.println("Простые числа:");
        for (i = a; i < b; i++) {
            isPrime = true;
            for (j = 2; j <= i / j; j++)
                if ((i % j) == 0)
                    isPrime = false;
            if (isPrime)
                System.out.print(i + " | ");
        }
    }
    public static int[] mergeSort(int[] sortArr) {
        int[] buffer1 = Arrays.copyOf(sortArr, sortArr.length);
        int[] buffer2 = new int[sortArr.length];
        int[] result = mergeSortInner(buffer1, buffer2, 0, sortArr.length);
        return result;
    }
    public static int[] mergeSortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }

}
