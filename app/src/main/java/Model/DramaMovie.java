package Model;

public class DramaMovie {

    private String nameOfDramaMovie;
    private String imageURL_drama;
    private String videoURL_drama;

    public DramaMovie() {
    }

    //Constructor Of DramaMovie Class
    public DramaMovie(String pNameOfDramaMovie , String pImageURL_drama , String pVideoURL_drama) {
        this.nameOfDramaMovie = pNameOfDramaMovie;
        this.imageURL_drama = pImageURL_drama;
        this.videoURL_drama = pVideoURL_drama;
    }

    //Name Of Movie (Setter and Getter)
    public void setNameOfDramaMovie(String pNameOfDramaMovie) {
        this.nameOfDramaMovie = pNameOfDramaMovie;
    }
    public String getNameOfDramaMovie() {
        return this.nameOfDramaMovie;
    }

    //Drama Image URL Of Movie (Setter and Getter)
    public void setImageURL_drama(String pImageURL_drama) {
        this.imageURL_drama = pImageURL_drama;
    }
    public String getImageURL_drama() {
        return this.imageURL_drama;
    }

    //Drama Video URL Of Movie (Setter and Getter)
    public void setVideoURL_drama(String pVideoURL_drama) {
        this.videoURL_drama = pVideoURL_drama;
    }
    public String getVideoURL_drama() {
        return this.videoURL_drama;
    }



}
