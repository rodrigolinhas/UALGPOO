/**
 * The {@code IGameObject} interface stores information about
 * an object's position, layer, angle and scale.
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version March 25, 2025
 */
public interface IGameObject {
    /**
     * Returns the name of the GameObject.
     * @return the name of the GameObject.
     */
    String name();

    /**
     * Returns the Transform of the GameObject.
     * @return the Transform of the GameObject.
     */
    ITransform transform();

    /**
     * Returns the Collider of the GameObject.
     * <p>The centroid will always lie at {@code this.transform().position()}.
     * @return the Collider of the GameObject.
     */
    ICollider collider();
}