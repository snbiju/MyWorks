package com.app.test.GS;


import java.util.Random;

/*


Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Implement the Solution class:

Solution(ListNode head) Initializes the object with the head of the singly-linked list head.
int getRandom() Chooses a node randomly from the list and returns its value. All the nodes of the list should be equally likely to be chosen.


Example 1:

Input
["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
[[[1, 2, 3]], [], [], [], [], []]
Output
[null, 1, 3, 2, 2, 3]

Explanation
Solution solution = new Solution([1, 2, 3]);
solution.getRandom(); // return 1
solution.getRandom(); // return 3
solution.getRandom(); // return 2
solution.getRandom(); // return 2
solution.getRandom(); // return 3
// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.


Constraints:

The number of nodes in the linked list will be in the range [1, 104].
-104 <= Node.val <= 104
At most 104 calls will be made to getRandom.


Follow up:

What if the linked list is extremely large and its length is unknown to you?
Could you solve this efficiently without using extra space?

 */
public class SinglyLinkList {
    private final ListNode head;
    private final Random random;
    SinglyLinkList(ListNode head){
        this.head = head;
        this.random = new Random();
    }
    public int getRandom() {
        int result = head.val;
        ListNode current = head.next;
        int i = 2; // Current node index (1-indexed)

        while (current != null) {
            // With a probability of 1/i, update the result
            if (random.nextInt(i) == 0) {
                result = current.val;
            }

            i++;
            current = current.next;
        }

        return result;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        SinglyLinkList solution = new SinglyLinkList(head);
        System.out.println(solution.getRandom()); // return 1
        System.out.println(solution.getRandom()); // return 2
        System.out.println(solution.getRandom()); // return 3
    }
}
