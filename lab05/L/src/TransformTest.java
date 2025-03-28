import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class TransformTest {
    Transform transform = new Transform(new Point(1, 1), 1, 180, 1);

    @Test
    void move()
    {
        transform.move(new Point(10.0, 10.0), 2);
        assertEquals(new Point(11, 11), transform.position());
        assertEquals(3, transform.layer());
    }

    @Test
    void rotate()
    {
        transform.rotate(190);
        assertEquals(10, transform.angle());
    }

    @Test
    void scale()
    {
        transform.scale(3.5);
        assertEquals(4.5, transform.scale());
    }

    @Test
    void position()
    {
        assertEquals(new Point(1, 1), transform.position());
    }

    @Test
    void layer()
    {
        assertEquals(1, transform.layer());
    }

    @Test
    void angle()
    {
        assertEquals(180, transform.angle());
    }

    @Test
    void testScale()
    {
        assertEquals(1, transform.scale());
    }

    @Test
    void testToString()
    {
        assertEquals("(1.00,1.00) 1 180.00 1.00", transform.toString());
    }
}