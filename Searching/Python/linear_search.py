from ast import If


def linear_search(arr, item):

    for i in range(0, len(arr)):
        if arr[i] == item:
            return i

    return -1


print(linear_search([2, 5, 12, 6, 1, 6, 9, 0], 5))


def linear_search_recursive(arr, item, index=0):
    if arr[index] == item:
        return index

    if index >= len(arr):
        return -1

    return linear_search_recursive(arr, item, index+1)


print(linear_search_recursive([2, 5, 12, 6, 1, 6, 9, 0], 2))
