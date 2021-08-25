package com.dabloons.watts.data;

import com.dabloons.watts.data.model.LoggedInUser;
import com.dabloons.watts.data.model.User;
import com.dabloons.watts.firebase.FirebaseUtil;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    private FirebaseFirestore firebaseInstance;
    private FirebaseAuth firebaseAuth;

    public LoginDataSource() {
        firebaseInstance = FirebaseUtil.getFirestore();
        firebaseAuth = FirebaseUtil.getAuth();
    }

    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication

            User user = new User(username, password);
            CollectionReference userCollection = firebaseInstance.collection("Users");

            userCollection.add(user);

            LoggedInUser fakeUser = new LoggedInUser(java.util.UUID.randomUUID().toString(), username);
            return new Result.Success<>(fakeUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}