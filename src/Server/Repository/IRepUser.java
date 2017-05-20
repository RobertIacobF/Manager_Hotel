package Server.Repository;

import Server.Model.User;

/**
 * Created by Robert Iacob on 16.05.2017.
 */
public interface IRepUser{
    void createUser(User newUser);

    User readUser(String username);

    void updateUser(String username, User newUserModel);

    void deleteUser(String username);
}
