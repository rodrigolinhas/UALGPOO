import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class ColliderTest {

    private Polygon createSamplePolygon() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(4, 0));
        points.add(new Point(2, 3));
        return new Polygon(points);
    }

    private Polygon createSamplePolygon2() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(2, 2));
        points.add(new Point(2, 6));
        points.add(new Point(4, 6));
        points.add(new Point(4, 2));
        return new Polygon(points);
    }

    private Circle createSampleCircle() {
        Point centroid = new Point(0, 0);
        double radius = 5;
        return new Circle(centroid, radius);
    }

    private Circle createSampleCircle2() {
        Point centroid = new Point(1, 1);
        double radius = 1;
        return new Circle(centroid, radius);
    }

    @Test
    void collides_polygon_polygon() {
        Polygon p1 = createSamplePolygon();
        Polygon p2 = createSamplePolygon();
        assertTrue(p1.collides(p2));
    }

    @Test
    void collides_polygon_circle() {
        Polygon p1 = createSamplePolygon();
        Circle c1 = createSampleCircle();
        assertTrue(p1.collides(c1));
    }

    @Test
    void collides_circle_circle() {
        Circle c1 = createSampleCircle();
        Circle c2 = createSampleCircle();
        assertTrue(c1.collides(c2));
    }


    @Test
    void moveTest()
    {
        Polygon p = createSamplePolygon2();
        Point point = new Point(1, 1);
        p.move(point);
        assertEquals(3, p.getPoints().get(0).getX());
        assertEquals(3, p.getPoints().get(0).getY());
        assertEquals(3, p.getPoints().get(1).getX());
        assertEquals(7, p.getPoints().get(1).getY());
        assertEquals(5, p.getPoints().get(2).getX());
        assertEquals(7, p.getPoints().get(2).getY());
        assertEquals(5, p.getPoints().get(3).getX());
        assertEquals(3, p.getPoints().get(3).getY());
    }

    @Test
    void testToString() {
        Polygon p1 = createSamplePolygon();
        assertEquals("(0.00,0.00) (4.00,0.00) (2.00,3.00)", p1.toString());
    }
}