package 快速;

public class Demo0510 {


    public static void main(String[] args) {

        int[] nums=new int[]{8,1,2,8,5};

        quickSort(nums,0,nums.length-1);

        for (int num : nums) {
            System.out.print(num);
            System.out.print(" ");
        }
    }

    public static void quickSort(int[] nums,int left,int right){


        //不记得条件是不是这个了
        if(left<right){

            int priortIndex=partition(nums, left, right);

            quickSort(nums,left,priortIndex-1);
            quickSort(nums,priortIndex+1,right);

        }

    }


    public static int partition(int[] nums,int left,int right){


        int i=left+1;
        int j=right;

        int pivot=nums[left];


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


        //这里也要注意一下
        swap(nums,left,j);

        return j;

    }


    public static void swap(int[] nums,int i,int j){

        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}




