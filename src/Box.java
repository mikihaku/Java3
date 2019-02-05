import java.util.ArrayList;

public class Box<T extends Fruits> {

    private ArrayList<T> content = new ArrayList<>();

    public Box(T fruit) {

        this.content.add(fruit);

    }

    private double weight() {

        float weight;

        if(content.size() == 0)
            weight = 0;
        else {

            T fruit = content.get(0);
            weight = fruit.weight;
        }

        return weight * content.size();
    }


    public boolean compare(Box<?> secondBox) {

        return weight() == secondBox.weight();

    }

    public void receiveFruits(Box<T> secondBox) {

        for(T fruit:secondBox.sendFruits()) {

            addFruit(fruit);

        }

    }

    public void addFruit(T fruit) {

        try {

            if(getBoxSize() == 0) content.add(fruit);
            else {

                String one = content.get(0).getClass().getName();
                String two = fruit.getClass().getName();

                if(one.equals(two))
                    content.add(fruit);
                else
                    System.out.println("В этой коробке лежат фрукты другого типа");

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public ArrayList<T> sendFruits() {

        ArrayList<T> temp = content;

        this.content = new ArrayList<T>();

        return temp;

    }

    public int getBoxSize() {

        return content.size();

    }


}
