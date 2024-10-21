
### **Finding Duplicates in an Array - 3 Approaches** 🔍

**Problem**: Given an integer array `nums`, return `true` if any value appears more than once, otherwise return `false`.

---

#### 1️⃣ **Brute Force** (O(n²) time, O(1) space) 🐢
- Compare each element with every other element.
```java
class Solution {
    public boolean hasDuplicate(int[] nums) {
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
}
```

---

#### 2️⃣ **Sorted Approach** (O(n log n) time, O(1)/O(n) space) 🚀
- Sort the array and compare adjacent elements to find duplicates.
```java
class Solution {
    public boolean hasDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                return true;
            }
        }
        return false;
    }
}
```

---

#### 3️⃣ **Optimal Approach** (O(n) time, O(n) space) ⚡
- Use a `HashSet` to check for duplicates in O(1) time per lookup.
```java
class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> uniqueElements = new HashSet<>();
        for(int num : nums) {
            if(uniqueElements.contains(num)) {
                return true;
            }
            uniqueElements.add(num);
        }
        return false;
    }
}
```

---

📝 **Takeaway**:  
- **Brute Force**: Simple but inefficient.  
- **Sorted Approach**: Slightly better, but sorting adds overhead.  
- **Optimal Approach**: Best performance, leveraging HashSet for O(n) time.
