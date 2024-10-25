"""
1233. Remove Sub-Folders from the Filesystem
"""
from typing import List


class Solution:
    def removeSubfolders(self, folders: List[str]) -> List[str]:
        folders.sort()
        current_folder = folders[0]
        new_folders = [current_folder]
        for i in range(1, len(folders)):
            if folders[i] in ["", "/"]:
                continue
            elif folders[i].startswith(current_folder + "/"):
                continue
            else:
                new_folders.append(folders[i])
                current_folder = folders[i]

        return new_folders


arr = Solution().removeSubfolders(["/a/b/c", "/a/b/d", "/a"])
print(arr)
