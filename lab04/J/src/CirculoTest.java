import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CirculoTest {

    // Teste para círculo válido
    @Test
    public void testValidCircle() {
        Circulo c = new Circulo("5 5 3");
        assertEquals("Circulo: (5,5) 3", c.toString());
    }

    // Teste para círculo inválido (raio negativo)
    @Test
    public void testInvalidCircle() {
        Circulo c = new Circulo("5 5 -3");
        assertEquals("Circulo:vi", c.toString());
    }

    // Teste para círculo inválido (coordenadas negativas)
    @Test
    public void testInvalidCircle2() {
        Circulo c = new Circulo("5 -5 3");
        assertEquals("Circulo:vi", c.toString());
    }

    // Teste para translaçao valida de um circulo
    @Test
    public void testCirculo_TranslacaoValida() {
        Circulo c = new Circulo("5 5 2");
        FiguraGeometrica translacao = c.translacao(1, 1); // Novo centro (6,6), raio 2
        assertEquals("Circulo: (6,6) 2", translacao.toString());
    }

    // Teste para translaçao invalida de um círculo (coordenadas negativas)
    @Test
    public void testCirculo_TranslacaoInvalida() {
        Circulo c = new Circulo("2 2 2");
        FiguraGeometrica transladado = c.translacao(-1, -5);
        assertEquals("Ponto:vi", transladado.toString());
    }
}