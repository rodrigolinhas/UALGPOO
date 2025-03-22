/*
 * Classe Triangulo representa um triângulo com o uso de 3 pontos.
 * @author      Rodrigo Linhas a83933.
 * @version     21/03/2025.
 * @inv         Os 3 pontos devem ser distintos, pertencentes ao 1º quadrante
 *              e válidos para a criação de um triângulo.
 */
public class Triangulo extends Poligono {

    /*
     * Construtor para o triângulo.
     * @param pontosAsString String com 3 pontos.
     */
    public Triangulo(String pontosAsString) {
        super("3 " + pontosAsString);
        check(pontosAsString);
    }

    /*
     * Método complementar do construtor que verifica se o triângulo criado é válido.
     * @param pontosAsString String com os pontos.
     */
    private static void check(String pontosAsString) {
        String[] parts = pontosAsString.split(" ");
        if (parts.length != 6) {
            System.out.println("Triangulo:vi");
            System.exit(0);
        }
    }

    /*
     * Método que imprime o triângulo no terminal.
     * @return Triangulo: [(x1,y1), (x2,y2), (x3,y3)].
     */
    @Override
    public String toString() {
        return "Triangulo: [" + vertices.get(0) + ", " + vertices.get(1) + ", " + vertices.get(2) + "]";
    }

    /*
     * Método translação do triângulo.
     * @param dx Translação no eixo x.
     * @param dy Translação no eixo y.
     * @return Novo triângulo com a translação aplicada.
     */
    @Override
    public FiguraGeometrica translacao(int dx, int dy) {
        Poligono pTransladado = (Poligono) super.translacao(dx, dy);
        return new Triangulo(pTransladado.verticesToString());
    }
}