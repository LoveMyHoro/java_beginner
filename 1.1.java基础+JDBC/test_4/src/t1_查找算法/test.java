package t1_查找算法;

public class test {
    public static void main(String[] args) {
        int []arr={1,3,6,7,11,13,19};
        int index=Find(arr,1   );
        System.out.println(index);

    }
    public static int Find(int []arr,int num){
        int l=0,r=arr.length;
        while(l<=r){
            int mid=(l+r)/2;
            if(num<arr[mid]){
                r=mid-1;
            }
            else if(num>arr[mid]){
                l=mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }

}

