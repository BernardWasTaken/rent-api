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
public class carController {
    baseConnection bc = new baseConnection();

    @GetMapping("/cars")
    public ResponseEntity<Map<String, Object>> getAllCars() throws SQLException {
        ResultSet resultSet = bc.getAllCars();
        List<String> userDataList = new ArrayList<>();
        while(resultSet.next()) {
            String name = resultSet.getString("name");
            String licenceplate = resultSet.getString("licenceplate");
            int garage_id = resultSet.getInt("garage_id");
            int kilometers = resultSet.getInt("kilometers");
            String userData = String.format("%s+%s+%s+%s", name, licenceplate, String.valueOf(garage_id), String.valueOf(kilometers));
            userDataList.add(userData);
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/cars"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
    }

    @GetMapping("/cars/getSpec")
    public ResponseEntity<Map<String, Object>> getSpecCar(@RequestParam(name = "id") int id) throws SQLException {
        ResultSet resultSet = bc.getSpecCar(id);
        List<String> userDataList = new ArrayList<>();
        while(resultSet.next()) {
            String name = resultSet.getString("name");
            String licenceplate = resultSet.getString("licenceplate");
            int garage_id = resultSet.getInt("garage_id");
            int kilometers = resultSet.getInt("kilometers");
            String userData = String.format("%s+%s+%s+%s", name, licenceplate, String.valueOf(garage_id), String.valueOf(kilometers));
            userDataList.add(userData);
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/cars/getSpec"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
    }


    @GetMapping("/cars/updateCar")
    public ResponseEntity<Map<String, Object>> updateCar(
    @RequestParam int car_id,
    @RequestParam String new_name,
    @RequestParam String new_licenceplate,
    @RequestParam int new_garage_id,
    @RequestParam int new_kilometers
    ) throws SQLException {
        List<String> userDataList = new ArrayList<>();
        try{
            int success = bc.updateCar(car_id, new_name, new_licenceplate, new_garage_id, new_kilometers);
            String userData = String.format("%s+%s", "success", String.valueOf(success));
            userDataList.add(userData);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/cars/updateCar"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
        
    }

    @GetMapping("/cars/deleteCar")
    public ResponseEntity<Map<String, Object>> deleteCar(
    @RequestParam int car_id
    ) throws SQLException {
        List<String> userDataList = new ArrayList<>();
        try{
            int success = bc.deleteCar(car_id);
            String userData = String.format("%s+%s", "success", String.valueOf(success));
            userDataList.add(userData);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/cars/deleteCar"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
        
    }

    @GetMapping("/cars/insertCar")
    public ResponseEntity<Map<String, Object>> insertCar(
    @RequestParam String new_name,
    @RequestParam String new_licenceplate,
    @RequestParam int new_garage_id,
    @RequestParam int new_kilometers
    ) throws SQLException {
        List<String> userDataList = new ArrayList<>();
        try{
            int success = bc.insertCar(new_name, new_licenceplate, new_garage_id, new_kilometers);
            String userData = String.format("%s+%s", "success", String.valueOf(success));
            userDataList.add(userData);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/cars/insertCar"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
        
    }
}
