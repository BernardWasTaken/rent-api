package com.example.rentapi;

import java.io.Console;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.naming.spi.DirStateFactory.Result;

import org.json.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import ch.qos.logback.core.pattern.Converter;

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
            String userData = String.format("%s-%s-%s-%s-%s", firstname, surname, email, username, password);
            userDataList.add(userData);
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("self", "/users"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
    }

    @GetMapping("/users/getName")
    public ResponseEntity<Map<String, Object>> getUserData(@RequestParam(name = "firstname") String name) throws SQLException {
        ResultSet resultSet = bc.getSpecUser(name);
        List<String> userDataList = new ArrayList<>();
        try{
            String firstname = resultSet.getString("firstname");
            String surname = resultSet.getString("surname");
            String email = resultSet.getString("email");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String userData = String.format("%s-%s-%s-%s-%s", firstname, surname, email, username, password);
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
    public ResponseEntity<Map<String, Object>> updateData(
    @RequestParam String old_username,
    @RequestParam String new_username,
    @RequestParam String new_firstname,
    @RequestParam String new_surname,
    @RequestParam String new_password
    ) throws SQLException {
        List<String> userDataList = new ArrayList<>();
        try{
            int success = bc.updateData(old_username, new_username, new_firstname, new_surname, new_password);
            String userData = String.format("%s-%s", "success", String.valueOf(success));
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
}
