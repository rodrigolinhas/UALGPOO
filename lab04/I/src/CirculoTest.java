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

}