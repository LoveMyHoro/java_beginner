package t1_查找算法;
//注：分的块数通常是长度开根号
public class 分块查找 {
    public static void main(String[] args) {
        int[] arr = {16, 5, 9, 12,21, 18,
                     32, 23, 37, 26, 45, 34,
                     50, 48, 61, 52, 73, 66};
        Block b1=new Block(21,5,0,5);
        Block b2=new Block(45,23,6,11);
        Block b3=new Block(73,48,12,17);
        Block []arr2={b1,b2,b3};
        int num=66;
        Find(arr,arr2,num);
    }
    public static void Find(int []arr,Block []arr2,int num){
        int index=FindIndex(arr2,num);
        if(index==-1){
            System.out.println("查找失败！");
            return;
        }
        for(int i=arr2[index].getStart();i<=arr2[index].getEnd();i++){
            if(arr[i]==num){
                System.out.println("索引是"+i);
                return;
            }
        }
    }
    public static int FindIndex(Block []arr2,int num){
        for (int i = 0; i < arr2.length; i++) {
            if(num<=arr2[i].getMax()&&num>=arr2[i].getMin()){
                return i;
            }
        }
        return -1;
    }
}
class Block{
    private int max;
    private int min;
    private int start;
    private int end;

    public Block() {
    }

    public Block(int max, int min,int start, int end) {
        this.max = max;
        this.start = start;
        this.end = end;
        this.min=min;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
