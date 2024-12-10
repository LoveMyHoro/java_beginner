package t2_排序算法;

public class 插入排序 {
    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        int startIndex=-1;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                startIndex=i+1;
                break;
            }
        }
        for(int i=startIndex;i<arr.length;i++){
            int j=i;
            while(j>0&&arr[j]<arr[j-1]){
                int temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                j--;
            }
        }
        for (int i1 = 0; i1 < arr.length; i1++) {
                System.out.print(arr[i1]+" ");
            }
    }
}
