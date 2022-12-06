package com.example.courseWork.Controllers;

import com.example.courseWork.Services.BDService.BankTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ShowResultsController {

    private final BankTransactionService transactionService;

    @Autowired
    public ShowResultsController(BankTransactionService transactionService) {
        this.transactionService = transactionService;
    }

    //Загрузка таблицы на страницу
    @GetMapping("/DataUpload")
    public String DataUpload(Model model) {

        List<String> data = transactionService.FindOccurance();
        List<String[]> dataForWeb = new ArrayList<>();

        for (int i = 0; i < data.size(); i++)
        {
            dataForWeb.add(data.get(i).split(","));
        }

        model.addAttribute("data", dataForWeb);
        return "DataUpload";
    }

    //Загрузка таблицы на страницу
    @GetMapping("/DataUploadTop5")
    public String DataUploadTop5(Model model) {

        List<String> data = transactionService.FindTopFiveOccurrence();
        List<String[]> dataForWeb = new ArrayList<>();

        for (int i = 0; i < data.size(); i++)
        {
            dataForWeb.add(data.get(i).split(","));
        }

        model.addAttribute("data", dataForWeb);
        return "DataUploadTop5";
    }
}
