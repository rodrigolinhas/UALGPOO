import java.util.Objects;
import static java.lang.Math.*;

/*
 * Classe responsável pela  criaçao de um Ponto
 * em coordenadas polares ou cartesianas
 * @author      Rodrigo Linhas a83929
 * @version     21/03/2025.
 * @inv         O ponto deve pertencer ao 1o quadrante
 *              (cartesianas) x>=0 e y>=0 || (polares) r>=0 e teta>=0
 */
public class Ponto {
    private double r;
    private double teta;
    private static final double EPSILON = 1e-9;

    /*
     * Construtor para coordenadas polares.
     * @param r Distância da origem até ao ponto
     * @param teta angulo feito entre o eixo X e o ponto r
     */
    public Ponto(double r, double teta) {
        check(r, teta);
        this.r = r; //se tiver que usar isto provalvemente vou ter que fazer um toRadians
        this.teta = teta;
    }

    /*
     * Construtor para um vetor (é mesmo que um ponto)
     * @param Ponto a do vetor.
     * @param Ponto b do vetor.
     * @see https://www.superprof.es/apuntes/escolar/matematicas/analitica/vectores/formulas-de-vectores.html
     *          (formula)
     */
    public Ponto(Ponto a, Ponto b){
        this.r = sqrt((pow(b.getXDouble() - a.getXDouble(), 2) + pow(b.getYDouble() - a.getYDouble(), 2)));
        this.teta = toDegrees(atan2(b.getYDouble() - a.getYDouble(), b.getXDouble() - a.getXDouble()));
    }

    /*
     * Construtor para coordenadas cartesianas e converte para polares.
     * @param coordenada X do ponto.
     * @param coordenada Y do ponto.
     */
    public Ponto(int x, int y) {
        check(x, y);
        this.r = sqrt((pow(x, 2) + pow(y, 2)));
        this.teta = toDegrees(atan2(y, x));
    }


    /*
     * Metodo complementar que verifica se as coordenadas polares não violam a @inv
     * @param coordenada r
     * @param coordenada teta
     */
    private void check(double r, double ang)
    {
        if (r > 10 || r < 0 || ang < 0 || ang > 90)
        {
            System.out.print("iv");
            System.exit(0);
        }
    }

    /*
     * Metodo complementar que verifica se as coordenadas cartesianas não violam a @inv
     * @param coordenada x
     * @param coordenada y
     */
    private void check(int x, int y){
        if (x < 0 || y < 0){
            System.out.println("Ponto:vi");
            System.exit(0);
        }
    }

    /*
     * Getter usado para uso do r noutras classes
     * @return r (distância da origem até ao ponto)
     */
    public double getR()    { return this.r; }

    /*
     * Getter usado para uso do teta noutras classes
     * @return teta (angulo feito entre o eixo X e o ponto)
     */
    public double getTeta() { return this.teta; }

    /*
     * Getter usado para uso do X das coordenadas cartesianas
     * usado noutras classes
     * @return coordenada do x
     */
    public int getX()   { return (int) round(this.r * cos(toRadians(this.teta))); }

    /*
     * Getter usado para uso do Y das coordenadas cartesianas
     * usado noutras classes
     * @return coordenada do y
     */
    public int getY()   { return (int) round(this.r * sin(toRadians(this.teta))); }

    /*
     * Getter do X das coordenadas cartesianas em double
     * para cálculos intermédios.
     * @return coordenada x em decimal
     * @see https://wwwp.fc.unesp.br/~mauri/Down/Polares.pdf (formula)
     */
    public double getXDouble() {return r * cos(toRadians(teta));}

    /*
     * Getter do Y das coordenadas cartesianas em double
     * para cálculos intermédios.
     * @return coordenada y em decimal
     * @see https://wwwp.fc.unesp.br/~mauri/Down/Polares.pdf (formula)
     */
    public double getYDouble() {return r * sin(toRadians(teta));}

    /*
     * Calcula distância de dois pontos.
     * @param Outro ponto
     * @return Distância entre os pontos
     * @return https://mundoeducacao.uol.com.br/matematica/distancia-entre-dois-pontos.htm (formula)
     */
    public double dist(Ponto b){
        double res = 0;
        res = sqrt(pow(this.r, 2) + pow(b.r, 2) - (2 * this.r * b.r * cos(toRadians((b.teta) - (this.teta)))));
        return res;
    }

    /*
     * Metodo toString
     * @return a string no seuinte formato: (x,y)
     */
    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + ")";
    }

    /*
     * Método que verifica se dois pontos são iguais,
     * e caso sejam, verifica se os pontos são coincidentes.
     * @param Objeto o a ser comparado com o Ponto.
     * @return true caso sejam iguais, falso caso contrário.
     */
    @Override
    public boolean equals(Object o){
        if (o == null || getClass() != o.getClass()) return false;
        Ponto ponto = (Ponto) o;
        return abs(this.r - ponto.getR()) < EPSILON && abs(this.teta - ponto.getTeta()) < EPSILON;
    }

    /* Método complementar ao equals, necessario para
     * evitar as colisões entre objetos (AED).
     * @return o codigo hash para o r e o teta
     */
    @Override
    public int hashCode(){
        return Objects.hash(getR(), getTeta());
    }
}