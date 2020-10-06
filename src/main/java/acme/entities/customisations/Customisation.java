
package acme.entities.customisations;

import javax.persistence.Entity;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customisation extends DomainEntity {

	private static final long	serialVersionUID	= 1;

	@NotBlank
	private String				spam;

	@NotNull
	@Digits(integer = 3, fraction = 2)
	@Min(0)
	@Max(100)
	private Double				threshold;

	@NotBlank
	private String				itemCategories;

	@NotBlank
	private String				newsCategories;

}
