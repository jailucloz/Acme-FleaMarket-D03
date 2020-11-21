
package acme.entities.suggestions;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Suggestion extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	/*
	 * The system must store suggestions, each of which consists of
	 * a title, a creation moment, a piece of text that describes it,
	 * and a contact e-mail.
	 */

	@NotBlank
	private String				title;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date				creationMoment;

	@NotBlank
	@Size(min = 1, max = 256)
	private String				description;

	@NotBlank
	@Email
	private String				email;

}
