package lt.inkodus.opta.school.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;


@Entity
public class TimeTableWrapper {
	
    @Id @GeneratedValue
    private Long id;
	
    @Lob 
    @Column(name="CONTENT", length=8000)
    private String serializedTimeTable;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getSerializedTimeTable() {
		return serializedTimeTable;
	}


	public void setSerializedTimeTable(String serializedTimeTable) {
		this.serializedTimeTable = serializedTimeTable;
	}
    
    
}
