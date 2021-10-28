package by.overone.lesson20_hometask.utils;

import by.overone.lesson20_hometask.entity.User;

public class UserWrapper {
    public static User stringToUser(String userStr) {
        User user = new User();
        String[] properties = userStr.split(", ");
        for (String str : properties) {
            String prop = str.substring(0, str.indexOf(" "));
            switch (prop) {
                case "id:":
                    long id = Long.parseLong(str.substring(4));
                    user.setId(id);
                    break;
                case "name:":
                    String name = str.substring(6);
                    user.setName(name);
                    break;
                case "surname:":
                    String surname = str.substring(9);
                    user.setSurname(surname);
                    break;
                case "age:":
                    int age = Integer.parseInt(str.substring(5));
                    user.setAge(age);
                    break;
                case "phoneNumber:":
                    String phoneNumber = str.substring(13);
                    user.setPhoneNumber(phoneNumber);
                    break;
            }
        }
        return user;
    }
    public static User stringToFIO(String userStr) {
        String[] userFIO=new String[2];
        User user = new User();
        userFIO=userStr.split("\s+");
        user.setName(userFIO[0]);
        user.setSurname(userFIO[1]);
        //System.out.println(" проверка " + user);
        return user;
    }

    public static String userToString(User user) {
        return
                "id: " + user.getId() + ","+
                        " name: " + user.getName() + "," +
                        " surname: " + user.getSurname() + "," +
                        " age: " + user.getAge() + ","+
                        " phoneNumber: " + user.getPhoneNumber() ;
    }

}
