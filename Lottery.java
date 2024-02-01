import java.util.ArrayList;
import java.util.Random;

public class Lottery {
    ArrayList<Toy> toys;
    public static Random random = new Random();

    public Lottery() {
        toys = new ArrayList<>();
    }

    public void put (Toy toy) {
        toys.add(toy);
    }

    public String getToysQty() {
        StringBuilder toysQty = new StringBuilder("\nОставшиеся игрушки:\n");
        for (Toy toy : toys) {
            toysQty.append(String.format("%s: %s\n",
                    toy.name,
                    toy.qty));
        }
        toysQty.append("\n");
        return toysQty.toString();
    }

    private Toy randomToy() {
        ArrayList<Integer> lotteryDrum = new ArrayList();
        for (Toy toy : toys) {
            for (int i = 0; i < toy.qty; i++) lotteryDrum.add(toy.id);
        }
        try {
            int randomId = lotteryDrum.get(random.nextInt(lotteryDrum.size()));
            for (Toy toy : toys) {
                if (toy.id == randomId) {
                    return toy;
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Toy get() {
       Toy toy = randomToy();
       if (toy != null) {
           toy.qty -= 1;
       }
       return toy;
    }
}