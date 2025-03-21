import static java.lang.Math.*;
/*
 * Representa um circúlo em duas dimensões.
 * @author Paulo Rodrigues, a83929.
 * @version 2025/02/25.
 * @inv O circúlo tem que estar completamente no primeiro quadrante, ou seja, raio > 0 && x >= raio && y >= raio.
 */
public class Circulo extends FiguraGeometrica
{
    private Ponto center;
    private double raio;
    private static final double EPSILON = 1e-9; // Tolerância para erros de precisão

    /*
     * Construtor para o circúlo.
     * @param center -> Ponto que define o centro do circúlo.
     * @param raio -> Raio que define o circúlo.
     */
    public Circulo(String ponto_RaioAsString)
    {
        String[] ponto_raio = ponto_RaioAsString.split(" ");

        if (ponto_raio.length != 3)
        {
            System.out.println("Circulo:vi");
            System.exit(0);
        }

        int x = Integer.parseInt(ponto_raio[0]);
        int y = Integer.parseInt(ponto_raio[1]);
        double raio = Double.parseDouble(ponto_raio[2]);
        Ponto center = new Ponto(x, y);
        check(center, raio);
        this.center = center;
        this.raio = raio;
    }

    /*
     * Verifica se o centro e o raio não violam a @inv
     * @param center -> Ponto que define o centro do circúlo.
     * @param raio -> Raio que define o circúlo.
     */
    private void check(Ponto center, double raio) //ver se preciso por estatica
    {
        if (raio < 0 || center.getXDouble() < raio - EPSILON || center.getYDouble() < raio - EPSILON)
        {
            System.out.println("Circulo:vi");
            System.exit(0);
        }
    }

    /*
     * Getter usado para uso do centro do circúlo noutras classes.
     * @param center -> Ponto que define o centro do circúlo.
     */
    public Ponto getCenter(){ return this.center; }

    /*
     * Getter usado para uso do raio do circúlo noutras classes.
     * @param raio -> Raio que define o circúlo.
     */
    public double getRaio(){ return this.raio; }

    /*
     * Calcula o perímetro do circúlo
     * @return perímetro do circulo
     */
    public double perimeter()
    {
        return 2 * PI * this.raio;
    }

    @Override
    public String toString() {
        return "Circulo: " + center + " " + (int)raio;
    }
}