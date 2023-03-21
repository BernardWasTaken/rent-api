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
public class garageController {
    baseConnection bc = new baseConnection();

    @GetMapping("/garages")
    public ResponseEntity<Map<String, Object>> getAllGarages() throws SQLException {
        ResultSet resultSet = bc.getAllGarages();
        List<String> userDataList = new ArrayList<>();
        while(resultSet.next()) {
            String name = resultSet.getString("name");
            int city_id = resultSet.getInt("city_id");
            String userData = String.format("%s+%s", name, String.valueOf(city_id));
            userDataList.add(userData);
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/garages"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
    }

    @GetMapping("/garages/getSpec")
    public ResponseEntity<Map<String, Object>> getSpecGarage(@RequestParam(name = "id") int id) throws SQLException {
        ResultSet resultSet = bc.getSpecGarage(id);
        List<String> userDataList = new ArrayList<>();
        while(resultSet.next()) {
            String name = resultSet.getString("name");
            int city_id = resultSet.getInt("city_id");
            String userData = String.format("%s+%s", name, String.valueOf(city_id));
            userDataList.add(userData);
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/garages/getSpec"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
    }

    @GetMapping("/garages/updateGarage")
    public ResponseEntity<Map<String, Object>> updateGarage(
    @RequestParam int new_id,
    @RequestParam String new_name,
    @RequestParam int new_city_id
    ) throws SQLException {
        List<String> userDataList = new ArrayList<>();
        try{
            int success = bc.updateGarage(new_id, new_name, new_city_id);
            String userData = String.format("%s+%s", "success", String.valueOf(success));
            userDataList.add(userData);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/garages/updateGarage"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
        
    }

    @GetMapping("/garages/insertGarage")
    public ResponseEntity<Map<String, Object>> insertGarage(
    @RequestParam String new_name,
    @RequestParam int new_city_id
    ) throws SQLException {
        List<String> userDataList = new ArrayList<>();
        try{
            int success = bc.insertGarage(new_name, new_city_id);
            String userData = String.format("%s+%s", "success", String.valueOf(success));
            userDataList.add(userData);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/garages/insertGarage"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
        
    }

    @GetMapping("/garages/deleteGarage")
    public ResponseEntity<Map<String, Object>> deleteGarage(
    @RequestParam int garage_id
    ) throws SQLException {
        List<String> userDataList = new ArrayList<>();
        try{
            int success = bc.deleteGarage(garage_id);
            String userData = String.format("%s+%s", "success", String.valueOf(success));
            userDataList.add(userData);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/garages/deleteGarage"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
        
    }
}
