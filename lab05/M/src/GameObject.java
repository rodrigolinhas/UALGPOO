/**
 * This class represents GameObjects in 2D.
 * <p>It implements the IGameObject and encapsulates the object´s name,
 * its transform (layer,position, angle, scale) and its collider.
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version March 27, 2025
 */
public class GameObject implements IGameObject
{
    private String name;
    private ITransform transform;
    private ICollider collider;

    /**
     * Constructor to class GameObject, create an instance of GameObject (see description of class).
     * @param name
     * @param transform
     * @param collider
     */
    public GameObject(String name, ITransform transform, ICollider collider)
    {
        this.name = name;
        this.transform = transform;
        this.collider = collider;
    }

    /**
     * Returns the name of the GameObject.
     * @return String with the name of the GameObject
     */
    @Override
    public String name() { return name; }

    /**
     * Response method to obtain the transform associate with this GameObject
     * The transform contains all the transformation info, including: position, layer, rotation angle, and scale factor.
     * @return an instance of ITransform that represents this GameObject´s transform.
     */
    @Override
    public ITransform transform() { return transform; }

    /**
     * Obtain the collider associate with this GameObject.
     * @return an instance of ICollider that represents this GameObject´s collider.
     */
    @Override
    public ICollider collider() { return collider; }
}
