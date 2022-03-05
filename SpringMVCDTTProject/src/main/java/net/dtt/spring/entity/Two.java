package net.dtt.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "datatwo")
public class Two implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String TwoId;
	private String Note;
	private Test test;
	
	public Two() {
		
	}
	
	public Two(String TwoId, String Note, Test test) {
		this.TwoId = TwoId;
		this.Note = Note;
		this.test = test;
	}
	
	@Id
	@Column(name = "TwoId", length = 200, nullable = false)
	public String getTwoId() {
		return TwoId;
	}

	public void setTwoId(String twoId) {
		this.TwoId = twoId;
	}

	@Column(name = "Note", length = 200, nullable = true)
	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		this.Note = note;
	}
	
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "TestId", nullable = false)
    public Test gettest() {
        return this.test;
    }

    public void settest(Test test) {
        this.test = test;
    }
}
