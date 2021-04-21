
package dmacc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dmacc.beans.CustomerOrder;
import dmacc.beans.MenuItems;
import dmacc.repository.CustomerOrderRepository;

/**
 * @author Jeremy Brannen - jrbrannen
 *CIS175
 * Apr 5, 2021
 */
@Controller
public class CustomerOrderController {
	
	@Autowired
	CustomerOrderRepository repo;
	
	// display an order
//	@GetMapping({"displayOrder"})
//		public String viewOrder(Model model) {
//		if(repo.findAll().isEmpty()) {
//			return addNewOrder(null, model);
//		}
//		model.addAttribute("Order", repo.findAll());
//		return "results";
//	}
	
	// adds a new order to database
	@PostMapping("/addNewOrder")
		public String addNewOrder(@RequestParam(defaultValue = "false") boolean checkbox) {
			CustomerOrder o = new CustomerOrder();
			
			if(checkbox == true) {
				
			}		
			return "addNewOrder";
	}
	
	// edits order pull order from database by id
	@GetMapping("/editOrder/{id}")
		public String editOrder(@PathVariable("id") long id, Model model) {
		CustomerOrder o = repo.findById(id).orElse(null);
		model.addAttribute("newOrder", o);
		return "input";
	}
	
//	// updates a current order
//	@PostMapping("/createOrder/{id}")
//		public String updateOrder(@ModelAttribute CustomerOrder o, Model model) {
//		repo.save(o);
//		return viewOrder(model);
//	}
//	
//	// deletes current order id
//	@GetMapping("/deleteOrder/{id}")
//		public String deleteOrder(@PathVariable("id") long id, Model model) {
//		CustomerOrder o = repo.findById(id).orElse(null);
//		repo.delete(o);
//		return viewOrder(model);
//	}
}
