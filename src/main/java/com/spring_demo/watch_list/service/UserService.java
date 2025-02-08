package com.spring_demo.watch_list.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class UserService {

    private final JdbcUserDetailsManager userDetailsManager;
    private final JdbcTemplate jdbcTemplate;
    private final BCryptPasswordEncoder passwordEncoder;


    public UserService(DataSource dataSource, BCryptPasswordEncoder passwordEncoder){
        this.userDetailsManager = new JdbcUserDetailsManager(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.passwordEncoder = passwordEncoder;
    }

    // Get all users
    public List<String> getAllUsers(){
        return jdbcTemplate.queryForList("SELECT username FROM users" , String.class);
    }

    // Add user
    public void addUser(String username , String password , boolean enabled){

        if (userDetailsManager.userExists(username)) {
            throw new IllegalArgumentException("User already exists.");
        }

        String encodedPassword = passwordEncoder.encode(password);

        UserDetails user = User.withUsername(username)
                .password(encodedPassword)
                .roles("USER")
                .build();

        userDetailsManager.createUser(user);
    }

    // disable User
    public void disableUser(String username) {
        jdbcTemplate.update("UPDATE users SET enabled = false WHERE username = ?", username);
    }

    // enable user
    public void enableUser(String username) {
        jdbcTemplate.update("UPDATE users SET enabled = true WHERE username = ?", username);
    }

}
