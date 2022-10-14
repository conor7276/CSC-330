public class D extends B {
    private double q;
    protected double r;
    public void setQ(double q) {
        this.q = q;
    }
    public void setR(double r) {
        this.r = r;
    }
    public double getQ() {
        return q;
    }
    public double getR() {
        return r;
    }
    public double calc() {
        return r*q;
    };
}
