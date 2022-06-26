def binary_search_iterative(arr, key):
    n = len(arr)
    low = 0
    high = n
    while low <= high:
        mid = (low + high) // 2
        if key == arr[mid]:
            return mid
        if key < arr[mid]:
            high = mid - 1
        else:
            low = mid + 1
    return "Not Found"


result = binary_search_iterative([23, 34, 45, 56, 67, 78, 89, 90, 123], 123)
print(result)
