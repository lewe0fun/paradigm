package Strategy;

public class Sorter {
    Sorting sorting;

    public void setSorting(Sorting sorting) {
        this.sorting = sorting;
    }
    public void runSorting(int[]arr){
        sorting.sort(arr);
    }
}
