package lt.inkodus.opta.school.domain;

import java.io.Serializable;
import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.SolverStatus;

@PlanningSolution
public class TimeTable implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;

	@ValueRangeProvider
	@ProblemFactCollectionProperty
	private List<Timeslot> timeslotList;

	@ValueRangeProvider
	@ProblemFactCollectionProperty
	private List<Room> roomList;

	@PlanningEntityCollectionProperty
	private List<Lesson> lessonList;

	@PlanningScore
	private HardSoftScore score;

	// Ignored by OptaPlanner, used by the UI to display solve or stop solving
	// button
	private SolverStatus solverStatus;

	// No-arg constructor required for OptaPlanner
	public TimeTable() {
	}

	public TimeTable(List<Timeslot> timeslotList, List<Room> roomList, List<Lesson> lessonList) {
		this.timeslotList = timeslotList;
		this.roomList = roomList;
		this.lessonList = lessonList;
	}

	// ************************************************************************
	// Getters and setters
	// ************************************************************************

	public List<Timeslot> getTimeslotList() {
		return timeslotList;
	}

	public List<Room> getRoomList() {
		return roomList;
	}

	public List<Lesson> getLessonList() {
		return lessonList;
	}

	public HardSoftScore getScore() {
		return score;
	}

	public SolverStatus getSolverStatus() {
		return solverStatus;
	}

	public void setSolverStatus(SolverStatus solverStatus) {
		this.solverStatus = solverStatus;
	}

	@Override
	public String toString() {
		return String.format("TimeTable: timeslots: %s; rommlist: %s; lessonList %s", 
				this.timeslotList.size(),  
				this.roomList.size(),  
				this.lessonList.size()
				);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
