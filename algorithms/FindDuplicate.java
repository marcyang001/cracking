
public class FindDuplicate {

    public static int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // for num3, tortoise = 7

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        System.out.println(ptr1);
        return ptr1;
    }

    // use binary search to find the duplicates 
    // the duplicated number is always in the denser range,
    // either: 50% more than mid or 50% less than mid
    
    public int findDuplicate_binarySearch(int[] nums) {
        int low = 1, high = nums.length - 1;
        while (low <= high) {
            int mid = (int) (low + (high - low) * 0.5);
            int cnt = 0;
            for (int a : nums) {
                if (a <= mid) ++cnt;
            }
            if (cnt <= mid) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }


    public static void main(String[] args) {
    	int[] nums = {1, 3, 4, 2, 2};
    	int[] nums2 = {3, 1, 3, 4, 2};
    	int[] nums3 = {2,5,9,6,9,3,8,9,7,1};
    	findDuplicate(nums2);

    }

}