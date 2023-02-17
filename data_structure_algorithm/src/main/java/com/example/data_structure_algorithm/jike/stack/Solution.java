package com.example.data_structure_algorithm.jike.stack;

/**
 * 算数运算扩展匹配问题括号问题
 * 如: {sd(){234}[]}
 * <p>
 * 这里也可以用栈来解决。我们用栈来保存未匹配的左括号，从左到右依次扫描字符串。
 * 当扫描到左括号时，则将其压入栈中；当扫描到右括号时，从栈顶取出一个左括号。
 * 如果能够匹配，比如“(”跟“)”匹配，“[”跟“]”匹配，“{”跟“}”匹配，则继续扫描剩下的字符串。
 * 如果扫描的过程中，遇到不能配对的右括号，或者栈中没有数据，则说明为非法格式。
 */
public class Solution {
    /**
     * 是否有效
     */
    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        char[] stacks = new char[chars.length];
        int index = -1;
        for (char aChar : chars) {
            if ('{' == aChar || '[' == aChar || '(' == aChar) {
                if ('{' == aChar) {
                    aChar = '}';
                }
                if ('[' == aChar) {
                    aChar = ']';
                }
                if ('(' == aChar) {
                    aChar = ')';
                }
                stacks[index + 1] = aChar;
                index++;
                continue;
            }
            if ('}' == aChar || ']' == aChar || ')' == aChar) {
                if (index == -1 || aChar != stacks[index--]) {
                    return false;
                }
            }
        }
        return index == -1;
    }

    public static void main(String[] args) {
        System.out.println(isValid("{sdf(sd[23])23}"));
    }
}