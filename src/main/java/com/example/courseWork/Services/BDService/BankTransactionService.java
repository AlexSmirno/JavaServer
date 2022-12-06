package com.example.courseWork.Services.BDService;

import com.example.courseWork.Database.Entities.BankTransaction;
import com.example.courseWork.Database.reposes.BankTransactionRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BankTransactionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankTransactionService.class.getName());
    private final BankTransactionRepository bankTransactionRepository;

    @Autowired
    public BankTransactionService(BankTransactionRepository bankTransactionRepository)
    {
        this.bankTransactionRepository = bankTransactionRepository;
    }

    public void save(List<String[]> data)
    {
        for (int i = 1; i < data.size(); i++)
        {
            BankTransaction newTran = new BankTransaction();
            newTran.setCustomer_id(Long.parseLong(data.get(i)[0]));
            newTran.setTr_datetime(data.get(i)[1]);
            newTran.setMcc_code(Long.parseLong(data.get(i)[2]));
            newTran.setTr_type(Long.parseLong(data.get(i)[3]));
            newTran.setAmount(Double.parseDouble(data.get(i)[4]));
            newTran.setTr_datetime(data.get(i)[5]);
            bankTransactionRepository.save(newTran);
        }
        LOGGER.info("Файл transactions_cut.csv успешно загружен");
    }

    public List<String> FindOccurance()
    {
        return bankTransactionRepository.findByAccurance();
    }

    public List<String> FindTopFiveOccurrence(){
        return bankTransactionRepository.findByAccuranceLimitFive();
    }
}
