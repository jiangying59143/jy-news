package com.jy.eureka;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int a[] = new int[]{0};
        merge(a, 0, new int[]{1}, 1);
        System.out.println(Arrays.toString(a));
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1=m-1;
        int p2=n-1;
        int p3=m+n-1;
        while(p1 >= 0 && p2 >= 0) {
            if (nums1[p1] < nums2[p2]) {
                nums1[p3--] = nums2[p2--];
            } else {
                nums1[p3--] = nums1[p1];
                nums1[p1--] = nums2[p2--];
            }
        }

    }
}
