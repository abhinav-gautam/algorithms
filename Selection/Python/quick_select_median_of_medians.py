no_quick_select_calls = 0


def find_arr_median(first_index, last_index):
    median_arr = []
    find_median_of_medians(median_arr, first_index, last_index)
    final_median = find_median(median_arr)
    return final_median


def find_median(arr):
    arr_sorted = sorted(arr)
    median_index = len(arr_sorted)//2
    return arr_sorted[median_index]


def find_median_of_medians(median_arr, first_index, last_index):
    if first_index > last_index:
        return

    if first_index+4 > last_index:
        return median_arr.append(find_median(arr[first_index:last_index+1]))

    median = find_median(arr[first_index:first_index+5])
    median_arr.append(median)

    return find_median_of_medians(median_arr, first_index+5, last_index)


def start_quick_select(arr, k, mode='smallest'):

    def quick_select(first_index, last_index, kp):
        global no_quick_select_calls
        no_quick_select_calls += 1
        if mode == 'smallest':
            pivot_index = partition_smallest(first_index, last_index)
        elif mode == 'largest':
            pivot_index = partition_largest(first_index, last_index)

        if pivot_index > kp:
            return quick_select(first_index, pivot_index-1, kp)
        elif pivot_index < kp:
            return quick_select(pivot_index+1, last_index, kp)

        return arr[pivot_index]

    def partition_smallest(first_index, last_index):
        pivot = find_arr_median(first_index, last_index)
        pivot_index = arr.index(pivot)
        swap(pivot_index, last_index)

        for i in range(first_index, last_index):
            if arr[i] < arr[last_index]:
                swap(i, first_index)
                first_index += 1

        swap(last_index, first_index)

        return first_index

    def partition_largest(first_index, last_index):
        pivot = find_arr_median(first_index, last_index)
        pivot_index = arr.index(pivot)
        swap(pivot_index, first_index)

        for i in range(last_index, first_index-1, -1):
            if arr[i] < arr[first_index]:
                swap(i, last_index)
                last_index -= 1

        swap(last_index, first_index)
        return last_index

    def swap(first_index, second_index):
        arr[first_index], arr[second_index] = arr[second_index], arr[first_index]

    return quick_select(0, len(arr)-1, k-1)


arr = [23, 5, 2, 0, 6, -2, -2, -9, 4, 1, 45, 65, 24, -6, 20, 65, 8, 64, 10]
print(start_quick_select(arr, 5, 'smallest'))
print(f'No of quick select function calls: {no_quick_select_calls}')
