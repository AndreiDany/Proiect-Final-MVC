package ro.emanuel.java.web;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ro.emanuel.java.dao.ClientiDAO;
import ro.emanuel.java.pojo.Client;
@Controller
public class ClientController {

	@RequestMapping(value="listaClienti.htm", method=RequestMethod.GET)
	public ModelAndView listaClienti() throws SQLException {
		
		ModelMap model = new ModelMap();
		
		ArrayList<Client> clienti = ClientiDAO.getALL();
		
		model.put("clienti", clienti);
		
		return new ModelAndView("Clienti.jsp", "model", model);
	}
	
	
	@RequestMapping(value="pregatireAdaugareClient.htm")
	public ModelAndView pregatireAdaugareClient(Model model) {
		
		Client client = new Client();
		model.addAttribute("clientForm", client);
		
		return new ModelAndView("adaugareClient.jsp", "model", model);
	}
	
	
	@RequestMapping(value="adaugareClient.htm", method=RequestMethod.POST)
	public ModelAndView adaugareClient(@ModelAttribute("clientForm") Client client,
			ModelMap model, BindingResult result) throws SQLException {

		ClientiDAO.insert(client);
		
		return new ModelAndView("redirect:/index.html");
	}
	
	
	@RequestMapping(value="pregatireModificareClient.htm")
	public ModelAndView prepareModificareClient(@RequestParam("id") String id, 
			Model model) throws SQLException {
		
		int ID=Integer.parseInt(id);
		
		Client client = ClientiDAO.getById(ID);
		
		model.addAttribute("client", client);
		
		return new ModelAndView("ModificareClient.jsp", "model", model);
	}


	@RequestMapping(value="modificareClient.htm", method=RequestMethod.POST)
	public ModelAndView modificareClient(@ModelAttribute("client") Client client,
			ModelMap model, BindingResult result) throws SQLException {

		ClientiDAO.updatePrepared(client);
		
		return new ModelAndView("redirect:/index.jsp#contact");
	}
	
	
	@RequestMapping(value="stergereClient.htm")
	public ModelAndView stergereProdus(@RequestParam("id") String id,
			Model model) throws SQLException {
				
		int ID=Integer.parseInt(id);

		ClientiDAO.delete(ID);
		
		return new ModelAndView("redirect:/index.jsp#contact");
	}
}
