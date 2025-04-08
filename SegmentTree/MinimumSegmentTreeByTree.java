public class MinimumSegmentTreeByTree extends SegmentTreeByTree {
	/**
	 * Constructs of MinimumSegmentTreeByTree
	 *We will get an array and send it to initialize the parent class
	 * @param arr int []
	 * Returns a pointer with the max values the original array
	 */
	public MinimumSegmentTreeByTree(int[] arr) {
		super(arr);
	}
	/**
	 * A cutting function that checks where the maximum value is between segments
	 * @return int min betwon left and right
	 */
	public int queryRange(int left, int right) {

	if (queryRangeHelper(root,left,right) != null)
			
			   return queryRangeHelper(root,left,right).getMin();
			return-1;

/**
 * print function that returns the printout of the array max
 * @return none
 */
 }
	public String toString(){
		return " [ " +print_me(root) + " ] ";
		}

	
	public String print_me(SegmentTreeNode node){
		String soltion=node.getMin()+"";
		if (node.isLeaf()){
			return soltion;
		}
		String left=print_me((SegmentTreeNode)node.leftChild);
		String right=print_me((SegmentTreeNode)node.rightChild);

		return soltion+" "+left+" "+right;
	}
	
}
	
	

