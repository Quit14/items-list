import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> itemsList = new ArrayList<>(); //создаем список
        itemsList.add("Молоко");
        itemsList.add("Хлеб");
        itemsList.add("Конфеты \"Птичье молоко\"");
        itemsList.add("Вода");
        while (true) { //запускаем цикл
            printOptions(); //выводим на экран доступные опции
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            sc.nextLine(); // забираем лишний enter
            if (input == 5) { //выход из программы
                break;
            }
            switch (input) {
                case 1:
                    System.out.println("Какую покупку хотите добавить в список?");
                    String item = sc.nextLine();
                    itemsList.add(item); //добавляем покупку в список
                    System.out.println("Итого в списке покупок: " + itemsList.size());
                    break;

                case 2: //вывод списка на экран
                    getItemsList(itemsList);
                    break;
                case 3:
                    getItemsList(itemsList);
                    System.out.println("Какую покупку хотите удалить? Введите название или номер");
                    if (sc.hasNextInt()) { //удаляем покупку по индексу
                        int numForRemove = sc.nextInt();
                        System.out.println("Покупка \"" + itemsList.get(numForRemove - 1) + "\" удалена из вашего списка");
                        itemsList.remove(numForRemove - 1);
                        getItemsList(itemsList);
                    } else {
                        String itmForRemove = sc.nextLine(); //удаляем покупку по названию
                        System.out.println("Покупка \"" + itmForRemove + "\" удалена из вашего списка покупок");
                        itemsList.remove(itmForRemove);
                        getItemsList(itemsList);

                    }
                    break;
                case 4:
                    System.out.println("Введите текст для поиска:");
                    String queryLower = sc.nextLine().toLowerCase();
                    System.out.println("Найдено:");
                    int cnt = 0; //счетчик совпадений

                    for (int i = 0; i < itemsList.size(); i++) {
                        String itemLower = itemsList.get(i).toLowerCase();
                        if (itemLower.contains(queryLower)) {
                            cnt++;
                            System.out.println((i + 1) + ". \"" + itemsList.get(i) + "\"");

                        }
                    }
                    if (cnt == 0) {
                        System.out.println("Нет совпадений!");
                    }
                    break;


            }


        }
    }


    static void printOptions() {
        System.out.println("Введите цифру и выберите операцию:");
        System.out.println("1. Добавить продукт в список покупок");
        System.out.println("2. Показать текущий список продуктов");
        System.out.println("3. Удалить покупку из списка");
        System.out.println("4. Поиск продукта в списке");
        System.out.println("5. Выход из программы");
    }

    static void getItemsList(ArrayList<String> itemsList) {
        System.out.println("Список покупок:");
        for (int i = 0; i < itemsList.size(); i++) {
            System.out.println((i + 1) + ". " + itemsList.get(i));
        }
    }
}

