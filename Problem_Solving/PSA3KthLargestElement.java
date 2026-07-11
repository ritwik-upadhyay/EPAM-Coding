package Problem_Solving;

//import java.util.ArrayList;
import java.util.Arrays;
//import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class PSA3KthLargestElement {

    // public static int findKthLargestElement(Queue<Integer> minHeap, int[] nums,
    // int k) {
    // for(int i=k;i<nums.length;i++) {
    // if(nums[i]>minHeap.peek()) {
    // minHeap.poll();
    // minHeap.offer(nums[i]);
    // }
    // }
    // return minHeap.peek();
    // }

    public static int findKthLargestElement(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for(int num : nums) {
            minHeap.offer(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N<=0) {
            // throw new IllegalArgumentException("Invalid Array size\nTry Again.");
            System.out.println("Invalid value of N.\nPlease Try Again.");
            sc.close();
            return;
        }
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println();
        System.out.print("K = ");
        int k = sc.nextInt();
        if (k < 1 || k > nums.length) {
            System.out.println("Invalid value of K.\nPlease Try Again.");
            sc.close();
            return;
            // throw new IllegalArgumentException("Invalid K value\nTry Again.");
        }
        System.out.println();
        System.out.println("=============");
        System.out.println(Arrays.toString(nums));
        System.out.println("K = " + k);

        // List<Integer> list = new ArrayList<>();
        // for(int i=0;i<k;i++) {
        // list.add(nums[i]);
        // }
        // Queue<Integer> minHeap = new PriorityQueue<>(list);
        System.out.print("Kth Largest Element : ");
        // System.out.println(findKthLargestElement(minHeap, nums, k));
        System.out.println(findKthLargestElement(nums, k));
        sc.close();
    }
}
