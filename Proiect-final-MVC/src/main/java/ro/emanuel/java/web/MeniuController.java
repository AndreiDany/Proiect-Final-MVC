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

import ro.emanuel.java.dao.ProduseCulinareDAO;
import ro.emanuel.java.pojo.ProdusCulinar;

@Controller
public class MeniuController {

	@RequestMapping(value="afiseazaMeniu.htm", method=RequestMethod.GET)
	public ModelAndView listaProduseCulinar(@RequestParam("produsCulinar") String produsCulinar) throws SQLException {
		
		int felulDorit = Integer.parseInt(produsCulinar);
		
		ArrayList<ProdusCulinar> produseCulinare = ProduseCulinareDAO.getALL();
		ArrayList<ProdusCulinar> produseCulinareCerute = new ArrayList<ProdusCulinar>();
		
		
		Iterator<ProdusCulinar> it = produseCulinare.iterator();
		
		while (it.hasNext()) {
			
			ProdusCulinar produsulCulinar = it.next();
			
			if(felulDorit == 1 && produsulCulinar.getNumeProdusCulinar().startsWith("Pizza")) {
				produseCulinareCerute.add(produsulCulinar);
				
				//System.out.println(produsulCulinar.getNumeProdusCulinar());
				
			}
			else if(felulDorit == 2 && produsulCulinar.getNumeProdusCulinar().startsWith("Paste")) {
				produseCulinareCerute.add(produsulCulinar);
				
				//System.out.println(produsulCulinar.getNumeProdusCulinar());
				
			}
			else if(felulDorit == 3 && produsulCulinar.getNumeProdusCulinar().startsWith("Kebab")) {
				produseCulinareCerute.add(produsulCulinar);

				
			}
			else if(felulDorit == 4 && produsulCulinar.getNumeProdusCulinar().startsWith("Tort")) {
				produseCulinareCerute.add(produsulCulinar);

				
			}
		}
		
		ModelMap model = new ModelMap();
		
		model.put("produseCulinareCerute", produseCulinareCerute);
		
		
		return new ModelAndView("Meniu.jsp", "model", model);
	}


	@RequestMapping(value="pregatireAdaugareProdus.htm")
	public ModelAndView prepareAdaugareProdusCulinar(Model model) {
		
		ProdusCulinar produsCulinarNou = new ProdusCulinar();
		model.addAttribute("produsCulinarForm", produsCulinarNou);
		
		return new ModelAndView("AdaugareProdusCulinar.jsp", "model", model);
	}


	@RequestMapping(value="adaugareProdus.htm", method=RequestMethod.POST)
	public ModelAndView adaugareProdus(@ModelAttribute("produsCulinarForm") ProdusCulinar produsCulinar,
			ModelMap model, BindingResult result) throws SQLException {

		ProduseCulinareDAO.insert(produsCulinar);
		
		return new ModelAndView("redirect:/index.jsp#menu");
	}
	
	@RequestMapping(value="pregatireModificareProdus.htm")
	public ModelAndView prepareModificareProdusCulinar(@RequestParam("id") String id, 
			Model model) throws SQLException {
		
		int ID=Integer.parseInt(id);
		
		ProdusCulinar produsCulinar = ProduseCulinareDAO.getById(ID);
		
		model.addAttribute("produsCulinar", produsCulinar);
		
		return new ModelAndView("ModificareProdusCulinar.jsp", "model", model);
	}


	@RequestMapping(value="modificareProdus.htm", method=RequestMethod.POST)
	public ModelAndView modificareProdus(@ModelAttribute("produsCulinar") ProdusCulinar produsCulinar,
			ModelMap model, BindingResult result) throws SQLException {

		ProduseCulinareDAO.updatePrepared(produsCulinar);
		
		return new ModelAndView("redirect:/index.jsp#menu");
	}
	
	
	@RequestMapping(value="stergereProdus.htm")
	public ModelAndView stergereProdus(@RequestParam("id") String id,
			Model model) throws SQLException {
				
		int ID=Integer.parseInt(id);

		ProduseCulinareDAO.delete(ID);
		
		return new ModelAndView("redirect:/index.jsp#menu");
	}


}
