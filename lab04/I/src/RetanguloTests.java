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
}
