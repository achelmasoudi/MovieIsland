package Model;

public class RomanticMovie {

    private String nameOfRomanticMovie;
    private String imageURL_romantic;
    private String videoURL_romantic;

    public RomanticMovie() {
    }

    public RomanticMovie(String nameOfRomanticMovie, String imageURL_romantic, String videoURL_romantic) {
        this.nameOfRomanticMovie = nameOfRomanticMovie;
        this.imageURL_romantic = imageURL_romantic;
        this.videoURL_romantic = videoURL_romantic;
    }

    public String getNameOfRomanticMovie() {
        return nameOfRomanticMovie;
    }

    public void setNameOfRomanticMovie(String nameOfRomanticMovie) {
        this.nameOfRomanticMovie = nameOfRomanticMovie;
    }

    public String getImageURL_romantic() {
        return imageURL_romantic;
    }

    public void setImageURL_romantic(String imageURL_romantic) {
        this.imageURL_romantic = imageURL_romantic;
    }

    public String getVideoURL_romantic() {
        return videoURL_romantic;
    }

    public void setVideoURL_romantic(String videoURL_romantic) {
        this.videoURL_romantic = videoURL_romantic;
    }
}
