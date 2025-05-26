import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameEngine engine = new GameEngine();
        ArrayList<Double> velocities = new ArrayList<>();

        int f = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            ITransform transform = new Transform(new Point(sc.nextDouble(), sc.nextDouble()),
                    sc.nextInt(), sc.nextDouble(), sc.nextDouble());
            sc.nextLine();

            String colliderLine = sc.nextLine();
            String[] colliderParts = colliderLine.split(" ");
            ArrayList<Double> values = new ArrayList<>();

            for (String value : colliderParts) {
                values.add(Double.parseDouble(value));
            }

            ICollider collider;
            if (values.size() == 3) {
                collider = new Circle(new Point(values.get(0), values.get(1)), values.get(2));
            } else if (values.size() >= 6 && values.size() % 2 == 0) {
                ArrayList<Point> points = new ArrayList<>();
                for (int j = 0; j < values.size(); j += 2) {
                    points.add(new Point(values.get(j), values.get(j + 1)));
                }
                collider = new Polygon(points);
            } else {
                throw new IllegalArgumentException("INVALID COLLIDER ARGUMENTS\n");
            }

            String velocity = sc.nextLine();
            String[] velocityParts = velocity.split(" ");
            double dx = Double.parseDouble(velocityParts[0]);
            double dy = Double.parseDouble(velocityParts[1]);
            int dLayer = Integer.parseInt(velocityParts[2]);
            double dAngle = Double.parseDouble(velocityParts[3]);
            double dScale = Double.parseDouble(velocityParts[4]);
            velocities.add(dx);
            velocities.add(dy);
            velocities.add((double) dLayer);
            velocities.add(dAngle);
            velocities.add(dScale);

            GameObject gameObject = new GameObject(name, transform, collider);
            Point delta = new Point(transform.position().getX() - collider.centroid().getX(),
                    transform.position().getY() - collider.centroid().getY()); //SEQ DÁ PARA USAR O MOVETO
            collider.move(delta);
            collider.rotate(transform.angle());
            collider.scale(transform.scale());

            engine.add(gameObject);
        }

        ArrayList<GameObject> gameObjects = engine.getLoadedObjects();
        //System.out.println(gameObjects);

        for (int frame = 0; frame < f; frame++) {
            for (int i = 0; i < gameObjects.size(); i++) {
                GameObject go = gameObjects.get(i);
                int base = i * 5;
                double dx = velocities.get(base);
                double dy = velocities.get(base + 1);
                int dlayer = velocities.get(base + 2).intValue();
                double dAngle = velocities.get(base + 3);
                double dScale = velocities.get(base + 4);

                // Aplicar movimento
                Point deltaMove = new Point(dx, dy);
                go.move(deltaMove, dlayer);
                //go.collider().move(deltaMove);

                // Aplicar rotação
                go.rotate(dAngle);
                //go.collider().rotate(dAngle);

                // Aplicar escala (considerar fator multiplicativo)
                double oldScale = go.transform().scale();
                go.transform().scale(dScale);
                double newScale = go.transform().scale();
                double scaleFactor = newScale / oldScale;
                go.collider().scale(scaleFactor);
            }
            //System.out.println(gameObjects);
        }

        // Detetar colisões
        List<List<String>> collisions = new ArrayList<>();
        for (int i = 0; i < gameObjects.size(); i++) {
            collisions.add(new ArrayList<>());
        }

        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject go1 = gameObjects.get(i);
            for (int j = i + 1; j < gameObjects.size(); j++) {
                GameObject go2 = gameObjects.get(j);
                if (go1.transform().layer() == go2.transform().layer() && ((Colisor) go1.collider()).collides((Colisor) go2.collider())) {
                    collisions.get(i).add(go2.name());
                    collisions.get(j).add(go1.name());
                }
            }
        }

        // Gerar saída
        for (int i = 0; i < gameObjects.size(); i++) {
            List<String> collidedNames = collisions.get(i);
            if (collidedNames.isEmpty()) continue;

            System.out.print(gameObjects.get(i).name());
            for (String name : collidedNames) {
                System.out.print(" " + name);
            }
            System.out.println();
        }
    }
}