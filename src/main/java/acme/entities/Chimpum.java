package acme.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Chimpum extends AbstractEntity{
	
	private static final long serialVersionUID = 1L;
	
	//dddd-01-10-40
	
	@NotBlank
	@Pattern(regexp = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")
	@Column(unique = true)
	protected String code;
	
	@NotNull
	@Past
	@Temporal(value = TemporalType.TIMESTAMP)
	protected Date creationMoment;
	
	@NotBlank
	@Length(max = 100)
	protected String title;
	
	@NotBlank
	@Length(max = 255)
	protected String description;
	
	@Valid
	@NotNull
	protected Money budget;
	
	@URL
	protected String moreInfo;
	
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Item artefact;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@NotNull
	protected Date periodStart;
	
	@Future
	@Temporal(value = TemporalType.TIMESTAMP)
	@NotNull
	protected Date periodFinish;
}
