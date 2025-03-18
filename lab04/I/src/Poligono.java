import java.util.ArrayList;

public class Poligono extends FiguraGeometrica {
    ArrayList<Ponto> vertices;

    public Poligono(ArrayList<Ponto> vertices) {
        check(vertices);
        this.vertices = vertices;
    }

    //REVIEW
    private void check(ArrayList<Ponto> vertices) {
        if (vertices.size() == 3) {Triangulo t = new Triangulo(vertices.get(0), vertices.get(1), vertices.get(2));
        } else if (vertices.size() == 4) {
            Rectangulo r = new Rectangulo(vertices.get(0), vertices.get(1), vertices.get(2), vertices.get(3));
        }else
            System.out.println("Poligono:vi");
    }

    //REVIEW
    @Override
    public String toString() {
        return "Poligono{}";
    }
}
