/*  Classe Rectangulo representa um retangulo com o uso de 4 pontos, imprime o reatngulo
 *  e verifica se interseta com um segmento.
 *  @author     Rodrigo Linhas a83933
 *  @version    06/03/2025
 *  @inv        Os 4 pontos devem ser distintos, pertencentes ao 1o quadrante
 *  @inv        e validos para a criação de um retangulo.
 */
public class Rectangulo extends FiguraGeometrica {
    private Ponto p1, p2, p3, p4;
    private static final double EPSILON = 1e-9;

    /* Construtor da classe Rectangulo
     * @param   4 Pontos que cumprem a @inv
     */
    public Rectangulo(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
        check(p1, p2, p3, p4);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    /*  Metodo responsavel para verificar se o retangulo e o segmento dado
     *  de facto intersetam
     *  @param Segmento s
     *  @return true se interseta ou falso cc
     */
    public boolean intersecta(Segmento s) {
        //if (insideRetangulo(s.getA()) || insideRetangulo(s.getB())) return true;
        Segmento s1 = new Segmento(p1, p2);
        Segmento s2 = new Segmento(p2, p3);
        Segmento s3 = new Segmento(p3, p4);
        Segmento s4 = new Segmento(p4, p1);

        return  s.doIntersect(s1) || s.doIntersect(s2) ||
                s.doIntersect(s3) || s.doIntersect(s4);
    }

    //REVER
    /*private boolean insideRetangulo(Ponto ponto) {
        double xMin = Math.min(Math.min(p1.getX(), p2.getX()), Math.min(p3.getX(), p4.getX()));
        double xMax = Math.max(Math.max(p1.getX(), p2.getX()), Math.max(p3.getX(), p4.getX()));
        double yMin = Math.min(Math.min(p1.getY(), p2.getY()), Math.min(p3.getY(), p4.getY()));
        double yMax = Math.max(Math.max(p1.getY(), p2.getY()), Math.max(p3.getY(), p4.getY()));

        return (ponto.getX() > xMin + EPSILON && ponto.getX() < xMax - EPSILON) &&
                (ponto.getY() > yMin + EPSILON && ponto.getY() < yMax - EPSILON);
    }*/

    /*  Metodo que imprime o retangulo no terminal
     *  @return uma string que demonstra as coordenadas usadas
     *  para a criação do retangulo
     */
    @Override
    public String toString() {return "[" + p1 + ", " + p2 + ", " + p3 + ", " + p4 + "]";}

    /*  Metodo complementar do construtor que verifica se o
     *  retangulo criado é valido
     *  @param 4 Pontos distintos
     */
    private void check(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
        Segmento s1 = new Segmento(p1, p2);
        Segmento s2 = new Segmento(p2, p3);
        Segmento s3 = new Segmento(p3, p4);
        Segmento s4 = new Segmento(p4, p1);
        double a = s1.anginterseta(s2);
        double b = s2.anginterseta(s3);
        double c = s3.anginterseta(s4);
        double d = s4.anginterseta(s1);
        if (Math.abs(a - 90) >= EPSILON || Math.abs(b - 90) >= EPSILON ||
                Math.abs(c - 90) >= EPSILON || Math.abs(d - 90) >= EPSILON) {
            System.out.println("Retangulo:vi");
            System.exit(0);
        }
    }
}