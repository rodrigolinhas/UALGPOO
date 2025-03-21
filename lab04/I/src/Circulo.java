/*
 * Classe responsável pela criação do circulo.
 * @author Rodrigo Linhas a83929
 * @version 21/03/2025.
 * @inv O circúlo tem que estar completamente no primeiro quadrante
 * @inv raio > 0 && x >= raio && y >= raio
 */
public class Circulo extends FiguraGeometrica
{
    private Ponto centro;
    private double raio;
    private static final double EPSILON = 1e-9;

    /*
     * Construtor para o circúlo
     * @param String que contem as coordenadas do centro e o raio.
     */
    public Circulo(String ponto_RaioAsString) {
        String[] ponto_raio = ponto_RaioAsString.split(" ");
        if (ponto_raio.length != 3) {
            System.out.println("Circulo:vi");
            System.exit(0);
        }
        int x = Integer.parseInt(ponto_raio[0]);
        int y = Integer.parseInt(ponto_raio[1]);
        double raio = Double.parseDouble(ponto_raio[2]);
        Ponto center = new Ponto(x, y);
        check(center, raio);
        this.centro = center;
        this.raio = raio;
    }

    /*
     * Metodo complementar que verifica se o centro e o raio não violam a @inv
     * @param centro do circúlo
     * @param raio que define o circúlo
     */
    private void check(Ponto center, double raio){
        if (raio < 0 || center.getXDouble() < raio - EPSILON || center.getYDouble() < raio - EPSILON){
            System.out.println("Circulo:vi");
            System.exit(0);
        }
    }


    /*
     * Getter usado para uso do centro do circúlo noutras classes
     * @return ponto que define o centro do circúlo
     */
    public Ponto getCentro(){ return this.centro; }

    /*
     * Getter usado para uso do raio do circúlo noutras classes
     * @return raio que define o circúlo
     */
    public double getRaio(){ return this.raio; }

    /*
     * Calcula o perímetro do circúlo
     * @return perímetro do circulo
     * @see https://www.todamateria.com.br/perimetro-do-circulo/ (formula)
     */
     /*public double perimeter(){
        return 2 * PI * this.raio;
    }*/

    /*
    * Metodo toString usado para imprimir o circulo
    * @return Circulo: (x,y) raio
    */
    @Override
    public String toString() {
        return "Circulo: " + centro + " " + (int)raio;
    }
}