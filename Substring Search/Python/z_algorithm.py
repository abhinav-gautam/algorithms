class ZAlgorithm:

    def __init__(self, text, pattern):
        self.pattern = pattern
        self.text = text

        # We have to concatanate the pattern and the text
        self.S = pattern+text

        # Integer table for the Z values
        self.Z = [0 for _ in range(len(self.S))]

    def construct_z_table(self):

        # The first item (at index 0) is the length of the S
        self.Z[0] = len(self.S)

        # The first and last item in the Z box
        left = 0
        right = 0

        # Consider all the letters of the S string (starting with index 1)
        for k in range(1, len(self.S)):

            # Case I we are not within the Z box (naive approach)
            if k > right:
                n = 0
                while n+k < len(self.S) and self.S[n] == self.S[n+k]:
                    n += 1

                # Update the z index
                self.Z[k] = n

                # Update the left and right index of Z box
                left = k
                right = n+k-1
            else:

                # We are inside a Z box so maybe we can copy the values
                p = k-left

                if self.Z[p] < right-k+1:
                    # Case II when we can copy the values
                    self.Z[k] = self.Z[p]
                else:
                    # Case III when we cannot copy the value
                    i = right + 1

                    while i < len(self.S) and self.S[i] == self.S[i-k]:
                        i += 1

                    self.Z[k] = i-k
                    left = k
                    right = i-1

    def search(self):
        self.construct_z_table()

        # We just have to consider the values in the Z table in O(n+m)
        for i in range(1, len(self.Z)):
            if self.Z[i] >= len(self.pattern):
                print(f"Match found at index {i-len(self.pattern)}")


algorithm = ZAlgorithm("abcadvasbaabcasbasabc", "abc")
algorithm.search()
