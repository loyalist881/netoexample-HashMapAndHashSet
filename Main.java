import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Address, Integer> costPerAddress = new HashMap<>();
        Set<String> uniqueCountries = new HashSet<>();

        costPerAddress.put(new Address("Россия", "Новосибирск"), 200);
        costPerAddress.put(new Address("Россия", "Москва"), 300);
        costPerAddress.put(new Address("Россия", "Казань"), 150);

        costPerAddress.put(new Address("США", "Нью-Йорк"), 600);
        costPerAddress.put(new Address("США", "Лос-Анджелес"), 650);
        costPerAddress.put(new Address("США", "Чикаго"), 580);

        costPerAddress.put(new Address("Казахстан", "Астана"), 230);
        costPerAddress.put(new Address("Казахстан", "Алматы"), 210);

        Scanner scanner = new Scanner(System.in);
        int totalCost = 0;

        while (true) {
            System.out.println("Заполнение нового заказа.");

            System.out.print("Введите страну (или end для выхода): ");
            String country = scanner.nextLine().trim();
            if ("end".equals(country)) {
                System.out.println("Программа завершена!");
                break;
            }

            System.out.print("Введите город (или end для выхода): ");
            String city = scanner.nextLine().trim();
            if ("end".equals(city)) {
                System.out.println("Программа завершена!");
                break;
            }

            Address address = new Address(country, city);
            Integer pricePerKg = costPerAddress.get(address);

            if (pricePerKg == null) {
                System.out.println("Такой адрес не обслуживается.");
            } else {
                System.out.print("Введите вес (кг): ");
                String weightStr = scanner.nextLine().trim();
                int weight;
                try {
                    weight = Integer.parseInt(weightStr);
                    if (weight <= 0) {
                        System.out.println("Вес должен быть положительным числом.");
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Некорректный ввод веса.");
                    continue;
                }

                int orderCost = pricePerKg * weight;
                totalCost += orderCost;
                uniqueCountries.add(country);
                System.out.println("Стоимость доставки: " + orderCost + " у.е.");
                System.out.println("Общая сумма всех доставок: " + totalCost + " у.е.");
            }
            System.out.println();
        }
        System.out.println("Итоговая сумма всех доставок: " + totalCost + " у.е.");
        System.out.println("Доставки были оформлены в "
                + uniqueCountries.size() + " уникальных стран(ы).");
    }
}