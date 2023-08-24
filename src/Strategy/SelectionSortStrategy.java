package Strategy;

public class SelectionSortStrategy implements Sorting{
    @Override
    public void sort(int[] sortArr) {
        for (int i = 0; i < sortArr.length; i++) {
            int pos = i;
            int min = sortArr[i];
            for (int j = i + 1; j < sortArr.length; j++) {
                if (sortArr[j] < min) {
                    pos = j;
                    min = sortArr[j];
                }
            }
            sortArr[pos] = sortArr[i];
            sortArr[i] = min;
        }
    }
}
