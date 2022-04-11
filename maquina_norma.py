#!/usr/bin/python
# -*- coding: utf-8 -*-

import re
from time import sleep

registradores = {
    'A': 0,
    'B': 0,
    'C': 0,
    'D': 0
}

def zero(reg):
    valorAux = int(registradores[reg])
    if valorAux == 0:
        print('Registrador {} é zero'.format(reg))
        return True
    else:
        print('Registrador {} não é zero'.format(reg))
        return False

def dec(reg):
    valorAux = int(registradores[reg])
    if not (zero(reg)):
        print('Registrador {} DEC {}'.format(reg, registradores[reg]))
        valorAux -= 1
        registradores[reg] = valorAux
        print('Novo valor do registrador {} é {}'.format(reg,registradores[reg]))
    else:
        registradores[reg] = 0

def inc(reg):
    valorAux = int(registradores[reg])
    print('Registrador {} INC {}'.format(reg, registradores[reg]))
    valorAux += 1
    registradores[reg] = valorAux
    print('Novo valor do registrador {} é {}'.format(reg,registradores[reg]))

def soma():
    while not (zero('B')):
        inc('A')
        dec('B')

    print('O resultado é: {}'.format(registradores['A']))
    print('\n\n')
    sleep(2)
    menu()

def subtracao():
    while not (zero('B')):
        if zero('A'):
            registradores['A'] = 1
            while not (zero('B')):
                inc('A')
                dec('B')
        else:
            dec('A')
            dec('B')

    print('O resultado é: {}'.format(registradores['A']))
    print('\n\n')
    sleep(2)
    menu()

def multiplicacao():
    while not (zero('A')):
        inc('C')
        dec('A')
    
    while not (zero('C')):
        while not (zero('B')):
            inc('A')
            inc('D')
            dec('B')

        while not (zero('D')):
            inc('B')
            dec('D')
        
        dec('C')

    print('O resultado é: {}'.format(registradores['A']))
    print('\n\n')
    sleep(2)
    menu()

def menu():
    print('Entre com um cálculo para a máquina norma:')
    expressao = input()
    operacao = re.findall('[\*\-\+]', expressao.replace(' ', ''))
    nums = expressao.split(operacao[0])
    registradores['A'] = nums[0]
    registradores['B'] = nums[1]

    if operacao[0] == '+':
        soma()
    elif operacao[0] == '-':
        subtracao()
    elif operacao[0] == '*':
        multiplicacao()
    else:
        print('Operação inválida')

if __name__ == '__main__':
    menu()