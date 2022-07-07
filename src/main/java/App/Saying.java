package App;

public class Saying {
    int id;
    String words;
    String author;


    public Saying(int id, String words, String author) {
        this.id = id;
        this.words = words;
        this.author = author;

    }
    @Override
    public String toString() {
        return "Saying{" +
                "id=" + id +
                ", words='" + words + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
