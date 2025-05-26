import java.util.Locale;
import java.util.Objects;

import static java.lang.Math.*;

/**
 * This class represents a simple Point in 2D.
 * @author Ricardo Rodrigues
 * @author Rodrigo Linhas
 * @author Tiago Tome
 * @version March 26, 2025
 */
public class Point
{
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the abscissa of the Point.
     * @return x -> abscissa of a Point
     */
    public double getX() { return this.x; }

    /**
     * Returns the ordinate of the Point.
     * @return y -> ordinate of a Point
     */
    public double getY() { return this.y; }

    /**
     * Response method to do a translation in one Point.
     * @param point, coordinates x and y to add to this.point
     */
    public void move(Point point)
    {
        this.x += point.x;
        this.y += point.y;
    }

    /**
     * Response method to calculate distance between two Points.
     * @param point, point to calculate distance
     * @return distance between point and this.point
     */
    public double dist(Point point)
    {
        return sqrt(pow(this.x - point.x, 2) + pow(this.y - point.y, 2));
    }

    /**
     * Response method to put the information of a point on a string with this format: (x,y)
     * @return string that contains all info about a point
     */
    @Override
    public String toString() {
        return  "(" + String.format(Locale.US,"%.2f", x) + "," + String.format(Locale.US,"%.2f", y) + ")";
    }

    /**
     * Response method to see if one Point its equal to this.
     * @param obj
     * @return a boolean, if its equal return true, otherwise return false.
     */
    @Override
    public boolean equals(Object obj)
    {
        return obj instanceof Point p && x == p.x && y == p.y;
    }

    /**
     * This method is necessary to pass in mooshak.
     * @return hashcode of a Point based on its coordinates(x,y).
     */
    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    /**
     * Rotates the point around a specified center by a given angle in degrees.
     * @param angleDegrees The rotation angle in degrees.
     * @param center The center point around which to rotate.
     */
    public void rotate(double angleDegrees, Point center) {
        double radians = toRadians(angleDegrees);
        double cos = cos(radians);
        double sin = sin(radians);

        // Translacao o ponto para a origem relativa ao centro
        double translatedX = this.x - center.getX();
        double translatedY = this.y - center.getY();

        // Aplica a rotacao
        double rotatedX = translatedX * cos - translatedY * sin;
        double rotatedY = translatedX * sin + translatedY * cos;

        // Translacao de volta para a posicao original
        this.x = center.getX() + rotatedX;
        this.y = center.getY() + rotatedY;
    }
}
