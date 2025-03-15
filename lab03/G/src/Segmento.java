/* Classe Segmento representa um segmento de reta entre dois pontos e verifica o angulo que forma
 *  com outro segmento.
 *  @author     Rodrigo Linhas a83933
 *  @version    28/02/2025
 *  @inv        Os pontos a e b devem ser distintos e pertencentes ao 1o quadrante.
 */
import java.lang.Math;

public class Segmento {
    private Ponto a;
    private Ponto b;

    /* Construtor da classe Segmento
     * @param   a Ponto inicial do segmento
     * @param   b Ponto final do segmento
     */
    public Segmento(Ponto a, Ponto b){
        check(a,b);
        this.a = a;
        this.b = b;
    }

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
