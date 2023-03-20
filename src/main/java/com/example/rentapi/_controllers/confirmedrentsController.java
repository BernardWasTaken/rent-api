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
public class confirmedrentsController {
    baseConnection bc = new baseConnection();


    @GetMapping("/confirmedrents")
    public ResponseEntity<Map<String, Object>> getAllConfirmedRents() throws SQLException {
        ResultSet resultSet = bc.getAllConfirmedRents();
        List<String> userDataList = new ArrayList<>();
        while(resultSet.next()) {
            int car_id = resultSet.getInt("car_id");
            int kilometersmade = resultSet.getInt("kilometersmade");
            String comment = resultSet.getString("comment");
            int rent_id = resultSet.getInt("rent_id");
            String userData = String.format("%s+%s+%s+%s", String.valueOf(car_id), String.valueOf(kilometersmade), comment, String.valueOf(rent_id));
            userDataList.add(userData);
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/confirmedrents"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
    }

    @GetMapping("/confirmedrents/getSpec")
    public ResponseEntity<Map<String, Object>> getSpecConfirmedRent(@RequestParam(name = "id") int id) throws SQLException {
        ResultSet resultSet = bc.getSpecConfirmedRent(id);
        List<String> userDataList = new ArrayList<>();
        while(resultSet.next()) {
            int car_id = resultSet.getInt("car_id");
            int kilometersmade = resultSet.getInt("kilometersmade");
            String comment = resultSet.getString("comment");
            int rent_id = resultSet.getInt("rent_id");
            String userData = String.format("%s+%s+%s+%s", String.valueOf(car_id), String.valueOf(kilometersmade), comment, String.valueOf(rent_id));
            userDataList.add(userData);
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/confirmedrents/getSpec"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
    }


    @GetMapping("/confirmedrents/updateConfirmedRent")
    public ResponseEntity<Map<String, Object>> updateConfirmedRent(
    @RequestParam int new_id,
    @RequestParam int new_car_id,
    @RequestParam int new_kilometersmade,
    @RequestParam String new_comment,
    @RequestParam int new_rent_id
    ) throws SQLException {
        List<String> userDataList = new ArrayList<>();
        try{
            int success = bc.updateConfirmedRent(new_id, new_car_id, new_kilometersmade, new_comment, new_rent_id);
            String userData = String.format("%s+%s", "success", String.valueOf(success));
            userDataList.add(userData);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/confirmedrents/updateConfirmedRent"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
        
    }

    @GetMapping("/confirmedrents/insertConfirmedRent")
    public ResponseEntity<Map<String, Object>> insertConfirmedRent(
        @RequestParam int new_car_id,
        @RequestParam int new_kilometersmade,
        @RequestParam String new_comment,
        @RequestParam int new_rent_id
    ) throws SQLException {
        List<String> userDataList = new ArrayList<>();
        try{
            int success = bc.insertConfirmedRent(new_car_id, new_kilometersmade, new_comment, new_rent_id);
            String userData = String.format("%s+%s", "success", String.valueOf(success));
            userDataList.add(userData);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/confirmedrents/insertConfirmedRent"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
        
    }

    @GetMapping("/confirmedrents/deleteConfirmedRent")
    public ResponseEntity<Map<String, Object>> deleteConfirmedRent(
    @RequestParam int confirmedrent_id
    ) throws SQLException {
        List<String> userDataList = new ArrayList<>();
        try{
            int success = bc.deleteConfirmedRent(confirmedrent_id);
            String userData = String.format("%s+%s", "success", String.valueOf(success));
            userDataList.add(userData);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/confirmedrents/deleteConfirmedRent"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
        
    }
}
