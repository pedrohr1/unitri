def mergeSort(nums):
    if len(nums) > 1:
        esquerda = nums[:len(nums)//2]
        direita = nums[len(nums)//2:]
        i = 0
        j = 0
        k = 0

        mergeSort(esquerda)
        mergeSort(direita)

        while i < len(esquerda) and j < len(direita):
            if esquerda[i] < direita[j]:
                nums[k]=esquerda[i]
                i+=1
            else:
                nums[k]=direita[j]
                j+=1
            k+=1

        while i < len(esquerda):
            nums[k]=esquerda[i]
            i+=1
            k+=1

        while j < len(direita):
            nums[k]=direita[j]
            j+=1
            k+=1
    
    return(nums)

if __name__ == '__main__':
    print(mergeSort([57,23,95,13,71,32,49,59,24]))