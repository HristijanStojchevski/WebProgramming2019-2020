package mk.ukim.finki.wp.rentscoot.service.implementation;

import mk.ukim.finki.wp.rentscoot.model.User;
import mk.ukim.finki.wp.rentscoot.service.UserManagementService;

import java.util.List;

public class UserManagementServiceImplementation implements UserManagementService {
    @Override
    public User registerUser(String name, String email, String password) {
        return null;
    }

    @Override
    public List<User> findUsersByEmailOrName(String email, String name) {
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User updateUser(Long id,String email,String password) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public boolean changeUserPassword(Long id, String password) {
        return false;
    }
}
