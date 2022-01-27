In problems involving an array, a sliding window is used to avoid computing overlaping parts of the problem.

With a sliding window it is possible to consider sub arrays or chunks of the input array, list of string that satisfy the problem's constraint and then grow or shrink the window as required for determining a solution.

With a sliding window it is possible to improve the time complexity of the problem from O(n ^ 2) to O(n).

The logic involves using two pointers to represent the window. The window is unstable when it does not satisfy the problem constraints and then grows or shrink in order to satisfy the constraint and consider all present data points.

 Reference:
 [Coderbyte](https://www.youtube.com/watch?v=BM0mhAlvyQc&list=RDCMUCOJtQcnBnIy4LERo6vkrItg&index=1)
[Techie delight](https://medium.com/techie-delight/top-problems-on-sliding-window-technique-8e63f1e2b1fa)

 