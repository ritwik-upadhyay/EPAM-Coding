package Problem_Solving;
import java.util.*;
public class KSmallestElements {

    public static List<Integer> kSmallestElements(int[] nums, int k) {
        if(nums.length==0 || k<=0 || k>nums.length) {
            System.out.println("Invalid value of nums or k");
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        for(int n : nums) {
            list.add(n);
        }
        Queue<Integer> minHeap = new PriorityQueue<>(list);
        List<Integer> elements = new ArrayList<>();
        while(k>0) {
            elements.add(minHeap.poll());
            k--;
        }
        return elements;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i=0;i<N;i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println();
        System.out.print("K = ");
        int k = sc.nextInt();
        System.out.println();
        System.out.println("=============");
        // System.out.print("[");
        // for(int i=0;i<N;i++) {
        //     if(i==N-1) {
        //         System.out.print(nums[i]);
        //     }
        //     else {
        //         System.out.print(nums[i]+",");
        //     }
        // }
        // System.out.print("]\n");
        System.out.println(Arrays.toString(nums));
        System.out.println("K = "+k);
        System.out.println("K Smallest Elements : ");
        System.out.println(kSmallestElements(nums, k));
        sc.close();
    }
}