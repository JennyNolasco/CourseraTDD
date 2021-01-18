# Quebra de Strings com CamelCase

1- Criei a classe que irá conter todos os testes, nela criei um array de listas, para poder separar por cada entrada e testar as saídas; 

public class Teste {
	ArrayList<String> entrada1, entrada2, entrada3, entrada4, entrada5, entrada6, 		entradaInvalida1, entradaInvalida2;
}

2- Para tornar padrão e mais fácil de testar para cada Entrada criei um método que inicializa um arraylist e adicionei como teria que ser a saída e como isso tem que ser criado antes de qualquer teste utilizei o @Before;

3- Criei o 1 primeiro teste que tem como entrada ‘nome’;

4- Criei a classe CamelCase e o método que irá fazer a conversão. Como Estou trabalhando com lista na Entrada criei o retorno do método uma lista com o próprio argumento voltando;

5- Criei o segundo Teste também no método entradaSimples. Nesse teste a entrada será ‘Nome’. O teste não passou porque esperava saída lowercase;

6- Criei então um método que converta as palavras para lowerCase e com isso o teste passou;

7- Adicionei no Teste entradaSimples a entrada ‘CPF’ e o Teste não passou pois esperava ‘CPF’ e obteve ‘cpf’;

8- Alterei o método que transforme em lowerCase para não converter caso a próxima letra também seja maiúscula e com isso o teste passou;

9- Criei o método entradaComposta, para separar os que terão mais que 1 palavra. Neste teste inclui a primeira entrada nomeComposto e o teste não passou;

10- Alterei então a classe e criei um novo método para separar as palavras, pois ele retornava como estava e com isso vi que o método que criaria a lista seria então o que quebraria a palavras;

11 – Inclui no método de teste entradaComposta as outras entradas com várias palavras mas que não gerariam erro;

12- Crei o método de Teste que tem que dar erro, para testar o erro criei uma classe de Erro para caracter especial. Então com isso retornar o erro;

13- Alterei a classe para gerar o erro caso tenha caracter especial;

14- Criei o método de teste que irá testar iniciar com número e também criei a classe de erro;

15- Alterei a classe para verificar e retornar um erro caso iniciasse com número;

