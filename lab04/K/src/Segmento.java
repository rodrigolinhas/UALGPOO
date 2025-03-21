import static java.lang.Math.*;

/* Classe Segmento representa um segmento de reta entre dois pontos,
 * verifica a orientação formada por 3 pontos e se interseta com outro segmento
 *  @author     Rodrigo Linhas a83933
 *  @version    06/03/2025
 *  @inv        Os pontos a e b devem ser distintos e pertencentes ao 1o quadrante.
 */

public class Segmento {
    private Ponto a;
    private Ponto b;
    private static final double EPSILON = 1e-9;

    /* Construtor da classe Segmento
     * @param   a Ponto inicial do segmento
     * @param   b Ponto final do segmento
     */
    public Segmento(Ponto a, Ponto b) {
        check(a, b);
        this.a = a;
        this.b = b;
    }

    /*
     * Getter usado para uso do 1o ponto noutras classes.
     * @return 1o ponto do segmento de reta.
     */
    public Ponto getA() {return a;}

    /*
     * Getter usado para uso do 2o ponto noutras classes.
     * @return 2o ponto do segmento de reta.
     */
    public Ponto getB() {return b;}

    /*
     * Metodo complementar que verifica se os dois pontos dados não violam a @inv
     * @param ponto no primeiro quadrante.
     * @param outro ponto no primeiro quadrante.
     */
    private void check(Ponto a, Ponto b) {
        if (a.equals(b)){
            System.out.println("Segmento:vi");
            System.exit(0);
        }
    }

    /*
     * Verifica se existe alguma interseção entre o segmento de reta e um circúlo.
     * @param circulo a verificar se interseta ou não o segmento de reta.
     * @return caso exista retorna true,
     * @return caso contrario retorna false.
     */
    /*public boolean intersect_circle(Circulo c) {
        //conversão para coordenadas cartesianas
        double xa = this.a.getR() * cos(this.a.getAng());
        double ya = this.a.getR() * sin(this.a.getAng());
        double xb = this.b.getR() * cos(this.b.getAng());
        double yb = this.b.getR() * sin(this.b.getAng());
        double xc = c.getCentro().getR() * cos(c.getCentro().getAng());
        double yc = c.getCentro().getR() * sin(c.getCentro().getAng());

        double mReta = (yb - ya) / (xb - xa);
        double bReta = ya - (mReta * xa);

        double A = 1 + pow(mReta, 2);
        double B = (-2 * xc) + (2 * mReta * (bReta - yc));
        double C = pow(xc, 2) + pow((bReta - yc), 2) - pow(c.getRaio(), 2);

        double discriminant = pow(B, 2) - (4 * A * C);
        return discriminant >= 0; //se for >= retorna true, cc, retorna false
    }*/

    /*   Metodo que calcula a orientação de 3 pontos distintos
     *   @param 3 Pontos distintos
     *   @return 0 se forem coliniares
     *   @return 1 se vai no sentido horário
     *   @return -1 cc
     *   @see https://www.geeksforgeeks.org/check-if-two-given-line-segments-intersect/ (metodos usados)
     *   @see https://www.geeksforgeeks.org/orientation-3-ordered-points/               (mais detalhes da formula)
     */
    public int orient(Ponto p, Ponto q, Ponto r) {
        double orient = (q.getYDouble() - p.getYDouble()) *
                (r.getXDouble() - q.getXDouble()) - (q.getXDouble() - p.getXDouble())
                    * (r.getYDouble() - q.getYDouble());

        if (abs(orient) < EPSILON) return 0; //são colineares
        else if(orient > 0) return 1; //positivo
        else return -1; //negativo
    }

    /*
     * Método responsável por verificar se existe intersecção entre dois segmentos de reta,
     * @param Segmento
     * @return true se intersetam
     * @return false cc
     */
    public boolean intersect_segment(Segmento segmento) {
        Ponto A = this.a;
        Ponto B = this.b;
        Ponto C = segmento.getA();
        Ponto D = segmento.getB();

        int orient1 = orient(A, B, C);
        int orient2 = orient(A, B, D);
        int orient3 = orient(C, D, A);
        int orient4 = orient(C, D, B);

        if (orient1 * orient2 < 0 && orient3 * orient4 < 0) return true;

        //casos especiais: interseção em vértices (ignorar)
        return false;
    }
}