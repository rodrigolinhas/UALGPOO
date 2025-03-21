import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TrianguloTest {

    // Teste para triângulo válido
    @Test
    public void testValidTriangle() {
        Triangulo t = new Triangulo("0 0 5 0 2 5");
        assertEquals("Triangulo: [(0,0), (5,0), (2,5)]", t.toString());
    }

    // Teste para triângulo inválido (apenas 2 pontos)
    @Test
    public void testInvalidPointCount() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangulo("0 0 5 0");
        });
    }

    // Teste para triângulo inválido (pontos colineares)
    @Test
    public void testColinearPoints() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangulo("0 0 2 0 4 0");
        });
    }
}