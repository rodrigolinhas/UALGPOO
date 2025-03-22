/*
 * Classe responsável pela criação do círculo.
 * @author      Rodrigo Linhas a83929.
 * @version     21/03/2025.
 * @inv         O círculo deve estar completamente no primeiro quadrante.
 *              raio > 0 && x >= raio && y >= raio.
 */
public class Circulo extends FiguraGeometrica {
    private Ponto centro;
    private double raio;
    private static final double EPSILON = 1e-9;

    /*
     * Construtor para o círculo.
     * @param String RaioAsString que contém as coordenadas do centro e o raio.
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
     * Método complementar que verifica se o centro e o raio não violam a @inv.
     * @param center Centro do círculo.
     * @param raio Raio do círculo.
     */
    private void check(Ponto center, double raio) {
        if (raio < 0 || center.getXDouble() < raio - EPSILON || center.getYDouble() < raio - EPSILON) {
            System.out.println("Circulo:vi");
            System.exit(0);
        }
    }

    /*
     * Getter usado para obter o centro do círculo.
     * @return Ponto que define o centro do círculo.
     */
    public Ponto getCentro()    {return this.centro;}

    /*
     * Getter usado para obter o raio do círculo.
     * @return Raio do círculo.
     */
    public double getRaio() {return this.raio;}

    /*
     * Método toString usado para imprimir o círculo.
     * @return String no formato: Circulo: (x,y) raio.
     */
    @Override
    public String toString() {
        return "Circulo: " + centro + " " + (int) raio;
    }

    /*
     * Método translação do círculo.
     * @param dx Translação no eixo x.
     * @param dy Translação no eixo y.
     * @return Novo círculo com a translação aplicada.
     */
    @Override
    public FiguraGeometrica translacao(int dx, int dy) {
        int novoX = centro.getX() + dx;
        int novoY = centro.getY() + dy;
        Ponto novoCentro = new Ponto(novoX, novoY); // Lança Ponto:vi se inválido
        return new Circulo(novoX + " " + novoY + " " + raio);
    }

    /*
     * Método para verificar colisão entre figuras geométricas.
     * @param outra Figura geométrica a ser verificada.
     * @return true se houver colisão, false caso contrário.
     */
    @Override
    public boolean colideCom(FiguraGeometrica outra) {
        if (outra instanceof Circulo) {
            Circulo c = (Circulo) outra;
            double distancia = centro.dist(c.centro);
            return distancia <= raio + c.raio + EPSILON;
        } else if (outra instanceof Poligono) {
            Poligono p = (Poligono) outra;
            // Verifica se o centro do círculo está dentro do polígono
            if (p.contemPonto(centro)) return true;
            // Verifica se alguma aresta do polígono intersecta o círculo
            for (int i = 0; i < p.vertices.size(); i++) {
                Ponto a = p.vertices.get(i);
                Ponto b = p.vertices.get((i + 1) % p.vertices.size());
                Segmento aresta = new Segmento(a, b);
                double distanciaAresta = distanciaParaSegmento(centro, aresta);
                if (distanciaAresta <= raio + EPSILON) return true;
            }
            // Verifica se algum vértice está dentro do círculo
            for (Ponto v : p.vertices) {
                if (centro.dist(v) <= raio + EPSILON) return true;
            }
            return false;
        }
        return false;
    }

    /*
     * Método complementar para calcular a distância de um ponto a um segmento.
     * @param p Ponto a ser verificado.
     * @param s Segmento de reta.
     * @return Distância do ponto ao segmento.
     */
    private double distanciaParaSegmento(Ponto p, Segmento s) {
        Ponto a = s.getA();
        Ponto b = s.getB();
        double len2 = a.dist(b) * a.dist(b);
        if (len2 < EPSILON) return p.dist(a);
        double t = ((p.getXDouble() - a.getXDouble()) * (b.getXDouble() - a.getXDouble()) +
                (p.getYDouble() - a.getYDouble()) * (b.getYDouble() - a.getYDouble())) / len2;
        t = Math.max(0, Math.min(1, t));
        double projX = a.getXDouble() + t * (b.getXDouble() - a.getXDouble());
        double projY = a.getYDouble() + t * (b.getYDouble() - a.getYDouble());
        return Math.sqrt(Math.pow(p.getXDouble() - projX, 2) + Math.pow(p.getYDouble() - projY, 2));
    }
}