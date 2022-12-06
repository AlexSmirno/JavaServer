package com.example.courseWork.Database.reposes;

import com.example.courseWork.Database.Entities.GenderTrain;
import org.springframework.data.repository.CrudRepository;

public interface GenderRepository extends CrudRepository<GenderTrain, Long>{
}