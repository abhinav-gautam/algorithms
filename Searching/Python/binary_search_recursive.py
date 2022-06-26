def binary_search_recursive(arr,key,low,high):
    if low == high:
        if arr[low] == key:
            return low
        return "Not Found"

    mid = (low + high) // 2
    if key == arr[mid]:
        return mid
    if key < arr[mid]:
        return binary_search_recursive(arr,key,low,mid-1)
    else:
        return binary_search_recursive(arr,key,mid+1,high)


result = binary_search_recursive([23, 34, 45, 56, 67, 78, 89, 90, 123], 123,0,8)
print(result)
