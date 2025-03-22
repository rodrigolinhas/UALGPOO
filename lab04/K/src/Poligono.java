import java.util.ArrayList;
import java.util.List;

/*
 * Classe responsável pela criação de um polígono de N vértices
 * e pela generalização do retângulo e do triângulo.
 * @author      Rodrigo Linhas a83929.
 * @version     21/03/2025.
 * @inv         Deve-se formar um polígono válido com pontos no 1º quadrante.
 */
public class Poligono extends FiguraGeometrica {
    protected List<Ponto> vertices;

    /*
     * Construtor do polígono.
     * @param pontosAsString String que contém as coordenadas dos pontos do polígono.
     */
    public Poligono(String pontosAsString) {
        String[] parts = pontosAsString.split(" ");
        int numVertices = Integer.parseInt(parts[0]);
        this.vertices = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            int x = Integer.parseInt(parts[i * 2 + 1]);
            int y = Integer.parseInt(parts[i * 2 + 2]);
            this.vertices.add(new Ponto(x, y));
        }

        check(vertices);
    }

    /*
     * Método complementar que verifica se o polígono não viola a @inv.
     * @param vertices Lista de pontos usados para as verificações.
     * @see https://tutoria.ualg.pt/2024/pluginfile.php/242347/mod_resource/content/5/POO24-25_Lab4-Figuras.pdf
     *      (refere as propriedades para um polígono válido).
     */
    private static void check(List<Ponto> vertices) {
        if (vertices.size() < 3) {
            System.out.println("Poligono:vi");
            System.exit(0);
        }
        for (int i = 0; i < vertices.size(); i++) {
            Ponto p = vertices.get(i);
            Ponto q = vertices.get((i + 1) % vertices.size());
            Ponto r = vertices.get((i + 2) % vertices.size());

            Segmento temp = new Segmento(p, q);
            int orient = temp.orient(p, q, r);

            if (orient == 0) {
                System.out.println("Poligono:vi");
                System.exit(0);
            }
        }
        for (int i = 0; i < vertices.size(); i++) {
            Segmento aresta1 = new Segmento(vertices.get(i), vertices.get((i + 1) % vertices.size()));
            for (int j = i + 2; j < vertices.size(); j++) {
                if (i == 0 && j == vertices.size() - 1) continue;
                Segmento aresta2 = new Segmento(vertices.get(j), vertices.get((j + 1) % vertices.size()));
                if (aresta1.intersect_segment(aresta2)) {
                    System.out.println("Poligono:vi");
                    System.exit(0);
                }
            }
        }
    }

    /*
     * Método toString usado para imprimir o polígono.
     * @return Polígono de N vértices: [(x1,y1),…(xN,yN)].
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Poligono de " + vertices.size() + " vertices: [");
        for (int i = 0; i < vertices.size(); i++) {
            sb.append(vertices.get(i));
            if (i < vertices.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /*
     * Método translação do polígono.
     * @param dx Translação no eixo x.
     * @param dy Translação no eixo y.
     * @return novo polígono com a translação aplicada.
     */
    @Override
    public FiguraGeometrica translacao(int dx, int dy) {
        StringBuilder sb = new StringBuilder();
        sb.append(vertices.size()).append(" ");
        for (Ponto p : vertices) {
            int novoX = p.getX() + dx;
            int novoY = p.getY() + dy;
            sb.append(novoX).append(" ").append(novoY).append(" ");
        }
        return new Poligono(sb.toString());
    }

    /*
     * Método complementar na translação do polígono e suas especializações (triângulo e retângulo).
     * @return String para o construtor das classes.
     */
    protected String verticesToString() {
        StringBuilder sb = new StringBuilder();
        for (Ponto p : vertices) {
            sb.append(p.getX()).append(" ").append(p.getY()).append(" ");
        }
        return sb.toString();
    }

    /*
     * Método para verificar colisão entre figuras geométricas.
     * @param outra Figura geométrica a ser verificada.
     * @return true se houver colisão
     *         false cc
     */
    @Override
    public boolean colideCom(FiguraGeometrica outra) {
        if (outra instanceof Circulo) {
            return outra.colideCom(this);
        } else if (outra instanceof Poligono) {
            Poligono p = (Poligono) outra;
            // Verifica interseção de arestas
            for (int i = 0; i < vertices.size(); i++) {
                Segmento aresta1 = new Segmento(vertices.get(i), vertices.get((i + 1) % vertices.size()));
                for (int j = 0; j < p.vertices.size(); j++) {
                    Segmento aresta2 = new Segmento(p.vertices.get(j), p.vertices.get((j + 1) % p.vertices.size()));
                    if (aresta1.intersect_segment(aresta2)) return true;
                }
            }
            // Verifica se um polígono está dentro do outro
            return this.contemPonto(p.vertices.get(0)) || p.contemPonto(this.vertices.get(0));
        }
        return false;
    }

    /*
     * Método para verificar se um ponto está dentro do polígono.
     * @param p Ponto a ser verificado.
     * @return true se o ponto estiver dentro do polígono, false caso contrário.
     */
    public boolean contemPonto(Ponto p) {
        int intersect = 0;
        for (int i = 0; i < vertices.size(); i++) {
            Ponto a = vertices.get(i);
            Ponto b = vertices.get((i + 1) % vertices.size());
            if ((a.getY() > p.getY()) != (b.getY() > p.getY())) {
                double xIntersect = (double) ((p.getY() - a.getY()) * (b.getX() - a.getX())) / (b.getY() - a.getY()) + a.getX();
                if (p.getX() <= xIntersect) intersect++;
            }
        }
        return (intersect % 2) == 1;
    }
}