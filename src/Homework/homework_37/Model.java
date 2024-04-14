package lessons.src.Homework.homework_37;


import java.io.*;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Model {
    private Map<String, Films> films;
    private String dataFile;

    public Model() {
        this.dataFile = "Films.txt";
        this.films = loadData();
    }
    public void addFilm(Map newFilm){
        Films film = new Films(newFilm);
        films.put((String) newFilm.get("название фильма"), film);
    }
    public Collection getFilms(){
        return films.values();
    }
    public Map getOneFilm (String filmName) {
        Films film = this.films.get(filmName);
        Map<String, String> chosenFilm = new LinkedHashMap<>();
        chosenFilm.put("название фильма", film.getName());
        chosenFilm.put("жанр", film.getGenre());
        chosenFilm.put("режиссер", film.getProducer());
        chosenFilm.put("год выпуска", film.getYear());
        chosenFilm.put("длительность", film.getDuration());
        chosenFilm.put("студия", film.getStudio());
        chosenFilm.put("актеры", film.getActors());
        return chosenFilm;
    }
    public LinkedHashMap loadData(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.dataFile))) {
            return (LinkedHashMap) ois.readObject();
        } catch (Exception ex) {
            return new LinkedHashMap<>();
        }
    }
    public Films removeFilm (String filmName){
        return films.remove(filmName);
    }
    public void saveData(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.dataFile))) {
            oos.writeObject(this.films);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
class Films implements Serializable{
    private String name;
    private String genre;
    private String producer;
    private String year;
    private String duration;
    private String studio;
    private String actors;

    public Films(Map filmInfo) {
        this.name = (String) filmInfo.get("название фильма");
        this.genre = (String) filmInfo.get("жанр");
        this.producer = (String) filmInfo.get("режиссер");
        this.year = (String) filmInfo.get("год выпуска");
        this.duration = (String) filmInfo.get("длительность");
        this.studio = (String) filmInfo.get("студия");
        this.actors = (String) filmInfo.get("актеры");
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getProducer() {
        return producer;
    }

    public String getYear() {
        return year;
    }

    public String getDuration() {
        return duration;
    }

    public String getStudio() {
        return studio;
    }

    public String getActors() {
        return actors;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.producer + ", " + this.year + ")";
    }
}
