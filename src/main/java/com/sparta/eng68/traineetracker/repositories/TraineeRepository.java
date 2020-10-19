package com.sparta.eng68.traineetracker.repositories;

import com.sparta.eng68.traineetracker.entities.Trainee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TraineeRepository extends CrudRepository<Trainee, Integer> {
    List<Trainee> findAllByGroupId(int groupId);
}
