ways = []


def stairway_to_heaven(n):
    ways.append(1)
    ways.append(1)
    for i in range(2,n+1):
        c = ways[i-1] + ways[i-2]
        ways.append(c)
    return ways[n]


ways = stairway_to_heaven(5)
print(ways)
