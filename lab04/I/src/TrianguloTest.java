import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TrianguloTest {

    // Teste para triângulo inválido (pontos colineares)
    @Test
    public void testInvalidTriangle() {
        Ponto p1 = new Ponto(1, 1);
        Ponto p2 = new Ponto(2, 2);
        Ponto p3 = new Ponto(3, 3);
        Triangulo t1 = new Triangulo(p1, p2, p3);
        assertEquals("Triangulo:vi", t1.toString());
    }

    // Teste para ponto inválido (coordenada negativa)
    @Test
    public void testInvalidPoint() {
        Ponto p1 = new Ponto(-1, 0);
        Ponto p2 = new Ponto(2, 2);
        Ponto p3 = new Ponto(3, 3);
        Triangulo t1 = new Triangulo(p1, p2, p3);
        assertEquals("Ponto:vi", t1.toString());
    }

    // Teste para triângulo válido
    @Test
    public void testValidTriangle() {
        Ponto p1 = new Ponto(0, 0);
        Ponto p2 = new Ponto(4, 0);
        Ponto p3 = new Ponto(0, 3);
        Triangulo t1 = new Triangulo(p1, p2, p3);
        assertEquals("[(0,0), (4,0), (0,3)]", t1.toString());
    }
    
}