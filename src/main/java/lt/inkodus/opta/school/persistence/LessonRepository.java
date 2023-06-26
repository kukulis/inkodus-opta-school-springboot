package lt.inkodus.opta.school.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import lt.inkodus.opta.school.domain.Lesson;

public interface LessonRepository extends CrudRepository<Lesson, Long>, PagingAndSortingRepository<Lesson, Long> {

    @Override
    List<Lesson> findAll();

}
