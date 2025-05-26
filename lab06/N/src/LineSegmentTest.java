import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LineSegmentTest {

    static LineSegment lineSegment = new LineSegment(new Point(0, 0), new Point(2, 2));
    static LineSegment lineSegment2 = new LineSegment(new Point(-1, 2), new Point(2, -1));

    @Test
    void testInvalidLineSegment() {
        assertThrows(IllegalArgumentException.class, () -> new Line(new Point(4, 4), new Point(4, 4)));
    }


    @Test
    void length() {
        assertEquals(2*(Math.sqrt(2)), lineSegment.length());
    }

    @Test
    void closestRatio() {
        Point point = new Point(1, 1);
        assertEquals(0.5, lineSegment.closestRatio(point, true));
    }

    @Test
    void contains() {
        Point point = lineSegment.closest(new Point(2, 4.5));
        assertEquals(point.getX(), 2);
        assertEquals(point.getY(), 2);

    }

    @Test
    void intersects() {
        assertTrue(lineSegment.intersects(lineSegment2));
    }
}