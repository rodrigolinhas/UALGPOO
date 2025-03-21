import static java.lang.Math.*;
import java.util.List;

/*
 * Representa um retângulo em duas dimensões e verifica interseções com segmentos de reta.
 * @author Paulo Rodrigues, a83929.
 * @version 2025/03/5.
 * @inv Os 4 pontos formam vetores de segmentos de reta, os produtos escalares dos vetores tem que ser igual a 0 o que significa
 * que fazem sempre um ângulo reto, os lados opostos têm que ser iguais e as diagonais também.
 */
public class Rectangulo extends Poligono {
    private static final double EPSILON = 1e-9;

    /*
     * Construtor para o segmento de reta.
     * @param a -> Ponto no primeiro quadrante.
     * @param b -> Outro ponto no primeiro quadrante.
     * @param c -> Outro ponto no primeiro quadrante.
     * @param d -> Outro ponto no primeiro quadrante.
     */
    public Rectangulo(String pontosAsString) {
        super("4 " + pontosAsString);
        check(super.vertices, pontosAsString);
    }

    /*
     * Verifica se os quatro pontos dados não violam a @inv e então podem formar um retângulo ou não.
     * @param a -> Ponto no primeiro quadrante.
     * @param b -> Outro ponto no primeiro quadrante.
     * @param c -> Outro ponto no primeiro quadrante.
     * @param d -> Outro ponto no primeiro quadrante.
     */
    protected static void check(List<Ponto> vertices, String pontosAsString) {
        String[] parts = pontosAsString.split(" ");
        if (parts.length != 8) //vertices.size() != 4 -> com isto nao funciona
        {
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

        double escalarAB_BC = (vetorAB.getR() * vetorBC.getR()) + (vetorAB.getAng() * vetorBC.getAng());
        double escalarBC_CD = (vetorBC.getR() * vetorCD.getR()) + (vetorBC.getAng() * vetorCD.getAng());
        double escalarCD_DA = (vetorCD.getR() * vetorDA.getR()) + (vetorCD.getAng() * vetorDA.getAng());
        double escalarDA_AB = (vetorDA.getR() * vetorAB.getR()) + (vetorDA.getAng() * vetorAB.getAng());

        if (abs(escalarAB_BC) > EPSILON || abs(escalarBC_CD) > EPSILON
                || abs(escalarCD_DA) > EPSILON || abs(escalarDA_AB) > EPSILON){
            System.out.println("Retangulo:vi");
            System.exit(0);
        }

        double distAB = a.dist(b);
        double distBC = b.dist(c);
        double distCD = c.dist(d);
        double distDA = d.dist(a);

        if (abs(distAB - distCD) > EPSILON  || abs(distBC - distDA) > EPSILON){
            System.out.println("Retangulo:vi");
            System.exit(0);
        }

        double distAC = a.dist(c);
        double distBD = b.dist(d);

        if (abs(distAC - distBD) > EPSILON){
            System.out.println("Retangulo:vi");
            System.exit(0);
        }
    }

    /*
     * Dá a informação dos vertiçes do retângulo em coordenadas cartesianas inteiras no formato: [(x1,y1), (x2,y2), (x3,y3), (x4,y4)].
     * @return "[" + a + "," + b + "," + c + "," + d + "]" -> String que contem o ponto na forma descrita a cima.
     */
    //Retangulo: [(x1,y1), (x2,y2), (x3,y3), (x4,y4)]
    @Override
    public String toString() {
        return "Retangulo: [" + vertices.get(0) + ", " + vertices.get(1) + ", "
                + vertices.get(2) + ", " + vertices.get(3) + "]";
    }

    /*
     * Método que verifica efetivamente se um segmento de reta interseta um retângulo.
     * @param segmento -> segmento a ser verificado se interseta ou nao o retângulo.
     * @return um booleano, true caso haja interseção do segmento com o retângulo e false caso contrário.
     */
    public boolean segmento_intersect_retangulo(Segmento segmento)
    {

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
            if (segmento.intersect_segment(aresta)){
                boolean isVertexIntersection = false;
                for (Ponto vertice : pontos){
                    if (vertice.dist(segmento.getA()) < EPSILON || vertice.dist(segmento.getB()) < EPSILON){
                        isVertexIntersection = true;
                        break;
                    }
                }
                if (!isVertexIntersection) return true;
            }
        }
        return false;
    }
}