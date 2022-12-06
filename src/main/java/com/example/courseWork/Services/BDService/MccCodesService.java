package com.example.courseWork.Services.BDService;

import com.example.courseWork.Database.Entities.MccCode;
import com.example.courseWork.Database.reposes.MccCodesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MccCodesService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BankTransactionService.class.getName());
    private final MccCodesRepository codesRepository;

    public MccCodesService(MccCodesRepository codesRepository) {
        this.codesRepository = codesRepository;
    }

    public void save(List<String[]> data)
    {
        for (int i = 1; i < data.size(); i++)
        {
            MccCode newMccCode = new MccCode();
            newMccCode.setMcc_code(Long.parseLong(data.get(i)[0]));
            newMccCode.setMcc_description(data.get(i)[1]);
            codesRepository.save(newMccCode);
        }
        LOGGER.info("Файл transactions_cut.csv успешно загружен");
    }
}
