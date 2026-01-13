package other.baliram.twopointer;

public class FindCons1 {
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,1,1,0,1};
        int count= 0;
        int maxCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1){
            count++;
            maxCount = Math.max(maxCount, count);
            }else {
            count = 0;
            }
        }

        System.out.println("max count "+maxCount);
    }
}
