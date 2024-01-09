package com.yubi.RHSB.controller.user;

import com.yubi.RHSB.model.User;
import com.yubi.RHSB.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create a new user
    @PostMapping("/create")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        // Implement logic to create a new user
        userService.addUser(user);
        return ResponseEntity.ok("User created successfully");
    }

    // Get user details by user ID
    @GetMapping("/get/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable int userId) {
        // Implement logic to retrieve user details
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    // Update user details
    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        // Implement logic to update user details
        userService.updateUser(user);
        return ResponseEntity.ok("User updated successfully");
    }

    // Delete user by user ID
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable int userId) {
        // Implement logic to delete user
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }

    // Example of getting all users (for admin role)
//    @GetMapping("/all")
//    public ResponseEntity<List<User>> getAllUsers() {
//        // Implement logic to retrieve all users
//        List<User> users = userService.getAllUsers();
//        return ResponseEntity.ok(users);
//    }
}

