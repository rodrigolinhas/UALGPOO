
/*  Classe Triangulo representa um triangulo com o uso de 3 pontos
 *  @author         Rodrigo Linhas a83933
 *  @version        21/03/2025
 *  @inv            Os 3 pontos devem ser distintos, pertencentes ao 1o quadrante
 *                  e validos para a criação de um triangulo.
 */
public class Triangulo extends Poligono {

    /*
     * Construtor para o triangulo.
     * @param String com 3 pontos
     */
    public Triangulo(String pontosAsString) {
        super("3 " + pontosAsString);
        check(pontosAsString);
    }

    /*
     *  Metodo complementar do construtor que verifica se o
     *  triangulo criado é valido
     *  @param lista de pontos do triangulo
     */
    private static void check(String pontosAsString) {
        String[] parts = pontosAsString.split(" ");
        if (parts.length != 6) {
            System.out.println("Triangulo:vi");
            System.exit(0);
        }
    }


    /*
     * Metodo que imprime o retangulo no terminal
     * @return Triangulo: [(x1,y1), (x2,y2), (x3,y3)]
     */
    @Override
    public String toString() {
        return "Triangulo: [" + vertices.get(0) + ", " + vertices.get(1) + ", " + vertices.get(2) + "]";
    }
}