import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();

        addContact(phoneBook, "Иванов", "123-456-789");
        addContact(phoneBook, "Петров", "987-654-321");
        addContact(phoneBook, "Сидоров", "111-222-333");
        addContact(phoneBook, "Иванов", "555-555-555");
        addContact(phoneBook, "Петров", "999-999-999");

        List<Map.Entry<String, List<String>>> sortedContacts = new ArrayList<>(phoneBook.entrySet());
        sortedContacts.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        for (Map.Entry<String, List<String>> entry : sortedContacts) {
            System.out.println("Имя: " + entry.getKey());
            System.out.println("Телефоны: " + entry.getValue());
        }
    }

    public static void addContact(Map<String, List<String>> phoneBook, String name, String phoneNumber) {
        phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
    }
}
