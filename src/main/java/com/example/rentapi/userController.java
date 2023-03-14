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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@RestController
public class userController {
    baseConnection bc = new baseConnection();

    @GetMapping("/users")
    public ResponseEntity<Map<String, Object>> getUserData() throws SQLException {
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

    @GetMapping("/user/getName")
    public String specUser(@RequestParam(name = "userName") String name)
    {
        return "username is: "+name;
    }
}
