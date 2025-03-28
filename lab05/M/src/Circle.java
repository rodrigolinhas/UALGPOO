import java.util.Locale;

/**
 * Implementation of a Circle object.
 * <p>The circle can move, scale and rotate, despite not changing
 * with this last operation.
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version March 27, 2025
 */
public class Circle extends Collider
{
    private final Point center;
    private double radius;

    /**
     * Constructs a circle object from a center variable of {@code Point}
     * type and radius of double type.
     * @param center the center of the circle;
     * @param radius the radius of the circle.
     * @throws IllegalArgumentException if the provided radius is negative or null.
     */
    public Circle(Point center, double radius) {
        if (radius <= 0) throw new IllegalArgumentException("Circulo:vi\n");
        this.center = center;
        this.radius = radius;
    }

    /**
     * Getter for the radius.
     * @return the radius of the circle.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Simple method to check if collides with another collider
     * @return boolean depending on the situation
     *         true if it happens
     *         false otherwise
     */
    @Override
    boolean collides(Collider collider) {
        if (collider instanceof Circle c) return center.dist(c.center) <= radius + c.radius;
        if (collider instanceof Polygon p)
        {
            for (Point po : p.getPoints()) if (po.dist(center) <= radius) return true;
            for (LineSegment seg : p.getSegments()) if (seg.intersects(this)) return true;
            return p.contains(center);
        }
        return false;
    }

    /**
     * Method to move the circle
     * @param point
     */
    @Override
    public void move(Point point) {
        center.move(point);
    }

    /**
     * Method to get the centroid
     * @return centroid (the center of the circle)
     */
    @Override
    public Point centroid() {
        return this.center;
    }


    /**
     * Method to rotate the circle
     * @param angle
     */
    @Override
    public void rotate(double angle) {
        //Não necessita
    }

    /**
     * Method to scale the circle
     * @param scale
     */
    @Override
    public void scale(double scale) {
        if (scale <= 0) throw new IllegalArgumentException();
        this.radius *= scale;
    }

    /**
     * Method toString of the circle
     * @return (x,y) radius
     */
    @Override
    public String toString()
    {
        return center.toString() + " " + String.format(Locale.US,"%.2f", radius);
    }
}
