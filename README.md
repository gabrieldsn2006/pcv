
---

# Problema do Caixeiro Viajante (PCV) com Heurísticas de Inserção

Este projeto refere-se ao Trabalho Prático 4 da disciplina de Resolução de Problemas com Grafos da **Universidade de Fortaleza (UNIFOR)**. O objetivo é implementar e comparar heurísticas de construção para o *Traveling Salesman Problem* (TSP).

## Descrição das Heurísticas

Conforme exigido pelo trabalho, foram implementadas as seguintes heurísticas de inserção:

* **Nearest Insertion**:
    1.  Identifica a cidade (ponto) fora do circuito que está mais próxima de qualquer cidade já presente no circuito atual.
    2.  Insere essa nova cidade na posição que resulte no menor aumento possível no comprimento total do percurso.
    * *Foco*: Proximidade da próxima cidade em relação ao conjunto já visitado.

* **Smallest Insertion**:
    1.  Analisa todos os pontos ainda não visitados em relação a todas as arestas possíveis do circuito atual.
    2.  Identifica qual inserção (entre quais duas cidades consecutivas) produz o menor aumento absoluto no comprimento total.
    * *Foco*: Impacto direto no custo total do percurso a cada passo.

## Estrutura do Projeto

* **`dados/`**: Contém instâncias de teste (`tsp10.txt`) e a instância oficial de execução (`usa13509.txt`).
* **`src/`**: Códigos-fonte em Java.
    * `Tour.java`: Onde a lógica das heurísticas foi implementada.
    * `Point.java`: Representação de cidades como pontos 2D e cálculos de distância.
    * `Main.java`: Ponto de entrada que carrega os dados e executa as comparações.
    * `TSPVisualizer.java`: Ferramenta para visualização gráfica dos circuitos gerados.

## Instruções de Compilação e Execução

Para compilar o projeto a partir do diretório `src/`:

```bash
javac Main.java Point.java Tour.java TSPVisualizer.java In.java StdIn.java StdOut.java StdDraw.java
```

### Execução com Instância Oficial
Para processar as 13.509 cidades dos EUA e visualizar os resultados:

```bash
java Main ../dados/usa13509.txt
```

### Depuração (Instância Menor)
Para testar a lógica com o conjunto de 10 cidades:

```bash
java Main ../dados/tsp10.txt
```

## Vídeo Explicativo

O vídeo apresentando o problema, a implementação em `Tour.java` e a demonstração da execução pode ser assistido no link abaixo:

* **Link do Vídeo**: [https://youtu.be/iz9UY3sexds]

## Ferramentas e Bibliotecas

O projeto utiliza as bibliotecas base `algs4-kw` (Java) e classes utilitárias para entrada/saída e desenho gráfico (`StdDraw`, `StdIn`, `StdOut`, `In`). A classe `Point.java` é usada para modelagem de pontos 2D e cálculos de distância euclidiana.

--- 