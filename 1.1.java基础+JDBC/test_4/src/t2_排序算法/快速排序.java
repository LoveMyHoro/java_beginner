package t2_排序算法;


public class 快速排序 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,8,0,5,9,44,8,7,9,3,4,5,10,8};
        Method(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    private static void Method(int[] arr,int i,int j) {
        int start=i,end=j;
        if(start>end){
            return;
        }
        int baseNumber=arr[i];
        while(start!=end){
            //end先移动可以保证最后与基准数交换的数是小于基准数的
            while(true){
                if(start>=end||arr[end]<baseNumber){
                    break;
                }
                end--;
            }
            while(true){
                if(start>=end||arr[start]>baseNumber){
                    break;
                }
                start++;
            }
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
        }
        //将第一个数（基准数）与现在start所指的数交换。因为左边是小于基准数的，右边是大于基准数的
        int temp=arr[i];
        arr[i]=arr[start];
        arr[start]=temp;
        Method(arr,i,start-1);
        Method(arr,start+1,j);
    }
}
