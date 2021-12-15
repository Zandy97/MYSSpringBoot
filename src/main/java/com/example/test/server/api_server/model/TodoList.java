package com.example.test.server.api_server.model;

// import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoList {
    private int todoPid;
    private String title;
    private String stDate;
    private String endTime;
    private String id;

    // java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
    // String st = sdf.format(stDate);
    // String end = sdf.format(endTime);

}