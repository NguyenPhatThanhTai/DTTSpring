package net.dtt.spring.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name = "datatest")
public class Test implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String Id;
	private String Name;
	private String Note;
	private Set<Two> Two = new HashSet<Two>();
	
	public Test() {
		
	}
	
	public Test(String Id) {
		this.Id = Id;
	}
	
	public Test(String Id, String Name, String Note) {
		this.Id = Id;
		this.Name = Name;
		this.Note = Note;
	}
	
	public Test(String Id, String Name, String Note, Set<Two> Two) {
		this.Id = Id;
		this.Name = Name;
		this.Note = Note;
		this.Two = Two;
	}
	
	@Id
	@Column(name = "Id", length = 200, nullable = false)
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		this.Id = id;
	}

	@Column(name = "Name", length = 200, nullable = true)
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}
	
	@Column(name = "Note", length = 200, nullable = true)
	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		this.Note = note;
	}
	
	@OneToMany(mappedBy = "test", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<Two> getTwo() {
        return this.Two;
    }

    public void setTwo(Set<Two> two) {
        this.Two = two;
    }
}
