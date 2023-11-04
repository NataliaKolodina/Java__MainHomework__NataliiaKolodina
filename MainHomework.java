import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class MainHomework {
  public static void main(String[] args) {
    Book phoneBook = new Book();
    phoneBook.add("89276325784", "Сидоров");
    phoneBook.add("89274521478", "Колодина");
    phoneBook.add("89741256354", "Козлов");
    phoneBook.add("89875239654", "Сидоров");
    phoneBook.add("89714523695", "Маликов");
    phoneBook.add("89276325784", "Колодина");
    phoneBook.add("89378965245", "Колодина");
    phoneBook.add("89412567412", "Суворов");
    phoneBook.add("89279657845", "Шишкина");
    phoneBook.add("89165248588", "Пупкин");

    System.out.println(phoneBook.getAll());
  }
}

class Book {
  private Map<String, List<String>> map = new HashMap<>();

  void add(String phoneNum, String name) {
    if (map.containsKey(name)) {
      List<String> phoneNumbers = map.get(name);
      phoneNumbers.add(phoneNum);
    } else {
      List<String> phoneNumbers = new ArrayList<>();
      phoneNumbers.add(phoneNum);
      map.put(name, phoneNumbers);
    }
  }

  String getAll() {
    StringBuilder stringBuilder = new StringBuilder();
    List<Map.Entry<String, List<String>>> entries = new ArrayList<>(map.entrySet());
    entries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));
    for (Map.Entry<String, List<String>> entry : entries) {
      List<String> phoneNumbers = entry.getValue();
      stringBuilder.append(entry.getKey());
      stringBuilder.append(" : ");
      stringBuilder.append(phoneNumbers);
      stringBuilder.append("\n");
    }
    return stringBuilder.toString();
  }
}