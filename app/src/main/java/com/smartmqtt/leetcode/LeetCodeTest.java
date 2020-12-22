package com.smartmqtt.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: kerry
 * date: On $ {DATE}
 */
public class LeetCodeTest {


    public static void main(String[] args) {


//        romanToInt("VM");
        /**
         * 编写一个函数来查找字符串数组中的公共前缀。
         * 示例1：输入 flower . flow flight ，输出 fl
         *  示例2：输入dog,racecar  ,car  输出"" 输入不存在公共前缀
         *
         * */

        String f = "aaa,aa,aaa";
        String longst = longst(f);
        Logs.s("   longstlongst   " + longst);


    }

    private static String longst(String fl) {

        //得到字符数组
        String[] split = fl.split(",");
        String first = "";
        //字符数组是空的直接返回
        if (split == null || split.length == 0) {
            return "";
        }
        //字符数组等于1 默认第一个为公共前缀。
        if (split.length == 1) {
            return split[0];
        }

        //把第一个字符数组取出来方便后边使用
        first = split[0];

        String help = "";
        //从0和1开始运算
        for (int i = 1; i < split.length; i++) {
            //help 记录上一个相等的公共前缀
            help = help(first, split[i]);
            if (help == null) {
                return "";
            }

        }
        return help;

    }

    static int min = 0;

    private static String help(String length, String sss) {
        //取两个数的最小值
        int m = Math.min(length.length(), sss.length());
        if (min == 0) {
            min = Math.min(length.length(), sss.length());
        }

        if (min > m) {
            min = m;
        }
        //字符串倒序比较，
        for (int i = min; i > 0; i--) {
            String substring = length.substring(0, i);
            //相等说明有公共前缀，直接返回
            if (substring.equals(sss.substring(0, i))) {
                return substring;
            }

        }
        return null;

    }


    /**
     * 罗马数字包含以下7种字符：I V X L C D 和 M
     * 字符   数值
     * I  = 1
     * V  = 5
     * X =10
     * L=50
     * C=100
     * D=500
     * M=1000
     * 例如，罗马数字2写做II，即为两个列的1,12写做XII,即X+II,27写做XXVII,即为XX+V+II
     * 通常情况下，罗马数字中小的数字在大的数字的右边，但也存在特列，例如4不会写做IIII而是IV，数字1在数字5的左边，所表示的书等于大数5减小数1得到的数值4
     * 同样地，数字9表示IX，这个特殊的规则只使用于一下六种情况
     * ~I可以放在V和X的左边，来表示4和9
     * ~X可以放在L和C的左边，来表示40和90
     * ~C可以放在D和M的左变，来表示400和900
     * 给定一个罗马数字，将其转换成整数，输入确保在1到3999的范围内/
     * 示例1，输入III 输出3
     * 示例2，输入IV输出4
     * 示例3，输入IX输出9
     * 示例4，输入LVIII输出58
     * 示例5，输入MCMXCIV输出1994
     * <p>
     * 提示：题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
     * IC和IM这样的例子并不符合题目的要求，49应该写作VLIX，999应该写作CMXCLX
     */
    private static void romanToInt(String s) {
//
//        HashMap<String, Integer> map = new HashMap<>();
//        map.put("I", 1);
//        map.put("V", 5);
//        map.put("X", 10);
//        map.put("L", 50);
//        map.put("C", 100);
//        map.put("D", 500);
//        map.put("M", 1000);
//        XXVII
        int length = s.length();
        int romanInt = 0;
        for (int i = 0; i < length; i++) {
            switch (s.charAt(i)) {
                case 'I':
                    romanInt += 1;
                    break;

                case 'V':
                    romanInt += 5;
                    break;

                case 'X':
                    romanInt += 10;
                    break;

                case 'L':
                    romanInt += 50;
                    break;

                case 'C':
                    romanInt += 100;
                    break;

                case 'D':
                    romanInt += 500;
                    break;

                case 'M':
                    romanInt += 1000;
                    break;

                default:
                    break;


            }


            if (i != 0) {
                if ((s.charAt(i) == 'V' || s.charAt(i) == 'X') && s.charAt(i - 1) == 'I') {
                    Logs.s("   s.charAt(i)  " + s.charAt(i - 1));
                    romanInt -= 1 * 2;
                }
                if ((s.charAt(i) == 'L' || s.charAt(i) == 'C') && s.charAt(i - 1) == 'X') {
                    romanInt -= 10 * 2;
                }

                if ((s.charAt(i) == 'D' || s.charAt(i) == 'M') && s.charAt(i - 1) == 'C') {
                    romanInt -= 100 * 2;
                }
            }

            //    XXVII
            Logs.s("   s.charAt(i)  " + romanInt);

        }

        Logs.s("  romanInt " + romanInt);

    }


    /**
     * 计算：回文数
     * 判断一个整数是否是回文数，回文数是指正序(从左到右)和倒序(从右到左)度都是一样的整数。
     * 示例1： 121 true
     * 示例2 -121 false
     * 实例3 10 false
     * <p>
     * 思路：
     * 如果是负数则一定不是回文数，直接返回false
     * 如果是整数，则将其倒序数值计算出来，然后比较原数值是否相等
     * 如果是回文数则相等返回true，如果不是则不相等返回false
     * isPalindrme(121);
     */
    private static boolean isPalindrme(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int cur = 0, num = x;
        while (num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }

        return cur == x;

    }

    /**
     * 给出一个32位的符号整数，你需要将这个整数中每位上的数字进行反转
     * 示例1：
     * 输入：123
     * 输出：321
     * 示例2：输入
     * 输入：-123
     * 输出：-312
     * 实例3：
     * 输入：120
     * 输出：21
     * <p>
     * 注意：假设我们的环境只能存储的下32位的有符号的整数，则其数值范围为【-2 21，2 31-1】根据这个假设，
     * 如果反转后整数溢出那么就返回0
     */
    private static void reverse() {

    }


    /**
     * 等级=简单
     * 给定一个整数数组nums和一个目标值target，请你在该数组中找出和目标值的两个整数，并返回他们的数组下标。
     * 可以假设每种输入只会对应一个答案，但是，数组中同一个元素不能使用两边
     */
    private static void twoSum() {
        //给定 nums = [2, 7, 11, 15], target = 9
        //因为 nums[0] + nums[1] = 2 + 7 = 9
        //所以返回 [0, 1]

        int[] nums = {2, 7, 11, 15};
        Map<Integer, Integer> map = new HashMap<>(16);
        int target = 9;
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                Logs.s(map.get(complement) + "  " + i);
                break;
            }
            map.put(nums[i], i);
        }

    }


    private static void twoSum2() {

        int[] nums = {2, 7, 11, 15};
        int taret = 18;
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int i1 = taret - nums[i];
            if (map.containsKey(i1)) {
                Logs.s(map.get(i1) + " .. " + i);
                break;
            }
            map.put(nums[i], i);
        }
    }


    /**
     * 等级=中等
     * 给出两个非空的链表用来表示非负的整数，其中，他们各自的位数是按照逆序的方式存储的，并且他们的每个节点只能存储一位数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字0之外，这两个数都不会以0开头
     * 示例：
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7-> 0 -> 8
     * 原因:342 + 465 = 807
     */
    private static void addTwoNumbers() {


    }


}


































