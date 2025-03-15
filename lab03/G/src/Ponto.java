import java.util.Objects;

/*  Classe Ponto representa um ponto em coordenadas polares com as verificações necessárias.
 *  @author     Rodrigo Linhas a83933
 *  @version    07/03/2025
 *  @inv        Em coordenadas polares: r => 0, 0 <= teta <= 90 graus.
 *  @inv        Em coordenadas cartesianas: x>=0 e y>=0 (pertencem ao 1o quadrante)
 */
class Ponto {
    private double r, teta;
    private static final double EPSILON = 1e-9;

    /* Construtor principal
     * @param double raio e teta
     */
    public Ponto(double r, double teta) {
        //verificacao
        check(r, teta);
        this.r = r;
        this.teta = teta;
    }

    /* Construtor que converte coordenadas cartesianas para polares
     * @param int x e y
     * @see https://www.omnicalculator.com/pt/matematica/calculadora-coordenadas-polares (formulas necessarias)
     */
    public Ponto(int x, int y){
        //verificacao
        check(x, y);
        this.r = Math.sqrt((x*x)+(y*y));
        this.teta = Math.toDegrees(Math.atan2(y, x));
    }

    /*
     * Método que verifica se dois pontos são iguais,
     * e caso sejam, verifica se os pontos são coincidentes.
     * @param Objeto o a ser comparado com o Ponto.
     * @return true caso sejam iguais, falso caso contrário.
     */
    @Override
    public boolean equals(Object o)
    {
        if (o == null || getClass() != o.getClass()) return false;
        Ponto ponto = (Ponto) o;
        return Math.abs(this.r - ponto.getr()) < EPSILON && Math.abs(this.teta - ponto.getteta()) < EPSILON;
    }

    /* Método complementar ao equals, necessario para
     * evitar as colisões entre objetos (AED).
     * @return o codigo hash para o r e o teta
     */
    @Override
    public int hashCode() {return Objects.hash(r, teta);}

    /*  Metodo toString
     *  @return a string no seuinte formato: (x,y)
     */
    @Override
    public String toString()    {return "(" + getX() + "," + getY() + ")";}

    /* Get do raio, nessecario para outras classes acederem esta informacao
    *  @return raio
    *  @see https://tutoria.ualg.pt/2024/mod/resource/view.php?id=107599 (refere os gets e checks)
    */
    public double getr()    {return this.r;}

    /*  Get do X, nessecario para outras classes acederem esta informacao
     *  @return x apos ter convertido de polares para cartesianas
     *  @see https://wwwp.fc.unesp.br/~mauri/Down/Polares.pdf (formulas usada)
     */
    public int getX()       {return (int) Math.round(this.r*Math.cos(Math.toRadians(this.teta)));}

    /*  Get do teta, nesecario para outras classes acederem esta informacao
     *  @return angulo teta
     *  @see https://tutoria.ualg.pt/2024/mod/resource/view.php?id=107599 (refere os gets e checks)
     */
    public double getteta() {return this.teta;}

    /*  Get do Y, nessecario para outras classes acederem esta informacao
     *  @return y apos ter convertido de polares para cartesianas
     *  @see https://wwwp.fc.unesp.br/~mauri/Down/Polares.pdf (formulas usada)
     */
    public int getY()       {return (int) Math.round(this.r*Math.sin(Math.toRadians(this.teta)));}

    /* Calcula distância de dois pontos.
     * @param Outro ponto
     * @return Distância entre os pontos
     */
    public double dist (Ponto that) {
        return Math.sqrt(this.r*this.r + that.r*that.r
                - 2*this.r*that.r*Math.cos(Math.toRadians(that.teta)-Math.toRadians(this.teta)));
    }

    /* Verifica se as coordenadas cartesianas nao violam a @inv.
     * @param Coordenada x
     * @param Coordenada y
     */
    private void check(int x, int y){
        if (x<0||y<0) {
            System.out.println("Ponto:vi");
            System.exit(0);
        }
    }

    /* Verifica se as coordenadas polares nao violam a @inv.
     * @param Raio r
     * @param Angulo teta
     */
    private void check(double r, double teta){
        if (r>10 || teta<0 || teta>90 ) {
            System.out.println("Ponto:vi");
            System.exit(0);
        }
    }
}