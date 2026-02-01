# Recursion

## Definition
Recursion is a technique where a function calls itself to solve smaller versions of the same problem until it reaches a **base case**.

> Big problem → smaller subproblem → smaller subproblem → base case

---

## Base Case
The **base case** is the stopping condition of a recursive function.

- Prevents infinite recursion  
- Without a base case, recursion never stops  

`Recursion without a base case = Infinite recursion`


---

## Infinite Recursion
Infinite recursion happens when:
- The base case is missing, or
- The base condition is incorrect

### Example (Pseudo Code)
```text
count = 0
void f(){
    print(count)
    count++
    f() //no base case
}

main(){
    f()
}
```


---

## Stack Overflow
**Stack overflow** occurs when the call stack memory is exhausted.

### Reasons:
- Infinite recursion  
- Too many recursive calls without returning  

---

## Call Stack & Stack Unwinding
When a recursive function is called:

1. Each call is stored in the **call stack**
2. Calls keep stacking until base case is reached
3. Base case executes `return`
4. Functions return **one by one** (LIFO)

This returning process is called **stack unwinding**.

### Easy Analogy
- Stack of plates  
- Each recursive call = one plate  
- Plates are removed in reverse order  

---

## Recursion Tree
A **recursion tree** shows how recursive calls are made.

- Node → function call  
- Branch → recursive call  
- Root → first call  
- Leaf → base case  

### Direction
- **Top → Down**: Recursive calls  
- **Bottom → Up**: Returns (stack unwinding)

### Here is the recursion tree for the above example:
```text
sample(count=0) → print 0
        |
sample(count=1) → print 1
        |
sample(count=2) → print 2
        |
sample(count=3) → return (base condition)
```

### Basic Recursion Problems
Q1: Print name n times using recursion   
```java
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();
        sample(1,n);
    }
    static void sample(int i,int n){
        if(i>n){
            return;
        }
        System.out.println("Hari");
        sample(i+1,n);
    }
}
```

### Recursion Tree (Linear)
```text
sample(1, 3) → print "Hari"
    |
sample(2, 3) → print "Hari"
    |
sample(3, 3) → print "Hari"
    |
sample(4, 3) → return (base condition)
```
Downward phase (recursive calls):
* Each call waits and makes one more call
* Tree grows straight downward

Upward phase (returns):
```text
sample(4,3) returns
↑
sample(3,3) finishes
↑
sample(2,3) finishes
↑
sample(1,3) finishes
```

Q2: Print linearly from 1-n:
```python
def sample(i,n):
    if i>n: #base case
        return
    print(i)
    sample(i+1,n)
n=4
print(sample(1,n))
```
Q3: Print in terms of n-->1
```python
def sample(i,n):
    if i<1: #base case
        return
    print(i)
    sample(i-1,n)
n=4
print(sample(n,n))
```

Q4: Print linearly from 1-->n (but by using backtrap)   
```python
def sample(i,n):
    if i<1:
        return
    sample(i-1,n)
    print(i)
n=4
print(sample(n,n))
```

Q5:Print linearly from n-->1 (but by using backtrap)  
```python
def sample(i,n):
    if i<1:
        return
    sample(i-1,n)
    print(i)
n=4
print(sample(n,n))
```   

Q: sumation of first n numbers   
Two  ways to solve prob --> (i) Parameter wise ways   (ii)functional way   

(i) 
```text
f(i,s){
    if(i<1){
        print(s)
        return;
    }
    f(i-1,s+i)
}
main(){
    n
    f(n,0)
}
```   

(ii)
```
f(n){
    if(n==0){
        return 0;
    }
    return n+f(n-1)
}
main(){
    n
    print(f(n))
}
```   

```c++
#include<iostream>
using namespace std;
int sum(int n){
    if(n==0){return 0;}
    return n+sum(n-1);
}
int main(){
    int n = 3;
    cout<<sum(n);
    return 0;
}
```   

Q: factorial of n   
```
f(n){
    if(n==0){
        return 0;
    }
    return n*f(n-1)
}
main(){
    n
    print(f(n))
}
```
Q: Reverse an array   
```
f(l,r){
    if(l>=r){
        return;
    }
    swap(a[l],a[r]);
    f(l-1,r-1);
}
main(){
    arr
    f(0,n-1)
}
```
```
f(i){
    if(i>=n/2){return;}
    swap(a[i],a[n-i-1]);
    f(i+1)
}
main(){
    arr
    f(0)
}
```    
Q:check whether a given string is palindrome   
```
f(i){
    if(i>=n/2){
        return true
    }
    if(s[i] != s[n-i-1]){
        return false
    }
    return f(i+1)
}
```

### Key Points
- Always define a base case
- Recursive calls happen before returns
- Stack memory is limited
- Recursion trees help understand flow