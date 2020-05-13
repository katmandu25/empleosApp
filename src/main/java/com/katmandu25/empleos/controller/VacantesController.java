package com.katmandu25.empleos.controller;

import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.katmandu25.empleos.model.Vacante;
import com.katmandu25.empleos.service.IVacantesService;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {
	
	@Autowired
	private IVacantesService serviceVacantes;
	
	@GetMapping("/create")
	public String crearVacante(Vacante vacante) {
		return "vacantes/formVacante";
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Vacante> listVacantes = serviceVacantes.buscarTodas();
		model.addAttribute("vacantes", listVacantes);
		
		return "vacantes/listVacantes";
	}
	
	
	@PostMapping("/save")
	//public String guardar(Vacante vacante, BindingResult result, Model model){   // El Binding siempre destras de la clase modelo
	public String guardar(Vacante vacante, BindingResult result, RedirectAttributes attributes){   // Los RedirectAtributos se borran de la sesión tras el redirect
		
		if(result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio el error: "+ error.getDefaultMessage());
			}
			return "vacantes/formVacante";
		}
		System.out.println("Objec t: "+ vacante);
		//model.addAttribute("msg", "Registro guardado"); //Ojo al hacer redirect es 2ª petición y el model no está disponible
		attributes.addFlashAttribute("msg", "Registro guardado");// Este si perdira tras el redirect
		serviceVacantes.guardar(vacante);
		return "redirect:/vacantes/index";		 
	}
	
	/*@PostMapping("/save")
	public String guardar(@RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion,
			@RequestParam("estatus") String estatus,
			@RequestParam("fecha") String fecha,
			@RequestParam("destacado") int destacado,
			@RequestParam("salario") double salario,
			@RequestParam("detalles") String detalles){
		
		System.out.println("nombre"+nombre);
		return "vacantes/listVacantes";		
	}*/
	
	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int idVacante, Model model) {
		System.out.println("Borrando vacante con id "+idVacante);
		model.addAttribute("id",idVacante);
		return "mensaje";
	}
	
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model model) {
		
		Vacante vacante = serviceVacantes.buscarPorId(idVacante);
		
		System.out.println("Vacante: " + vacante);
		model.addAttribute("vacante", vacante);
		
		 //Buscar detalles de vacante en BBDD
		
		return "/vacantes/detalle";
	}
	
	@InitBinder
	public void initBinder (WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
		

}
