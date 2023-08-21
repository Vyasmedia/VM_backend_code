package com.vm.Vyas_Media.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
import lombok.Data;

@Entity
@Data
@Table(name = "movetotrash")
@SQLDelete(sql = "UPDATE movetotrash SET deleted=true WHERE id=?")
//@Where(clause = "deleted = false")
@FilterDef(
        name = "deletedUserFilter",
        parameters = @ParamDef(name = "isDeleted", type = "boolean")
)
@Filter(
        name = "deletedUserFilter",
        condition = "deleted = :isDeleted"
)
public class MovetoTrash {

    @Id
    @GeneratedValue
	private int id;  
	 
	private String headline; 
  
	private String subHeadline;  

	private String description;  
 
	private String hashtag;
	
    private Boolean deleted;
	
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
   
}
