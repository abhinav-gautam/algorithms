def first_fit_decreasing_algorithm(items, bin_capacity):
    item_names = list(items.keys())
    item_names_sorted = sorted(
        item_names, key=lambda item_name: items[item_name], reverse=True)

    bins_array = []

    for item_name in item_names_sorted:
        item_size = items[item_name]
        bin_found = False
        for index, bin in enumerate(bins_array):
            bin_size = sum([items[item] for item in bin])
            if item_size <= bin_capacity-bin_size:
                bins_array[index].append(item_name)
                bin_found = True
                break
        if not bin_found:
            bins_array.append([item_name])

    return bins_array


items = {"item1": 4, "item2": 2, "item3": 7,
         "item4": 5, "item5": 6, "item6": 3}
bin_capacity = 8
print(first_fit_decreasing_algorithm(items, bin_capacity))
