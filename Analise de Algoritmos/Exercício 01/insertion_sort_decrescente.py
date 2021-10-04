#-*- coding: utf-8 -*-

def insertionSort(nums):
    for i in range(1, len(nums)):
        chave = nums[i]
        j = i - 1
        
        while j >= 0 and chave > nums[j]:
            nums[j + 1] = nums[j]
            j -= 1
            nums[j + 1] = chave
        
    return nums

if __name__ == '__main__':
    print(insertionSort([5,1,4,2,3]))