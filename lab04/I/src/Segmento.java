import static java.lang.Math.*;
/*
 * Representa um segmento de reta em duas dimensões.
 * @author Paulo Rodrigues, a83929.
 * @version 2025/03/5.
 * @inv Os pontos nao podem ser sobrepostos (iguais), ou seja, xa != xb && ya != yb.
 */
public class Segmento
{
    private Ponto a; //ponto 1
    private Ponto b; //ponto 2
    private static final double EPSILON = 1e-9; // Tolerância para erros de precisão

    /*
     * Construtor para o segmento de reta.
     * @param a -> Ponto no primeiro quadrante.
     * @param b -> Outro ponto no primeiro quadrante.
     */
    public Segmento(Ponto a, Ponto b) {
        check(a, b);
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

    /*
     * Verifica se os dois pontos dados não violam a @inv
     * @param a -> Ponto no primeiro quadrante.
     * @param b -> Outro ponto no primeiro quadrante.
     */
    private void check(Ponto a, Ponto b) {
        if (a.equals(b)){
            System.out.println("Segmento:vi");
            System.exit(0);
        }
    }

    /*
     * Verifica se existe alguma interseção entre o segmento de reta e um circúlo.
     * @param c -> Circulo a verificar se interseta ou não o segmento de reta.
     * @return um boolean que indica que existe ou nao interseção, caso exista retorna true, caso contrario retorna false.
     */
    public boolean intersect_circle(Circulo c) {
        //conversão para coordenadas cartesianas
        double xa = this.a.getR() * cos(this.a.getAng());
        double ya = this.a.getR() * sin(this.a.getAng());
        double xb = this.b.getR() * cos(this.b.getAng());
        double yb = this.b.getR() * sin(this.b.getAng());
        double xc = c.getCenter().getR() * cos(c.getCenter().getAng());
        double yc = c.getCenter().getR() * sin(c.getCenter().getAng());

        double mReta = (yb - ya) / (xb - xa);
        double bReta = ya - (mReta * xa);

        double A = 1 + pow(mReta, 2);
        double B = (-2 * xc) + (2 * mReta * (bReta - yc));
        double C = pow(xc, 2) + pow((bReta - yc), 2) - pow(c.getRaio(), 2);

        double discriminant = pow(B, 2) - (4 * A * C);
        return discriminant >= 0; //se for >= retorna true, cc, retorna false
    }

    /*
     * Calcula a orientação de três pontos (p, q, r) em coordenadas cartesianas. A orietançao é calculada atravês do produto vetorial
     * entre os vetores PQ e QR.
     * @param p -> Primeiro ponto
     * @param q -> Segunda ponto.
     * @param r -> Terceiro ponto.
     * @return um inteiro, neste caso, 0, 1 ou -1. Sendo que o 0 indica que os pontos são colineares; 1 indica que a orientação é no sentido
     * horário então retorna positivo; -1 para indicar que o sentido dos pontos é o sentido anti horário então retorna negativo. O retorno ser
     * positivo ou negativo é importante para a conta feita na verificação geral de intersecção.
     * @see https://www.deepseek.com/ onde usei o prompt "como posso verificar que um segmento de reta dado por dois pontos
     * interseta um retângulo dado por 4 pontos em coordenadas cartesianas. Utiliza a orientação de pontos.", para saber como
     * fazer os códigos para a intersecção de um segmento de reta e um retângulo.
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
     * Método responsável por verificar se existe intersecção entre dois segmentos de reta, o segmento de reta da classe e o recebido por parâmetro.
     * Utiliza os os cálculos da orientação de três pontos para determinar se existe ou nao intersecção (excluindo extremidades como tocar
     * apenas em vertices ou então o segmento de reta terminar exatamente na aresta do retângulo (nao cortar a aresta)).
     * @param segmento -> segmento a verificar se existe interseção com o segmento da class.
     * @return um booleano que indica se existe ou nao intersecção entre os segmentos de reta, true caso exista, false caso contrário.
     * @see usei varias vezes o site https://www.geogebra.org/calculator para verificar geométricamente quando era considerado intersecção.
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