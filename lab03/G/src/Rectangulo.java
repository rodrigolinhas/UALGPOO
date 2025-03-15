/*  Classe Retangulo responsavel pela criacao da mesma usando 4 pontos de coordenadas cartesianas
 *  com as verificações necessárias.
 *  @author     Rodrigo Linhas a83933
 *  @version    01/03/2025
 *  @inv        Pontos devem pertencer ao 1o quadrante
 *  @inv        Tem que ter formar entre eles angulos de 90 graus
 */

class Rectangulo {
    private Ponto p1, p2, p3, p4;

    /* Construtor principal
     * @param 4 pontos
     */
    public Rectangulo(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
        check(p1, p2, p3, p4);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    /* Metodo toString
     * @return A string na seguinte forma [(p1x,p1y), (p2x,p2y), (p3x,p3y), (p4x,p4y)]
     */
    @Override
    public String toString() {
        return "[" + p1 + ", " + p2 + ", " + p3 + ", " + p4 + "]";
    }

    /* Metodo complementar para o construtor de forma a confirma
     * as @inv declaradas
     * @param 4 pontos
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
        if (Math.abs(a - 90) >= 1e-9 || Math.abs(b - 90) >= 1e-9 ||
                Math.abs(c - 90) >= 1e-9 || Math.abs(d - 90) >= 1e-9) {
            System.out.println("Retangulo:vi");
            System.exit(0);
        }
    }
}