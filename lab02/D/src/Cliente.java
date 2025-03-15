/*  Classe Cliente responsável para correr o programa
 *  @author Rodrigo Linhas a83933
 *  @version 11/02/2025
 *  @inv o mais clean possível
 *  @param N/A
 *  @return N/A
 *  @see https://tutoria.ualg.pt/2024/mod/resource/view.php?id=109713 (explica com mais detalhes o inv referido)
 */

import java.util.Scanner;
public class Cliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ponto a = new Ponto(sc.nextInt(), sc.nextInt());
        double raio = sc.nextDouble();
        Circulo c = new Circulo(a,raio);
        System.out.println(c.perimetro());
        sc.close();
    }
}