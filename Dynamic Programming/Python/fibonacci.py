# Top-down approach
def fibonacci_memoization(n, table):
    # print(f"Fibonacci memoization called with n={n}")

    # Check if solution to the subproblem already exists
    if n not in table:

        # If solution does not available calculate and store in the table
        table[n] = fibonacci_memoization(
            n-1, table) + fibonacci_memoization(n-2, table)

    # Return the solution
    return table[n]


# Bottom-up approach
def fibonacci_tabulation(n, table):

    # We create the table starting from 0 to n
    for i in range(2, n+1):
        table[i] = table[i-1] + table[i-2]

    # Return the result for n
    return table[n]


table = {0: 1, 1: 1}
print(fibonacci_memoization(50, table))
print(fibonacci_tabulation(50, table))
