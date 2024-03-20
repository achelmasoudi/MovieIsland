package Model;

public class ModelOfFireFragment {

    private String nameOfMovie_FireFragment;
    private String imageUri_FireFragment;
    private String backgroundUri_FireFragment;
    private String videoUri_FireFragment;

    public ModelOfFireFragment() {
    }

    public ModelOfFireFragment(String nameOfMovie_FireFragment, String imageUri_FireFragment, String backgroundUri_FireFragment, String videoUri_FireFragment) {
        this.nameOfMovie_FireFragment = nameOfMovie_FireFragment;
        this.imageUri_FireFragment = imageUri_FireFragment;
        this.backgroundUri_FireFragment = backgroundUri_FireFragment;
        this.videoUri_FireFragment = videoUri_FireFragment;
    }

    public String getNameOfMovie_FireFragment() {
        return nameOfMovie_FireFragment;
    }

    public void setNameOfMovie_FireFragment(String nameOfMovie_FireFragment) {
        this.nameOfMovie_FireFragment = nameOfMovie_FireFragment;
    }

    public String getImageUri_FireFragment() {
        return imageUri_FireFragment;
    }

    public void setImageUri_FireFragment(String imageUri_FireFragment) {
        this.imageUri_FireFragment = imageUri_FireFragment;
    }

    public String getBackgroundUri_FireFragment() {
        return backgroundUri_FireFragment;
    }

    public void setBackgroundUri_FireFragment(String backgroundUri_FireFragment) {
        this.backgroundUri_FireFragment = backgroundUri_FireFragment;
    }

    public String getVideoUri_FireFragment() {
        return videoUri_FireFragment;
    }

    public void setVideoUri_FireFragment(String videoUri_FireFragment) {
        this.videoUri_FireFragment = videoUri_FireFragment;
    }
}
