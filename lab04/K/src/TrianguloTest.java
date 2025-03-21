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

    // Teste para translaçao valida de um triangulo
    @Test
    public void testTriangulo_TranslacaoValida() {
        Triangulo t = new Triangulo("2 2 5 2 3 5");
        FiguraGeometrica translacao = t.translacao(1, 1);
        assertEquals("Triangulo: [(3,3), (6,3), (4,6)]", translacao.toString());
    }

    // Teste para translaçao invalida de um triangulo (coordenadas negativas)
    @Test
    public void testTriangulo_TranslacaoInvalida() {
        Triangulo t = new Triangulo("0 0 2 0 4 0");
        FiguraGeometrica translacao = t.translacao(-1, -1);
        assertEquals("Ponto:vi", translacao.toString());
    }
}