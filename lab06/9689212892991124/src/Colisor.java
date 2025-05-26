/**
 * This class represent the collider
 * <p>The collider is necessary to determine if the
 * given object collides with another one
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version March 26, 2025
 */
abstract class Colisor implements ICollider
{
    protected Point centroid; //center of a collider

    /**
     * Simple method to check if collide with another collider
     * @return boolean depending on the situation
     *         true if it happens
     *         false otherwise
     */
    // Método genérico para colisão (será sobrescrito pelas subclasses)
    abstract boolean collides(Colisor colisor);

    // Métodos para Double Dispatch
    abstract boolean collidesWithCircle(Circle circle);
    abstract boolean collidesWithPolygon(Polygon polygon);

    /**
     * Method to move the given object
     * @param point
     */
    public abstract void move(Point point);

    /**
     * Method toString
     * @return specific string format
     *         depending on the invoker
     */
    public abstract String toString();

}
