package com.example.courseWork.Services;

import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyCSVReaderService
{
    private List<String[]> data = new ArrayList<>();
    private Scanner scanner;
    private String fileName;
    private static final Logger log = LoggerFactory.getLogger(MyCSVReaderService.class);

    public MyCSVReaderService(InputStream inputStream , String fileName) {
        this.fileName = fileName;
        scanner = new Scanner(inputStream).useDelimiter("\n");
    }


    public List<String[]> parse() {
        if (Objects.equals(fileName, "tr_mcc_codes.csv")
                || Objects.equals(fileName, "tr_types.csv")) {
            while (scanner.hasNext()) {
                String[] curr_string = scanner.next().split(";", -1);
                data.add(curr_string);
            }
        } else {
            while (scanner.hasNext()) {
                String[] curr_string = scanner.next().split(",", -1);
                data.add(curr_string);
            }
        }
        return data;
    }

}
