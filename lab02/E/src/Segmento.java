/*  Classe Ponto complementar para a classe Cliente
 *  responsável para inicializar  os pontos
 *  @author Rodrigo Linhas a83933
 *  @version 12/02/2025
 *  @inv pontos cartesianos SOMENTE no 1o quadrante
 *  @param o metodo construtor e o check recebem as coordenadas para os pontos polares (int x, int y)
 *  o metodo construtor e o check recebem as coordenadas para os pontos cartesianos (double r, double teta)
 *  @return metodo dist retorna o calculo da distancia entre 2 pontos
 *  o metodo getX e getY retornam eles mesmos
 *  @see https://mundoeducacao.uol.com.br/matematica/intersecao-reta-circunferencia.htm (formula da intersecao)
 *       https://tutoria.ualg.pt/2024/mod/resource/view.php?id=107599                   (refere os gets e checks)
 */
/* PROMPT USADO PARA AJUDAR NO METODO INTERSETA:
 * Tendo a seguinte formula da intersecao entre um circulo e uma reta,
 * faz um metodo que calcula o mesmo senão eu vou para o deepseek
 * (https://mundoeducacao.uol.com.br/matematica/intersecao-reta-circunferencia.htm)
 */
public class Segmento {
    private Ponto a;
    private Ponto b;

    public Segmento(Ponto a, Ponto b){
        check(a,b);
        this.a = a;
        this.b = b;
    }

    public boolean interseta(Circulo c){
        //verificacao
        //checkinterseta(c);
        double xa = this.a.getr() * Math.cos(this.a.getteta());
        double ya = this.a.getr() * Math.sin(this.a.getteta());
        double xb = this.b.getr() * Math.cos(this.b.getteta());
        double yb = this.b.getr() * Math.sin(this.b.getteta());
        double xc = c.getcenter().getr() * Math.cos(c.getcenter().getteta());
        double yc = c.getcenter().getr() * Math.sin(c.getcenter().getteta());
        // Coeficientes da equação da reta y=m*x+b
        double mReta = (yb-ya) / (xb-xa);
        double bReta = ya - mReta * xa;

        // Coeficientes da equação quadrática Ax^2 + Bx + C = 0
        // A => 1+m^2
        // B => -2*m*(b−x.centro)−2*y.centro
        // C => x.centro^2+(b−y.centro)^2−raio^2
        double A = 1 + mReta * mReta;
        double B = (-2*xc)+(2*mReta*(bReta-yc));
        double C = (xc*xc)+((bReta-yc)*(bReta-yc))-(c.getRaio()*c.getRaio());
        // Discriminante
        double delta = B * B - 4 * A * C;

        if (delta >= 0) return true;    // Há interseção
        else            return false;   // Não há interseção
    }

    private void checkinterseta(Circulo c){
        // Caso especial em que a reta é vertical (x=const)
        if (Math.abs(a.getr()-b.getr()) < Math.pow(10,-9)) {
            double xc = c.getcenter().getr() * Math.cos(c.getcenter().getteta());
            double distx = Math.abs(a.getr() - xc);
            if (distx <= c.getRaio()) System.out.println("1"); // Há interseção
            else                      System.out.println("0"); // Não há interseção
        }
    }

    private void check(Ponto a, Ponto b){
        if (a.getr() == b.getr() && a.getteta() == b.getteta()) {
            System.out.println("Segmento:vi");
            System.exit(0);
        }
    }
}
