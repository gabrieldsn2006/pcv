/* *****************************************************************************
 * Name: Hasit Nanda
 * NetID:
 * Precept:
 *
 * Description: This class defines the tour data type by implementing a Circular
 * Linked List and defining methods to allow for the implementation of two
 * heuristics to find good solutions to the TSP.
 **************************************************************************** */

public class Tour {
    private class Node {
        private Point p; // point value of node
        private Node next; // pointer to next Node
    }

    private Node start; // first Node in Linked List

    // creates an empty tour
    public Tour() {
        start = new Node();
    }

    // creates the 4-point tour a->b->c->d->a (for debugging)
    public Tour(Point a, Point b, Point c, Point d) {
        start = new Node();
        Node b1 = new Node();
        Node c1 = new Node();
        Node d1 = new Node();
        start.p = a;
        b1.p = b;
        c1.p = c;
        d1.p = d;
        start.next = b1;
        b1.next = c1;
        c1.next = d1;
        d1.next = start;
    }

    // returns the number of points in this tour
    public int size() {
        if (start.p == null) {
            return 0;
        }
        else {
            int counter = 0;
            Node current = start;
            do {
                current = current.next;
                counter += 1;
            } while (!current.equals(start));
            return counter;
        }
    }

    // returns the length of this tour
    public double length() {
        if (start.p == null) {
            return 0.0;
        }
        else {
            double distance = 0.0;
            Node current = start;
            do {
                distance += current.p.distanceTo(current.next.p);
                current = current.next;
            } while (!current.equals(start));

            return distance;
        }

    }

    // returns a string representation of this tour
    public String toString() {
        if (start.p == null) {
            return "";
        }
        else {
            Node current = start;
            StringBuilder str = new StringBuilder();
            do {
                str.append(current.p.toString() + "\n");
                current = current.next;
            } while (!current.equals(start));
            return str.toString();
        }
    }

    // draws this tour to standard drawing
    public void draw() {
        if (start.p != null && start.next != null) {
            Node current = start;
            do {
                current.p.drawTo(current.next.p);
                current = current.next;
            } while (!current.equals(start));
        }
    }

    // inserts p using the nearest neighbor heuristic
    public void insertNearest(Point p) {
        Node newNode = new Node();
        newNode.p = p;

        // Tour vazio: p e o unico ponto, aponta para si mesmo
        if (start.p == null) {
            start = newNode;
            start.next = start;
            return;
        }

        // Tour com um unico ponto: liga os dois entre si
        if (start.next == null || start.next == start) {
            newNode.next = start;
            start.next = newNode;
            return;
        }

        // Percorre o tour e encontra o nó mais proximo de p
        Node nearest = start;
        double minDist = p.distanceTo(start.p);

        Node current = start.next;
        while (!current.equals(start)) {
            double dist = p.distanceTo(current.p);
            if (dist < minDist) {
                minDist = dist;
                nearest = current;
            }
            current = current.next;
        }

        // Insere newNode logo apos o no mais proximo
        newNode.next = nearest.next;
        nearest.next = newNode;
    }

    // inserts p using the smallest increase heuristic
    public void insertSmallest(Point p) {
        Node newNode = new Node();
        newNode.p = p;

        // Tour vazio: p e o unico ponto, aponta para si mesmo
        if (start.p == null) {
            start = newNode;
            start.next = start;
            return;
        }

        // Tour com um unico ponto: liga os dois entre si
        if (start.next == null || start.next == start) {
            newNode.next = start;
            start.next = newNode;
            return;
        }

        // Percorre cada aresta (current -> current.next) e calcula o aumento
        // de custo ao inserir p entre os dois nos:
        //   aumento = dist(current, p) + dist(p, current.next) - dist(current, current.next)
        Node bestNode = start;
        double bestIncrease = p.distanceTo(start.p)
                + p.distanceTo(start.next.p)
                - start.p.distanceTo(start.next.p);

        Node current = start.next;
        while (!current.equals(start)) {
            double increase = p.distanceTo(current.p)
                    + p.distanceTo(current.next.p)
                    - current.p.distanceTo(current.next.p);
            if (increase < bestIncrease) {
                bestIncrease = increase;
                bestNode = current;
            }
            current = current.next;
        }

        // Insere newNode logo apos o no que minimiza o aumento
        newNode.next = bestNode.next;
        bestNode.next = newNode;
    }

    // tests this class by calling all constructors and instance methods
    public static void main(String[] args) {
        // define 4 points, corners of a square
        Point a = new Point(1.0, 1.0);
        Point b = new Point(1.0, 4.0);
        Point c = new Point(4.0, 4.0);
        Point d = new Point(4.0, 1.0);

        // create the tour a -> b -> c -> d -> a
        Tour squareTour = new Tour(a, b, c, d);

        // print the size to standard output
        int size = squareTour.size();
        StdOut.println("# of points = " + size);

        // print the tour length to standard output
        double length = squareTour.length();
        StdOut.println("Tour length = " + length);

        // print the tour to standard output
        StdOut.println(squareTour);

        StdDraw.setXscale(0, 6);
        StdDraw.setYscale(0, 6);

        Point e = new Point(5.0, 6.0);
        squareTour.insertNearest(e);
        squareTour.insertSmallest(e);
        squareTour.draw();
    }
}