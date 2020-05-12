import java.util.ArrayList;
import java.util.List;

public class BaseMv {
    private String directorName;
    private String title;
    private int year;
    private List<String> genre;

    public BaseMv(){

    }
    public BaseMv(String title, int year,String dirName){
        this.directorName = dirName;
        this.title = title;
        this.year = year;
    }

    public BaseMv(String title, int year, String dirName, ArrayList<String> genre){
        this.directorName = dirName;
        this.title = title;
        this.year = year;
        this.genre = genre;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "BaseMv{" +
                "directorName='" + directorName + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", genre=" + genre +
                '}';
    }


}
