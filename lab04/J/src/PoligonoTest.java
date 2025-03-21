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
}