package LC.快速.快速;

public class Demo0718 {

    public static void main(String[] args) {

        int[] nums={2,4,5,2,3,1};
        quickSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int[] nums) {
        quickSortHelper(nums,0,nums.length-1);
    }

//虽然 if(left <= right) 也能跑
// 但 left == right 的情况（区间只有一个元素）其实是不需要进入递归的
// left < right效率更高是更标准的写法。
    public static void quickSortHelper(int[] nums,int left,int right){
        if(left<=right){
            int pivotIndex = partition(nums,left,right);

            quickSortHelper(nums,left,pivotIndex-1);


            quickSortHelper(nums,pivotIndex+1,right);
        }
    }


    public static int partition(int[] nums, int left, int right) {
        int pivot=nums[left];
        int i=left+1;
        int j=right;


        while(i<=j){
            while(i<=right && nums[i]<=pivot){
                i++;
            }


            //这里应该是nums[j]
            while(j>=left && nums[j]>pivot){
                j--;
            }


            if(i<j){
                swap(nums,i,j);
            }


        }

        swap(nums,left,j);
        return j;
    }



    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
