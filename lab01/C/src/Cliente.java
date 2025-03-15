import java.util.Scanner;
public class Cliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Caminho c = new Caminho();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            c.add(new Ponto(sc.nextDouble(),sc.nextDouble()));
        }
        System.out.print(String.format("%.2f", c.comprimento()));
        sc.close();
    }
}