# Opta planner api for scool timetabling

# start application 

	mvn spring-boot:run
	
## endpoints

### Add timetable data:

	POST http://localhost:8080/api/time-table
	
### Get timetable data:

	GET http://localhost:8080/api/time-table/1
	
	GET http://localhost:8080/api/time-table/2

...

where 1, 2 ... is the time-table id, which you get in the POST request.

### Solve time table:


	POST http://localhost:8080/api/time-table/solve/1


### Example data for post body (when Add timetable data)  :

	{
	"timeslotList": [
		{
			"id": 1,
			"dayOfWeek": "MONDAY",
			"startTime": "08:30:00",
			"endTime": "09:30:00"
		},
		{
			"id": 2,
			"dayOfWeek": "MONDAY",
			"startTime": "09:30:00",
			"endTime": "10:30:00"
		},
		{
			"id": 3,
			"dayOfWeek": "MONDAY",
			"startTime": "10:30:00",
			"endTime": "11:30:00"
		},
		{
			"id": 4,
			"dayOfWeek": "MONDAY",
			"startTime": "13:30:00",
			"endTime": "14:30:00"
		},
		{
			"id": 5,
			"dayOfWeek": "MONDAY",
			"startTime": "14:30:00",
			"endTime": "15:30:00"
		},
		{
			"id": 6,
			"dayOfWeek": "TUESDAY",
			"startTime": "08:30:00",
			"endTime": "09:30:00"
		},
		{
			"id": 7,
			"dayOfWeek": "TUESDAY",
			"startTime": "09:30:00",
			"endTime": "10:30:00"
		},
		{
			"id": 8,
			"dayOfWeek": "TUESDAY",
			"startTime": "10:30:00",
			"endTime": "11:30:00"
		},
		{
			"id": 9,
			"dayOfWeek": "TUESDAY",
			"startTime": "13:30:00",
			"endTime": "14:30:00"
		},
		{
			"id": 10,
			"dayOfWeek": "TUESDAY",
			"startTime": "14:30:00",
			"endTime": "15:30:00"
		}
	],
	"roomList": [
		{
			"id": 1,
			"name": "Room A"
		},
		{
			"id": 2,
			"name": "Room B"
		},
		{
			"id": 3,
			"name": "Room C"
		}
	],
	"lessonList": [
		{
			"id": 1,
			"subject": "Math",
			"teacher": "A. Turing",
			"studentGroup": "9th grade",
			"timeslot": {
				"id": 1,
				"dayOfWeek": "MONDAY",
				"startTime": "08:30:00",
				"endTime": "09:30:00"
			},
			"room": {
				"id": 1,
				"name": "Room A"
			}
		},
		{
			"id": 2,
			"subject": "Math",
			"teacher": "A. Turing",
			"studentGroup": "9th grade",
			"timeslot": null,
			"room": null
		},
		{
			"id": 3,
			"subject": "Physics",
			"teacher": "M. Curie",
			"studentGroup": "9th grade",
			"timeslot": null,
			"room": null
		},
		{
			"id": 4,
			"subject": "Chemistry",
			"teacher": "M. Curie",
			"studentGroup": "9th grade",
			"timeslot": null,
			"room": null
		},
		{
			"id": 5,
			"subject": "Biology",
			"teacher": "C. Darwin",
			"studentGroup": "9th grade",
			"timeslot": null,
			"room": null
		},
		{
			"id": 6,
			"subject": "History",
			"teacher": "I. Jones",
			"studentGroup": "9th grade",
			"timeslot": null,
			"room": null
		},
		{
			"id": 7,
			"subject": "English",
			"teacher": "I. Jones",
			"studentGroup": "9th grade",
			"timeslot": null,
			"room": null
		},
		{
			"id": 8,
			"subject": "English",
			"teacher": "I. Jones",
			"studentGroup": "9th grade",
			"timeslot": null,
			"room": null
		},
		{
			"id": 9,
			"subject": "Spanish",
			"teacher": "P. Cruz",
			"studentGroup": "9th grade",
			"timeslot": null,
			"room": null
		},
		{
			"id": 10,
			"subject": "Spanish",
			"teacher": "P. Cruz",
			"studentGroup": "9th grade",
			"timeslot": null,
			"room": null
		},
		{
			"id": 11,
			"subject": "Math",
			"teacher": "A. Turing",
			"studentGroup": "10th grade",
			"timeslot": null,
			"room": null
		},
		{
			"id": 12,
			"subject": "Math",
			"teacher": "A. Turing",
			"studentGroup": "10th grade",
			"timeslot": null,
			"room": null
		},
		{
			"id": 13,
			"subject": "Math",
			"teacher": "A. Turing",
			"studentGroup": "10th grade",
			"timeslot": null,
			"room": null
		},
		{
			"id": 14,
			"subject": "Physics",
			"teacher": "M. Curie",
			"studentGroup": "10th grade",
			"timeslot": null,
			"room": null
		},
		{
			"id": 15,
			"subject": "Chemistry",
			"teacher": "M. Curie",
			"studentGroup": "10th grade",
			"timeslot": null,
			"room": null
		},
		{
			"id": 16,
			"subject": "French",
			"teacher": "M. Curie",
			"studentGroup": "10th grade",
			"timeslot": null,
			"room": null
		},
		{
			"id": 17,
			"subject": "Geography",
			"teacher": "C. Darwin",
			"studentGroup": "10th grade",
			"timeslot": null,
			"room": null
		},
		{
			"id": 18,
			"subject": "History",
			"teacher": "I. Jones",
			"studentGroup": "10th grade",
			"timeslot": null,
			"room": null
		},
		{
			"id": 19,
			"subject": "English",
			"teacher": "P. Cruz",
			"studentGroup": "10th grade",
			"timeslot": null,
			"room": null
		},
		{
			"id": 20,
			"subject": "Spanish",
			"teacher": "P. Cruz",
			"studentGroup": "10th grade",
			"timeslot": null,
			"room": null
		}
	],
	"score": "-38init/0hard/0soft",
	"solverStatus": "NOT_SOLVING"
	}


if you put id in to json ( for example "id": 2, ), then the data will be updated instead of inserting new one.

### stop solving

	POST http://localhost:8080/api/time-table/stop-solving/1

# further plans
 
 ..
