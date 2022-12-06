package com.example.courseWork.Controllers;

import com.example.courseWork.Services.BDService.BankTransactionService;
import com.example.courseWork.Services.BDService.GenderTrainService;
import com.example.courseWork.Services.BDService.MccCodesService;
import com.example.courseWork.Services.BDService.TypeService;
import com.example.courseWork.Services.ValidationFileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Controller
public class FileLoadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShowResultsController.class.getName());

    private final BankTransactionService transactionService;
    private final GenderTrainService genderTrainService;
    private final MccCodesService mccCodesService;
    private final TypeService typeService;

    @Autowired
    public FileLoadController(BankTransactionService transactionService, GenderTrainService genderTrainService,
                         MccCodesService mccCodesService, TypeService typeService) {
        this.transactionService = transactionService;
        this.genderTrainService = genderTrainService;
        this.mccCodesService = mccCodesService;
        this.typeService = typeService;
    }

    @GetMapping("/CSVLoadFiles")
    public String CSVLoadPage() {

        return "CSVLoadFiles";
    }

    //Получение файла, парсинг и отправка в бд
    @PostMapping("/CSVLoadFiles")
    public String GetCSVLoad(@RequestParam("new_file") MultipartFile file, Model model) {

        LOGGER.info("Загрузка " + file.getOriginalFilename());
        String fileName = file.getOriginalFilename();

        ValidationFileService validation = new ValidationFileService(file);
        validation.valid();

        if (fileName.equals("transactions_cut.csv"))
        {
            transactionService.save(validation.getData());
            LOGGER.info(validation.getData().toString());
        }
        else if (fileName.equals("gender_train_cut.csv"))
        {
            genderTrainService.save(validation.getData());
            LOGGER.info(validation.getData().toString());
        }
        else if (fileName.equals("tr_mcc_codes.csv"))
        {
            mccCodesService.save(validation.getData());
            LOGGER.info(validation.getData().toString());
        }
        else if(fileName.equals("tr_types.csv"))
        {
            typeService.save(validation.getData());
            LOGGER.info(validation.getData().toString());
        }

        model.addAttribute("message", validation.getMessage());
        model.addAttribute("color", validation.getMessageColor());

        return "CSVLoadFiles";
    }
}
