package com.example.courseWork.Services.BDService;

import com.example.courseWork.Database.Entities.GenderTrain;
import com.example.courseWork.Database.Entities.TranType;
import com.example.courseWork.Database.reposes.GenderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderTrainService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BankTransactionService.class.getName());
    private final GenderRepository genderRepository;

    public GenderTrainService(GenderRepository genderRepository){
        this.genderRepository = genderRepository;
    }

    public void save(List<String[]> data)
    {
        for (int i = 1; i < data.size(); i++)
        {
            GenderTrain newCustomer = new GenderTrain();
            newCustomer.setCustomer_id(Long.parseLong(data.get(i)[0]));
            newCustomer.setGender(Byte.parseByte(data.get(i)[1]));
            genderRepository.save(newCustomer);
        }
        LOGGER.info("Файл transactions_cut.csv успешно загружен");
    }
}
