def split(n):
    arr = [0 for _ in range(n+1)]
    arr[2] = 1
    for i in range(3,n+1):
        for j in range(1,i):
            arr[i] = max(j*arr[i-j],j*(i-j),arr[i])
    print(arr[n])
split(6)