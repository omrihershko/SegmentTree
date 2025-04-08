# 📊 Segment Tree Project (Java)

This project provides a modular and extensible implementation of various **Segment Trees** in Java. Segment trees are powerful data structures for performing efficient range queries (sum, minimum, maximum) and point updates in logarithmic time.

---

## 📁 Project Structure

SegmentTreeProject/ ├── SegmentTree.java ├── SegmentTreeByArray.java ├── SegmentTreeByTree.java ├── SegmentTreeNode.java ├── SummationSegmentTreeByArray.java ├── SummationSegmentTreeByTree.java ├── MinimumSegmentTreeByArray.java ├── MinimumSegmentTreeByTree.java ├── MaximumSegmentTreeByArray.java ├── MaximumSegmentTreeByTree.java ├── NumberAnalyzer.java ├── NumberAnalyzerByArrays.java ├── NumberAnalyzerByTrees.java ├── Tester.java └── README.md

---

## 🧠 What is a Segment Tree?

A Segment Tree is a binary tree used for storing intervals. It allows efficient querying and updating of aggregate information (like sum, min, or max) in a subrange of an array in **O(log n)** time.

---

## ✅ Features

- Range **Sum**, **Minimum**, and **Maximum** queries
- Efficient **point updates**
- Dual implementation:
  - Tree-based segment trees
  - Array-based segment trees
- **Number Analyzer** utilities using segment trees
- Fully tested with **50+** test cases in `Tester.java`

---

## 🧱 Class Overview

### Abstract Structures

- `SegmentTree` – Abstract interface for any segment tree
- `SegmentTreeByTree` – Node-based segment tree base class
- `SegmentTreeByArray` – Array-based segment tree base class
- `SegmentTreeNode` – Tree node used in tree-based implementations

### Implementations

- `SummationSegmentTreeByArray` / `SummationSegmentTreeByTree`
- `MinimumSegmentTreeByArray` / `MinimumSegmentTreeByTree`
- `MaximumSegmentTreeByArray` / `MaximumSegmentTreeByTree`

### Utilities

- `NumberAnalyzer` – Abstract class for analytics
- `NumberAnalyzerByArrays` – Analytics via array-based trees
- `NumberAnalyzerByTrees` – Analytics via tree-based trees

---

## 🛠️ Usage Example

```java
int[] data = {1, 3, 5, 7, 9, 11};
SummationSegmentTreeByArray segmentTree = new SummationSegmentTreeByArray(data);

// Query the sum from index 1 to 3
int sum = segmentTree.queryRange(1, 3); // Output: 15

// Update index 2 to value 10
segmentTree.update(2, 10);

// Query again
int newSum = segmentTree.queryRange(1, 3); // Output: 20

🧪 Testing
Run the Tester.java class to verify the correctness of all public methods. All segment tree variants are thoroughly tested for:

Boundary conditions

Randomized large arrays

Edge cases (empty, single element, full range, etc.)

📌 Requirements
Java 8 or higher

No external libraries needed
