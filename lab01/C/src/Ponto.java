class Ponto {
    private double r, teta;
    public Ponto(double r, double teta) {
        //verificacoes
        check(r, teta);
        this.r = r;
        this.teta = teta;
    }
    public double dist (Ponto that) {
        return Math.sqrt(this.r*this.r + that.r*that.r
                - 2*this.r*that.r*Math.cos(Math.toRadians(that.teta)-Math.toRadians(this.teta)));
    }
    private void check(double r, double teta){
        if (r>10 || teta<0 || teta>90 ) {
            System.out.print("iv");
            System.exit(0);
        }
    }
}