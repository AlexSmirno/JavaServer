package com.example.courseWork;

import com.example.courseWork.Database.reposes.BankTransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class TestOrmApplicationTests {

    @Autowired
    private BankTransactionRepository repository;

    @Test
    void getDataTest() {
        List<String> result = this.repository.findByAccuranceLimitFive();

        List<String[]> parsedResult = new ArrayList<>();

        for (int i = 0; i < result.size(); i++)
        {
            parsedResult.add(result.get(i).split(","));
        }
        assertThat(parsedResult.get(0)[0]).isEqualTo("Покупка. POS ТУ СБ РФ");
        assertThat(parsedResult.size()).isEqualTo(5);
    }
}
