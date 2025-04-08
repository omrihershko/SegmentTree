/**
 * This abstract class represents a segment tree implementation using an array
 * and provides methods to build, update, and query the tree.
 */
public abstract  class SegmentTreeByArray  implements SegmentTree {

	protected int[] tree;
    protected  int size;

	
   
		
	

    

    /**
     * Constructor for initializing the segment tree with the given input array.
     *
     * @param arr the input array
     */
    
    public SegmentTreeByArray(int[] arr) {
        int power = (int) (Math.ceil(Math.log(arr.length) / Math.log(2)));
        int sizeTree = 2 * (int) Math.pow(2, power) - 1;
        this.tree = new int[sizeTree];
        size=arr.length;
       
        build(arr);



    }

    /**
     * Builds the segment tree from the input array.
     *
     * @param arr the input array
     */
    @Override
    public void build(int[] arr) {
    	
        
       build_tree(arr, 0, 0, arr.length-1);
    }

   
    public abstract int build_tree(int[] arr, int node, int start, int end);

    /**
     * Updates the value at the specified index and updates the segment tree accordingly.
     *
     * @param index the index of the element to update in the array
     * @param value the new value to replace the existing value
     */
    @Override
    public void update(int index, int value) {
        if (index > size() || index < 0) {
            System.out.println("the index out of range");
            return;
        }
        
        //array[index]=value;
        updateNode(0, 0, size - 1, index, value);
        
        
       
        
        
      

    }

  public abstract int updateNode(int node, int start, int end, int index,int value);
   

    /**
     * Queries the segment tree for a range of elements.
     *
     * @param left  the left index of the range
     * @param right the right index of the range
     * @return the result of the query operation
     */
    @Override
    public int queryRange(int left, int right) {
    	if (right> size-1 || left< 0 ||left>right )
		{
            return -1;
		}
    	 return query(0,0,size-1,left,right);
    	
    	
    }

    /**
     * Abstract method for query operation, to be implemented by subclasses.
     *
     * @param node  the current node
     * @param start the start index
     * @param end   the end index
     * @param left  the left index
     * @param right the right index
     * @return the result of the query operation
     */
   protected abstract int query(int node, int start, int end, int left, int right);


    /**
     * The members inside the array representing the segment tree are printed according to their indexes in the array.
     * When the members are surrounded by "[ ]" and exactly one space between each number and between the brackets.
     * For example, for the tree [10,4,6,1,3,2,4] " [ 10 4 6 1 3 2 4 ] " will be returned
     */
    @Override
    public String toString() {
		
    	
    	String st="";
    	for (int i=0;i<tree.length;i++) {
    		if (tree[i]==0) {
    			st=st+"- ";
    		}
    		else {
        		st+=String.valueOf(tree[i])+ " ";
			}    		
    	}
         return " [ "+st+"] ";
    	
    		
   
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
}