money = [3,8,10,4,1,7]
def rob_houses(money):
    money_till_array = [0 for _ in range(len(money))]
    money_till_array[0] = money[0]
    money_till_array[1] = money[1]
    for i in range(2,len(money)):
        money_till_array[i] = money[i] + max(money_till_array[0:i-1])
    print(max(money_till_array))
rob_houses(money)
rob_houses([3,8,10,4,1,7,2])
