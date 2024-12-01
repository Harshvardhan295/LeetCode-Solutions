//brute force
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
//optimised 
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int zeros = 0, ones = 0;
        for (int student : students) {
            if (student == 0) zeros++;
            else ones++;
        }
        for (int sandwich : sandwiches) {
            if (sandwich == 0) {
                if (zeros > 0) zeros--;
                else break;
            } else {
                if (ones > 0) ones--; 
                else break; 
            }
        }
        return zeros + ones;
    }
}
