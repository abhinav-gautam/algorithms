array = [11,23,10,37,21,50,80]
array2 = [1,10,2,6,3,9,12,4]
def find_lis(array):
    lis_array = [0 for i in range(len(array))]
    lis_array[0] = 1
    for i in range(1,len(array)):
        if array[i]>array[i-1]:
            lis_array[i] = max(lis_array) + 1
        else:
            lis_array[i] = 1
    print(lis_array)
find_lis(array2)
def find_lis_2(array):
    n = len(array)
    max_length = 0
    lis_array = [1 for i in range(len(array))]
    for i in range(1,n):
        for j in range(0,i):
            if array[i]>array[j] and lis_array[i] < lis_array[j]+1:
                lis_array[i] = lis_array[j] + 1 
    for i in range(0,n):
        if max_length < lis_array[i]:
            max_length = lis_array[i]
    print(lis_array)
find_lis_2(array2)
