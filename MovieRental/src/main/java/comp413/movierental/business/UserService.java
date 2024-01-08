package comp413.movierental.business;

import comp413.movierental.beans.User;
import comp413.movierental.dao.UserDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class UserService {

    @Inject
    private UserDAO userDAO;

    public List<User> getAllUsers() {
        return userDAO.listAll();
    }

    public User getUserById(int id) {
        return userDAO.get(id);
    }

    public boolean registerUser(User user) {
        try {
            userDAO.add(user);
            return true;
        } catch (Exception e) {
            // 处理异常，例如如果用户名已存在
            return false;
        }
    }

    public void updateUser(User user) {
        userDAO.update(user);
    }

    public void deleteUser(int id) {
        userDAO.delete(id);
    }
    
    public boolean authenticate(String username, String password) {
        User user = userDAO.findByUsername(username);
        if (user == null) {
            return false;
        }

        return user.getPassword().equals(password);
    }
    
    public User getUserByUsername(String username) {
        return userDAO.findByUsername(username);
    }


}
