package mk.ukim.finki.wp.rentscoot.service;

import mk.ukim.finki.wp.rentscoot.model.Role;
import mk.ukim.finki.wp.rentscoot.model.User;

import java.util.List;

public interface UserManagementService {
    User registerUser(String name,String email,String password);

    List<User> findUsersByEmailOrName(String email,String name);

    User getUserById(Long id);

    User getUserByEmail(String email);

    List<User> getAllUsers();

    User updateUser(Long id,String name,String email);

    void deleteUser(Long id);

    boolean changeUserPassword(Long id,String password); //Should be encripted or done trough another secured service

//    Role setUserRole(User user,Role role);
//
//    Role changeUserRole(User user,Role role);
//
}
