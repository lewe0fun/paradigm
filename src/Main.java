import java.util.Arrays;

//Задача 1: Напишите программу, которая находит все простые числа в заданном диапазоне.
//Задача 2: Напишите программу, которая сортирует список чисел методом сортировки слиянием.
//● Ваша задача
//Написать программу на любом языке в любой парадигме для
//бинарного поиска. На вход подаётся целочисленный массив и
//число. На выходе - индекс элемента или -1, в случае если искомого
//элемента нет в массиве.
public class Main {
    public static void main(String[] args) {
        showPrimes(10, 50);
        int[] arr = {43, 456, 46, 479, 36, 107};
        int[] sortedArr = mergeSort(arr);
        System.out.println("\n\nМетод сортировки слиянием:\n"+Arrays.toString(sortedArr));
        int digitToFind=36;
        System.out.println("\nБинарный поиск числа "+digitToFind+": результат индекс - "+binarySearch(sortedArr,digitToFind));
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
    private static int binarySearch(int[] sortedArray, int valueToFind) {
        int low=0;
        int high=sortedArray.length-1;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sortedArray[mid] < valueToFind) {
                low = mid + 1;
            } else if (sortedArray[mid] > valueToFind) {
                high = mid - 1;
            } else if (sortedArray[mid] == valueToFind) {
                index = mid;
                break;
            }
        }
        return index;
    }

}
