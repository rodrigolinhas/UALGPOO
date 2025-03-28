import java.util.ArrayList;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        ITransform transform = new Transform(new Point(sc.nextDouble(), sc.nextDouble()),
                sc.nextInt(), sc.nextDouble(), sc.nextDouble());
        sc.nextLine(); //consumir a quebra de linha

        String colliderLine = sc.nextLine();
        String[] colliderParts = colliderLine.split(" ");
        ArrayList<Double> values = new ArrayList<>();

        for(String value : colliderParts)
        {
            values.add(Double.parseDouble(value));
        }

        ICollider collider;
        if (values.size() == 3)
        {
            collider = new Circle(new Point(values.get(0), values.get(1)), values.get(2));
        }
        else if(values.size() >= 6 && values.size() % 2 == 0)
        {
            ArrayList<Point> points = new ArrayList<>();
            for (int i = 0; i < values.size(); i+=2)
            {
                points.add(new Point(values.get(i), values.get(i + 1)));
            }
            collider = new Polygon(points);
        }
        else
        {
            throw new IllegalArgumentException("INVALID COLLIDER ARGUMENTS\n");
        }

        GameObject gameObject = new GameObject(name, transform, collider);
        Point delta = new Point(transform.position().getX() - collider.centroid().getX(), transform.position().getY() - collider.centroid().getY());

        collider.move(delta);
        collider.rotate(transform.angle());
        collider.scale(transform.scale());

        System.out.println(gameObject.name());
        System.out.println(transform);
        System.out.println(collider);
    }
}
