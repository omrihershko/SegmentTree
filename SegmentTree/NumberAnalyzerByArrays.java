import java.util.Iterator;

public class NumberAnalyzerByArrays extends NumberAnalyzer  implements  Iterator<Integer> {


    MaximumSegmentTreeByArray max_tree;

    MinimumSegmentTreeByArray min_tree;

    SummationSegmentTreeByArray sum_tree;

    int countrer ;

    /**
     *  constructor function that builds the NumberAnalyzerByArrays
     * return Returns a list of int objects Integer[]
     */
    public NumberAnalyzerByArrays(Integer[] numbers) {
        super(numbers);
        int[] array;
        array = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            array[i] = numbers[i];
        }
        max_tree = new MaximumSegmentTreeByArray(array);
        min_tree = new MinimumSegmentTreeByArray(array);
        sum_tree = new SummationSegmentTreeByArray(array);
    }

    /**
     *  Returns the largest element in the int array
     * @return Returns big int in the Integer[]
     */
    public Integer getMax(int left, int right) {
        return (max_tree.queryRange(left, right));
    }
    /**
     *  Returns the min element in the int array
     * @return Returns min int in the Integer[]
     */
    @Override
    public Integer getMin(int left, int right) {
        return min_tree.queryRange(left, right);
    }
    /**
     *  Returns the sum element in the int array
     * @return Returns sum int in the Integer[]
     */
    @Override
    public Integer getSum(int left, int right) {
        return sum_tree.queryRange(left, right);
    }

    /**
     * Updates the array of int the specific index value
     * return void
     */

    @Override
    public void update(int index, int value) {
        numbers[index]=value;
        min_tree.update(index, value);
        max_tree.update(index, value);
        sum_tree.update(index, value);
    }



    /**
     *An iterator that goes through the element of the array and checks if they exist
     * return Iterator<Integer>
     */
    @Override
    public Iterator<Integer> iterator() {
        countrer=0;
        return this;

    }
    //Checks if there is a next member

    @Override
    public boolean hasNext() {
        return countrer < numbers.length;
    }
    // Goes over the whole array member

    @Override
    public Integer next() {
        if (hasNext() == false) {
            return null;
        } else {
            Integer result = numbers[countrer];
            countrer += 1;
            return result;
        }
    }

    /**
     * Comparison between the two objects
     */
    public int compare(Integer o1, Integer o2) {
        if (o1 % 2 == 0 && o2 % 2 == 0) {
            // Both numbers are even, compare based on their actual value
            return Integer.compare(o1, o2);
        } else if (o1 % 2 == 0) {
            // num1 is even and num2 is odd, return 1
            return 1;
        } else if (o2 % 2 == 0) {
            // num2 is even and num1 is odd, return -1
            return -1;
        } else {
            // Both numbers are odd, compare based on their actual value
            return Integer.compare(o1, o2);
        }
    }


}
