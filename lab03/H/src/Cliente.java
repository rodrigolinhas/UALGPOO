import java.util.Scanner;
public class Cliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ponto p1 =  new Ponto(sc.nextInt(), sc.nextInt());
        Ponto p2 =  new Ponto(sc.nextInt(), sc.nextInt());
        Ponto p3 =  new Ponto(sc.nextInt(), sc.nextInt());
        Ponto p4 =  new Ponto(sc.nextInt(), sc.nextInt());
        Rectangulo r = new Rectangulo(p1,p2,p3,p4);
        Ponto p5 =  new Ponto(sc.nextInt(), sc.nextInt());
        Ponto p6 =  new Ponto(sc.nextInt(), sc.nextInt());
        Segmento s = new Segmento(p5,p6);
        if (r.intersecta(s))    System.out.println("1");
        else                    System.out.println("0");
    }
}