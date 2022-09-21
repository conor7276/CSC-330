public class Complex {
    // Complex number is in a + bi format
    double real;
    double imag;
    /**
     * Default Constructor no params
     */
    Complex(){
        this.real = 0;
        this.imag = 0;
    }
    /**
     * Constructor that should be used
     * @param real real number
     * @param imag imaginary number
     */
    Complex(double real, double imag){
        this.real = real;
        this.imag = imag;
    }
    /**
     * returns the objects real number
     * @return
     */
    public double getReal() {
        return real;
    }
    /**
     * returns the objects imaginary number
     * @return
     */
    public double getImag() {
        return imag;
    }
    /**
     * sets the objects imaginary number to the parameter
     * @param imag imaginary number : double
     */
    public void setImag(double imag) {
        this.imag = imag;
    }
    /**
     * sets the objects real  number to the parameter
     * @param real real number : double
     */
    public void setReal(double real) {
        this.real = real;
    }
    /**
     * adds the real numbers and imaginary numbers
     * @param c1 first combination of real and imaginary numbers
     * @param c2 second combination of real and imaginary numbers
     */
    public void addComplex(Complex c1, Complex c2){
        this.real = c1.real + c2.real;
        this.imag = c1.imag + c2.imag;
        toString("+");
    }
    /**
     * subtract the real numbers and imaginary numbers
     * @param c1 first combination of real and imaginary numbers
     * @param c2 second combination of real and imaginary numbers
     */
    public void subtractComplex(Complex c1, Complex c2){
        this.real = c1.real - c2.real;
        this.imag = c1.imag - c2.imag;
        toString("-");
    }
    /**
     * multiply the real numbers and imaginary numbers
     * @param c1 first combination of real and imaginary numbers
     * @param c2 second combination of real and imaginary numbers
     */
    public void multiplyComplex(Complex c1, Complex c2){
        double real1;//multiply real numbers
        double imag1;//multiply first real by second imag
        double imag2;//multiply first imag by first real
        double real2;//multiply first imag by second imag

        real1 = c1.real * c2.real;
        imag1 = c1.real * c2.imag;
        imag2 = c2.real * c1.imag;
        real2 = (c1.imag * c2.imag) * -1; // will always have a -1
        // combine real and imaginary numbers
        this.imag = imag1 + imag2;
        this.real = real1 + real2;

        toString("*");
    }
    /**
     * Print the real and imaginary numbers
     * @param sign the sign determines the layout of how the numbers are printed
     */
    public void toString(String sign){
        String s = "";
        if (sign == "*"){
            s = "The answer is " + this.real + " + " + this.imag + "i\n";
            
        }
        else if (sign == "-"){
            if(this.imag > 0){ // depending on the imag value a different sign needs to be used
                s = "The answer is " + this.real + " + "  + this.imag + "i\n";
            }
            else{
                s = "The answer is " + this.real + " - " + this.imag + "i\n";
            }
        }
        else{
            s = "The answer is " + this.real + " + "  + this.imag + "i\n";
        }
        System.out.print(s);
        
        
    }
}
