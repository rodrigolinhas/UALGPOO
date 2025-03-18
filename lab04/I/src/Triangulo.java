
public class Triangulo extends FiguraGeometrica {
    private Ponto p1, p2, p3;
    public Triangulo(Ponto p1, Ponto p2, Ponto p3) {
        check(p1,p2,p3);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    private void check(Ponto p1, Ponto p2, Ponto p3) {
        Segmento s1 = new Segmento(p1, p2);
        Segmento s2 = new Segmento(p2, p3);
        Segmento s3 = new Segmento(p3, p1);
        double a = s1.anginterseta(s2);
        double b = s2.anginterseta(s3);
        double c = s3.anginterseta(s1);
        if (a + b + c != 180) {
            System.out.println("Triangulo:vi");
            System.exit(0);
        }
    }

    //Triangulo: [(x1,y1), (x2,y2), (x3,y3)]
    @Override
    public String toString() {
        return "Triangulo: " + "[" + p1 + ", " + p2 + ", " + p3 + "]";
    }

}

