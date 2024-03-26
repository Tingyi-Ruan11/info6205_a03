import java.util.Arrays;

public class A03 {
// Soultion for P1:
// 1. we can first sort this intervals based on the start time using quick sort
// 2. then iteration over the sorted intervals. find if two adjacent intervals overlapped or not
// 3. if no overlapped intervals, we can return true, else return false
// 4. time complexity is O(nlogn)
    public static boolean canAttendMeetings(int[][] intervals) {
        quickSort(intervals, 0, intervals.length - 1);
        
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }

    private static void quickSort(int[][] intervals, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(intervals, start, end);
            quickSort(intervals, start, partitionIndex - 1);
            quickSort(intervals, partitionIndex + 1, end);
        }
    }

    private static int partition(int[][] intervals, int start, int end) {
        int[] pivot = intervals[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (intervals[j][0] < pivot[0]) {
                i++;
                int[] temp = intervals[i];
                intervals[i] = intervals[j];
                intervals[j] = temp;
            }
        }
        int[] temp = intervals[i + 1];
        intervals[i + 1] = intervals[end];
        intervals[end] = temp;
        return i + 1;
    }


    public static int countSubarraysWithMoreOnes(int[] nums) {
        int onesCount = 0, zerosCount = 0, result = 0;
        for (int i = 0; i < nums.length; i++) {
            onesCount = 0;
            zerosCount = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 1) onesCount++;
                else zerosCount++;

                if (onesCount > zerosCount) result++;
            }
        }
        return result;
    }



    public static void main(String[] args) {
        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        int[][] intervals2 = {{7, 10}, {2, 4}};
        
        System.out.println("Can attend all meetings 1: " + canAttendMeetings(intervals1)); // false
        System.out.println("Can attend all meetings 2: " + canAttendMeetings(intervals2)); // true

        int[] nums1 = {0, 1, 1, 0, 1};
        int[] nums2 = {0};
        int[] nums3 = {1};

        System.out.println("Count of subarrays with more ones 1: " + countSubarraysWithMoreOnes(nums1)); // 9
        System.out.println("Count of subarrays with more ones 2: " + countSubarraysWithMoreOnes(nums2)); // 0
        System.out.println("Count of subarrays with more ones 3: " + countSubarraysWithMoreOnes(nums3)); // 1
}   
}


