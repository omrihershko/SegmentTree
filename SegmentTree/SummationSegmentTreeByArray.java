public class SummationSegmentTreeByArray  extends SegmentTreeByArray{


	/**
	 * Constructs of SummationSegmentTreeByArray
	 *We will get an array and send it to initialize the parent class
	 * @param arr of int []
	 */
	public SummationSegmentTreeByArray(int[] arr) {
		super(arr);
		
		
	}

	/**
	 *Cuts the array and sends it to a helper function*
	 */
	protected int query(int node, int start, int end, int left, int right) {
		return queryhelp(node,start,end,left,right);
	}

	/**
	 * A helper function that cuts the array and returns the largest value in the array
	 * @return  int of the sum num in the cut array
	 */
	private int queryhelp(int node, int start, int end, int left, int right) {

		if (right< start || left> end ||left>right ) 
		 {
			//System.out.println("the index out of range");
           return 0;
		 }
	   // If segment of this node is completely
      // part of given range, then return
      // the max of segment
		if (left <= start && right >= end )
		{
			return this.tree[node];
		}

		int mid= (int)(start+end)/2;

			int leftRec = query(2 * node + 1, start, mid, left, right);
			int rightRec = query(2 * node + 2, mid + 1, end, left, right);
			tree[node] = leftRec + rightRec;
			return (tree[node]);

}


	/**
	 * A function that builds the tree with the maximum values
	 * @return  int [] array
	 */

	public int build_tree(int[] arr, int node, int start, int end) {
		if (start == end) {
	        tree[node] = arr[start];
	        return tree[node];
	    } else {
	        int midlle = (int) (start + end) / 2;
	        tree[node]= (build_tree(arr, (node * 2) + 1, start, midlle)+ build_tree(arr, (node * 2) + 2, midlle + 1, end));
	        return tree[node];
	    }
		
	}

	/**
	 *
	 * A helper function that helps update the specific value.
	 * @param index the index of the element to update
	 * @param value the new value of the element at the specified index
	 * @param start left index of the segmnt tree
	 * @param end right index  of the segmnt tree
	 */
	public int updateNode(int node, int start, int end, int index, int value) {
		if (index < start || index > end)
			return 0;
		if (start == end) {
			//array[index]=value;

			tree[node] = value;

		} else {

			int midlle = (int) (start + end) / 2;

			if (start <= index && index <= midlle) {
				//	updateNode(node * 2 + 1, start, midlle, index, value);
				tree[node] = (updateNode(node * 2 + 1, start, midlle, index, value)+ tree[2 * node + 2]);
				return tree[node];

			} else if (index > midlle && index <= end) {
				// updateNode(node * 2 + 2, midlle + 1, end, index, value);
				tree[node] = (tree[2 * node + 1]+ updateNode(node * 2 + 2, midlle + 1, end, index, value));
				return tree[node];
			}
			tree[node] =( tree[2*node+1] + tree[2*node+2]);
			return  tree[node];


		}
		return  tree[node];

	}


}
	


