package leetcode.simple;

/**
 * @ClassName SortedListNode
 * @Description 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @Author huangbo1221
 * @Date 2021/9/25 11:29
 * @Version 1.0
 */
public class SortedListNode {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // 返回的头结点肯定是l1或者l2其中的一个
        ListNode firstNode = l1.val < l2.val ? l1 : l2;
        // 把l1中的每一个插入l2链表中，此时需要直到插入时，l2节点的前一个结点
        ListNode preNode = null;
        // 循环停止条件是其中一个以遍历完成
        while (l1 != null && l2 != null) {
            // l1大于l2的结点时，要判断l2的下一个结点的值是否小于当前l1的值，而不是直接插入！
            if (l1.val >= l2.val) {
                preNode = l2;
                l2 = l2.next;
            } else {
                ListNode tmp = l1.next;
                l1.next = l2;
                // l1的当前结点插入l2中间时，l2的前一个结点得换成l1，同时，前一个结点应该指向l1
                if (preNode != null) {
                    preNode.next = l1;
                }
                preNode = l1;
                l1 = tmp;
            }
        }
        // l1后面的所有结点的值都大于l2时，上面的循环并不能保证l1插入l2中，最后还需要一个判断
        if (l1 != null) {
            preNode.next = l1;
        }
        return firstNode;
    }
}


class ListNode {
    int val;

    ListNode next;

    ListNode() {

    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}