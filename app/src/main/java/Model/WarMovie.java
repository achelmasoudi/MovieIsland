package Model;

public class WarMovie {

    private String nameOfWarMovie;
    private String imageURL_war;
    private String videoURL_war;

    public WarMovie() {
    }

    public WarMovie(String nameOfWarMovie, String imageURL_war, String videoURL_war) {
        this.nameOfWarMovie = nameOfWarMovie;
        this.imageURL_war = imageURL_war;
        this.videoURL_war = videoURL_war;
    }

    public String getNameOfWarMovie() {
        return nameOfWarMovie;
    }

    public void setNameOfWarMovie(String nameOfWarMovie) {
        this.nameOfWarMovie = nameOfWarMovie;
    }

    public String getImageURL_war() {
        return imageURL_war;
    }

    public void setImageURL_war(String imageURL_war) {
        this.imageURL_war = imageURL_war;
    }

    public String getVideoURL_war() {
        return videoURL_war;
    }

    public void setVideoURL_war(String videoURL_war) {
        this.videoURL_war = videoURL_war;
    }
}
