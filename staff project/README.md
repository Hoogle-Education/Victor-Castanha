# Explicando o código

## Parte 1

```java
    File directory = new File("");
  	String name = directory.getAbsolutePath() + "\\Staff.csv"; //*

		Scanner sc = new Scanner(new File(name));
		Scanner in = new Scanner(System.in);

		Staff[] staffs = new Staff[10000];
```

ideia principal: Buscar a pasta absoluta em cada computador através do comando `directory.getAbsolutePath()` e inserir o acesso ao arquivo no final.

## Diferença entre `i++` vs `++i`

`i++`: Primeiro retorna o valor de i, e ao final da operação, incrementa o valor.

``++i`: Primeiro incrementa o i, e depois retorna o valor atualizado.

## Insertion Sort]

ideia principal: selecionar um elemento e procurar o lugar certo para inserir ele, isto é, percorrer para trás, até que ele seja **maior que algum elemento anterior a ele**.

```java
//INSERTION SORT
static void insertionSort(Staff[] staffs, int size){
  
  for(int i=1; i < size; i++){
      Staff aux = staffs[i];
      int j = i-1;
      while(j >= 0 && staffs[j].compareTo(aux) > 0){
          staffs[j+1] = staffs[j]; // em j+1 vai receber o valor que esta em j
          j--;
        }
        staffs[j+1] = aux; // vetor [j+1] recebera o valor q esta no aux
  }

}
 ```

 ```
 Para cada elemento na sequencia:
    Seleciono o elemento (elementoSelecionado);
    Enquanto os anteriores e 
    paro Se(acabarem os elementos OU elementoSelecionado > elementoDaVez) :
      ...
    Ao final coloco o aux na posição adequada;
 ```

 ## Como medir o tempo no java

 O java tem o método nativo `System.currentMillis()`, este método retorna em milisegundos o tempo que levou para o programar rodar até o momento em que foi chamado.

 ## Busca binária

 A busca binária deve ser imaginada como se estivessemos buscando uma página em um livro. 

 ## Busca binária com repetição

Neste caso, procuro a primeira aparição de um determinado elemento. Logo em seguida, marco ele como primeira e última aparição (Suposição).

Agora, irei avançar para os anteriores e buscar a primeira aparição, e depois para os posteriores e buscar a última aparição.

**Observação:**  A busca binária com repetição de elementos tem um problema e passa a ter uma complexidade linear(n elementos) pois o pior caso é uma lista com n elementos repetidos, na qual para achar a primeira e a última aparição, será necessário percorrer todo o array.

## For each

```java
  for(Staff finded : search )
		System.out.println(finded);
```

> **For each** Staff finded **in** search

O `foreach` acessa cada elemento do array e coloca na variável finded, ao invés de acessar os elementos pelo indice.

## Adicionando dados em vetores

A princípio vetores são sequencias de tamanho imutável, porém podemos driblar isso, copiando seus dados para outro vetor.

Depois iremos recriar a staffs com um novo tamanho que será seu antigo tamanho e uma posição extra.

E agora podemos voltar com todos os dados que foram copiados, e colocar o dado adicional na posição adicional que estará ao final da sequência.