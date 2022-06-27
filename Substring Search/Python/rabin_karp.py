class RabinKarp:

    def __init__(self, pattern, text):
        self.pattern = pattern
        self.text = text

        # The size of alphabet set
        self.d = 26

        # Prime number for modulo operation
        self.q = 31

    def search(self):
        m = len(self.pattern)
        n = len(self.text)

        # Hashes for the region of the text and pattern
        hash_text = 0
        hash_pattern = 0

        # The largest polynomial term in the fingerprint function
        h = 1
        for _ in range(m-1):
            h = (h*self.d) % self.q

        # Pre-compute the has of the pattern and text
        for i in range(m):
            hash_pattern = (self.d*hash_pattern +
                            ord(self.pattern[i])) % self.q
            hash_text = (self.d*hash_text + ord(self.text[i])) % self.q

        # Slide the pattern over the text one by one
        for i in range(n-m+1):

            # Check the hash values of current window of text and pattern.
            # If the has values match then only check for characters one by one

            if hash_text == hash_pattern:
                # Naive approach to check the characters
                j = 0

                while j < m:
                    if self.text[i+j] != self.pattern[j]:
                        break
                    j += 1

                if j == m:
                    print(f"Found the match at index {i}")

            # Update the hash for the actual substring of the text
            # Apply rolling hash approach
            if i < n-m:
                hash_text = (
                    (hash_text - ord(self.text[i])*h) * self.d + ord(self.text[i+m])) % self.q

                # We might get a negative value so we have to make sure the hash is positive
                if hash_text < 0:
                    hash_text += self.q


algorithm = RabinKarp("abc", "abcasdasdqwdascabcasd")
algorithm.search()
