package main.java.com.company.user;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserOperations {

    List<User> userList = new ArrayList<>();

    public UserOperations() {
        userList.add(new User("Вася", 16, "Днепр"));
        userList.add(new User("Петя", 23, "Днепр"));
        userList.add(new User("Елена", 42, "Луцк"));
        userList.add(new User("Елена", 92, "Чернигов"));
        userList.add(new User("Сергей", 5, "Киев"));
        userList.add(new User("Марина", 32, "Киев"));
        userList.add(new User("Иван Иванович", 69, "Львов"));

        over40(userList, 40);
        under50City(userList, 50, "Днепр");
        lvivAVG(userList, "Львов");
        outKiev(userList, "Киев");
        orderByAge(userList, 3);
    }

    public static void over40(List<User> userList, int age) {
        System.out.println("Over " + age + ": ");
        userList.stream()
                .filter(user -> user.getAge() > age)
                .forEach(System.out::println);
    }

    public static void under50City(List<User> userList, int age, String cityName) {
        System.out.println("Under " + age + ": ");
        userList.stream()
                .filter(user -> user.getAge() < age && user.getCity().equals(cityName))
                .forEach(System.out::println);
    }

    private static void lvivAVG(List<User> userList, String city) {
        System.out.println("Average age of Lviv is: " +
                userList.stream()
                        .filter(user -> user.getCity().equals(city))
                        .mapToInt(User::getAge)
                        .average()
                        .getAsDouble());
    }

    public static void outKiev(List<User> userList, String cityName) {
        int count = Math.toIntExact(userList.stream()
                .filter(user -> !user.getCity().equals(cityName))
                .count());
        System.out.println("Not from " + cityName + ": " + count);
    }

    public static void orderByAge(List<User> userList, int value) {
        System.out.println(value + " sorted by age:");
        userList.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .limit(value)
                .forEach(System.out::println);
    }
}
