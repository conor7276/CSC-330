import java.io.ObjectInputStream.GetField;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private int copiesSold;
    Book(String title, String author, String publisher, int CopiesSold){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.copiesSold = copiesSold;
    }
    public String getAuthor() {
        return author;
    }
    public int getCopiesSold() {
        return copiesSold;
    }
    public String getPublisher() {
        return publisher;
    }
    public String getTitle() {
        return title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
