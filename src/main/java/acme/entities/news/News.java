
package acme.entities.news;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class News extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	/*
	 * The system must store news, each of which consists of a news category, a
	 * header picture, a title, a creation moment, a deadline moment, a body,
	 * and an arbitrary number of links to related news.
	 */

	@NotBlank
	private String				category;

	@NotBlank
	@URL
	private String				headerPicture;

	@NotBlank
	private String				title;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date				deadline;

	@NotBlank
	private String				body;

	@NotBlank
	@URL
	private String				relatedNews;

}
