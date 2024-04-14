package lessons.src.Homework.homework_37;


import java.util.Collection;
import java.util.Map;

public class Controller {
    private Model filmModel;
    private View userInterface;

    public Controller() {
        this.filmModel = new Model();
        this.userInterface = new View();
    }

    public void run() {
        String answer = "";
        while (!answer.equals("q")) {
            answer = this.userInterface.Menu();
            checkUserChoice(answer);
        }
    }
    public void checkUserChoice(String answer){
        if (answer.equals("1")){
            Map film = this.userInterface.addNewFilm();
            this.filmModel.addFilm(film);
        } else if (answer.equals("2")){
            Collection films = this.filmModel.getFilms();
            this.userInterface.showFilms(films);
        } else if (answer.equals("3")){
            String filmChosen = this.userInterface.getChosenFilm();
            try {
                Map film = this.filmModel.getOneFilm(filmChosen);
                this.userInterface.showChosenFilm(film);
            } catch (NullPointerException npe){
                this.userInterface.showIncorrectFilm(filmChosen);
            }
        } else if (answer.equals("4")){
            String filmName = this.userInterface.getChosenFilm();
            Films film = this.filmModel.removeFilm(filmName);
            this.userInterface.removeOneFilm(filmName);
        } else if (answer.equals("q")) {
            this.filmModel.saveData();
        } else {
            System.out.println("Введен некорректный пункт меню! Повторите ввод");
        }
    }
}
