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
public class rentController {
    baseConnection bc = new baseConnection();


    @GetMapping("/rents")
    public ResponseEntity<Map<String, Object>> getAllRents() throws SQLException {
        ResultSet resultSet = bc.getAllRents();
        List<String> userDataList = new ArrayList<>();
        while(resultSet.next()) {
            int user_id = resultSet.getInt("user_id");
            int car_id = resultSet.getInt("car_id");
            String fromdate = resultSet.getString("fromdate");
            String todate = resultSet.getString("todate");
            int completed = resultSet.getInt("completed");
            String userData = String.format("%s+%s+%s+%s+%s", String.valueOf(user_id), String.valueOf(car_id), fromdate, todate, String.valueOf(completed));
            userDataList.add(userData);
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/rents"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
    }

    @GetMapping("/rents/getSpec")
    public ResponseEntity<Map<String, Object>> getSpecRent(@RequestParam(name = "id") int id) throws SQLException {
        ResultSet resultSet = bc.getSpecRent(id);
        List<String> userDataList = new ArrayList<>();
        while(resultSet.next()) {
            int user_id = resultSet.getInt("user_id");
            int car_id = resultSet.getInt("car_id");
            String fromdate = resultSet.getString("fromdate");
            String todate = resultSet.getString("todate");
            int completed = resultSet.getInt("completed");
            String userData = String.format("%s+%s+%s+%s+%s", String.valueOf(user_id), String.valueOf(car_id), fromdate, todate, String.valueOf(completed));
            userDataList.add(userData);
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/rents/getSpec"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
    }


    @GetMapping("/rents/updateRent")
    public ResponseEntity<Map<String, Object>> updateRent(
    @RequestParam int new_id,
    @RequestParam int new_user_id,
    @RequestParam int new_car_id,
    @RequestParam String new_fromdate,
    @RequestParam String new_todate,
    @RequestParam int new_completed
    ) throws SQLException {
        List<String> userDataList = new ArrayList<>();
        try{
            int success = bc.updateRent(new_id, new_user_id, new_car_id, new_fromdate, new_todate, new_completed);
            String userData = String.format("%s+%s", "success", String.valueOf(success));
            userDataList.add(userData);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/rent/updateRent"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
        
    }

    @GetMapping("/rents/insertRent")
    public ResponseEntity<Map<String, Object>> insertRent(
        @RequestParam int new_user_id,
        @RequestParam int new_car_id,
        @RequestParam String new_fromdate,
        @RequestParam String new_todate
    ) throws SQLException {
        List<String> userDataList = new ArrayList<>();
        try{
            int success = bc.insertRent(new_user_id, new_car_id, new_fromdate, new_todate);
            String userData = String.format("%s+%s", "success", String.valueOf(success));
            userDataList.add(userData);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/rents/insertRent"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
        
    }

    @GetMapping("/rents/deleteRent")
    public ResponseEntity<Map<String, Object>> deleteRent(
    @RequestParam int rent_id
    ) throws SQLException {
        List<String> userDataList = new ArrayList<>();
        try{
            int success = bc.deleteRent(rent_id);
            String userData = String.format("%s+%s", "success", String.valueOf(success));
            userDataList.add(userData);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", userDataList);
        responseBody.put("meta", Collections.singletonMap("count", userDataList.size()));
        responseBody.put("links", Collections.singletonMap("endpoint", "/rents/deleteRent"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok()
                             .headers(headers)
                             .body(responseBody);
        
    }
}
