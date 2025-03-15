/*  Classe Circulo complementar para a classe Cliente
 *  responsável para o calculo do perimetro do circulo com a informacao recebida
 *  @author Rodrigo Linhas a83933
 *  @version 11/02/2025
 *  @inv mesmo que o do Ponto (pontos polares e cartesianos SOMENTE no 1o quadrante)
 *  @param o metodo perimetro recebe a variavel raio do tipo double
 *  @return o metodo perimetro retorna o calculo do mesmo
 *  @see https://mundoeducacao.uol.com.br/matematica/perimetro-circulo.htm (Formula)
 *       https://tutoria.ualg.pt/2024/mod/resource/view.php?id=107599      (refer o check)
 */
import java.lang.Math;

public class Circulo {
    private Ponto a;
    private double raio;

    public Circulo(Ponto a, double raio){
        //verificacao
        check(a, raio);
        this.a=a;
        this.raio=raio;
    }

    public int perimetro()  {return (int)(2*Math.PI*this.raio);}

     private void check(Ponto a, double raio){
        double x = (a.getr()*Math.cos(a.getteta()));
        double y = (a.getr()*Math.sin(a.getteta()));
        if (raio <= 0 || x < raio-Math.pow(10,-9) || y < raio-Math.pow(10,-9)) {
            System.out.println("Circulo:vi");
            System.exit(0);
        }
    }
}
