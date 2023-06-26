package lt.inkodus.opta.school.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import lt.inkodus.opta.school.domain.Timeslot;

public interface TimeslotRepository extends CrudRepository<Timeslot, Long>, PagingAndSortingRepository<Timeslot, Long> {

    @Override
    List<Timeslot> findAll();

}
