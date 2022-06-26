# This takes more time
# def sum_array(array,i,j):
#     sum = 0
#     while i<=j:
#         sum += array[i]
#         i += 1
#     print(sum)


def pre_process(array):
    sum_until[0] = array[0]
    for i in range(1,len(array)):
        sum_until[i] = sum_until[i-1] + array[i]

def sum_array(a,b):
    if a == 0:
        print(sum_until[b])
        return
    sum = sum_until[b] - sum_until[a-1]
    print(sum)

array = [1,-2,3,10,-8,0]
sum_until = [0 for i in range(len(array))]

pre_process(array)
sum_array(0,2)
sum_array(1,4)
sum_array(3,3)