package com.example.rentapi._controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentapi.baseConnection;

@RestController
public class userController {
    baseConnection bc = new baseConnection();

    @GetMapping("/users")
    public ResponseEntity<Map<String, Object>> getAllUsers() throws SQLException {
        ResultSet resultSet = bc.getAllUsers();
        List<String> userDataList = new ArrayList<>();
        while(resultSet.next()) {
            String firstname = resultSet.getString("firstname");
            String surname = resultSet.getString("surname");
            String email = resultSet.getString("email");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String userData = String.format("%s+%s+%s+%s+%s", firstname, surname, email, username, password);
            userDataList.add(userData);
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/users"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
    }

    @GetMapping("/users/getSpec")
    public ResponseEntity<Map<String, Object>> getUserData(@RequestParam(name = "username") String name) throws SQLException {
        ResultSet resultSet = bc.getSpecUser(name);
        List<String> userDataList = new ArrayList<>();
        try{
            String firstname = resultSet.getString("firstname");
            String surname = resultSet.getString("surname");
            String email = resultSet.getString("email");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String userData = String.format("%s+%s+%s+%s+%s", firstname, surname, email, username, password);
            userDataList.add(userData);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/users/getName"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
        
    }

    @GetMapping("/users/updateUser")
    public ResponseEntity<Map<String, Object>> updateUser(
    @RequestParam String old_username,
    @RequestParam String new_username,
    @RequestParam String new_firstname,
    @RequestParam String new_surname,
    @RequestParam String new_password
    ) throws SQLException {
        List<String> userDataList = new ArrayList<>();
        try{
            int success = bc.updateUser(old_username, new_username, new_firstname, new_surname, new_password);
            String userData = String.format("%s+%s", "success", String.valueOf(success));
            userDataList.add(userData);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/users/updateUser"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
        
    }


    @GetMapping("/users/insertUser")
    public ResponseEntity<Map<String, Object>> insertUser(
    @RequestParam String new_firstname,
    @RequestParam String new_surname,
    @RequestParam String new_birth,
    @RequestParam int new_city_id,
    @RequestParam String new_email,
    @RequestParam String new_username,
    @RequestParam String new_password
    ) throws SQLException {
        List<String> userDataList = new ArrayList<>();
        try{
            int success = bc.insertUser(new_firstname, new_surname, new_birth, new_city_id, new_email, new_username, new_password);
            String userData = String.format("%s+%s", "success", String.valueOf(success));
            userDataList.add(userData);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/users/insertUser"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
        
    }


    @GetMapping("/users/deleteUser")
    public ResponseEntity<Map<String, Object>> deleteUser(
    @RequestParam int user_id
    ) throws SQLException {
        List<String> userDataList = new ArrayList<>();
        try{
            int success = bc.deleteUser(user_id);
            String userData = String.format("%s+%s", "success", String.valueOf(success));
            userDataList.add(userData);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/users/deleteUser"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
        
    }

    @GetMapping("/users/resetPassword")
    public ResponseEntity<Map<String, Object>> resetPassword(
        @RequestParam String username,
        @RequestParam String password
        ) throws SQLException {
            List<String> userDataList = new ArrayList<>();
            try {
                int success = bc.resetPassword(username, password);
                String userData = String.format("%s+%s", "success", String.valueOf(success));
                userDataList.add(userData);
            } catch (Exception e) {
                // TODO: handle exception
            }
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("data", userDataList);
            responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
            responseBody.put("links", Collections.singletonMap("endpoint", "/users/resetPassword"));
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            return ResponseEntity.ok().headers(headers).body(responseBody);
        }

    @GetMapping("/users/checkLogin")
    public ResponseEntity<Map<String, Object>> checkLogin(
        @RequestParam String username,
        @RequestParam String password
        ) throws SQLException {
            List<String> userDataList = new ArrayList<>();
            try {
                int success = bc.checkLogin(username, password);
                String userData = String.format("%s+%s", "success", String.valueOf(success));
                userDataList.add(userData);
            } catch (Exception e) {
                // TODO: handle exception
            }
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("data", userDataList);
            responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
            responseBody.put("links", Collections.singletonMap("endpoint", "/users/checkLogin"));
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            return ResponseEntity.ok().headers(headers).body(responseBody);
        }
}
