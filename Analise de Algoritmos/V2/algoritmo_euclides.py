#!/usr/bin/python3.8
# -*- coding: utf-8 -*-

def mdc(x, y):
    antigo = int(x)
    atual = int(y)
    resto = antigo % atual

    while resto != 0:
        resto = antigo % atual
        antigo = atual
        atual = resto

    return antigo

def euclides_mdc(vals):
    if len(vals) == 2:
        return mdc(vals[0], vals[1])
    else:
        val_res_mdc = mdc(vals[0], vals[1])
        vals[0] = val_res_mdc
        del vals[1]
        return euclides_mdc(vals)

def mmc(x, y, mdc):
    _x = int(x)
    _y = int(y)
    _mdc = int(mdc)

    return int(((_x*_y)/_mdc))

def euclides_mmc(vals):
    if len(vals) == 2:
        return mmc(vals[0], vals[1], mdc(vals[0], vals[1]))
    else:
        while len(vals) >= 2:
            resultado_mdc = mdc(vals[0], vals[1])
            resultado_mmc = mmc(vals[0], vals[1], resultado_mdc)
            vals[0] = resultado_mmc
            del vals[1]
        return resultado_mmc

def main ():
    print('Entre com os valores, separados por espaço:')
    valores = input().split(" ")
    valores_copia = valores.copy()

    if len(valores) < 2:
        print('Por favor, entre com pelo menos 2 numeros')
        main()
    else:
        resultado_mdc = euclides_mdc(valores)
        resultado_mmc = euclides_mmc(valores_copia)
        print('O MDC dos numeros {}'.format(resultado_mdc))
        print('O MMC dos numeros {}'.format(resultado_mmc))

if __name__ == '__main__':
	main()
