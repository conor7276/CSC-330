public class Song {
    private String title;
    private double duration;
    private String artist;
    private double price;

    /**
     * 
     * 
     * returns the title for this song
     * @return the title for this song
     */
    public String getTitle(){
        return title;
    }
    public double getPrice(){
        return price;
    }
    /**
     * 
     * @param artist the artist to be set for this album
     */
    public String getArtist(){
        return artist;
    }
    public double getDuration(){
        return duration;
    }
    public void setTitle(String t){
        title = t;
    }
    public void setArtist(String a){
        artist = a;
    }
    public void setPrice(double p){
        price = p;
    }
    public void setDuration(double d){
        duration = d;
    }

    public Song(){
        title = "Why Didn't You Give a Real Value";
        artist = "Dummy";
        duration = 99999;
        price = -1.00;
    }
    public Song(String t, String a, double d, double p){
        title = t;
        artist = a;
        duration = d;
        price = p;
    }
    
    /* Every object has a toString method, which tells Java how to print this object in a print/println call */
    public String toString(){
        String s = "";
        s += "Title: " + title + "\n";
        s += "Artist: " + artist + "\n";
        s += "Duration: " + duration + "\n";
        s += "Price: " + price + "\n";
        return s;
    }

    public boolean compareTo(Song otherSong){
        return this.title == otherSong.title;
    }
}
