package lessons.src.Homework.homework_37;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    Scanner input = new Scanner(System.in);

    public String Menu() {
        System.out.println("============ Редактирование данных каталога фильма ============");
        System.out.println("Действия с фильмами:");
        System.out.println("1 - добавление фильма" + "\n2 - каталог фильмов" + "\n3 - просмотр определенного фильма" + "\n4 - удаление фильма" + "\nq - выход из программы");
        System.out.print("Выберите вариант действия: ");
        String point = input.nextLine();

        System.out.println("======================================================");
        return point;
    }
    public Map addNewFilm(){
        Map<String, String> newFilm = new LinkedHashMap<>();
        newFilm.put("название фильма", "");
        newFilm.put("жанр", "");
        newFilm.put("режиссер", "");
        newFilm.put("год выпуска", "");
        newFilm.put("длительность", "");
        newFilm.put("студия", "");
        newFilm.put("актеры", "");
        System.out.println("============ Добавление фильма ============");
        newFilm.forEach((key, value) -> {
            System.out.print("Введите данные фильма: " + key + " -> ");
            newFilm.put(key, input.nextLine());
        });
        System.out.println("============================================");
        return newFilm;
    }
    public void showFilms(Collection films){
        System.out.println("============ Каталог фильмов ============");
        films.forEach((film) -> System.out.println(film));
        System.out.println("=========================================");
    }
    public String getChosenFilm(){
        System.out.println("============ Ввод названия фильма ============");
        System.out.print("-> ");
        String chosenFilm = input.nextLine();
        System.out.println("==============================================");
        return chosenFilm;
    }
    public void showChosenFilm(Map film){
        System.out.println("============ Просмотр информации о фильме ============");
        film.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println("======================================================");
    }
    public void showIncorrectFilm(String filmName){
        System.out.println("============ Сообщение об ошибке ============");
        System.out.println("Фильма с названием '" + filmName + "' не существует");
        System.out.println("=============================================");
    }
    public void removeOneFilm(String filmName){
        System.out.println("============ Удаление фильма ============");
        System.out.println("Фильма '" + filmName + "' удален");
        System.out.println("=========================================");
    }
}
