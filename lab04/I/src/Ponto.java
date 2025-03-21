import java.util.Objects;

import static java.lang.Math.*;

/*
 * Representa um ponto em duas dimensões.
 * @author Paulo Rodrigues, a83929.
 * @version 2025/02/25.
 * @inv Os pontos pertencem ao primeiro quadrante, ou seja, em linguagem matemática será: x >= 0 && y >= 0 (para coordenadas cartesianas)
 * e 0 <ang< 90 && 0 <=r<= 10 (para coordenadas polares).
 */
public class Ponto {
    private double r;
    private double ang;
    private static final double EPSILON = 1e-9; // Tolerância para erros de precisão

    /*
     * Construtor para coordenadas polares.
     * @param r -> Distância da origem até ao ponto.
     * @param ang -> Ângulo feito entre o eixo X e o ponto.
     */
    public Ponto(double r, double ang)
    {
        check(r, ang);
        this.r = r; //se tiver que usar isto provalvemente vou ter que fazer um toRadians
        this.ang = ang;
    }

    /*
     * Construtor para um vetor visto que um vetor é um ponto.
     * @param a -> Ponto a do vetor.
     * @param b -> Ponto b do vetor.
     */
    public Ponto(Ponto a, Ponto b)
    {
        this.r = sqrt((pow(b.getXDouble() - a.getXDouble(), 2) + pow(b.getYDouble() - a.getYDouble(), 2)));
        this.ang = toDegrees(atan2(b.getYDouble() - a.getYDouble(), b.getXDouble() - a.getXDouble()));
    }

    /*
     * Construtor para coordenadas cartesianas que faz a conversão para polares.
     * @param x -> Coordenada X do ponto.
     * @param y -> Coordenada Y do ponto.
     */
    public Ponto(int x, int y)
    {
        check(x, y);
        this.r = sqrt((pow(x, 2) + pow(y, 2)));
        this.ang = toDegrees(atan2(y, x));
    }

    /*
     * Verifica se o ponto dado em coordenadas polares nao viola a @inv
     * @param r -> Distância da origem até ao ponto.
     * @param ang -> Ângulo feito entre o eixo X e o ponto.
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
     * Verifica se o ponto dado em coordenadas cartesianas nao viola a @inv
     * @param x -> Coordenada X do ponto.
     * @param y -> Coordenada Y do ponto.
     */
    private void check(int x, int y)
    {
        if (x < 0 || y < 0)
        {
            System.out.println("Ponto:vi");
            System.exit(0);
        }
    }

    /*
     * Getter usado para uso do r noutras classes.
     * @return r -> Distância da origem até ao ponto.
     */
    public double getR(){ return this.r; }

    /*
     * Getter usado para uso do ang noutras classes.
     * @return ang -> Ângulo feito entre o eixo X e o ponto.
     */
    public double getAng(){ return this.ang; }

    /*
     * Getter usado para uso do X das coordenadas cartesianas inteiras noutras classes ou mesmo nesta na parte do toString.
     * @return X -> Coordenada inteira X do ponto.
     */
    public int getX(){ return (int) round(this.r * cos(toRadians(this.ang))); }

    /*
     * Getter usado para uso do Y das coordenadas cartesianas inteiras noutras classes ou mesmo nesta na parte do toString.
     * @return Y -> Coordenada inteira Y do ponto.
     */
    public int getY() { return (int) round(this.r * sin(toRadians(this.ang))); }

    /*
     * Getter usado para uso do X das coordenadas cartesianas, mas neste caso em double para fazer cálculos intermédios.
     * Evita fazer este calculo sempre pois sempre que necessário basta chamar este método.
     * @return X -> Coordenada decimal Y do ponto.
     */
    public double getXDouble() {return r * cos(toRadians(ang));}

    /*
     * Getter usado para uso do Y das coordenadas cartesianas, mas neste caso em double para fazer cálculos intermédios.
     * Evita fazer este calculo sempre pois sempre que necessário basta chamar este método.
     * @return Y -> Coordenada decimal Y do ponto.
     */
    public double getYDouble() {return r * sin(toRadians(ang));}

    /*
     * Calcula a distância entre dois pontos.
     * @param Ponto b -> Ponto para o qual se vai calcular a distância entre o ponto da classe e o recebido.
     * @return distancia -> distância entre os dois pontos.
     */
    public double dist(Ponto b)
    {
        double res = 0;
        res = sqrt(pow(this.r, 2) + pow(b.r, 2) - (2 * this.r * b.r * cos(toRadians((b.ang) - (this.ang)))));
        return res;
    }

    /*
     * Dá o ponto no formato (x,y).
     * @return "(" + getX() + "," + getY() + ")" -> String que contem o ponto na forma (x,y).
     */
    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + ")";
    }

    /*
     * Método que verifica se dois pontos são iguais, verifica se são ambos da class Ponto e caso sejam, verifica se os pontos são coincidentes.
     * @param o -> objeto a ser comparado com o Ponto da class.
     * @return um booleano, true caso sejam iguais, falso caso contrário.
     */
    @Override
    public boolean equals(Object o)
    {
        if (o == null || getClass() != o.getClass()) return false;
        Ponto ponto = (Ponto) o;
        return abs(this.r - ponto.getR()) < EPSILON && abs(this.ang - ponto.getAng()) < EPSILON;
    }

    /*
     * Método criado ao gerar o equals e nao csg passar no mooshak se não deixar aqui, perguntar ao prof pq
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(getR(), getAng());
    }
}