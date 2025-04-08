import java.util.Iterator;

public class NumberAnalyzerByTrees extends NumberAnalyzer implements  Iterator<Integer> {

    SummationSegmentTreeByTree tree_sum;
    MaximumSegmentTreeByTree tree_max;
    MinimumSegmentTreeByTree tree_min;

    int countrer;

    /**
     *  constructor function that builds the NumberAnalyzerByArrays
     * return Returns a list of int objects Integer[]
     */
    public NumberAnalyzerByTrees(Integer[] numbers) {
        super(numbers);
        int[] array;
        array = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            array[i] = numbers[i];
        }
        tree_max = new MaximumSegmentTreeByTree(array);
        tree_min = new MinimumSegmentTreeByTree(array);
        tree_sum = new SummationSegmentTreeByTree(array);
    }

    /**
     *  Returns the largest element in the int array
     * @return Returns big int in the Integer[]
     */
    @Override
    public Integer getMax(int left, int right) {
        return tree_max.queryRange(left, right);
    }
    /**
     *  Returns the min element in the int array
     * @return Returns min int in the Integer[]
     */
    @Override
    public Integer getMin(int left, int right) {
        return tree_min.queryRange(left, right);
    }
    /**
     *  Returns the sum element in the int array
     * @return Returns sum int in the Integer[]
     */
    @Override
    public Integer getSum(int left, int right) {
        return tree_sum.queryRange(left, right);
    }

    /**
     * Updates the array of int the specific index value
     * return void
     */
    @Override
    public void update(int index, int value) {
        numbers[index]=value;
        tree_max.update(index, value);
        tree_min.update(index, value);
        tree_sum.update(index, value);

    }

    @Override
    /**
     *An iterator that goes through the element of the array and checks if they exist
     * return Iterator<Integer>
     */
    public Iterator<Integer> iterator() {
        countrer = 0;
        return this;
    }

    @Override
    //Checks if there is a next member
    public boolean hasNext() {
        return countrer < numbers.length;
    }

    @Override
    // Goes over the whole array member
    public Integer next() {
        if (hasNext() == false) {
            return null;
        } else {
            Integer result = numbers[countrer];
            countrer += 1;
            return result;
        }

    }
    //
    /**
     * Comparison between the two objects
     */
    @Override
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


