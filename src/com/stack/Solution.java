package com.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    /**
     * <p>
     *     #20题，判断括号的合法性
     *     https://leetcode-cn.com/problems/valid-parentheses/
     * </p>
     * 思路：
     * 右括号为key，左括号为value构造map
     * 如果是左括号放入栈顶
     * 如果是右括号从栈顶pop，比较
     * 循环完所有char后判断stack是否为空
     */
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
          char c = s.charAt(i);
          if (map.containsKey(c)) {
              // 是右括号，判断stack栈顶是否为对应的左括号
              char top = stack.empty() ? '#' : stack.pop();
              if (top != map.get(c)) {
                  return false;
              }

          } else {
              stack.push(c);
          }
        }
        return stack.empty();
    }

    /**
     * 采用字符串替换
     * 先记录字符串长度
     * 循环将字符串相邻括号移除
     * 处理后的字符串长度和处理前的比较，如果相等说明没有处理过了
     *
     * 循环结束，字符串长度是0说明括号合法
     */
    public boolean isValid2(String s) {
        int length;
        do {
            length = s.length();
            s = s.replace("()", "")
                    .replace("{}", "")
                    .replace("[]", "");
        } while (length != s.length());
        return s.length() == 0;
    }
}
