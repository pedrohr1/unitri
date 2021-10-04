#-*- coding: utf-8 -*-

import matplotlib.pyplot as plt
import random
from time import sleep, time
        
def merge(nums):
    if len(nums) > 1:
        esquerda = nums[:len(nums)//2]
        direita = nums[len(nums)//2:]
        i, j, k = 0, 0, 0
        merge(esquerda)
        merge(direita)
        while i < len(esquerda) and j < len(direita):
            if esquerda[i] < direita[j]:
                nums[k]=esquerda[i]
                i+=1
                if mostrar_vetor == 's':
                    print(nums)
            else:
                nums[k]=direita[j]
                j+=1
                if mostrar_vetor == 's':
                    print(nums)
            k+=1
        while i < len(esquerda):
            nums[k]=esquerda[i]
            if mostrar_vetor == 's':
                print(nums)
            i+=1
            k+=1
        while j < len(direita):
            nums[k]=direita[j]
            if mostrar_vetor == 's':
                print(nums)
            j+=1
            k+=1
        return nums

def insertion(nums):
    for i in range(1, len(nums)):
        chave = nums[i]
        j = i - 1
        while j >= 0 and chave < nums[j]:
            nums[j + 1] = nums[j]
            if mostrar_vetor == 's':
                print(nums)
            j -= 1
            nums[j + 1] = chave
            if mostrar_vetor == 's':
                print(nums)
    return nums

def countingRadix(nums, valPosAtual):
    tamanhoDoArray = len(nums)
    cont = [0] * 10

    for i in range(tamanhoDoArray):
        elementoBase = (nums[i] // valPosAtual) % 10
        cont[elementoBase] += 1

    for i in range(1, 10):
        cont[i] += cont[i-1]

    retorno = [0] * tamanhoDoArray
    i = tamanhoDoArray - 1

    while i >= 0:
        elementoAtual = nums[i]
        elementoBase = (nums[i] // valPosAtual) % 10
        cont[elementoBase] -= 1
        posNova = cont[elementoBase]
        retorno[posNova] = elementoAtual
        i -= 1

    return retorno

def radix(nums):
    elementoMaximo = max(nums)
    qtdDigitos = 1

    while elementoMaximo > 0:
        elementoMaximo /= 10
        qtdDigitos += 1

    valPosicao = 1
    retorno = nums

    while qtdDigitos > 0:
        retorno = countingRadix(retorno, valPosicao)
        valPosicao *= 10
        qtdDigitos -= 1

    return retorno

if __name__ == '__main__':
    array1 = []
    start = int(input('Qual a quantida de valores no primeiro vetor?\n'))
    step = int(input('Qual a razão de crescimento?\n'))
    stop = int(input('Qual a quantidade de valores no último vetor?\n'))
    mostrar_vetor = str.lower((input('Deseja mostrar o vetor a cada iteração?(s/n)\n')))
    mostrar_tempo = str.lower((input('Deseja mostrar o tempo de execução?(s/n)\n')))
    array1 = random.sample(range(start), start)
    qtd_vetores = 0

    if mostrar_tempo == 's':    
        inicio = time() 

    print('Vetor inicial ordenado: {}'.format(insertion(array1)))
    
    while qtd_vetores < 9:
        step += start
        array = random.sample(range(step), step)
        print('Vetor {} ordenado: {}'.format(qtd_vetores + 1, insertion(array)))
        array = []
        qtd_vetores += 1
    else:
        array = random.sample(range(step), stop)
        print('Vetor final ordenado: {}'.format(insertion(array)))

    qtd_vetores = 0

    if mostrar_tempo == 's':
        tempo_insertion = time() - inicio
        inicio = time() 

    print('Vetor inicial ordenado: {}'.format(merge(array1)))
    
    while qtd_vetores < 9:
        step += start
        array = random.sample(range(step), step)
        print('Vetor {} ordenado: {}'.format(qtd_vetores + 1, merge(array)))
        array = []
        qtd_vetores += 1
    else:
        array = random.sample(range(step), stop)
        print('Vetor final ordenado: {}'.format(merge(array)))

    qtd_vetores = 0

    if mostrar_tempo == 's':
        tempo_merge = time() - inicio
        inicio = time() 

    print('Vetor inicial ordenado: {}'.format(radix(array1)))
    
    while qtd_vetores < 9:
        step += start
        array = random.sample(range(step), step)
        print('Vetor {} ordenado: {}'.format(qtd_vetores + 1, radix(array)))
        array = []
        qtd_vetores += 1
    else:
        array = random.sample(range(step), stop)
        print('Vetor final ordenado: {}'.format(radix(array)))

    if mostrar_tempo == 's':
        tempo_radix = time() - inicio
        sleep(5)
        print('Tempo insertion: %f\nTempo merge: %f\nTempo radix: %f' % (tempo_insertion, tempo_merge, tempo_radix))
        sorts = ['Insertion', 'Merge', 'Radix']
        tempos = [tempo_insertion, tempo_merge, tempo_radix]
        plt.bar(sorts, tempos)
        plt.show()