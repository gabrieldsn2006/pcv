
---

# Problema do Caixeiro Viajante (PCV) com Heurísticas de Inserção

Este projeto consiste no desenvolvimento do Trabalho Prático 4 sobre o **Traveling Salesman Problem** (TSP), realizado na Universidade de Fortaleza (UNIFOR). O objetivo central é a implementação de heurísticas de inserção para encontrar soluções eficientes para o problema do ciclo de menor distância que visita todos os pontos de um conjunto.

## Objetivo do Trabalho

O foco do projeto é a implementação de dois métodos específicos na classe `Tour.java`:

* **`insertNearest(Point p)`**: Insere um ponto no circuito utilizando a heurística do vizinho mais próximo.
* **`insertSmallest(Point p)`**: Insere um ponto no circuito utilizando a heurística de menor aumento de distância total.

## Estrutura do Projeto

A organização dos arquivos no diretório `t4-tsp/` é a seguinte:

* **`dados/`**: Contém instâncias de teste como `tsp10.txt` e a instância oficial `usa13509.txt`, além de gabaritos para conferência (`-nearest.txt`, `-smallest.txt`, `-optimal.txt`).
* **`src/`**: Contém o código-fonte em Java, incluindo as classes de suporte (`Point.java`, `In.java`, `StdDraw.java`, etc.) e as classes principais de execução (`Main.java`, `TSPVisualizer.java`).

## Instruções de Compilação e Execução

Para compilar o projeto, acesse o diretório `src/` e utilize o comando:

```bash
javac Main.java Point.java Tour.java TSPVisualizer.java In.java StdIn.java StdOut.java StdDraw.java
```

### Execução Principal
Para rodar a execução oficial com a instância dos EUA, utilize:

```bash
java Main ../dados/usa13509.txt
```

### Visualização de Depuração
Para abrir o visualizador interativo e testar as heurísticas com um conjunto menor de pontos (10 cidades), utilize:

```bash
java TSPVisualizer ../dados/tsp10.txt
```

## Formato de Entrada

Os arquivos de dados seguem o padrão abaixo:
1.  A primeira linha contém a **largura** e a **altura** do plano.
2.  As linhas subsequentes contêm as coordenadas **x** e **y** de cada cidade.

## Vídeo Explicativo
O vídeo com a explicação técnica e demonstração da execução pode ser acessado no link abaixo:
* [https://www.youtube.com/]

--- 

## Ferramentas e Bibliotecas

O projeto utiliza as bibliotecas base `algs4-kw` (Java) e classes utilitárias para entrada/saída e desenho gráfico (`StdDraw`, `StdIn`, `StdOut`, `In`). A classe `Point.java` é usada para modelagem de pontos 2D e cálculos de distância euclidiana.