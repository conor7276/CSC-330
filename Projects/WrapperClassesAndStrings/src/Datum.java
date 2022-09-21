public class Datum {
    private String ssn;
    private int ccCode;
    private String phoneNum;
    private String word;

    public Datum(String s, int c, String p, String w){
        ssn = s;
        ccCode = c;
        phoneNum = p;
        word = w;
    }
    public int getCcCode() {
        return ccCode;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public String getSsn() {
        return ssn;
    }
    public String getWord() {
        return word;
    }
    public void setCcCode(int ccCode) {
        this.ccCode = ccCode;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public String toString(){
        String s = "";
        s += "Social Security Number: " + ssn + "\n";
        s += "Secret Credit card code: " + ccCode + "\n";
        s += "Phone Number: " + phoneNum + "\n";
        s += "Some random word: " + word + "\n";
        return s;
    }
}
