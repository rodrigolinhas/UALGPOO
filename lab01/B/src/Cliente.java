import java.util.Scanner;
public class Cliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        Ponto c = new Ponto(x, y);
        Ponto d = new Ponto(x1, y1);
        System.out.print((int) c.dist(d));
        sc.close();
    }
}