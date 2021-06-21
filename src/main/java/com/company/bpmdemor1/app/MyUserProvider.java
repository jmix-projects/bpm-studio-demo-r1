package com.company.bpmdemor1.app;

import com.company.bpmdemor1.entity.User;
import io.jmix.bpm.provider.UserProvider;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;

@UserProvider(description = "Returns a user with the specified email")
public class MyUserProvider {
    @Autowired
    private DataManager dataManager;

    public String getUserByEmail(String email) {
        return dataManager.load(User.class)
                .query("select u from User u where u.email = :email")
                .parameter("email", email)
                .one()
                .getUsername();
    }
}
