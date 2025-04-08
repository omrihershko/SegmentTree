/**
 * An abstract base class for a segment tree data structure implemented using a tree structure.
 * Subclasses must implement the {@code queryRange} method to provide specific range query functionality.
 */
public abstract class SegmentTreeByTree   implements SegmentTree {

    protected SegmentTreeNode root;
    protected int size;

    /**
     * Constructor for creating a Segment Tree from an input array
     * @param arr Input array for which Segment Tree needs to be constructed
     */
    public SegmentTreeByTree(int[] arr) {
        size=arr.length-1;
        build(arr);
    }

    /**
     * Builds the segment tree from the given array of integers.
     *
     * @param arr the array of integers to build the segment tree from
     */
    @Override
    public void build(int[] arr) {
        root = help_build(arr, 0, arr.length - 1);
    }
    

    

    /**
     * Updates the element at the specified index in the original array and updates the segment tree accordingly.
     *
     * @param index the index of the element to update
     * @param value the new value of the element at the specified index
     */
    @Override
    public void update(int index, int value) {
        root= help_update(root,index, value);
    }

    /**
     *
     A helper function that helps to depreciate the value in the tree in the array
     * @param index the index of the element to update
     * @param value the new value of the element at the specified index
     */
    public SegmentTreeNode help_update(SegmentTreeNode node,int index, int value) {

        if (node==null)
            return null;
       // if (node.getStart()==node.getEnd() && node.getStart()==index)
        if (node.isLeaf())
         {
             node.setMin( value);
             node.setMax( value);
             node.setSum( value);
            return node;
         }
        int mid =(int)(node.getStart() + node.getEnd()) / 2;
        if (index <= mid) {
            SegmentTreeNode new_left_child=help_update((SegmentTreeNode)node.getLeft(),index,value);
            SegmentTreeNode right_son=(SegmentTreeNode)node.getRight();
            node.setMax(Math.max(new_left_child.getMax(),right_son.getMax()));
            node.setMin(Math.min(new_left_child.getMin(),right_son.getMin()));
            node.setSum(new_left_child.getSum()+right_son.getSum());
            return node;
            //return help_update((SegmentTreeNode)node.getLeft(), index, value);
        } else {
            SegmentTreeNode new_right_child=help_update((SegmentTreeNode)node.getRight(),index,value);
            SegmentTreeNode left_son=(SegmentTreeNode)node.getLeft();
            node.setMax(Math.max(new_right_child.getMax(),left_son.getMax()));
            node.setMin(Math.min(new_right_child.getMin(),left_son.getMin()));
            node.setSum(new_right_child.getSum()+ left_son.getSum());
            return node;
           // return help_update((SegmentTreeNode)node.getRight(), index, value);
        }
       // node.setMin( Math.min(((SegmentTreeNode)node.getLeft()).getMin(), ((SegmentTreeNode)node.getRight()).getMin()));
      //  node.setMax( Math.max(((SegmentTreeNode)node.getLeft()).getMax(), ((SegmentTreeNode)node.getRight()).getMax()));
     //   node.setSum( ((SegmentTreeNode)node.getLeft()).getSum()+ ((SegmentTreeNode)node.getRight()).getSum());
      //  return node;


    }


    /**
     * Returns the number of elements in the original array that the segment tree was built from.
     *
     * @return the size of the original array
     */
    @Override
    public int size() {
        return size;
      
    }

    /**
     * Queries the Segment Tree for the minimum value in the given range. to be implemented by subclasses.
     * @param left Start index of the query range
     * @param right End index of the query range
     * @return Minimum value in the given range
     */
    @Override
    public abstract int queryRange(int left, int right);

    /**
     * Helper method for querying the Segment Tree 
     * @param node Current node of the Segment Tree
     * @param left Start index of the query range
     * @param right End index of the query range
     * @return A SegmentTreeNode that contains the minimum, maximum and sum values for the given range
     */
    protected SegmentTreeNode queryRangeHelper(SegmentTreeNode node, int left, int right) {
;
       // if (node.getStart() >=left && right >= node.getEnd())
        if (node.getStart() ==left && right == node.getEnd()){
            return node;

        }

        int mid = (int)(node.getStart() + node.getEnd()) / 2;
        if (right <= mid) {
            // case 2: search range is in the range of left child node

            return queryRangeHelper((SegmentTreeNode)node.getLeft(), left,right);
        }
        else if  (left > mid) {
            // case 3: search range is in the range of right child node
            return queryRangeHelper((SegmentTreeNode)node.getRight(), left, right);
        }
        else{
            SegmentTreeNode left_child=queryRangeHelper((SegmentTreeNode)node.getLeft(), left, mid);
            SegmentTreeNode right_child=queryRangeHelper((SegmentTreeNode)node.getRight(), mid+1, right);
            int min, sum, max;
            if (left_child.getMin() < right_child.getMin()) {
                min = left_child.getMin();
            } else {
                min = right_child.getMin();
            }
            if (left_child.getMax() < right_child.getMax()) {
                max = right_child.getMax();
            } else {
                max = left_child.getMax();
            }
            sum = left_child.getSum() + right_child.getSum();

            SegmentTreeNode node1 = new SegmentTreeNode(left, right, min, max, sum, left_child, right_child);
            return node1;
       }


    }

    /**
     * Helper method for querying the Segment Tree
     * @param arr Current node of the Segment Tree
     * @param start Start index of the query range
     * @return A SegmentTreeNode that contains the minimum, maximum and sum values for the given range
     */
    public SegmentTreeNode help_build(int[] arr, int start, int end) {
        if (start == end) {
            SegmentTreeNode leaf = new SegmentTreeNode(start, start, arr[start], arr[start], arr[start], null, null);
            return leaf;
        }
        int mid = (start + end) / 2;
        SegmentTreeNode left_child = help_build(arr, start, mid);
        SegmentTreeNode right_child = help_build(arr, mid + 1, end);
        int min, sum, max;
        if (left_child.getMin() < right_child.getMin()) {
            min = left_child.getMin();
        } else {
            min = right_child.getMin();
        }
        if (left_child.getMax() < right_child.getMax()) {
            max = right_child.getMax();
        } else {
            max = left_child.getMax();
        }
        sum = left_child.getSum() + right_child.getSum();

        SegmentTreeNode node = new SegmentTreeNode(start, end, min, max, sum, left_child, right_child);
        return node;
    }
    
}
