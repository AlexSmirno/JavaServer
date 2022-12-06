package com.example.courseWork.Services.BDService;

import com.example.courseWork.Database.Entities.BankTransaction;
import com.example.courseWork.Database.Entities.TranType;
import com.example.courseWork.Database.reposes.TypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BankTransactionService.class.getName());
    private final TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public void save(List<String[]> data)
    {
        for (int i = 1; i < data.size(); i++)
        {
            TranType newTranType = new TranType();
            newTranType.setTr_type(Long.parseLong(data.get(i)[0]));
            newTranType.setTr_description(data.get(i)[1]);
            typeRepository.save(newTranType);
        }
        LOGGER.info("Файл transactions_cut.csv успешно загружен");
    }
}
