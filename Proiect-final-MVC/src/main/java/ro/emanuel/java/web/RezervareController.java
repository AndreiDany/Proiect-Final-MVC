package ro.emanuel.java.web;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

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
import ro.emanuel.java.dao.MeseDAO;
import ro.emanuel.java.dao.RezervariDAO;
import ro.emanuel.java.pojo.Masa;
import ro.emanuel.java.pojo.Rezervare;

@Controller
public class RezervareController {

	@RequestMapping(value="PregatireRezervare.htm")
	public ModelAndView pregatireRezervare(Model model) throws SQLException {
		
		Rezervare rezervareForm = new Rezervare();
		model.addAttribute("rezervareForm", rezervareForm);
		
		return new ModelAndView("Rezervare.jsp", "model", model);
	}
	
	
	@RequestMapping(value="SalveazaRezervare.htm")
	public ModelAndView SalveazaRezervare(@ModelAttribute("rezervareForm") Rezervare rezervare,
			ModelMap model, BindingResult result) throws SQLException {
		
		int idClient = ClientiDAO.insert(rezervare.getClient());
		rezervare.getClient().setId(idClient);
		
		ArrayList<Masa> mese = MeseDAO.getAll();
		Iterator<Masa> it = mese.iterator();
		while(rezervare.getNumarPersoane() > 0 && it.hasNext())
		{
			Masa masa = it.next();
			rezervare.setNumarPersoane(rezervare.getNumarPersoane() - masa.getNumarLocuri());
			
			RezervariDAO.insert(rezervare, masa.getId());
		}
		
		return new ModelAndView("redirect:/index.jsp#contact");
	}
	
	
	@RequestMapping(value="listaRezervari.htm", method=RequestMethod.GET)
	public ModelAndView listaRezervari() throws SQLException {
		
		ModelMap model = new ModelMap();
		
		ArrayList<Rezervare> rezervari = RezervariDAO.getALL();
		
		model.put("rezervari", rezervari);
		
		return new ModelAndView("Rezervari.jsp", "model", model);
	}
	
	
	@RequestMapping(value="pregatireModificareRezervare.htm")
	public ModelAndView prepareModificareRezervare(@RequestParam("id") String id, 
			Model model) throws SQLException {
		
		int ID=Integer.parseInt(id);
		
		Rezervare rezervare = RezervariDAO.getById(ID);
		
		model.addAttribute("rezervare", rezervare);
		
		return new ModelAndView("ModificareRezervare.jsp", "model", model);
	}


	@RequestMapping(value="modificareRezervare.htm", method=RequestMethod.POST)
	public ModelAndView modificareClient(@ModelAttribute("rezervare") Rezervare rezervare,
			ModelMap model, BindingResult result) throws SQLException {

		RezervariDAO.updatePrepared(rezervare);
		
		return new ModelAndView("redirect:/index.jsp#contact");
	}
	
	
	@RequestMapping(value="stergereRezervare.htm")
	public ModelAndView stergereProdus(@RequestParam("id") String id,
			Model model) throws SQLException {
				
		int ID=Integer.parseInt(id);

		RezervariDAO.delete(ID);
		
		return new ModelAndView("redirect:/index.jsp#contact");
	}
	
}
