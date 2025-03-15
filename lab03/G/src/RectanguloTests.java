import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RectanguloTests {

    //teste para os retangulos validos

    @Test
    public void test1() {
        Ponto p1 = new Ponto(1, 1);
        Ponto p2 = new Ponto(1, 3);
        Ponto p3 = new Ponto(3, 3);
        Ponto p4 = new Ponto(3, 1);
        Rectangulo rect = new Rectangulo(p1, p2, p3, p4);
        assertEquals("[(1,1), (1,3), (3,3), (3,1)]", rect.toString()); // String atualizada
    }

    @Test
    public void test2() {
        Ponto p1 = new Ponto(4, 1);
        Ponto p2 = new Ponto(6, 1);
        Ponto p3 = new Ponto(6, 2);
        Ponto p4 = new Ponto(4, 2);
        Rectangulo rect = new Rectangulo(p1, p2, p3, p4);
        assertEquals("[(4,1), (6,1), (6,2), (4,2)]", rect.toString()); // String atualizada
    }

    @Test
    public void test3() {
        Ponto p1 = new Ponto(3, 2);
        Ponto p2 = new Ponto(4, 1);
        Ponto p3 = new Ponto(6, 3);
        Ponto p4 = new Ponto(5,4);
        Rectangulo rect = new Rectangulo(p1, p2, p3, p4);
        assertEquals("[(3,2), (4,1), (6,3), (5,4)]", rect.toString()); // String atualizada
    }

    @Test
    public void test4() {
        Ponto p1 = new Ponto(0,0);
        Ponto p2 = new Ponto(5, 0);
        Ponto p3 = new Ponto(5,5);
        Ponto p4 = new Ponto(0,5);
        Rectangulo rect = new Rectangulo(p1, p2, p3, p4);
        assertEquals("[(0,0), (5,0), (5,5), (0,5)]", rect.toString()); // String atualizada
    }

    //Testes para retangulos invalidos

    @Test
    public void test5() {
        Ponto p1 = new Ponto(1,2);
        Ponto p2 = new Ponto(2,3);
        Ponto p3 = new Ponto(3,4);
        Ponto p4 = new Ponto(4,5);
        Rectangulo r1 = new Rectangulo(p1,p2,p3,p4);
        assertEquals("Retangulo:vi", r1.toString());
    }

    @Test
    public void test6() {
        Ponto p1 = new Ponto(3,0);
        Ponto p2 = new Ponto(4,2);
        Ponto p3 = new Ponto(3,4);
        Ponto p4 = new Ponto(2,2);
        Rectangulo r1 = new Rectangulo(p1,p2,p3,p4);
        assertEquals("Retangulo:vi", r1.toString());
    }

    @Test
    public void test7() {
        Ponto p1 = new Ponto(3,2);
        Ponto p2 = new Ponto(4,1);
        Ponto p3 = new Ponto(6,3);
        Ponto p4 = new Ponto(5,5);
        Rectangulo r1 = new Rectangulo(p1,p2,p3,p4);
        assertEquals("Retangulo:vi", r1.toString());
    }

    @Test
    public void test8() {
        Ponto p1 = new Ponto(0,0);
        Ponto p2 = new Ponto(10,0);
        Ponto p3 = new Ponto(10,2);
        Ponto p4 = new Ponto(0,1);
        Rectangulo r1 = new Rectangulo(p1,p2,p3,p4);
        assertEquals("Retangulo:vi", r1.toString());
    }

}