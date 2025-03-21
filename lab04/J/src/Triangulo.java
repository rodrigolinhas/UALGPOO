
public class Triangulo extends Poligono {

    public Triangulo(String pontosAsString)
    {
        super("3 " + pontosAsString);
        String[] parts = pontosAsString.split(" ");
        if (parts.length != 6){
            System.out.println("Triangulo:vi");
            System.exit(0);
        }
    }

    //Triangulo: [(x1,y1), (x2,y2), (x3,y3)]
    @Override
    public String toString() {
        return "Triangulo: [" + vertices.get(0) + ", " + vertices.get(1) + ", " + vertices.get(2) + "]";
    }
}