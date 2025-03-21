import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RectanguloTests {

    //teste para um retangulo invalido
    //@Test
    /*public void testInvalidRectangle() {
        Ponto p1 = new Ponto(1,2);
        Ponto p2 = new Ponto(2,3);
        Ponto p3 = new Ponto(3,4);
        Ponto p4 = new Ponto(4,5);
        Rectangulo r1 = new Rectangulo(p1,p2,p3,p4);
        assertEquals("Retangulo:vi", r1.toString());
    }*/

    //teste para um ponto invalido
    //@Test
    /*public void testInvalidPoint() {
        Ponto p1 = new Ponto(-1,0);
        Ponto p2 = new Ponto(5,2);
        Ponto p3 = new Ponto(5,3);
        Ponto p4 = new Ponto(2,7);
        Rectangulo r1 = new Rectangulo(p1,p2,p3,p4);
        assertEquals("Ponto:vi", r1.toString());

    }*/

    //teste para um retangulo valido
    //@Test
    /*public void testValidRectangle() {
        Ponto p1 = new Ponto(4, 1);
        Ponto p2 = new Ponto(6, 1);
        Ponto p3 = new Ponto(6, 2);
        Ponto p4 = new Ponto(4, 2);
        Rectangulo rect = new Rectangulo(p1, p2, p3, p4);
        assertEquals("[(4,1), (6,1), (6,2), (4,2)]", rect.toString());
    }*/

    //teste para um retangulo e um segmento não intersetam
    //@Test
    /*public void testNonIntersect() {
        Ponto p1 = new Ponto(4, 1);
        Ponto p2 = new Ponto(6, 1);
        Ponto p3 = new Ponto(6, 2);
        Ponto p4 = new Ponto(4, 2);
        Rectangulo rect = new Rectangulo(p1, p2, p3, p4);
        Ponto p5 =  new Ponto(1,3);
        Ponto p6 =  new Ponto(3,1);
        Segmento s = new Segmento(p5,p6);
        assertFalse(rect.intersecta(s));
    }*/

    //teste para um retangulo e um segmento intersetam
    //@Test
    /*public void testIntersect() {
        Ponto p1 = new Ponto(4, 1);
        Ponto p2 = new Ponto(6, 1);
        Ponto p3 = new Ponto(6, 2);
        Ponto p4 = new Ponto(4, 2);
        Rectangulo rect = new Rectangulo(p1, p2, p3, p4);
        Ponto p5 =  new Ponto(4,0);
        Ponto p6 =  new Ponto(5,3);
        Segmento s = new Segmento(p5,p6);
        assertTrue(rect.intersecta(s));
    }*/

    //teste para um retangulo e um segmento não intersetam porque são tangentes
    //@Test
    /*public void testTangIntersect() {
        Ponto p1 = new Ponto(3, 2);
        Ponto p2 = new Ponto(4, 1);
        Ponto p3 = new Ponto(6, 3);
        Ponto p4 = new Ponto(5, 4);
        Rectangulo rect = new Rectangulo(p1, p2, p3, p4);
        Ponto p5 =  new Ponto(1,3);
        Ponto p6 =  new Ponto(4,3);
        Segmento s = new Segmento(p5,p6);
        assertFalse(rect.intersecta(s));
        //Uma vez que TEM QUE ENTRAR DENTRO DO RETANGULO, NÃO BASTA TOCAR
    }*/

}