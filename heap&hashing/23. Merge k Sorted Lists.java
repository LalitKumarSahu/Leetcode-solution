//brute force approach
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> allValues = new ArrayList<>();

        // Step 1: Extract all node values
        for (ListNode head : lists) {
            while (head != null) {
                allValues.add(head.val);
                head = head.next;
            }
        }

        // Step 2: Sort all values
        Collections.sort(allValues);

        // Step 3: Create a new sorted linked list
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        for (int val : allValues) {
            temp.next = new ListNode(val);
            temp = temp.next;
        }

        // Step 4: Return merged list
        return dummy.next;
    }
}

// optimal solution using Min Heap (Priority Queue)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Step 1: Base case
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Step 2: Min Heap (PriorityQueue) based on node value
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Step 3: Push all first nodes of each list into PQ
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        // Step 4: Dummy node to form merged list
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        // Step 5: Process PQ
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll(); // smallest node
            temp.next = minNode;          // add to result
            temp = temp.next;             // move pointer

            if (minNode.next != null) {
                pq.add(minNode.next);     // push next node from same list
            }
        }

        // Step 6: Return merged sorted list
        return dummy.next;
    }
}
