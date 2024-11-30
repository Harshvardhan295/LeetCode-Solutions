import java.util.*;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        int count = 0;

        for (int i = sandwiches.length - 1; i >= 0; i--) {
            st.push(sandwiches[i]);
        }

        for (int i = 0; i < students.length; i++) {
            q.add(students[i]);
        }
        
        int rotations = 0; // Initialize a variable to count the number of rotations without serving a sandwich

        while (!st.isEmpty()) {
            if (q.peek() == st.peek()) {
                st.pop();
                q.poll();
                count++; 
                rotations = 0; // Reset rotations since we served a sandwich
            } else {
                q.add(q.poll());
                rotations++;
            }

            // If no progress has been made in a full rotation, break out of the loop
            if (rotations == students.length) {
                break;
            }
        }
        return students.length - count;
    }
}
