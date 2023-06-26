package lt.inkodus.opta.school.rest;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.SolutionManager;
import org.optaplanner.core.api.solver.SolverManager;
import org.optaplanner.core.api.solver.SolverStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import lt.inkodus.opta.school.domain.TimeTable;
import lt.inkodus.opta.school.persistence.TimeTableRepository;

@RestController
@RequestMapping(value = "/api", consumes = "application/json", produces = "application/json")
public class ApiController {
	@Autowired
	private TimeTableRepository timeTableRepository;
	@Autowired
	private SolverManager<TimeTable, Long> solverManager;
	@Autowired
	private SolutionManager<TimeTable, HardSoftScore> solutionManager;

	@PostMapping("/time-table")
	public Long store(@RequestBody TimeTable timetable) throws JsonProcessingException {
		return timeTableRepository.save(timetable).getId();
	}

	@GetMapping("/time-table/{id}")
	public TimeTable find(@PathVariable String id) throws JsonProcessingException {

		Long timetableId = Long.valueOf(id);

		// Get the solver status before loading the solution
		// to avoid the race condition that the solver terminates between them
		SolverStatus solverStatus = solverManager.getSolverStatus(timetableId);
		TimeTable solution = timeTableRepository.findById(timetableId);
		
		if ( solution == null ) {
			return solution;
		}
		
		solutionManager.update(solution); // Sets the score
		solution.setSolverStatus(solverStatus);

		return solution;
	}

	@PostMapping("/time-table/solve/{id}")
	public String solve(@PathVariable String id) throws JsonProcessingException {
		Long timetableId = Long.valueOf(id);

		// SolverJob<TimeTable, Long> job =
		solverManager.solveAndListen(timetableId, timeTableRepository::findById, timeTableRepository::save);

		return String.format("Solving timetable %s", timetableId);
	}

	@PostMapping("/time-table/stop-solving/{id}")
	public String stopSolving(@PathVariable String id) {
		Long timetableId = Long.valueOf(id);
		solverManager.terminateEarly(timetableId);
		
		return String.format("Stopping solving timetable %s", timetableId);
	}

}
