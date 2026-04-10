# pcv

- modelagem de cidades como pontos 2D;
- cálculo de distância euclidiana;
- construção incremental de um circuito (tour);
- comparação entre heurísticas de inserção;
- visualização do circuito (tour) gerado.

```Bash
javac Main.java Point.java Tour.java TSPVisualizer.java In.java StdIn.java StdOut.java StdDraw.java
java Main ../dados/usa13509.txt
java TSPVisualizer ../dados/tsp10.txt
```