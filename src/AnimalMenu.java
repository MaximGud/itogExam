import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AnimalMenu {
    private ArrayList<Animal> register;

    public AnimalMenu() {
        register = new ArrayList<>();
    }

    public void loadAnimals() throws IOException {
        File file = new File(
                "C:\\Users\\USER\\Desktop\\ItogExam\\Java\\exam\\src\\Animals.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            register.add(Animal.parse(line));
        }
        br.close();
    }

    public void saveAnimals() throws IOException {

        FileWriter writer = new FileWriter(
                "C:\\Users\\USER\\Desktop\\ItogExam\\Java\\exam\\src\\Animals.txt",
                false);

        for (Animal animal : register) {
            writer.append(animal.toString() + "\n");
        }

        writer.flush();
        writer.close();
    }

    public ArrayList<Animal> getRegister() {
        return register;
    }

    public void addAnimal(Animal animal) {
        register.add(animal);
    }
}