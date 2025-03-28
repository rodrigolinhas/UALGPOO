import java.util.ArrayList;

/**
 * This class represent a polygon witch contains 3 or more points
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version March 27, 2025
 */

public class Polygon extends Collider {

    private ArrayList<Point> points;
    private ArrayList<LineSegment> segments;
    private Point centroid;

    /**
     * Constructs a polygon from a list of points
     * @param points the list of vertices of the polygon
     * @throws IllegalArgumentException if the provided point amount is less than 3,
     * or if three consecutive points are collinear
     */
    public Polygon(ArrayList<Point> points)
    {
        int size = points.size();
        if (size < 3) throw new IllegalArgumentException();
        this.points = points;
        this.segments = new ArrayList<>();

        // Criar segmentos conectando os pontos
        for (int i = 0; i < points.size(); i++) {
            segments.add(new LineSegment(points.get(i), points.get((i + 1) % points.size())));
        }
        if (size == 3)
        {
            if (new Line(points.getFirst(), points.get(1)).contains(points.getLast())) throw new IllegalArgumentException();
        }
        else
        {
            for (int i = 0; i < points.size(); i++)
            {
                if (new Line(points.get(i), points.get((i + 1) % size)).contains(points.get((i + 2) % size))) throw new IllegalArgumentException();
            }
        }

        double area = 0, cx = 0, cy = 0;
        int n = points.size();
        for (int i = 0; i < n; i++)
        {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % n);
            double cross = p1.getX() * p2.getY() - p2.getX() * p1.getY();
            area += cross;
            cx += (p1.getX() + p2.getX()) * cross;
            cy += (p1.getY() + p2.getY()) * cross;
        }

        area /= 2;
        cx /= (6 * area);
        cy /= (6 * area);
        centroid = new Point(cx, cy);
    }

    /**
     * Getter points
     * @return points
     *
     */
    public ArrayList<Point> getPoints() {
        return points;
    }

    /**
     * Getter segments
     * @return segments
     *
     */
    public ArrayList<LineSegment> getSegments() {
        return segments;
    }

    /**
     * Method to check contains a certain point
     * @param point
     * @return true if contains
     *         false otherwise
     */
    public boolean contains(Point point) {
        Line line;
        for (LineSegment seg : segments) {
            if (seg.contains(point)) return true;
            line = new Line(point, seg);
            boolean b = false;
            for (LineSegment other : segments) if (line.intersects(other)) {
                b = true;
                break;
            }
            if (!b) return false;
        }
        return true;
    }

    /**
     * Simple method to check if collide with another collider
     * @return boolean depending on the situation
     *         true if it happens
     *         false otherwise
     */
    @Override
    boolean collides(Collider collider)
    {
        if (collider instanceof Circle) return collider.collides(this);
        if (collider instanceof Polygon polygon)
        {
            for (Point p : points) if (polygon.contains(p)) return true;
            for (LineSegment s : segments) {
                boolean b = false;
                for (LineSegment ss : polygon.segments) {
                    System.out.println(s + " / " + ss);
                    if (s.intersects(ss)) {
                        b = true;
                        break;
                    }
                }
                if (b) return true;
            }
        }
        return false;
    }

    /**
     * Method to move a certain point
     * @param point
     */
    @Override
    public void move(Point point)
    {
        for (Point p : points)  p.move(point);
        centroid.move(point);
    }

    /**
     * Method to calculate the centroid
     * @return centroid point
     */
    @Override
    public Point centroid() {
        return centroid;
    }

    /**
     * Method to rotate a certain angle
     * @param angle
     */
    @Override
    public void rotate(double angle) {
        Point centroid = centroid();
        double cx = centroid.getX();
        double cy = centroid.getY();
        double radians = Math.toRadians(angle);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);

        for (Point p : points) {
            double xOffset = p.getX() - cx;
            double yOffset = p.getY() - cy;
            double newX = cx + (xOffset * cos - yOffset * sin);
            double newY = cy + (xOffset * sin + yOffset * cos);
            p.move(new Point(newX - p.getX(), newY - p.getY()));
        }
    }

    /**
     * Method to scale the polygon
     * @param scale
     */
    @Override
    public void scale(double scale) {
        if (scale <= 0) throw new IllegalArgumentException();
        double cx = centroid.getX();
        double cy = centroid.getY();
        for (Point p : points) {
            double dx = (p.getX() - cx) * (scale - 1);
            double dy = (p.getY() - cy) * (scale - 1);
            p.move(new Point(dx, dy));
        }
    }

    /**
     * Method to scale the polygon
     * @return string
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Point p : points) {
            sb.append(p.toString()).append(" ");
        }
        return sb.toString().trim();
    }
}