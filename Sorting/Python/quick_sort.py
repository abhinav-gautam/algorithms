import random


def start_quick_sort(arr, mode='asc'):

    def quick_sort(first_index, last_index):
        if first_index >= last_index:
            return

        if mode == 'asc':
            pivot_index = partition_asc(first_index, last_index)
        if mode == 'desc':
            pivot_index = partition_desc(first_index, last_index)

        quick_sort(first_index, pivot_index-1)
        quick_sort(pivot_index+1, last_index)

    def partition_asc(first_index, last_index):
        pivot_index = random.randint(first_index, last_index)
        swap(pivot_index, last_index)

        for i in range(first_index, last_index):
            if arr[i] < arr[last_index]:
                swap(i, first_index)
                first_index += 1

        swap(last_index, first_index)

        return first_index

    def partition_desc(first_index, last_index):
        pivot_index = random.randint(first_index, last_index)
        swap(pivot_index, first_index)

        for i in range(last_index, first_index-1, -1):
            if arr[i] < arr[first_index]:
                swap(i, last_index)
                last_index -= 1

        swap(last_index, first_index)
        return last_index

    def swap(first_index, second_index):
        arr[first_index], arr[second_index] = arr[second_index], arr[first_index]

    return quick_sort(0, len(arr)-1)


arr = [23, 5, 2, 0, 6, -2, -9, 4]
start_quick_sort(arr, mode='asc')
print(arr)
