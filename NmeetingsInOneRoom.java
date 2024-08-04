// You are given timings of n meetings in the form of (start[i], end[i]) where start[i] is the start time of meeting i and end[i]
//is the finish time of meeting i. Return the maximum number of meetings that can be accommodated in a single meeting room,
// when only one meeting can be held in the meeting room at a particular time. 

// Note: The start time of one chosen meeting can't be equal to the end time of the other chosen meeting.

// Examples :

// Input: n = 6, start[] = [1, 3, 0, 5, 8, 5], end[] =  [2, 4, 6, 7, 9, 9]
// Output: 4
// Explanation: Maximum four meetings can be held with given start and end timings. The meetings are - (1, 2), (3, 4), (5,7) and (8,9)
// Input: n = 3, start[] = [10, 12, 20], end[] = [20, 25, 30]
// Output: 1
// Explanation: Only one meetings can be held with given start and end timings.


import java.util.*;

public class NmeetingsInOneRoom {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 12, 7, 9, 9 };
        int n = start.length;

        int result = solution.maxMeetings(n, start, end);
        System.out.println("Maximum number of meetings: " + result); // Output should be 4
    }
}

class pair {
    int start;
    int end;

    public pair(int start, int end) {
        this.end = end;
        this.start = start;
    }

    public String toString() {
        return "(" + start + ", " + end + ")";
    }
}

class Solution {
    public int maxMeetings(int n, int start[], int end[]) {
        ArrayList<pair> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new pair(start[i], end[i]));
        }
        System.out.println("total number of pairs" + arr);
        Collections.sort(arr, new Comparator<pair>() {
            public int compare(pair a, pair b) {
                return a.end - b.end;
            }
        });
        System.out.println("pairs after sorting" + arr);

        int ans = 1;
        pair prev = arr.get(0);
        pair curr;
        ArrayList<pair> ansArr = new ArrayList<>();
        ansArr.add(prev); // added the first meeting....
        for (int i = 1; i < n; i++) {
            curr = arr.get(i);
            if (curr.start > prev.end) {
                ans++;
                ansArr.add(curr); // added the selected meeting from pair..
                prev = curr;
            }
        }
        System.out.println("Total no of meetings possible in one room given time range are: " + ansArr);
        return ans;
    }
}
