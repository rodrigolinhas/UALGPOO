import static java.lang.Math.*;

/*
 * Classe Segmento representa um segmento de reta entre dois pontos,
 * verifica a orientação formada por 3 pontos e se intersecta com outro segmento.
 * @author      Rodrigo Linhas a83933.
 * @version     06/03/2025.
 * @inv         Os pontos a e b devem ser distintos e pertencentes ao 1º quadrante.
 */
public class Segmento {
    private Ponto a;
    private Ponto b;
    private static final double EPSILON = 1e-9;

    /*
     * Construtor da classe Segmento.
     * @param a Ponto inicial do segmento.
     * @param b Ponto final do segmento.
     */
    public Segmento(Ponto a, Ponto b) {
        check(a, b);
        this.a = a;
        this.b = b;
    }

    /*
     * Getter usado para obter o primeiro ponto do segmento.
     * @return Primeiro ponto do segmento de reta.
     */
    public Ponto getA() {return a;}

    /*
     * Getter usado para obter o segundo ponto do segmento.
     * @return Segundo ponto do segmento de reta.
     */
    public Ponto getB() {return b;}

    /*
     * Método complementar que verifica se os dois pontos dados não violam a @inv.
     * @param a Ponto no primeiro quadrante.
     * @param b Outro ponto no primeiro quadrante.
     */
    private void check(Ponto a, Ponto b) {
        if (a.equals(b)) {
            System.out.println("Segmento:vi");
            System.exit(0);
        }
    }

    /*
     * Método que calcula a orientação de 3 pontos distintos.
     * @param p Primeiro ponto.
     * @param q Segundo ponto.
     * @param r Terceiro ponto.
     * @return 0 se forem colineares, 1 se no sentido horário, -1 caso contrário.
     * @see https://www.geeksforgeeks.org/orientation-3-ordered-points/ (formula usada)
     */
    public int orient(Ponto p, Ponto q, Ponto r) {
        double orient = (q.getYDouble() - p.getYDouble()) *
                (r.getXDouble() - q.getXDouble()) - (q.getXDouble() - p.getXDouble())
                * (r.getYDouble() - q.getYDouble());

        if (abs(orient) < EPSILON) return 0; // São colineares
        else if (orient > 0) return 1; // Sentido horário
        else return -1; // Sentido anti-horário
    }

    /*
     * Método responsável por verificar se existe interseção entre dois segmentos de reta.
     * @param segmento Segmento a ser verificado.
     * @return true se houver interseção, false caso contrário.
     * @see https://www.geeksforgeeks.org/check-if-two-given-line-segments-intersect/ (fomrula usada)
     */
    public boolean intersect_segment(Segmento segmento) {
        Ponto A = this.a;
        Ponto B = this.b;
        Ponto C = segmento.getA();
        Ponto D = segmento.getB();

        int o1 = orient(A, B, C);
        int o2 = orient(A, B, D);
        int o3 = orient(C, D, A);
        int o4 = orient(C, D, B);

        // Interseção geral
        if (o1 * o2 < 0 && o3 * o4 < 0) return true;

        // Verifica pontos extremos
        if (o1 == 0 && noSegmento(C, A, B)) return true;
        if (o2 == 0 && noSegmento(D, A, B)) return true;
        if (o3 == 0 && noSegmento(A, C, D)) return true;
        if (o4 == 0 && noSegmento(B, C, D)) return true;

        return false;
    }

    /*
     * Método complementar para verificar se um ponto está no segmento.
     * @param p Ponto a ser verificado.
     * @param a Ponto inicial do segmento.
     * @param b Ponto final do segmento.
     * @return true se o ponto estiver no segmento, false caso contrário.
     */
    private boolean noSegmento(Ponto p, Ponto a, Ponto b) {
        return (p.getXDouble() >= Math.min(a.getXDouble(), b.getXDouble()) - EPSILON &&
                p.getXDouble() <= Math.max(a.getXDouble(), b.getXDouble()) + EPSILON &&
                p.getYDouble() >= Math.min(a.getYDouble(), b.getYDouble()) - EPSILON &&
                p.getYDouble() <= Math.max(a.getYDouble(), b.getYDouble()) + EPSILON);
    }
}