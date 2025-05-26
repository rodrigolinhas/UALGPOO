/**
 * The {@code ICollider} interface stores information about
 * an object's colision.
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version March 25, 2025
 */
public interface ICollider
{
    /**
     * Returns the centroid of the collider.
     * @return the centroid of the collider.
     */
    Point centroid();

    /**
     * Move the centroid of a collider consonant the point param.
     * @param point
     */
    void move(Point point);

    /**
     * Rotate the collider consonant the angle param.
     * @param angle
     */
    void rotate(double angle);

    /**
     * Scale the collider consonant the scale param passed.
     * @param scale
     */
    void scale(double scale);
}