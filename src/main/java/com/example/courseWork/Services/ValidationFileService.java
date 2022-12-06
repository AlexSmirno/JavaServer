package com.example.courseWork.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ValidationFileService {

    private MultipartFile file;
    private String fileName;
    private String message;
    private String messageColor;
    private String messageForLog;
    private List<String[]> data;
    private String[] fileNames = {"transactions_cut.csv", "tr_mcc_codes.csv", "tr_types.csv" ,"transactions_cut.csv"};
    private static final Logger log = LoggerFactory.getLogger(ValidationFileService.class);

    public ValidationFileService(MultipartFile file)
    {
        this.file = file;
        fileName = file.getOriginalFilename();
        log.info(ValidationFileService.log.getName() + " контсруктор");
    }

    public void valid()
    {
        if (fileName == null || fileName.length() < 1)
        {
            message = "Вы не выбрали файл";
            messageColor = "color:Crimson";
            messageForLog = "Файл не был выбран";
        }
        else if (fileName.contains(".csv") && isTrueFile())
        {
            message = "Загрузка успешна!";
            messageColor = "color:DarkGreen";
            messageForLog = "Загрузка файла " + fileName + "произошла успешна!";
            
            try (InputStream inputStream = file.getInputStream()){
                MyCSVReaderService parser = new MyCSVReaderService(inputStream, file.getOriginalFilename());
                data = parser.parse();
            } catch (IOException e) {
                log.info(e.getMessage());
            }
        }
        else
        {
            message = "Вы не выбрали файл не подходящего разрешения. Пожалуйста, выберете .csv файл";
            messageColor = "color:Crimson";
            messageForLog = "Был выбран файл не подходящего разрешения";
        }
    }

    private boolean isTrueFile()
    {
        for (int i = 0; i < fileNames.length; i++)
        {
            if (fileName.equals(fileNames[i]))
            {
                return true;
            }
        }
        return false;
    }
    public String getMessage()
    {
        return message;
    }

    public String getMessageColor() {
        return messageColor;
    }

    public String getMessageForLog() {
        return messageForLog;
    }

    public List<String[]> getData()
    {
        return data;
    }

}
