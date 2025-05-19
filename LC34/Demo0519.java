package LC34;

public class Demo0519 {



    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;

        int[] result = searchRange(nums, target);
        System.out.print(result[0]);
        System.out.print(" ");
        System.out.print(result[1]);
    }


    public static int[] searchRange(int[] nums, int target) {
        int first = search(nums, target);
        int second = search(nums, target + 1);

        System.out.print("第一个：" + first);
        System.out.print(" ");
        System.out.println("第二个：" + second);

        // 越界检查
        //	•	如果 first == nums.length 或者 second == 0，就会发生越界访问。
        //	•	示例：数组中根本没有 target，first 会等于 nums.length，这时 nums[first] 会抛出异常。
        if (first == nums.length || nums[first] != target) {
            return new int[] { -1, -1 };
        }
        return new int[] { first, second - 1 };
    }


    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }



}
