# Function to solve Fractional Knapsack Problem
def solve_fractional_knapsack(profits, weights, max_capacity):
    cost = [profits[i] / weights[i] for i in range(len(profits))]
    solution = [0 for i in range(len(profits))]
    total_weight = 0
    total_profit = 0

    while total_weight < max_capacity:
        # Finding max cost and index of it
        max_cost = max(cost)
        max_cost_index = cost.index(max_cost)

        # Finding capacity and current weight and profit
        capacity = max_capacity - total_weight
        current_weight = weights[max_cost_index]
        current_profit = profits[max_cost_index]

        # Adding whole item if weight is greater than capacity else adding part of it
        if capacity >= current_weight:
            ratio = 1
        else:
            ratio = capacity / current_weight

        # Adding item to solution
        total_weight += current_weight * ratio
        total_profit += current_profit * ratio
        solution[max_cost_index] = ratio

        # Removing item from cost list
        cost[max_cost_index] = -1

    return solution, total_profit, total_weight


# Driver Code
# profits = [10, 5, 15, 7, 6, 18, 3]
# weights = [2, 3, 5, 7, 1, 4, 1]
# max_capacity = 15

# profits = [60, 40, 100, 120]
# weights = [10, 40, 20, 30]
# max_capacity = 50

profits = [10, 5, 15, 7, 6, 18, 3]
weights = [2, 3, 5, 7, 1, 4, 1]
max_capacity = 15

solution, total_profit, total_weight = solve_fractional_knapsack(
    profits, weights, max_capacity)
print("Solution:", solution)
print("Total profit:", total_profit)
print("Total weights:", total_weight)
