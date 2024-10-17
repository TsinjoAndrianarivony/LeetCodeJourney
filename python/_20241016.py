import heapq

class Solution(object):
    def longestDiverseString(self, a, b, c):
        """
        :type a: int
        :type b: int
        :type c: int
        :rtype: str
        """
        # Initialize a max-heap with the negative counts to simulate a max priority queue
        max_heap = []
        for count, letter in [(a, "a"), (b, "b"), (c, "c")]:
            if count > 0:
                heapq.heappush(max_heap, (-count, letter))

        result = ""

        while max_heap:
            # Pop the most frequent letter from the heap
            count, letter = heapq.heappop(max_heap)

            # If the last two characters in the result are the same as the current letter, try the next one
            if result.endswith(letter * 2):
                if not max_heap:
                    break  # No other letter to choose
                # Pop the next most frequent letter
                next_count, next_letter = heapq.heappop(max_heap)
                result += next_letter
                next_count += 1  # We used one occurrence of next_letter

                # Push the next letter back if it's still available
                if next_count < 0:
                    heapq.heappush(max_heap, (next_count, next_letter))

                # Push the current letter back for later
                heapq.heappush(max_heap, (count, letter))
            else:
                # Append the current letter to the result
                result += letter
                count += 1  # We've used one occurrence of this letter

                # Push it back if there are more occurrences left
                if count < 0:
                    heapq.heappush(max_heap, (count, letter))

        return result
