package com.example.data_structure_algorithm.jike.query;

/**
 * 二分查找
 * 变形问题
 * 查找第一个值等于给定值的元素
 * 查找最后一个值等于给定值的元素
 * 查找第一个大于等于给定值的元素
 * 查找最后一个小于等于给定值的元素
 */
public class BinarySearch {
    private static int[] a = {1, 2, 3, 3, 3, 3, 3, 4, 4, 5, 5, 6};

    /**
     * 无重复查询元素
     */
    private static int binarySearchWhile(int[] numbers, final int target) {
        int start = 0, end = numbers.length;
        int mid;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            if (numbers[mid] > target) {
                end = mid - 1;
            } else if (numbers[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 重复查询元素
     * 二分查找第最后一个值等于给定值的元素
     */
    private static int binarySearchWhile1(int[] numbers, final int target) {
        int start = 0, end = numbers.length;
        int mid;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            if (numbers[mid] > target) {
                end = mid - 1;
            } else if (numbers[mid] < target) {
                start = mid + 1;
            } else {
                if ((mid == end) || (a[mid + 1] != target)) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 重复查询元素
     * 查找第一个大于等于给定值的元素
     */
    private static int binarySearchWhile2(int[] numbers, final int target) {
        int start = 0, end = numbers.length;
        int mid;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            if (numbers[mid] >= target) {
                if (mid == 0 || numbers[mid - 1] < target) {
                    return mid;
                }
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 重复查询元素
     * 查找最后一个小于等于给定值的元素
     */
    private static int binarySearchWhile3(int[] numbers, final int target) {
        int start = 0, end = numbers.length;
        int mid;
        while (start <= end) {
            // 替换 (start + end ) >> 1 避免start+end过大而溢出
            mid = start + ((end - start) >> 1);
            if (numbers[mid] > target) {
                end = mid - 1;
            } else {
                if (mid == end || numbers[mid + 1] > target) {
                    return mid;
                }
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 递归二分查找
     */
    private static int binarySearchRecursiveAcronym(int[] numbers, final int target) {
        return recursiveAcronym(numbers, 0, numbers.length, target);
    }

    private static int recursiveAcronym(int[] numbers, int start, int end, final int target) {
        if (start > end) {
            return -1;
        }
        int mid = start + ((end - start) >> 1);
        if (numbers[mid] < target) {
            return recursiveAcronym(numbers, mid + 1, end, target);
        } else if (numbers[mid] > target) {
            return recursiveAcronym(numbers, start, mid - 1, target);
        } else {
            if ((mid == 0) || (a[mid - 1] != target)) {
                return mid;
            } else {
                return recursiveAcronym(numbers, start, mid - 1, target);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(binarySearchWhile3(a, 4));
    }
}
