import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RetanguloTests {

    //Teste para um retangulo valido
    @Test
    public void testValidRectangle() {
        Retangulo r = new Retangulo("4 1 6 1 6 2 4 2");
        assertEquals("Retangulo: [(4,1), (6,1), (6,2), (4,2)]", r.toString());
    }

    //Teste para um retangulo valido
    @Test
    public void testInvalidPointCount() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Retangulo("0 0 1 0"); // Apenas 2 pontos
        });
    }

    //Teste para um retangulo invalido (angulos não retos)
    @Test
    public void testNonRightAngles() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Retangulo("0 0 1 2 3 2 2 0");
        });
    }

    // Teste para um retangulo invalido (lados opostos desiguais)
    @Test
    public void testUnequalOppositeSides() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Retangulo("0 0 0 3 4 3 4 0");
        });
    }

    // Teste para translaçao valida de um retangulo
    @Test
    public void testRetangulo_TranslacaoValida() {
        Retangulo r = new Retangulo("2 2 2 4 4 4 4 2");
        FiguraGeometrica translacao = r.translacao(1, 1);
        assertEquals("Retangulo: [(3,3), (3,5), (5,5), (5,3)]", translacao.toString());
    }

    // Teste para translaçao invalida de um retangulo (coordenadas negativas)
    @Test
    public void testRetangulo_TranslacaoInvalidaForaQuadrante() {
        Retangulo r = new Retangulo("1 1 1 3 3 3 3 1");
        FiguraGeometrica transladado = r.translacao(-2, -2);
        assertEquals("Ponto:vi", transladado.toString());
    }
}
