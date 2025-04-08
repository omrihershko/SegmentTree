/**
 * This is a testing framework. Use it extensively to verify that your code is working
 * properly.
 */
public class Tester {

    private static boolean testPassed = true;
    private static int testNum = 0;

    /**
     * This entry function will test all classes created in this assignment.
     * @param args command line arguments
     */
    public static void main(String[] args) {

        /* TODO - write a function for each class separately */
        // Each function here should test a different class. you should test here every class you created.


        //SegmentTrees
        testSummationSegmentTreeByTree();
        testSummationSegmentTreeByArray();
        testMinimumSegmentTreeByArray();
        testMinimumSegmentTreeByTree();
        testMaximumSegmentTreeByTree();
        testMaximumSegmentTreeByArray();
        //...
        //NumberAnalyzers
        testNumberAnalyzerByArrays();
        testNumberAnalyzerByTrees();
        // etc....

        // Notifying the user that the code have passed all tests.
        if (testPassed) {
            System.out.println("All " + testNum + " tests passed!");
        }
    }

    /**
     * This utility function will count the number of times it was invoked.
     * In addition, if a test fails the function will print the error message.
     * @param exp The actual test condition
     * @param msg An error message, will be printed to the screen in case the test fails.
     */
    private static void test(boolean exp, String msg) {
        testNum++;

        if (!exp) {
            testPassed = false;
            System.out.println("Test " + testNum + " failed: "  + msg);
        }
    }


    /**
     * Checks the MaximumSegmentTreeByTree class.
     */
    private static void testMaximumSegmentTreeByTree() {

        MaximumSegmentTreeByTree mstbt = new MaximumSegmentTreeByTree(new int[]{60,10,5,15,6});

        test(mstbt.queryRange(0,4) == 60, "The max of {60,10,5,15,6} between indexes [0:3] should be 60");
        test(mstbt.queryRange(2,4) == 15, "The max of {60,10,5,15,6} between indexes [0:3] should be 60");

        mstbt.update(1,80);
        test(mstbt.queryRange(0,4) == 80, "After update index 1 from {60,10,5,15,6} to 80, the max between indexes [0:3] should be 80");
        test(mstbt.queryRange(0,0) == 60, "After update index 1 from {60,10,5,15,6} to 80, the max between indexes [0:3] should be 80");

        test(mstbt.toString().equals(" [ 80 80 80 60 80 5 15 15 6 ] "),"The toString of {60,80,5,15} should be ' [ 80 80 80 60 80 5 15 15 6 ] ' got: '" + mstbt.toString()+ " '");
    }
    /**
     * Checks the testMinimumSegmentTreeByTree class.
     */
    private static void testMinimumSegmentTreeByTree(){
        MinimumSegmentTreeByTree min_tree= new MinimumSegmentTreeByTree(new int [] {3,2,1,4});
        test(min_tree.toString().equals(" [ 1 2 3 2 1 1 4 ] "),"The toString of {3,2,1,4} should be ' [ 1 2 3 2 1 1 4 ] ' got: '" + min_tree.toString()+ " '");
        test(min_tree.queryRange(0,3)==1,"The min of {3,2,1,4} between indexes [0:3] should be 60");
        test(min_tree.queryRange(0,1)==2,"The min of {3,2,1,4} between indexes [0:3] should be 60");
        test(min_tree.queryRange(0,0)==3,"The min of {3,2,1,4} between indexes [0:3] should be 60");
        min_tree.update(0,1);
        test(min_tree.queryRange(3,3)==4,"The min of {3,2,1,4} between indexes [0:3] should be 60");
        test(min_tree.queryRange(2,3)==1,"The min of {3,2,1,4} between indexes [0:3] should be 60");


    }


    /**
     * Checks the MaximumSegmentTreeByArray class.
     */
    private static void testMaximumSegmentTreeByArray() {

        MaximumSegmentTreeByArray mstbt = new MaximumSegmentTreeByArray(new int[]{10,15,55,15,9,12});

        test(mstbt.toString().equals(" [ 55 55 15 15 55 15 12 10 15 - - 15 9 - - ] "),"The toString of {10,15,55,15,9,12} should be ' [ 55 55 15 15 55 15 12 10 15 - - 15 9 - - ] ' got: '" + mstbt.toString()+ " '");
        test(mstbt.queryRange(0,1) == 15, "The max of {10,15,55,15,9,12} between indexes [0:1] should be 15");
        test(mstbt.queryRange(3,5)==15,"The max of {10,15,55,15,9,12} between indexes [0:1] should be 15");;
        mstbt.update(0,80);
        test(mstbt.queryRange(0,0) == 80, "After update index 0 from {10,15,55,15,9,12} to 80, the max between indexes [0:0] should be 80");
    }
    /**
     * Checks the NumberAnalyzerByTrees class.
     */
    private static void testNumberAnalyzerByTrees() {

        Integer[] arr = {10,30,50};
        NumberAnalyzerByTrees nabt = new NumberAnalyzerByTrees(arr);

        test(nabt.getMax(0,1) == 30, "The max of {10,30,50} between indexes [0:1] should be 30");
        test(nabt.getMin(0,1) == 10, "The min of {10,30,50} between indexes [0:1] should be 10");
        test(nabt.getSum(0,1) == 40, "The sum of {10,30,50} between indexes [0:1] should be 40");

        nabt.update(1,70);
        test(nabt.getMax(0,2)==70,"The sum of {10,70,50} between indexes [0:1] should be 40");
        test(nabt.getMin(0,2)==10,"The sum of {10,70,50} between indexes [0:1] should be 40");
        test(nabt.getSum(0,2)==130,"The sum of {10,70,50} between indexes [0:1] should be 40");
        //test compare
        test(nabt.compare(7,2)==-1,"need to be -1");
        test(nabt.compare(2,7)==1,"need to be 1");
        test(nabt.compare(2,2)==0,"need to be 0");
        test(nabt.compare(3,3)==0,"need to be 0");

        //test itertable
        String st="";
        for(int i:nabt){
            st=st+i;
        }
        test(st.equals("107050"),"the string need to bee 107050");



    }

    private static void testNumberAnalyzerByArrays() {
        Integer[] arr = {10,30,50};
        NumberAnalyzerByArrays nabeet = new NumberAnalyzerByArrays(arr);

        test(nabeet.getMax(0,1) == 30, "The max of {10,30,50} between indexes [0:1] should be 30");
        test(nabeet.getMin(0,1) == 10, "The max of {10,30,50} between indexes [0:1] should be 30");
        test(nabeet.getSum(0,1) == 40, "The max of {10,30,50} between indexes [0:1] should be 30");
        nabeet.update(1,20);
        //{10,20,50}
        test(nabeet.getMax(0,2) == 50, "The max of {10,30,50} between indexes [0:1] should be 30");
        test(nabeet.getSum(0,2) == 80, "The max of {10,30,50} between indexes [0:1] should be 30");
        test(nabeet.getMin(0,2) == 10, "The max of {10,30,50} between indexes [0:1] should be 30");
        //test compare
        test(nabeet.compare(1,2)==-1,"need to be 1");
        test(nabeet.compare(5,2)==-1,"need to be -1");
        test(nabeet.compare(5,5)==0,"need to be 0");
        String st="";
        for(int i:nabeet){
            st=st+i;
        }
        test(st.equals("102050"),"the string need to bee 102050");

    }

    private static void testMinimumSegmentTreeByArray() {
        MinimumSegmentTreeByArray min_arr= new MinimumSegmentTreeByArray(new int [] {3,2,1,4});
        test(min_arr.toString().equals(" [ 1 2 1 3 2 1 4 ] "),"The toString of {3,2,1,4} should be ' 1 2 1 3 2 1 4  ' got: '" + min_arr.toString()+ " '");
        test(min_arr.queryRange(0,3)==1,"The min of {3,2,1,4} between indexes [0:3] should be 60");
        test(min_arr.queryRange(0,1)==2,"The min of {3,2,1,4} between indexes [0:3] should be 60");//PR
        min_arr.update(2,4);
        test(min_arr.queryRange(0,2)==2,"The min of {3,2,1,4} between indexes [0:3] should be 60");//PR

    }


    private static void testSummationSegmentTreeByArray() {
        SummationSegmentTreeByArray sum_arr= new SummationSegmentTreeByArray(new int [] {3,2,1,4});
        test(sum_arr.toString().equals(" [ 10 5 5 3 2 1 4 ] "),"The toString of {3,2,1,4} should be [ 10 5 5 3 2 1 4 ] got: '" + sum_arr.toString()+ " '");
        test(sum_arr.queryRange(0,3)==10,"The min of {3,2,1,4} between indexes [0:3] should be 60");
        test(sum_arr.queryRange(0,1)==5,"The min of {3,2,1,4} between indexes [0:3] should be 60");
        //{2,2,1,4}
        sum_arr.update(0,2);
        //test(sum_arr.queryRange(0,1)==4,"The min of {3,2,1,4} between indexes [0:3] should be 60"); pr
        test(sum_arr.queryRange(0,3)==9,"The min of {3,2,1,4} between indexes [0:3] should be 60");
        test(sum_arr.queryRange(2,3)==5,"The min of {3,2,1,4} between indexes [0:3] should be 60");


    }
    private static void testSummationSegmentTreeByTree() {
        SummationSegmentTreeByTree sum_tree= new SummationSegmentTreeByTree(new int [] {60,10,5,15,6});
        test(sum_tree.toString().equals(" [ 96 75 70 60 10 5 21 15 6 ] "),"The toString of {3,2,1,4} should be [ 10 5 5 3 2 1 4 ] got: '" + sum_tree.toString()+ " '");
        test(sum_tree.queryRange(0,2)==75,"The min of {3,2,1,4} between indexes [0:3] should be 60");
        test(sum_tree.queryRange(0,1)==70,"The min of {3,2,1,4} between indexes [0:3] should be 60");
        sum_tree.update(0,50);
        test(sum_tree.queryRange(0,1)==60,"The min of {3,2,1,4} between indexes [0:3] should be 60");
        test(sum_tree.queryRange(0,4)==86,"The min of {3,2,1,4} between indexes [0:3] should be 60");


    }


    }
