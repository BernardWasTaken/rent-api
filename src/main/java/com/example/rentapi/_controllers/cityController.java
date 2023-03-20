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
public class cityController {
    baseConnection bc = new baseConnection();


    @GetMapping("/cities")
    public ResponseEntity<Map<String, Object>> getAllCities() throws SQLException {
        ResultSet resultSet = bc.getAllCities();
        List<String> userDataList = new ArrayList<>();
        while(resultSet.next()) {
            String name = resultSet.getString("name");
            int post_number = resultSet.getInt("post_number");
            String userData = String.format("%s+%s", name, String.valueOf(post_number));
            userDataList.add(userData);
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/cities"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
    }

    @GetMapping("/cities/getSpec")
    public ResponseEntity<Map<String, Object>> getSpecCity(@RequestParam(name = "id") int id) throws SQLException {
        ResultSet resultSet = bc.getSpecCity(id);
        List<String> userDataList = new ArrayList<>();
        while(resultSet.next()) {
            String name = resultSet.getString("name");
            int post_number = resultSet.getInt("post_number");
            String userData = String.format("%s+%s", name, String.valueOf(post_number));
            userDataList.add(userData);
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/cities/getSpec"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
    }

    @GetMapping("/cities/updateCity")
    public ResponseEntity<Map<String, Object>> updateCity(
    @RequestParam String old_name,
    @RequestParam String new_name,
    @RequestParam int new_post
    ) throws SQLException {
        List<String> userDataList = new ArrayList<>();
        try{
            int success = bc.updateCity(old_name, new_name, new_post);
            String userData = String.format("%s+%s", "success", String.valueOf(success));
            userDataList.add(userData);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/cities/updateCity"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
        
    }

    @GetMapping("/cities/insertCity")
    public ResponseEntity<Map<String, Object>> insertCity(
    @RequestParam String new_name,
    @RequestParam int new_post
    ) throws SQLException {
        List<String> userDataList = new ArrayList<>();
        try{
            int success = bc.insertCity(new_name, new_post);
            String userData = String.format("%s+%s", "success", String.valueOf(success));
            userDataList.add(userData);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/cities/insertCity"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
        
    }

    @GetMapping("/cities/deleteCity")
    public ResponseEntity<Map<String, Object>> deleteCity(
    @RequestParam int city_id
    ) throws SQLException {
        List<String> userDataList = new ArrayList<>();
        try{
            int success = bc.deleteCity(city_id);
            String userData = String.format("%s+%s", "success", String.valueOf(success));
            userDataList.add(userData);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/cities/deleteCity"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
        
    }
}
