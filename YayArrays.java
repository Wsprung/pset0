import java.util.Arrays;
import java.util.ArrayList;
public class YayArrays {
  //different colors show us what the different pieces of our code are
  public static void main(String[] args) {
    //testing priceIsRight()
    System.out.println(priceIsRight(new int[] {2,5,9},6));
    System.out.println(priceIsRight(new int[] {2,5,9},1));

    //testing clump()
    String[] helpTC = {"hi", "there", "what", "is", "up"};
    ArrayList<String> testClump = new ArrayList<>(Arrays.asList(helpTC));
    clump(testClump);
    System.out.println(testClump);
    testClump = new ArrayList<>(Arrays.asList(helpTC));;
    testClump.remove("up"); //testClump now = "hi", "there", "what", "is"
    clump(testClump);

    int[][] testMS = {{2,7,6},{9,5,1},{4,3,8}};
    System.out.println(isMagicSquare(testMS));
  }
  public static int priceIsRight(int[] bids, int correctP) {
    int priceRN = bids[0];
    boolean ret = false;
    for(int i = 1; i < bids.length; i++) {
      if(correctP >= bids[i] && correctP - priceRN > correctP - bids[i]) {
        priceRN = bids[i];
        ret = true;
      }
    }
    if(!ret) { return -1; }
    return priceRN;
  }
  public static void clump(ArrayList<String> words) {
    int j = 0;
    int size = words.size();
    for(int i = 0; i < size/2; i++) {
      words.add(words.get(j) + words.get(j + 1));
      j = j + 2;
    }
    if(size%2 != 0) { words.add(words.get(size - 1)); }
    j = 0;
    for(int i = 0; i < size; i++) {
      words.remove(j);
    }
    /**a reference type passed into a method will have any changes made to its
    values reflected outside the method as well. If you assign the reference
    type to a new reference type inside the method, those changes will only be local to the method.**/
  }
  
}
