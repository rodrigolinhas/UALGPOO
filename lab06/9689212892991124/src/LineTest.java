import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    static Line line = new Line(new Point(0, 3), new Point(2, 2));

    @Test
    void testInvalidLine() {
        assertThrows(IllegalArgumentException.class, () -> new Line(new Point(4, 4), new Point(4, 4)));
    }

    @Test
    void testContains() {
        assertTrue(line.contains(new Point(4, 1)));
        assertFalse(line.contains(new Point(-2, 5)));
    }

    @Test
    void testPerpendicular() {
        Line other = new Line(new Point(1, 1), line);
        System.out.println(other.getA());
        System.out.println(other.getB());
        assertTrue(other.contains(new Point(2, 3)));
        Line another = new Line(new Point(4, 1), line);
        assertTrue(another.contains(new Point(5, 3)));
    }

    @Test
    void testClosest() {
        Point point = line.closest(new Point(2, 4.5));
        assertEquals(point.getX(), 1);
        assertEquals(point.getY(), 2.5);
    }

    @Test
    void testIntersections() {
        assertTrue(line.intersects(new Circle(new Point(2, 0), 2)));
        assertFalse(line.intersects(new Circle(new Point(4, 3), 1)));
        assertTrue(line.intersects(new Polygon(new ArrayList<>(List.of(
                new Point(3, 1.5),
                new Point(3, 2.5),
                new Point(4, 1.5)
        )))));
        assertTrue(line.intersects(new Polygon(new ArrayList<>(List.of(
                new Point(-2, 5),
                new Point(-1.5, 3),
                new Point(-1, 5)
        )))));
    }
}