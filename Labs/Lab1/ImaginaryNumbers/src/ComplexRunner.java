public class ComplexRunner {
    public static void main(String[] args) throws Exception {
        Complex answer = new Complex();
        Complex c1 = new Complex(7,4);
        Complex c2 = new Complex(23,-12);
        answer.addComplex(c1,c2); //expected 30-8i
        Complex c3 = new Complex(7,4);
        Complex c4 = new Complex(23,-12);
        answer.subtractComplex(c3, c4); //expected -16 + 16i
        Complex c5 = new Complex(1,2);
        Complex c6 = new Complex(2,3);
        answer.multiplyComplex(c5, c6); // -4 + 7i
        Complex c7 = new Complex(-3,5);
        Complex c8 = new Complex(-5,-6);
        answer.addComplex(c7, c8);
        Complex c9 = new Complex(-3,5);
        Complex c10 = new Complex(-5,-6);
        answer.subtractComplex(c9, c10);
        Complex c11 = new Complex(2,4);
        Complex c12 = new Complex(2,4);
        answer.multiplyComplex(c11, c12);
    }


    //c1.addComplex(c1,c2);
        // c1.getReal return 3 because 1 + 2;
        // c1.getImag return 5 because 2 + 3;
        // To do multiplication you have to FOIL
        // (1+2i) (2+3i)
        // c1.getreal,c1.getimag c2.getreal, c2.getimag
        // (1*2)+(1*3i)+(2i*2)+(2i,3i)
        // 2+3i+4i+6i^2 i^2 == -1, 2 + 3i + 4i + -6
        //  -4 + 7i
        // Printing 
    /**
     * This method swaps two song objects by using shadow copy
     * @param s1 First song object
     * @param s2 Second song object
     */
}
