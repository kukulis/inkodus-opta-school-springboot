package lt.inkodus.opta.school.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import lt.inkodus.opta.school.domain.Room;

public interface RoomRepository extends CrudRepository<Room, Long>, PagingAndSortingRepository<Room, Long> {

    @Override
    List<Room> findAll();

}
