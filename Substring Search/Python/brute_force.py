def brute_force(pattern, text):
    n = len(text)
    m = len(pattern)

    # Looping over the characters of text
    for i in range(n-m+1):  # O(n)

        # Pointer to track character of pattern
        j = 0

        # Looping over the characters of pattern
        while j < m:    # O(m)

            # If characters does not match then breaking the loop and moving forward to next character
            if text[i+j] != pattern[j]:
                break

            # If character matches moving forward to next character in pattern
            j += 1

        # If complete pattern is matched print the starting index
        if j == m:
            print(f"Found a match at index {i}")


brute_force("abc", "abcasdglkjabcasdqnabc")
