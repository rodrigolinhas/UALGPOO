import static java.lang.Math.*;
import java.util.List;

/*
 * Classe Retangulo representa um retângulo com o uso de 4 pontos.
 * @author      Rodrigo Linhas a83933.
 * @version     21/03/2025.
 * @inv         Os 4 pontos devem ser distintos, pertencentes ao 1º quadrante
 *              e válidos para a criação de um retângulo.
 */
public class Retangulo extends Poligono {
    private static final double EPSILON = 1e-9;

    /*
     * Construtor para o retangulo.
     * @param pontosAsString String com 4 pontos.
     */
    public Retangulo(String pontosAsString) {
        super("4 " + pontosAsString);
        check(super.vertices, pontosAsString);
    }

    /*
     * Método complementar do construtor que verifica se o retângulo criado é válido.
     * @param vertices Lista de pontos que representam os vértices.
     * @param pontosAsString String com os pontos.
     */
    private static void check(List<Ponto> vertices, String pontosAsString) {
        String[] parts = pontosAsString.split(" ");
        if (parts.length != 8) {
            System.out.println("Retangulo:vi");
            System.exit(0);
        }

        Ponto a = vertices.get(0);
        Ponto b = vertices.get(1);
        Ponto c = vertices.get(2);
        Ponto d = vertices.get(3);

        Ponto vetorAB = new Ponto(a, b);
        Ponto vetorBC = new Ponto(b, c);
        Ponto vetorCD = new Ponto(c, d);
        Ponto vetorDA = new Ponto(d, a);

        double escalarAB_BC = (vetorAB.getX() * vetorBC.getX()) + (vetorAB.getY() * vetorBC.getY());
        double escalarBC_CD = (vetorBC.getX() * vetorCD.getX()) + (vetorBC.getY() * vetorCD.getY());
        double escalarCD_DA = (vetorCD.getX() * vetorDA.getX()) + (vetorCD.getY() * vetorDA.getY());
        double escalarDA_AB = (vetorDA.getX() * vetorAB.getX()) + (vetorDA.getY() * vetorAB.getY());

        if (abs(escalarAB_BC) > EPSILON || abs(escalarBC_CD) > EPSILON
                || abs(escalarCD_DA) > EPSILON || abs(escalarDA_AB) > EPSILON) {
            System.out.println("Retangulo:vi");
            System.exit(0);
        }

        double distAB = a.dist(b);
        double distBC = b.dist(c);
        double distCD = c.dist(d);
        double distDA = d.dist(a);

        if (abs(distAB - distCD) > EPSILON || abs(distBC - distDA) > EPSILON) {
            System.out.println("Retangulo:vi");
            System.exit(0);
        }

        double distAC = a.dist(c);
        double distBD = b.dist(d);

        if (abs(distAC - distBD) > EPSILON) {
            System.out.println("Retangulo:vi");
            System.exit(0);
        }
    }

    /*
     * Método que imprime o retângulo no terminal.
     * @return Retangulo: [(x1,y1), (x2,y2), (x3,y3), (x4,y4)].
     */
    @Override
    public String toString() {
        return "Retangulo: [" + vertices.get(0) + ", " + vertices.get(1) + ", "
                + vertices.get(2) + ", " + vertices.get(3) + "]";
    }

    /*
     * Método translação do retângulo.
     * @param dx Translação no eixo x.
     * @param dy Translação no eixo y.
     * @return Novo retângulo com a translação aplicada.
     */
    @Override
    public FiguraGeometrica translacao(int dx, int dy) {
        Poligono pTransladado = (Poligono) super.translacao(dx, dy);
        return new Retangulo(pTransladado.verticesToString());
    }

    /*
     * Método responsável por verificar se o retângulo e o segmento dado de fato se intersectam.
     * @param segmento Segmento a ser verificado.
     * @return true se houver interseção, false caso contrário.
     */
    /*public boolean segmento_intersect_retangulo(Segmento segmento) {
        Ponto a = vertices.get(0);
        Ponto b = vertices.get(1);
        Ponto c = vertices.get(2);
        Ponto d = vertices.get(3);

        Segmento[] arestas = {
                new Segmento(a, b),
                new Segmento(b, c),
                new Segmento(c, d),
                new Segmento(d, a),
        };

        Ponto[] pontos = {a, b, c, d};

        for (Segmento aresta : arestas) {
            if (segmento.intersect_segment(aresta)) {
                boolean isVertexIntersection = false;
                for (Ponto vertice : pontos) {
                    if (vertice.dist(segmento.getA()) < EPSILON || vertice.dist(segmento.getB()) < EPSILON) {
                        isVertexIntersection = true;
                        break;
                    }
                }
                if (!isVertexIntersection) return true;
            }
        }
        return false;
    }*/
}