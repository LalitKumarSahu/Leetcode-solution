import java.util.Stack;
public class NextGreater {

 public static void nextGreater(int arr[]) {
      int n = arr.length;

      int nge[] = new int[n];

      for (int i = 0; i < n; i++) {

        for (int j = i + 1; j < n; j++) {
          nge[i] = -1;
          if (arr[j] > arr[i]) {
            nge[i] = arr[j];
            break;
          }
        }
      }

      for (int i = 0; i < n; i++) {
        System.out.print(nge[i] + " ");
      }

  }
}

// method - 2
  public static void nextGreater2(int arr[]) {
    int n = arr.length;

    Stack<Integer> st = new Stack<>();
    int nge[] = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      while (!st.isEmpty() && arr[i] >= st.peek()) {
        st.pop();
      }

      if (st.isEmpty()) {
        nge[i] = -1;
      } else {
        nge[i] = st.peek();
      }

      st.push(arr[i]);

    
    }
  }
