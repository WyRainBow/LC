package 快速;


/**
 * 2025-04-20 23:48
 */
public class Demo0420 {

    public static void main(String[] args) {
        int[] nums={2,4,5,2,1};
        quickSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }




    public static void quickSort(int[] nums) {
        quickSortHelper(nums,0,nums.length-1);
    }



    public static void quickSortHelper(int[] nums, int left, int right) {
        if(left <= right){
            int pivotIndex=partition(nums,left,right);

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
