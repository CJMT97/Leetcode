package Median_2SortedArr;

public class Median_2SortedArr {

    public static void main(String[] args) {
        int[] nums1 = { 1, 3, 4 };
        int[] nums2 = { 2, 4, 5, 17 };
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int n1 = 0;
        int n2 = 0;
        int index1 = 0;
        int index2 = 0;
        int counter = 0;
        while (counter < total / 2 + 1) {
            if (nums1.length > index1 && nums2.length > index2 && nums1[index1] <= nums2[index2]) {
                n2 = n1;
                n1 = nums1[index1];
                index1++;
            } else if (nums2.length > index2 && nums1.length > index1 && nums1[index1] > nums2[index2]) {
                n2 = n1;
                n1 = nums2[index2];
                index2++;
            } else if (nums1.length > index1) {
                n2 = n1;
                n1 = nums1[index1];
                index1++;
            } else if (nums2.length > index2) {
                n2 = n1;
                n1 = nums2[index2];
                index2++;
            }
            counter++;
        }

        return total % 2 == 0 ? (n1 + n2) / 2.0 : n1;
    }
}
