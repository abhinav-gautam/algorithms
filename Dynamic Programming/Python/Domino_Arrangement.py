def arrange(n):
    ways = [1 for i in range(n+1)]

    for i in range(2,n+1):
        ways[i] = ways[i-1] + ways[i-2]

    print(ways[n])

arrange(14)