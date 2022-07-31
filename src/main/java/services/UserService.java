package services;

import domain.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService {

    public HashMap<String, User> users = new HashMap<>();
    public User signUp(User user){
        switch (user.getRole()){
            case ADMIN:
                if(user.getPassword().length()!=8){
                    throw new RuntimeException("password length do not match, length of 8 is a must");
                } else{
                    users.put(user.getUsername(), user);
                    return user;
                }
            case PATIENT:
                if(user.getPassword().length()!=7){
                    throw new RuntimeException("password length do not match, length of 7 is a must");
                } else{
                    users.put(user.getUsername(), user);
                    return user;
                }
            case PHYSICIAN:
                if(user.getPassword().length()!=6){
                    throw new RuntimeException("password length do not match, length of 6 is a must");
                } else{
                    users.put(user.getUsername(), user);
                    return user;
                }
            case PHARMACIST:
                if(user.getPassword().length()!=5){
                    throw new RuntimeException("password length do not match, length of 5 is a must");
                } else{
                    users.put(user.getUsername(), user);
                    return user;
                }
        }
        return user;
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, User> users) {
        this.users = users;
    }

}
