import java.util.Objects;
import static java.lang.Math.*;

/*
 * Classe responsável pela criação de um Ponto em coordenadas polares ou cartesianas.
 * @author      Rodrigo Linhas a83929.
 * @version     21/03/2025.
 * @inv         O ponto deve pertencer ao 1º quadrante.
 *              (cartesianas) x >= 0 e y >= 0 || (polares) r >= 0 e teta >= 0.
 */
public class Ponto {
    private double r;
    private double teta;
    private static final double EPSILON = 1e-9;

    /*
     * Construtor para coordenadas polares.
     * @param r Distância da origem até ao ponto.
     * @param teta Ângulo feito entre o eixo X e o ponto r.
     */
    public Ponto(double r, double teta) {
        check(r, teta);
        this.r = r;
        this.teta = teta;
    }

    /*
     * Construtor para um vetor (é mesmo que um ponto).
     * @param a Ponto inicial do vetor.
     * @param b Ponto final do vetor.
     * @see https://www.superprof.es/apuntes/escolar/matematicas/analitica/vectores/formulas-de-vectores.html
     *  (formula usada)
     */
    public Ponto(Ponto a, Ponto b) {
        this.r = sqrt((pow(b.getXDouble() - a.getXDouble(), 2) + pow(b.getYDouble() - a.getYDouble(), 2)));
        this.teta = toDegrees(atan2(b.getYDouble() - a.getYDouble(), b.getXDouble() - a.getXDouble()));
    }

    /*
     * Construtor para coordenadas cartesianas e converte para polares.
     * @param x Coordenada X do ponto.
     * @param y Coordenada Y do ponto.
     */
    public Ponto(int x, int y) {
        check(x, y);
        this.r = sqrt((pow(x, 2) + pow(y, 2)));
        this.teta = toDegrees(atan2(y, x));
    }

    /*
     * Método complementar que verifica se as coordenadas polares não violam a @inv.
     * @param r Distância da origem.
     * @param ang Ângulo em graus.
     */
    private void check(double r, double ang) {
        if (r > 10 || r < 0 || ang < 0 || ang > 90) {
            System.out.print("iv");
            System.exit(0);
        }
    }

    /*
     * Método complementar que verifica se as coordenadas cartesianas não violam a @inv.
     * @param x Coordenada X.
     * @param y Coordenada Y.
     */
    private void check(int x, int y) {
        if (x < 0 || y < 0) {
            System.out.println("Ponto:vi");
            System.exit(0);
        }
    }

    /*
     * Getter usado para obter a distância da origem até ao ponto.
     * @return Distância da origem até ao ponto.
     */
    public double getR()    {return this.r;}

    /*
     * Getter usado para obter o ângulo entre o eixo X e o ponto.
     * @return Ângulo entre o eixo X e o ponto.
     */
    public double getTeta() {return this.teta;}

    /*
     * Getter usado para obter a coordenada X do ponto.
     * @return Coordenada X do ponto.
     */
    public int getX()   {return (int) round(this.r * cos(toRadians(this.teta)));}

    /*
     * Getter usado para obter a coordenada Y do ponto.
     * @return Coordenada Y do ponto.
     */
    public int getY()   {return (int) round(this.r * sin(toRadians(this.teta)));}

    /*
     * Getter usado para obter a coordenada X do ponto em double.
     * @return Coordenada X do ponto em double.
     */
    public double getXDouble()  {return r * cos(toRadians(teta));}

    /*
     * Getter usado para obter a coordenada Y do ponto em double.
     * @return Coordenada Y do ponto em double.
     */
    public double getYDouble()  {return r * sin(toRadians(teta));}

    /*
     * Método para calcular a distância entre dois pontos.
     * @param b Outro ponto.
     * @return Distância entre os pontos.
     */
    public double dist(Ponto b) {
        double res = 0;
        res = sqrt(pow(this.r, 2) + pow(b.r, 2) - (2 * this.r * b.r * cos(toRadians((b.teta) - (this.teta)))));
        return res;
    }

    /*
     * Método toString.
     * @return String no formato: (x,y).
     */
    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + ")";
    }

    /*
     * Método que verifica se dois pontos são iguais.
     * @param o Objeto a ser comparado com o Ponto.
     * @return true se forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ponto ponto = (Ponto) o;
        return abs(this.r - ponto.getR()) < EPSILON && abs(this.teta - ponto.getTeta()) < EPSILON;
    }

    /*
     * Método complementar ao equals, necessário para evitar colisões entre objetos
     * dependo do seu codigo de hash (AED).
     * @return Código hash para o r e o teta.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getR(), getTeta());
    }
}