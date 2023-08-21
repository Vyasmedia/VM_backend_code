package com.vm.Vyas_Media.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categorysearch")
public class CategorySearch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column  
	private String headline; 
	
	@Column  
	private String subHeadline;  
	
	@Column  
	private String description;  
	
	@Column  
	private String hashtag;
	
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime dateUpdated;
    
	/*
	 * public LocalDateTime getDateCreated() { return dateCreated; } public void
	 * setDateCreated(LocalDateTime dateCreated) { this.dateCreated = dateCreated; }
	 * public LocalDateTime getDateUpdated() { return dateUpdated; } public void
	 * setDateUpdated(LocalDateTime dateUpdated) { this.dateUpdated = dateUpdated; }
	 */
 
}

