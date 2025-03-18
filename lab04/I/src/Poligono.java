import java.util.ArrayList;

public class Poligono extends FiguraGeometrica {
    ArrayList<Ponto> vertices;

    public Poligono(ArrayList<Ponto> vertices) {
        check(vertices);
        this.vertices = vertices;
    }

    private void check(ArrayList<Ponto> vertices) {
        if (vertices.size() < 3) {
            System.out.println("Poligono:vi");
            System.exit(0);
        }
    }

    @Override
    public String toString() {
        return "Poligono{}";
    }
}
