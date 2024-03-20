package Model;

public class MobstersMovie {

    private String nameOfMobstersMovie;
    private String imageURL_mobsters;
    private String videoURL_mobsters;

    public MobstersMovie() {
    }

    public MobstersMovie(String nameOfMobstersMovie, String imageURL_mobsters, String videoURL_mobsters) {
        this.nameOfMobstersMovie = nameOfMobstersMovie;
        this.imageURL_mobsters = imageURL_mobsters;
        this.videoURL_mobsters = videoURL_mobsters;
    }

    public String getNameOfMobstersMovie() {
        return nameOfMobstersMovie;
    }

    public void setNameOfMobstersMovie(String nameOfMobstersMovie) {
        this.nameOfMobstersMovie = nameOfMobstersMovie;
    }

    public String getImageURL_mobsters() {
        return imageURL_mobsters;
    }

    public void setImageURL_mobsters(String imageURL_mobsters) {
        this.imageURL_mobsters = imageURL_mobsters;
    }

    public String getVideoURL_mobsters() {
        return videoURL_mobsters;
    }

    public void setVideoURL_mobsters(String videoURL_mobsters) {
        this.videoURL_mobsters = videoURL_mobsters;
    }
}
