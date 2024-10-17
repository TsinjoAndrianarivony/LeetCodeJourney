"""
670. Maximum Swap
"""
from math import floor, log10


def digit_length(value):
    return int(floor(log10(value)) + 1)


def digit_at(value, i):
    length = digit_length(value)
    return (value // 10 ** (length - i - 1)) % 10


def swap_digits(n, i, j):
    # Get the total length of the number
    length = digit_length(n)

    # Convert i and j from left-indexed to right-indexed
    i_right = length - 1 - i
    j_right = length - 1 - j

    # Extract digits at i and j (right-indexed)
    digit_i = (n // 10 ** i_right) % 10
    digit_j = (n // 10 ** j_right) % 10

    # Remove the digits from positions i and j (right-indexed)
    n = n - digit_i * 10 ** i_right - digit_j * 10 ** j_right

    # Place the swapped digits (right-indexed)
    n = n + digit_i * 10 ** j_right + digit_j * 10 ** i_right

    return n


class Solution(object):
    def maximumSwap(self, num):
        """
        :type num: int
        :rtype: int
        """
        length = digit_length(num)
        i = length - 2
        last_max = num % 10
        right_max = [0] * length
        right_max[-1] = last_max
        while i >= 0:
            last_max = max(last_max, digit_at(num, i))
            right_max[i] = last_max
            i -= 1

        max_swap = num
        left = 0
        right = 0
        while right < length and left < length:
            left_value = digit_at(num, left)
            if left_value < right_max[right]:
                swapped = swap_digits(num, left, right)
                max_swap = max(max_swap, swapped)
                right += 1
            else:
                left += 1

        return max_swap

