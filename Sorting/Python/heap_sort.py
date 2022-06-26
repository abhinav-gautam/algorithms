import math


def max_heapify(arr, i, n):
    left = 2 * i
    right = 2 * i + 1
    largest = i
    if left <= n and arr[left] >= arr[largest]:
        largest = left
    if right <= n and arr[right] >= arr[largest]:
        largest = right
    if largest != i:
        arr[largest], arr[i] = arr[i], arr[largest]
        max_heapify(arr, largest, n)


def build_max_heap(arr):
    n = len(arr)
    for i in range(math.floor(n/2)-1, -1, -1):
        max_heapify(arr, i, n)


def heap_sort(arr):
    n = len(arr)
    build_max_heap(arr)
    for i in range(n-1, 0, -1):
        arr[0], arr[i] = arr[i], arr[0]
        max_heapify(arr, 0, i-1)


arr = [10,20,15,12,40,25,18]
heap_sort(arr)
print(arr)
