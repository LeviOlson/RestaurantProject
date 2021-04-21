package dmacc.beans;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Abutalib Hasan - amhasan
 * 202101 CIS171 12928
 * Apr 2, 2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDate date;
	@ManyToOne
	private Customer customer;
	@OneToMany
	private List<MenuItems> menuItem;
	@OneToOne
	private PaymentInfo payment;
}
