/*  Classe Ponto complementar para a classe Cliente
 *  responsável para inicializar  os pontos
 *  @author Rodrigo Linhas a83933
 *  @version 11/02/2025
 *  @inv pontos polares e cartesianos SOMENTE no 1o quadrante
 *  @param o metodo construtor e o check recebem as coordenadas para os pontos polares (int x, int y)
 *  o metodo construtor e o check recebem as coordenadas para os pontos cartesianos (double r, double teta)
 *  @return metodo dist retorna o calculo da distancia entre 2 pontos
 *  o metodo getX e getY retornam eles mesmos
 *  @see https://tutoria.ualg.pt/2024/mod/resource/view.php?id=107599 (refere os gets e checks)
 */

class Ponto {
    private double r, teta;
    //private int x,y;

    public Ponto(double r, double teta) {
        //verificacao
        check(r, teta);
        this.r = r;
        this.teta = teta;
    }

    public Ponto(int x, int y){
        //verificacao
        check(x, y);
        this.r = Math.sqrt((x*x)+(y*y));
        this.teta = Math.atan2(y,x);
    }

    public double getr(){
        return this.r;
    }
    public double getteta(){
        return this.teta;
    }

    public double dist (Ponto that) {
        return Math.sqrt(this.r*this.r + that.r*that.r
                - 2*this.r*that.r*Math.cos(Math.toRadians(that.teta)-Math.toRadians(this.teta)));
    }

    private void check(int x, int y){
        if (x<0||y<0) {
            System.out.println("Ponto:vi");
            System.exit(0);
        }
    }

    private void check(double r, double teta){
        if (r>10 || teta<0 || teta>90 ) {
            System.out.println("iv");
            System.exit(0);
        }
    }
}