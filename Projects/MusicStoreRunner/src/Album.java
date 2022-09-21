public class Album {
    private Song[] allSongs;
    private String title;
    private String artist;
// no default constructor **that we code**
    public Album(Song[] songs, String t, String a){
        allSongs = songs;
        title = t;
        artist = a;
    }
    // Only getters because we don't want people changing this information
    public String getArtist(){
        return artist;
    }
    public String getTitle(){
        return title;
    }
    public Song getSong(int index){
        return allSongs[index];
    }
    public double getPrice(){
        double total = 0;
        for( int i = 0; i < allSongs.length; i++){
            total += allSongs[i].getPrice();
        }
        /* Be careftul no index means you cannot change specific items
         * for(Song s : allSongs){
         *      total += s.getPrice();
         *      
         * } 
         */
        return total;
    }

    public String toString(){
        String s = "";
        s += "Title: " + title + "\n";
        s += "Artist: " + artist + "\n";
        // Now we print the Songs
        for(int i = 0; i < allSongs.length; i++){
            s+= "Song " + (i+1) + "\n";
            // s+= allSongs[i].getTitle(); dont do that you wrote code for this
            s += allSongs[i].toString();
            s += "\n";
        }
        

        return s;
    }

}
