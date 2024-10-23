# Is Anagram?

**An anagram** is a string that contains the exact same characters as another string, but in a different order. 

**Given two strings** `s` and `t`, return `true` if they are anagrams of each other; otherwise, return `false`.

### Basic Idea:
1. Compare both strings.
2. Return `true` if they contain the same characters; otherwise, `false`.
3. Ensure both strings have the same length. If not, return `false`.
4. Check if each character matches in quantity.

### **Brute Force Approach:**
Sort both strings and compare:
```java
public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    char[] sArray = s.toCharArray();
    char[] tArray = t.toCharArray();
    Arrays.sort(sArray);
    Arrays.sort(tArray);
    return Arrays.equals(sArray, tArray);
}
```
**Time Complexity**: O(n log n)  
**Space Complexity**: O(1) or O(n)

### **Optimal Approach:**
Count character frequencies using an array:
1. Return `false` if lengths differ.
2. Use a frequency array of size 26 (for lowercase letters).
3. Increment counts for `s` and decrement for `t`.
4. If all counts are zero, return `true`.

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int count[] = new int[26];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++) {
            if(count[i] != 0) return false;
        }
        return true;
    }
}
```
**Time Complexity**: O(n)  
**Space Complexity**: O(1)

### **HashMap Approach:**
Use two `HashMap`s to count character frequencies and compare:
```java
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }
        return countS.equals(countT);
    }
}
```
**Advantages**: Works for any character set.  
**Disadvantages**: Higher space complexity.

### Conclusion:
- Use `HashMap` for unknown character sets.
- Use a count array for fixed sets (e.g., lowercase letters).

---

Feel free to adjust any part of this to fit your style or needs!
