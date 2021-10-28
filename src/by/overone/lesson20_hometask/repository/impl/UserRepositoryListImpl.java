package by.overone.lesson20_hometask.repository.impl;

import by.overone.lesson20_hometask.DBList;
import by.overone.lesson20_hometask.entity.User;
import by.overone.lesson20_hometask.repository.UserRepository;
import by.overone.lesson20_hometask.utils.UserWrapper;

import java.util.ArrayList;
import java.util.List;


    public class UserRepositoryListImpl implements UserRepository {
        @Override

        public User[] getAllUsers() {
            List<User> users= new ArrayList<>();
            for (String strUser: DBList.users){
                users.add(UserWrapper.stringToUser(strUser));}
            return users.toArray(new User[0]);
        }

        @Override
        public User getUserById(long id) {
            User check=new User();
            for (String user: DBList.users) {
                check=UserWrapper.stringToUser(user);
                if (check.getId()==id) return check;

            }
            return null;
        }

        @Override
        public User[] getUserByFullName(String fullName) {
            List<User> rezult = new ArrayList<>();
            User userToFind=UserWrapper.stringToFIO(fullName);
            User chekX=new User();

            for (String user: DBList.users) {
                chekX= UserWrapper.stringToUser(user);
                if (userToFind.getName().equals(chekX.getName()) && userToFind.getSurname().equals(chekX.getSurname())) {
                    rezult.add(chekX);
                }


            }
            if (rezult.size()==0) {return null;}
            return rezult.toArray(new User[0]);
        }

        @Override
        public User removeUserById(long id) {

            // String[] users = new String[DB.users.length - 1];
            String idProp = "id: " + id+",";
            // String removed=null;
            for (String strUser: DBList.users){
                if(strUser.startsWith(idProp)) {
                    DBList.users.remove(strUser);
                    return UserWrapper.stringToUser(strUser);
                }
            }

            return new User();
        }

        @Override
        public User addUser(User user) {
            DBList.id += 1;
            user.setId(DBList.id);
            DBList.users.add(UserWrapper.userToString(user));
            return user;
        }
    }

