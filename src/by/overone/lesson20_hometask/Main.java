package by.overone.lesson20_hometask;

import by.overone.lesson20_hometask.entity.User;
import by.overone.lesson20_hometask.service.UserService;
import by.overone.lesson20_hometask.service.impl.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        User removedUser = userService.removeUserById(1);
        if (removedUser.getId() > 0) {
            System.out.println("REMOVED: " + removedUser);
        } else {
            System.out.println("User not found");
        }
        getAllUsersOut();
        System.out.println(userService.getUserById(10));
        System.out.println(userService.getUserById(11));
        System.out.println("-----------------------");
        User[] userFIO = userService.getUserByFullName("Kate    Katovalova");
        for (User user : userFIO) {
            System.out.println(user);
        }
        System.out.println("user delete: " + userService.removeUserById(11));
        System.out.println("-----------------------");
        User[] users1 = userService.getAllUsers();
        for (User user : users1) {
            System.out.println(user);
        }
        User newUser = new User("John", "Smith", 31, "+74951085622");
        addNewUser(newUser);
        System.out.println(" ####### try to add dublicate: John Smith");
        User newUser1 = new User("John", "Smith", 31, "+74951085622");
        addNewUser(newUser1);
    }

    public static void addNewUser(User user) {
        UserService userService = new UserServiceImpl();
        System.out.println("adding new user: " + user.getName() + " " + user.getSurname());
        if (userService.addUser(user) == null) {
            System.out.println("User is exist");
        } else {
            System.out.println("User is added: " + user);
        }
    }

    public static void getAllUsersOut() {
        UserService userService = new UserServiceImpl();
        System.out.println("-----------Users------------");
        User[] users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("----------end of out users-------------");
    }
}
