package com.example.rentapi;

import java.io.Console;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Iterator;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;

import org.json.*;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/user")
    public String getJSONString() {
        String json = null;
        ResultSet rst = bc.getAllUsers();
        JSONArray arr = new JSONArray();
        Map<String, Object> map = null;
        try {
            JSONObject obj = new JSONObject();
            int index = 1;
            while(rst.next())
            {
                obj.put("name", rst.getString(index));
                map = obj.toMap();
                index++;
            }
            
            arr.put(map);
            map.clear();
            // Serialize the Map using Jackson
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(arr);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return json;
    }

    @GetMapping("/user/getName")
    public String specUser(@RequestParam(name = "userName") String name)
    {
        return "username is: "+name;
    }
}
