"""
670. Maximum Swap
"""


def array_to_number(arr):
    return int("".join(arr))


def swap_indices(arr, i, j):
    new_arr = arr[:]
    new_arr[i], new_arr[j] = new_arr[j], new_arr[i]
    return new_arr


class Solution(object):
    def maximumSwap(self, num):
        """
        :type num: int
        :rtype: int
        """
        nums = list(str(num))
        length = len(nums)
        i = length - 2
        last_max = nums[-1]

        right_max = ['0'] * length
        right_max[-1] = last_max
        while i >= 0:
            last_max = max(last_max, nums[i])
            right_max[i] = last_max
            i = i - 1

        max_swap = num
        left = 0
        right = 0
        while right < length and left < length:
            if nums[left] < right_max[right]:
                swapped = swap_indices(nums, left, right)
                max_swap = max(max_swap, array_to_number(swapped))
                right += 1
            else:
                left += 1

        return max_swap


print(Solution().maximumSwap(9973))
