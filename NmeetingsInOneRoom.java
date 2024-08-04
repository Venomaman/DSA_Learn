import java.util.*;
public class NmeetingsInOneRoom {
        public static void main(String[] args) {
            Solution solution = new Solution();
            int start[] = {1, 3, 0, 5, 8, 5};
            int end[] = {2, 4, 12, 7, 9, 9};
            int n = start.length;
            
            int result = solution.maxMeetings(n, start, end);
            System.out.println("Maximum number of meetings: " + result); // Output should be 4
        }
}
class pair{
    int start;
    int end;
    
    public pair(int start, int end){
        this.end = end;
        this.start = start;
    }
    public String toString(){
        return "(" + start + ", " + end + ")";
    }
}

class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int n, int start[], int end[]) {
        // add your code here
        
        ArrayList<pair> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(new pair(start[i], end[i]));
        }
        System.out.println("total number of pairs" +arr); 
        Collections.sort(arr, new Comparator<pair>(){
            public int compare(pair a, pair b){
                return a.end-b.end;
            }
        });
        System.out.println("pairs after sorting" +arr);
        
        
        int ans=1;
        pair prev = arr.get(0);
        pair curr;
        ArrayList<pair> ansArr = new ArrayList<>();
        ansArr.add(prev); //added the first meeting....
        for(int i=1;i<n;i++){
            curr = arr.get(i);
            if(curr.start>prev.end){
                ans++;
                ansArr.add(curr); //added the selected meeting from pair..
                prev=curr;
            }
        }
        System.out.println("Total no of meetings possible in one room given time range are: "+ansArr);
        return ans;
    }
}
