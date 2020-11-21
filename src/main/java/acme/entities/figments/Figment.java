
package acme.entities.figments;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Figment extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	/*
	 * The system must store figments, each of which consists of a title,
	 * a creation moment, the name of its inventor, a piece of text that
	 * describes it, and a prospective price interval.
	 */

	@NotBlank
	private String				title;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date				creationMoment;

	@NotBlank
	private String				inventorName;

	@NotBlank
	@Size(min = 1, max = 256)
	private String				description;

	@NotNull
	private Money				minMoney;

	@NotNull
	private Money				maxMoney;

}
