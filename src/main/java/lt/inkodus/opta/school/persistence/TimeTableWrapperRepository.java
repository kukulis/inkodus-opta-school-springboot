package lt.inkodus.opta.school.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import lt.inkodus.opta.school.domain.TimeTableWrapper;

public interface TimeTableWrapperRepository extends CrudRepository<TimeTableWrapper, Long>, PagingAndSortingRepository<TimeTableWrapper, Long> {

}
