"""
1545. Find Kth Bit in Nth Binary String
"""


class Solution(object):

    def findKthBit(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        string_length = n * 2 + 1



    def findKthBit_v1(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        s = ["0"]
        for i in range(1, n):
            next_string = s[i - 1] + "1" + "".join(["1" if bit == "0" else "0" for bit in s[i - 1]])[::-1]
            s.append(next_string)
            if len(next_string) >= k - 1:
                break

        return s[-1][k - 1]
