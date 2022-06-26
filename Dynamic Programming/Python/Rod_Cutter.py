cost = [0,2,4,5,7]
n = 4
def rod_cutter(cost, n):
    rod = [0 for i in range(n+1)]
    for i in range(1,n+1):
        temp_rod = [0 for k in range(0,i+1)]
        for j in range(0,i+1):
            temp_rod[j] = cost[j] + rod[i-j]
        rod[i] = max(temp_rod)
    print(rod[n])
rod_cutter(cost,n)

    