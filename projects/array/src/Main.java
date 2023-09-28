public class Main {
    public static void main(String[] args) {
        SortedArray sortedArray = new SortedArray();

        int[] myArr = sortedArray.getIntegers(5);
        sortedArray.printArray(myArr);
        int[] sortedArr = sortedArray.sortIntegers(myArr);

        System.out.println("\nSorted out: ");
        sortedArray.printArray(sortedArr);
    }
}