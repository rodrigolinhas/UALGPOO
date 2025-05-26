import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class GameObjectTest {
    static Transform transform = new Transform(new Point(1, 2), 1, 0, 1);
    static Colisor circle = new Circle(new Point(2, 3), 3);
    static GameObject gameObject = new GameObject("gameObject1", transform, circle);

    @Test
    void name()
    {
        assertEquals("gameObject1", gameObject.name());
    }

    @Test
    void transform()
    {
        assertEquals(transform, gameObject.transform());
    }

    @Test
    void collider()
    {
        assertEquals(circle, gameObject.collider());

        ArrayList<Point> points = new ArrayList<Point>();
        points.add(new Point(-1, 0));
        points.add(new Point(5, 0));
        points.add(new Point(2, 4));
        Colisor polygon = new Polygon(points);
        GameObject gameObject2 = new GameObject("gameObject2", transform, polygon);
        assertEquals(polygon, gameObject2.collider());
    }
}