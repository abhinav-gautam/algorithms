def construct_pi(pattern):

    # Length of pie table will be same as length of the pattern
    # Initially all will be zero
    pi_table = [0]*len(pattern)

    prefix_counter = 0
    i = 1

    while i < len(pattern):
        if pattern[i] == pattern[prefix_counter]:
            prefix_counter += 1
            pi_table[i] = prefix_counter
            i += 1
        else:
            if prefix_counter != 0:
                prefix_counter = pi_table[prefix_counter-1]
            else:
                pi_table[i] = 0
                i = i+1

    return pi_table


def search(text, pattern):

    # Constructing the pi table
    pi_table = construct_pi(pattern)

    # Initially i and j both will be 0
    # i to track text
    # j to track pattern
    i = 0
    j = 0

    # We have to iterate until i is less than length of the text
    # and j i less than the length of the pattern
    while i < len(text) and j < len(pattern):

        # If characters are matching we increment both indices
        if text[i] == pattern[j]:
            i += 1
            j += 1

        # We found the pattern in the text
        # Reinitialize the j index to be able to find more pattern
        if j == len(pattern):
            print(f"Pattern found at index {i-j}")
            j = pi_table[j-1]

        # If there is a mismatch
        elif j < len(pattern) and text[i] != pattern[j]:

            # If we can decrement j then we decrement it based on the pi table
            if j != 0:
                j = pi_table[j-1]

            # If we are not able to decrement j then we will increment i
            else:
                i += 1


print(construct_pi("aadabaadab"))
search("aababasababasbasababaabasabsab", "aab")
