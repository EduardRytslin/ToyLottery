import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static String FILE_PATH = "results.txt";
    private static void saveToFile(String text) {
        File file = new File(FILE_PATH);
        FileWriter writer = null;
        try {
            writer = new FileWriter(file,true);
            writer.write(text);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Lottery lottery = new Lottery();
        lottery.put(new Toy(1, "Smesharik", 4));
        lottery.put(new Toy(2, "Barbie", 6));
        lottery.put(new Toy(3, "Bionicle", 4));
        lottery.put(new Toy(4, "Lego", 2));
        lottery.put(new Toy(5, "Car", 4));
        

        for (int attempt = 1; attempt <= 10; attempt++) {
            Toy toy = lottery.get();
            if (toy != null) {
                String str = String.format("Попытка %d: %s\n", attempt, toy);
                System.out.printf(str);
                saveToFile(str);
            } else {
                String str = String.format("Попытка %d: Игрушек больше нет\n", attempt);
                System.out.printf(str);
                saveToFile(str);
                break;
            }
        }
        String str = lottery.getToysQty();
        System.out.println(str);
        saveToFile(str);
    }
}