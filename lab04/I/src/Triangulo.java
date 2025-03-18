
public class Triangulo extends FiguraGeometrica {
    private Ponto p1, p2, p3;
    public Triangulo(Ponto p1, Ponto p2, Ponto p3) {
        check(p1,p2,p3);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }


    private void check(Ponto a, Ponto b){
        if (a.equals(b)) {
            System.out.println("Triangulo:vi");
            System.exit(0);
        }

}

    //Triangulo: [(x1,y1), (x2,y2), (x3,y3)]
    @Override
    public String toString() {
        return "Triangulo: " + "[" p1 + ", " + p2 + ", " + p3 + "]";
    }
