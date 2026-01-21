# Hashing

## Definition
Hashing is a technique used to map data (keys) to a fixed-size value using a **hash function**.  
It allows **fast insertion, deletion, and search** operations.

Hashing is commonly implemented using **hash tables**.

---

## Why Hashing?
Consider an array: | 1 | 2 | 1 | 3 | 2 |  

If we want to count how many times an element appears **without hashing**, we must:
- Traverse the array again for every query  
- This results in **O(n)** time for each query  

To avoid repeated traversal, we use **hashing**.

---

## Prestoring / Prefetching Concept
If the problem states:
> Array elements range from `0` to `12`

We create a **hash array** of size `13` (index `0 → 12`).

### Precomputation
For each element in the array:  
hash[element] += 1  

Example:
arr = [1, 2, 1, 3, 2]

hash[1] = 2
hash[2] = 2
hash[3] = 1  


This process is called:
- **Prestoring**
- **Precomputation**
- **Prefetching**

---

## Fetching (Querying)
After precomputation, the frequency of any element `x` can be found in **O(1)** time: Frequency of x = hash[x]

---

### Number Hashing Using Array (C++)
```cpp
#include <iostream>
using namespace std;

int main() {
    int n;
    cout << "Enter number of elements: ";
    cin >> n;

    int arr[n];
    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }

    // Precompute
    int hash[10] = {0};
    for(int i = 0; i < n; i++){
        hash[arr[i]]++;
    }

    // Fetching
    int q;
    cout << "Enter number of queries: ";
    cin >> q;

    while(q--){
        int num;
        cin >> num;
        cout << hash[num] << endl;
    }

    return 0;
}
```

## Array Size Limitation
* Inside main():
   * Maximum array size ≈ 10^6
   * Boolean array ≈ 10^7
* Global array:
   * Maximum array size ≈ 10^7
   * Boolean array ≈ 10^8
So, Large number hashing cannot be done using arrays.

## Character Hashing
Character hashing can be safely done using arrays because the number of characters is limited

Common Cases:
* Lowercase letters (a to z) → size 26
* ASCII characters → size 256

### Character Hashing Example (C++)
```cpp
#include <bits/stdc++.h>
using namespace std;

int main() {
    string s;
    cout << "Enter string: ";
    cin >> s;

    // Precompute
    int hash[26] = {0};
    for(int i = 0; i < s.size(); i++){
        hash[s[i] - 'a']++;
    }

    // Fetching
    int q;
    cout << "Enter number of queries: ";
    cin >> q;

    while(q--){
        char c;
        cin >> c;
        cout << hash[c - 'a'] << endl;
    }

    return 0;
}
```
## Time & Space Complexity
| Operation      | Complexity    |
| -------------- | ------------- |
| Precomputation | O(n)          |
| Query          | O(1)          |
| Space          | O(maxElement) |

## Limitations of Array Hashing
* Works only for small, fixed value ranges
* Cannot handle:
   * Very large numbers
   * Negative numbers
   * Sparse data
so, For these cases, map or unordered_map should be used.

## Key Points
* Hashing avoids repeated traversal
* Precomputation enables fast queries
* Arrays are best for small ranges
* Character hashing is safe with arrays
* Large ranges require map-based hashing