import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ClienteTest {

    // Teste de colisão entre dois círculos
    @Test
    public void testColisaoCirculoCirculo() {
        Circulo c1 = new Circulo("2 2 1");
        Circulo c2 = new Circulo("3 2 1");
        assertTrue(c1.colideCom(c2)); // Distância entre centros = 1 (<= 1+1)
    }

    // Teste de não colisão entre dois círculos
    @Test
    public void testSemColisaoCirculoCirculo() {
        Circulo c1 = new Circulo("2 2 1");
        Circulo c2 = new Circulo("5 5 1");
        assertFalse(c1.colideCom(c2)); // Distância ~4.24 > 2
    }

    // Teste de colisão entre círculo e polígono (centro dentro)
    @Test
    public void testColisaoCirculoDentroPoligono() {
        Circulo c = new Circulo("3 3 1");
        Poligono p = new Poligono("4 1 1 5 1 5 5 1 5");
        assertTrue(p.colideCom(c));
    }

    // Teste de colisão entre círculo e polígono (aresta intersecta)
    @Test
    public void testColisaoCirculoArestaPoligono() {
        Circulo c = new Circulo("3 1 1");
        Poligono p = new Poligono("4 1 1 5 1 5 5 1 5");
        assertTrue(p.colideCom(c));
    }

    // Teste de colisão entre dois polígonos (arestas intersectam)
    @Test
    public void testColisaoPoligonosArestas() {
        Poligono p1 = new Poligono("4 1 1 4 1 4 4 1 4");
        Poligono p2 = new Poligono("4 3 3 6 3 6 6 3 6");
        assertTrue(p1.colideCom(p2));
    }

    // Teste de colisão entre retângulo e círculo (vértice dentro)
    @Test
    public void testColisaoRetanguloCirculo() {
        Retangulo r = new Retangulo("2 2 5 2 5 5 2 5");
        Circulo c = new Circulo("6 6 2");
        assertTrue(r.colideCom(c));
    }

    // Teste de colisão entre triângulo e círculo
    @Test
    public void testColisaoTrianguloCirculo() {
        Triangulo t = new Triangulo("7 1 9 1 9 3");
        Circulo c = new Circulo("8 2 1");
        assertTrue(t.colideCom(c));
    }

    // Teste de não colisão entre figuras distantes
    @Test
    public void testSemColisao() {
        Poligono p = new Poligono("4 10 10 20 10 20 20 10 20");
        Circulo c = new Circulo("5 5 1");
        assertFalse(p.colideCom(c));
    }
}