import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PoligonoTest {
    // Teste para polígono válido
    @Test
    public void testValidPolygon() {
        Poligono p = new Poligono("4 5 5 8 6 8 7 5 7");
        assertEquals("Poligono de 4 vertices: [(5,5), (8,6), (8,7), (5,7)]", p.toString());
    }

    // Teste para polígono inválido (apenas 2 pontos)
    @Test
    public void testLessThan3Vertices() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Poligono("2 0 0 5 0"); // Apenas 2 vértices
        });
    }

    // Teste para polígono inválido (pontos colineares)
    @Test
    public void testColinearPoints() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Poligono("3 0 0 2 0 4 0");
        });
    }

    // Teste para translaçao valida de um poligono
    @Test
    public void testPoligono_TranslacaoInvalida() {
        Poligono p = new Poligono("4 1 2 5 6 8 7 12 14");
        FiguraGeometrica translacao = p.translacao(-1,3);
        assertEquals("Poligono:vi", translacao.toString());
    }

    // Teste para translaçao invalida de um poligono (coordenadas negativas)
    @Test
    public void testPoligono_TranslacaoValida() {
        Poligono p = new Poligono("3 1 1 3 1 2 3");
        FiguraGeometrica transladado = p.translacao(-2, -2);
        assertEquals("Ponto:vi", transladado.toString());
    }
}