package lt.inkodus.opta.school.persistence;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lt.inkodus.opta.school.domain.TimeTable;
import lt.inkodus.opta.school.domain.TimeTableWrapper;

@Service
@Transactional
public class TimeTableRepository {
	@Autowired
	private TimeTableWrapperRepository timeTableWrapperRepository;

	public TimeTable findById(Long id) {
		try {
			Optional<TimeTableWrapper> ow = timeTableWrapperRepository.findById(Long.valueOf(id));
			
			if ( !ow.isPresent() ) {
				return null;
			}
			
			TimeTableWrapper w = ow.get();

			JsonMapper jsonMapper = JsonMapper.builder()
					.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();
			jsonMapper.registerModule(new JavaTimeModule());

			TimeTable timeTable = jsonMapper.readValue(w.getSerializedTimeTable(), TimeTable.class);
			timeTable.setId(w.getId());
			
			return timeTable;
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	public TimeTableWrapper save(TimeTable timeTable) {
		try {
			JsonMapper jsonMapper = new JsonMapper();
			jsonMapper.registerModule(new JavaTimeModule());

			TimeTableWrapper w = new TimeTableWrapper();
			w.setSerializedTimeTable(jsonMapper.writeValueAsString(timeTable));
			
			if ( timeTable.getId() != null ) {
				w.setId(timeTable.getId());
			}

			return this.timeTableWrapperRepository.save(w);

		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}
