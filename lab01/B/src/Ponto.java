class Ponto {
    private double x, y;
    public Ponto(double x, double y) {
        //verificacoes
        if(x>10||y<0||y>90) {System.out.print("iv");
            System.exit(0);
        }
        this.x=x;
        this.y=y;
    }
    public double dist (Ponto that) {
        double xa = this.x;
        double xb = that.x;
        double ya = this.y;
        double yb = that.y;
        return Math.sqrt(xa*xa + xb*xb - 2*xa*xb*Math.cos(Math.toRadians(yb)-Math.toRadians(ya)));
    }
}