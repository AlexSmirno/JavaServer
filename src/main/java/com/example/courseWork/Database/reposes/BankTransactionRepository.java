package com.example.courseWork.Database.reposes;

import com.example.courseWork.Database.Entities.BankTransaction;
import org.hibernate.Transaction;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankTransactionRepository extends CrudRepository<BankTransaction, Long>{

    @Query (value = "select tr_types.tr_description as Discription, count(tr_types.tr_types) as quantity,\n" +
            "count(tr_types.tr_types)*1.0/(select count(tr_type) from transactions_cut) as occurrence\n" +
            "from transactions_cut\n" +
            "join tr_types on tr_types.tr_types = transactions_cut.tr_type\n" +
            "group by tr_types.tr_types\n" +
            "order by quantity DESC",
            nativeQuery = true)
    List<String> findByAccurance();

    @Query (value = "select tr_types.tr_description as Discription, count(tr_types.tr_types) as quantity,\n" +
            "count(tr_types.tr_types)*1.0/(select count(tr_type) from transactions_cut) as occurrence\n" +
            "from transactions_cut\n" +
            "join tr_types on tr_types.tr_types = transactions_cut.tr_type\n" +
            "group by tr_types.tr_types\n" +
            "order by quantity DESC\n" +
            "limit 5",
            nativeQuery = true)
    List<String> findByAccuranceLimitFive();
}
