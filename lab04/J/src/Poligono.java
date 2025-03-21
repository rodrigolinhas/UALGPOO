import java.util.ArrayList;
import java.util.List;

/*
 * Classe responsável pela  criaçao de um poligono de N vertices
 * e pela generalização do retangulo e do triangulo
 * @author Rodrigo Linhas a83929
 * @version 21/03/2025
 * @inv Deve-se formar um poligono valido com pontos no 1o quadrante
 */

public class Poligono extends FiguraGeometrica {
    protected List<Ponto> vertices;

    /*
     * Construtor do poligono
     * @param String que contem as coordenadas dos pontos do poligono
     */
    public Poligono(String pontosAsString) {
        String [] parts = pontosAsString.split(" ");
        int numVertices = Integer.parseInt(parts[0]);
        this.vertices = new ArrayList<>();

        for (int i = 0; i < numVertices; i++){
            int x = Integer.parseInt(parts[i * 2 + 1]);
            int y = Integer.parseInt(parts[i * 2 + 2]);
            this.vertices.add(new Ponto(x, y));
        }

        check(vertices);
    }

    /*
     * Metodo complementar que verifica se o pligono não viola a @inv
     * @param uma lista de pontos usados para as verificações
     * @see https://tutoria.ualg.pt/2024/pluginfile.php/242347/mod_resource/content/5/POO24-25_Lab4-Figuras.pdf
     *      (refere as propriedades para um poligono valido)
     */
    private static void check(List<Ponto> vertices){
        if (vertices.size() < 3){
            System.out.println("Poligono:vi");
            System.exit(0);
        }
        for (int i = 0; i < vertices.size(); i++){
            Ponto p = vertices.get(i);
            Ponto q = vertices.get((i + 1) % vertices.size());
            Ponto r = vertices.get((i + 2) % vertices.size());

            Segmento temp = new Segmento(p, q);
            int orient = temp.orient(p, q, r);

            if (orient == 0){
                System.out.println("Poligono:vi");
                System.exit(0);
            }
        }
        for (int i = 0; i < vertices.size(); i++){
            Segmento aresta1 = new Segmento(vertices.get(i), vertices.get((i + 1) % vertices.size()));
            for (int j = i + 1; j < vertices.size(); j++){
                Segmento aresta2 = new Segmento(vertices.get(j), vertices.get((j + 1) % vertices.size()));
                if (aresta1.intersect_segment(aresta2)){
                    System.out.println("Poligono:vi");
                    System.exit(0);
                }
            }
        }
    }

    /*
     * Metodo toString usado para imprimir o poligono
     * @return Poligono de N vertices: [(x1,y1),…(xN,yN)]
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Poligono de " + vertices.size() + " vertices: [");
        for (int i = 0; i < vertices.size(); i++) {
            sb.append(vertices.get(i));
            if (i < vertices.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}