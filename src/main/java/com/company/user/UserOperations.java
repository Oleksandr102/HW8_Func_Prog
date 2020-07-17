package main.java.com.company.user;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserOperations {

    List<User> userList = new ArrayList<>();

    public UserOperations() {
        userList.add(new User("Vasya", 16, "Dnepr"));
        userList.add(new User("Petya", 23, "Dnepr"));
        userList.add(new User("Elena", 42, "Luck"));
        userList.add(new User("Elena", 92, "Chernigov"));
        userList.add(new User("Sergay", 5, "Kiev"));
        userList.add(new User("Marina", 32, "Kiev"));
        userList.add(new User("Ivan Ivanovich", 69, "Lvov"));

        olderThan(userList, 40);
        youngerThanFromCity(userList, 50, "Dnepr");
        citizensAverageAge(userList, "Lvov");
        notFromDesiredCity(userList, "Kiev");
        orderByAge(userList, 3);
    }

    public static void olderThan(List<User> userList, int age) {
        System.out.println("Over " + age + ": ");
        userList.stream()
                .filter(user -> user.getAge() > age)
                .forEach(System.out::println);
    }

    public static void youngerThanFromCity(List<User> userList, int age, String cityName) {
        System.out.println("Under " + age + ": ");
        userList.stream()
                .filter(user -> user.getAge() < age && user.getCity().equals(cityName))
                .forEach(System.out::println);
    }

    private static void citizensAverageAge(List<User> userList, String cityName) {
        System.out.println("Average age of Lviv is: " +
                userList.stream()
                        .filter(user -> user.getCity().equals(cityName))
                        .mapToInt(User::getAge)
                        .average()
                        .getAsDouble());
    }

    public static void notFromDesiredCity(List<User> userList, String cityName) {
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
