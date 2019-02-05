public class Main {

    public static void main(String[] args) {

        // Задания 1 и 2
        new Generics();

        // Задание 3
        Box boxOfApples = new Box<Apple>(new Apple());
        Box boxOfOranges = new Box<Orange>(new Orange());

        // Яблоки
        boxOfApples.addFruit(new Apple());
        boxOfApples.addFruit(new Apple());
        boxOfApples.addFruit(new Apple());
        boxOfApples.addFruit(new Apple());
        boxOfApples.addFruit(new Apple());

        System.out.println("Box of apples size: "+ boxOfApples.getBoxSize());

        // Апельсины
        boxOfOranges.addFruit(new Orange());
        boxOfOranges.addFruit(new Orange());
        boxOfOranges.addFruit(new Orange());

        System.out.println("Box of oranges size: "+ boxOfOranges.getBoxSize());

        // Сравниваем
        if(boxOfApples.compare(boxOfOranges)) {

            System.out.println("Коробки равны по весу");

        } else {

            System.out.println("Коробки не равны по весу");

        }

        // Пересыпаем все в коробку 1
        Box boxOfApples2 = new Box<>(new Apple());
        System.out.println("Box of apples 2 size: "+ boxOfApples2.getBoxSize());
        boxOfApples2.receiveFruits(boxOfApples);
        System.out.println("Пересыпаем все в коробку 2");
        System.out.println("Box of apples 1 size: "+ boxOfApples.getBoxSize());
        System.out.println("Box of apples 2 size: "+ boxOfApples2.getBoxSize());

        // Нельзя добавить в коробку с яблоками апельсин
        System.out.println("Нельзя добавить в коробку с яблоками апельсин:");
        boxOfApples2.addFruit(new Orange());



    }

}