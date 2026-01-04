
import java.util.*;
public class JumpGameII {
  public int jump(int[] nums) {
        return fn(0, nums);
    }

    public int fn(int idx, int[] nums) {
        int n = nums.length;

        if (idx >= n - 1) return 0;

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= nums[idx]; i++) {
            if (idx + i < n) {
                int res = fn(idx + i, nums);
                if (res != Integer.MAX_VALUE) {
                    min = Math.min(min, 1 + res);
                }
            }
        }
        return min;
    }
}
