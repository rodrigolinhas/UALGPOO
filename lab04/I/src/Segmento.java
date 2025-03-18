/* Classe Segmento representa um segmento de reta entre dois pontos, verifica o angulo que forma
 *  com outro segmento e se intersetam.
 *  @author     Rodrigo Linhas a83933
 *  @version    06/03/2025
 *  @inv        Os pontos a e b devem ser distintos e pertencentes ao 1o quadrante.
 */
import java.lang.Math;

public class Segmento {
    private Ponto a;
    private Ponto b;
    private static final double EPSILON = 1e-9;

    /* Construtor da classe Segmento
     * @param   a Ponto inicial do segmento
     * @param   b Ponto final do segmento
     */
    public Segmento(Ponto a, Ponto b){
        check(a,b);
        this.a = a;
        this.b = b;
    }

    /*
     * Getter usado para uso do ponto A (1º ponto) noutras classes.
     * @return a -> Ponto A de um segmento de reta.
     */
    public Ponto getA() {return a;}

    /*
     * Getter usado para uso do ponto B (2º ponto) noutras classes.
     * @return b -> Ponto B de um segmento de reta.
     */
    public Ponto getB() {return b;}

    /* Verifica o angulo formado entre 2 segmnetos de reta.
     * @param   s que é outro Segmento para calcular o angulo
     * @return  o angulo formado em graus
     * @see     https://mundoeducacao.uol.com.br/matematica/angulo-formado-entre-duas-retas.htm
     */
    public double anginterseta(Segmento s) {
        double xa = this.a.getr() * Math.cos(Math.toRadians(this.a.getteta()));
        double ya = this.a.getr() * Math.sin(Math.toRadians(this.a.getteta()));
        double xb = this.b.getr() * Math.cos(Math.toRadians(this.b.getteta()));
        double yb = this.b.getr() * Math.sin(Math.toRadians(this.b.getteta()));
        double xa2 = s.a.getr() * Math.cos(Math.toRadians(s.a.getteta()));
        double ya2 = s.a.getr() * Math.sin(Math.toRadians(s.a.getteta()));
        double xb2 = s.b.getr() * Math.cos(Math.toRadians(s.b.getteta()));
        double yb2 = s.b.getr() * Math.sin(Math.toRadians(s.b.getteta()));
        // Coeficientes da equação da reta y=m*x
        double mRet1 = (yb - ya) / (xb - xa);
        double mRet2 = (yb2 - ya2) / (xb2 - xa2);
        //Angulo -> arctan |ms-mr/1+ms*mr|
        //toDegrees por causa que os angulos calculados são em rad

        return Math.toDegrees(Math.atan(Math.abs((mRet1 - mRet2) / (1 + mRet1 * mRet2))));
    }

    //https://www.geeksforgeeks.org/check-if-two-given-line-segments-intersect/
    // Given three collinear points p, q, r, the function checks if
    // point q lies on line segment 'pr'
    /*public boolean onSegment(Ponto p, Ponto q, Ponto r) {
        if (orientation(p, q, r) != 0)  return false;
        //Verifica se q está estritamente entre p e r (excluindo extremos)
        boolean xBetween = (q.getX() < Math.max(p.getX(), r.getX())) &&
                (q.getX() > Math.min(p.getX(), r.getX()));
        boolean yBetween = (q.getY() < Math.max(p.getY(), r.getY())) &&
                (q.getY() > Math.min(p.getY(), r.getY()));
        return xBetween && yBetween;
    }*/

    /*   Metodo que verifica se 2 segmentos de reta intersetam
     *   @param Segemento
     *   @return true se intersetam false cc
     *   @see https://www.geeksforgeeks.org/check-if-two-given-line-segments-intersect/ (metodo referido)
     */
    public boolean doIntersect(Segmento that) {
        Ponto p1 = this.a;
        Ponto q1 = this.b;
        Ponto p2 = that.getA();
        Ponto q2 = that.getB();

        Ponto[] vertices = {p1,q1,p2,q2};
        boolean control = false;

        for (Ponto vertice: vertices){
            if(vertice.dist(p1) < EPSILON ||  vertice.dist(p2) < EPSILON){
                control = true;
                break;
            }
        }

        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);

        // General case
        if (o1 * o2 < 0 && o3 * o4 < 0)   return true;

        // Special Cases
        if (o1 == 0  && !control) return true;
        if (o2 == 0  && !control) return true;
        if (o3 == 0  && !control) return true;
        if (o4 == 0  && !control) return true;

        return false;
    }

    /*   Metodo complementar ao doInterset
     *   @param 3 Pontos distintos
     *   @return 0 se forem coliniares
     *   @return 1 se vai no sentido horário
     *   @return -1 cc
     *   @see https://www.geeksforgeeks.org/check-if-two-given-line-segments-intersect/ (metodos usados)
     *   @see https://www.geeksforgeeks.org/orientation-3-ordered-points/               (mais detalhes da formula)
     */
    private int orientation(Ponto p, Ponto q, Ponto r)
    {
        // See https://www.geeksforgeeks.org/orientation-3-ordered-points/
        // for details of below formula.
        double val = ((q.getY() - p.getY()) * (r.getX() - q.getX()) -
                (q.getX() - p.getX()) * (r.getY() - q.getY()));

        if (Math.abs(val) < EPSILON) return 0; // collinear
        else if (val > 0) return 1;
        else return -1;
    }

    /* Verifica se os pontos são distintos.
     * @param   a Ponto inicial
     * @param   b Ponto final
     * @see     https://tutoria.ualg.pt/2024/mod/resource/view.php?id=107599 (refer o check)
     */
    private void check(Ponto a, Ponto b){
        if (a.equals(b)) {
        System.out.println("Segmento:vi");
        System.exit(0);
        }
    }
}