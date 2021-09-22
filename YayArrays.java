import java.util.Arrays;
import java.util.ArrayList;
public class YayArrays {
  //different colors show us what the different pieces of our code are
  public static void main(String[] args) {
    //testing priceIsRight()
    System.out.println(priceIsRight(new int[] {2,5,9},6));
    System.out.println(priceIsRight(new int[] {2,5,9},9));

    //testing clump()
    String[] helpTC = {"hi", "there", "what", "is", "up","?"};
    ArrayList<String> testClump = new ArrayList<>(Arrays.asList(helpTC));
    clump(testClump);
    System.out.println(testClump);
    testClump = new ArrayList<>(Arrays.asList(helpTC));;
    testClump.remove("up"); //testClump now = "hi", "there", "what", "is"
    clump(testClump);

    //testing isMagicSquare()
    int[][] testMS = {{2,7,6},{9,5,1},{4,3,8}};
    System.out.println(isMagicSquare(testMS));
  }
  public static int priceIsRight(int[] bids, int correctP) {
    int priceRN = bids[0];
    boolean ret = false;
    //test to see what number, if any, is less than or equal to correctP, and the closest to correctP out of all of bids
    for(int i = 1; i < bids.length; i++) {
      if(correctP >= bids[i] && correctP - priceRN > correctP - bids[i]) {
        priceRN = bids[i];
        ret = true;
      }
    }
    //if no numbers in bids are less than or equal to correctP, return -1
    if(!ret) { return -1; }
    return priceRN;
  }
  public static void clump(ArrayList<String> words) {
    int j = 0;
    int size = words.size();
    //combines every pair of Strings in words into one String and adds it to words
    for(int i = 0; i < size/2; i++) {
      words.add(words.get(j) + words.get(j + 1));
      j = j + 2;
    }
    //adds final noncombined String to words if the original size of words was odd
    if(size%2 != 0) { words.add(words.get(size - 1)); }
    j = 0;
    //removes the original Strings from words
    for(int i = 0; i < size; i++) {
      words.remove(j);
    }
    /**a reference type passed into a method will have any changes made to its
    values reflected outside the method as well. If you assign the reference
    type to a new reference type inside the method, those changes will only be local to the method.
    Changes made at the actual Object stick, changes made to the address the reference variable holds do not. (ex. aliasing)**/
  }
  public static boolean isMagicSquare(int[][] arr) {
    //are the row sums equal?
    int rowSum = 0;
    int[] rowSums = new int[arr.length];
    for(int i = 0; i < arr.length; i++) {
      for(int j = 0; j < arr[i].length; j++) {
        rowSum = rowSum + arr[i][j];
      }
      rowSums[i] = rowSum;
      rowSum = 0;
    }
    //returns false if any difference in the row sums is found
    for(int i = 0; i < rowSums.length - 1; i++) {
      if(rowSums[i] != rowSums[i + 1]) { return false; }
    }

    //are the column sums equal?
    int colSum = 0;
    int[] colSums = new int[arr.length];
    for(int i = 0; i < arr[0].length; i++) {
      for(int j = 0; j < arr.length; j++) {
        colSum = colSum + arr[j][i];
      }
      colSums[i] = colSum;
      colSum = 0;
    }
    //returns false if any difference in the column sums is found
    for(int i = 0; i < colSums.length - 1; i++) {
      if(colSums[i] != colSums[i + 1]) { return false; }
    }

    //are the diagonal sums equal?
    int diag1 = 0;
    int diag2 = 0;
    for(int i = 0; i < arr.length; i++) {
      diag1 = diag1 + arr[i][i];
    }
    int j = 0;
    for(int i = arr.length - 1; i >=0; i--) {
      diag2 = diag2 + arr[j][i];
      j++;
    }
    //returns false if the diagonal sums are not equal
    if(diag1 != diag2) { return false; }
    return true;
  }
}
