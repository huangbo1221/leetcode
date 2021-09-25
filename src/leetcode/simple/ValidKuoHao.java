package leetcode.simple;

import java.util.Stack;

/**
 * @ClassName ValidKuoHao
 * @Description 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author huangbo1221
 * @Date 2021/9/25 11:01
 * @Version 1.0
 */

/**
 * 可以用栈来解题，从左往右，只要碰到'('，'['，'{'，就可以往栈里面压，如果碰到
 * ')'，']'，'}'，首先判断栈顶部是否有相匹配的左括号，若没有，则一定不合法。若有，
 * 则将栈顶元素出栈，继续往后判断。
 * 若最终栈元素为0，则合法；不为0，则不合法！
 */
public class ValidKuoHao {

    public static void main(String[] args) {
        System.out.println(isValid("(])"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stacks = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stacks.push(s.charAt(i));
                continue;
            }
            if (stacks.isEmpty()) {
                return false;
            }
            if ((stacks.peek() == '(' & s.charAt(i) == ')') ||
                (stacks.peek() == '[' & s.charAt(i) == ']') ||
                (stacks.peek() == '{' & s.charAt(i) == '}')) {
                stacks.pop();
            } else {
                return false;
            }

        }
        return stacks.isEmpty();
    }

    // 在leetcode看到另一种解法，比较有趣，但是实际时间复杂度太高！
    public static boolean isValids(String s) {
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s.replace("()","");
            s.replace("[]","");
            s.replace("{}","");
        }
        return s.isEmpty();
    }
}
