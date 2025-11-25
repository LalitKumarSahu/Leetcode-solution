import java.util.ArrayList;
import java.util.List;

public class pascalTriangle {
  // 1st type question ->Element at (row, col)
  public static int pascalElement(int row, int col) {
    // Pascal Triangle is 1-indexed
    int n = row - 1;
    int r = col - 1;

    long ans = 1;

    // Compute C(n, r)
    for (int i = 0; i < r; i++) {
        ans = ans * (n - i);
        ans = ans / i+1;
    }

    return (int) ans;
}
  
 // 2nd type question print the all elem of the row
  ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        return new ArrayList<>(generateRow(n));
    }

    public static List<Integer> generateRow(int row) {
        List<Integer> ansRow = new ArrayList<>();
        long ans = 1;

        ansRow.add(1); // first element is always 1

        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int)ans);
        }

        return ansRow;
    }
     
    //3rd type q -> print all row 1 to n
    public static List<List<Integer>> pascalTriangle(int n) {
    List<List<Integer>> triangle = new ArrayList<>();

    for (int row = 1; row <= n; row++) {
        triangle.add(generateRow(row));
    }

    return triangle;
}

// Generate nth row in O(n)
public static List<Integer> generateRow(int row) {
    List<Integer> ansRow = new ArrayList<>();
    long val = 1;

    ansRow.add(1); // first element

    for (int col = 1; col < row; col++) {
        val = val * (row - col);
        val = val / col;
        ansRow.add((int) val);
    }

    return ansRow;
}


  }
