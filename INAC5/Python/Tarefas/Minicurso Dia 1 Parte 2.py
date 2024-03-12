# -*- coding: utf-8 -*-
"""Untitled0.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1QsmM-yZSrLg5uxy2Q0KrWOCSNcRtx9Na
"""

print("Hello, World!");

print("Hello, World!") # Meu primeiro código em Python

a = 5         #Integer
_b = 5.5      #Float
c1 = 'c'      #String
d = "String"  #String
e = False     #Boolean
print(a)
print(_b)
print(c1)
print(d)
print(type(a), type(_b), type(c1), type(d), type(e))

# Juntando Strings
a = "Isso é uma String"
b = "e isso é outra String"
c = a + " " + b
print(c)
print("O tamanho da String c é: " , len(c))
#Separando Strings
d = "Hello, World!"
print(d.split(","))

print("Múltiplos valores para múltiplas variáveis")
x, y, z = "Orange", "Banana", "Cherry"
print(x,y,z)

print("Um valor para múltiplas variáveis")
x = y = z = "Orange"
print(x,y,z)

print("Entrada de dados pelo teclado")
x = input("Digite uma string")
print(x)

y = int(input("Digite um numero inteiro")) #Casting
print(y)

import math;

a = int( input( "Digite o valor a: " ) );
b = int( input( "Digite o valor b: " ) );
c = int( input( "Digite o valor c: " ) );

delta = b**2 - 4*a*c;

if delta > 0:
  x1 = (-b + math.sqrt(delta))/(2*a);
  x2 = (-b - math.sqrt(delta))/(2*a);
  print("As ráizes são: ", x1, " e ", x2);
else:
  print("Delta negativo");

list = ["apple", "banana", "cherry", "orange", "kiwi", "melon", "mango"]
list[1] = "blackcurrant"

print("Lista completa",list)
print("Primeiro elemento",list[0])
print("Segundo elemento",list[1])
print("Terceiro elemento",list[2])
print("Último elemento (índice negativo)",list[-1])      # Índice Negativo
print("Range (intervalo) de 2 a 5 (não incluso)",list[2:5])
print("Range (intervalo) do início até 4 (não incluso)",list[:4])
print("Range (intervalo) de 2 até o final da lista",list[2:])
print("Range (intervalo) negativo de -4 até -1 (não incluso)",list[-4:-1])
print("Tamanho da lista",len(list))

list = []
list2 = ["apple", "banana", "cherry"]
list.extend(list2)
list.append("another fruit")
list.insert(1, "inserted fruit")
list.remove("banana")
list.pop(1)
print(list)

dictionary = {
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}
dictionary["color"] = "white"
print(dictionary)
print(dictionary['brand'])
print(dictionary.keys())
print(dictionary.values())
print(dictionary.items())
print(dictionary.pop("model"))
print(dictionary)

a = 33
b = 200
if b > a:
    print("-> b is greater than a")

if a > b: print("a is greater than b")  # Uma linha (1)
print("A") if a > b else print("B")     # Uma linha (2)

a = 33
b = 33
if b > a:
    print("b is greater than a")
elif a == b:
    print("a and b are equal")
else:
    print("a is greater than b")

a = 200
b = 33
c = 500
if a > b and c > a: #Two or more conditions
    print("Both conditions are True")

import math;

sexo = input(" Qual seu Sexo (M - Masculino) (F - Feminino): ");
altura = int( input( "Digite o sua altura em centimetros: " ) );

if sexo == "M":
  pesoIdeal = altura - 100 - (altura/100 * 10);
  print("Seu peso Ideal é : ", pesoIdeal);
elif sexo=="F":
  pesoIdeal = altura - 100 - (altura/100 * 15);
  print("Seu peso Ideal é : ", pesoIdeal);
else:
  print("Sexo incorreto!");

fruits = ["apple", "banana", "cherry"]
for x in fruits:
  print(x)

for x in range(10):    # range (init, end, step) ex: range(0,6,1) -> from 0 until 6 incremented by 1
   print(x)

adj = ["red", "big", "tasty"]
fruits = ["apple", "banana", "cherry"]

for x in adj:
  for y in fruits:
    print(x, y)

#https://www.w3schools.com/python/python_lists_comprehension.asp
fruits = ["apple", "banana", "cherry", "kiwi", "mango"]
newlist = [x for x in fruits if "a" in x]  #newlist = [expression for item in iterable if condition == True]
print(newlist)

i = 1
while i < 6:
  print(i)
  i += 1

def delta(a,b,c):
    return b**2 - 4*a*c
d = delta(-1,0,1)
print(d)

for i in range(0, 11): print (i);

for i in range(10, 0, -1): print(i);

number = 0;
count = 1;
while( number <= 100 ):
  print(number);
  number += count;
  count+=2;

number = 1;
while( number <= 50):
  print(number);
  if(number < 5):
    number+=1;
  elif(number>=5 and number<10):
    number+=5;
  else:
    number+=10;

import math;

numero = int( input( "Digite um número: " ) );

ePrimo = True;

for i in range(2, numero, 1):
  if( numero%i == 0 ) :
    ePrimo = False;
    break;

if ePrimo :
  print("O número ", numero, " é primo");
else:
  print("O número ", numero, " não é primo");

def fibonacci(index):

  if(index == 0):
    return 0;
  if(index == 1 or index == 2):
    return 1;
  else:
    return (fibonacci(index-1) + fibonacci(index-2));

numeroFin = int( input( "Digite um número: " ) );

print("Fibonacci de ", numeroFin, " é: ", fibonacci(numeroFin));