cost_array = [7,4,3,9,6,2,10,13,1,2]
cost_array2 = [8,1,2,4,6,3]
def cal_max_profit(cost_array):
    min_cost_till_day = [0 for i in range(len(cost_array))]
    min_cost_till_day[0] = cost_array[0]

    for i in range(1,len(cost_array)):
        min_cost_till_day[i] = min(min_cost_till_day[i-1],cost_array[i])

    highest_profit = -9999
    for i in range(0, len(cost_array)):
        current_profit = cost_array[i] - min_cost_till_day[i]
        highest_profit = max(highest_profit,current_profit)

    print(highest_profit)
    
cal_max_profit(cost_array2)
