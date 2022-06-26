def findWays(m,n):
    # Initializing ways
    ways = [[0 for i in range(n)] for j in range(m)]

    for i in range(0,m):
        ways[i][n-1]=1
    for i in range(0,n):
        ways[m-1][i]=1
    
    for i in range(m-2,-1,-1):
        for j in range(n-2,-1,-1):
            ways[i][j] = ways[i+1][j]+ways[i][j+1]

    for i in ways:
        for j in i:
            print(j,end="\t")
        print("\n")

findWays(4,4)