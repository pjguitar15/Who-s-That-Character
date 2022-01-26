import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Philcob Suzuki Josol
 */
public class Questions {
    LinkedList<Question> questions = new LinkedList<>();

    Questions() {
        questions.add(new Question("images\\Silhouette Ahri.png",
                "images\\Ahri.png",
                "Ahri"));
        questions.add(new Question("images\\Silhouette Daffy Duck.png",
                "images\\DaffyDuck.png",
                "Daffy Duck"));
        questions.add(new Question("images\\Silhouette Franky.png",
                "images\\Franky.png",
                "Franky"));
        questions.add(new Question("images\\Silhouette Groot.png",
                "images\\Groot.png",
                "Groot"));
        questions.add(new Question("images\\Silhouette Hulk.png",
                "images\\Hulk.png",
                "Hulk"));
        questions.add(new Question("images\\Silhouette Maui.png",
                "images\\Maui.png",
                "Maui"));
        questions.add(new Question("images\\Silhouette Olaf.png",
                "images\\Olaf.png",
                "Olaf"));
        questions.add(new Question("images\\Silhouette Saitama.png",
                "images\\Saitama.png",
                "Saitama"));
        questions.add(new Question("images\\Silhouette Sandy Cheeks.png",
                "images\\Sandy-Cheeks.png",
                "Sandy Cheeks"));
        questions.add(new Question("images\\Silhouette Teemo.png",
                "images\\Teemo.png",
                "Teemo"));


    }

    public LinkedList<Question> getQuestions() {
        return questions;
    }
}
