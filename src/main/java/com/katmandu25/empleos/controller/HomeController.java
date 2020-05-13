package com.katmandu25.empleos.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.katmandu25.empleos.model.Vacante;
import com.katmandu25.empleos.service.IVacantesService;

@Controller
public class HomeController {

	@Autowired
	private IVacantesService servicesVacantes;

	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		// List<Vacante> lista = getVacantes();
		List<Vacante> lista = servicesVacantes.buscarTodas();
		model.addAttribute("vacantes", lista);

		return "tabla";
	}

	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {

		Vacante vacante = new Vacante();
		vacante.setNombre("Ingeniero de comunicaciones");
		vacante.setDescripcion("Se solicita ingeniero para dar soporte a Intranet");
		vacante.setFecha(new Date());
		vacante.setSalario(9700.0);

		model.addAttribute("vacante", vacante);

		return "detalle";

	}

	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<String>();

		lista.add("Ingeniero de Sistemas");
		lista.add("Auxiliar de Contabilidad");
		lista.add("Vendedor");
		lista.add("Arquitecto");

		model.addAttribute("empleos", lista);

		return "listado";
	}

	@GetMapping("/")
	public String mostrarHome(Model model) {
		/*
		 * model.addAttribute("mensaje", "Bienvenidos a Empleos App");
		 * model.addAttribute("fecha",new Date());
		 * 
		 * 
		 * String nombre = "Auxiliar de Contabilidad"; Date fechaPub = new Date();
		 * double salario = 9000.0; boolean vigente = true;
		 * 
		 * model.addAttribute("nombre", nombre); model.addAttribute("fecha", fechaPub);
		 * model.addAttribute("salario", salario); model.addAttribute("vigente",
		 * vigente);
		 */

		List<Vacante> lista = servicesVacantes.buscarTodas();
		model.addAttribute("vacantes", lista);
		
		return "home";
	}

	/*
	 * private List<Vacante> getVacantes() {
	 * 
	 * SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); List<Vacante>
	 * lista = new LinkedList<>();
	 * 
	 * try {
	 * 
	 * Vacante vacante1 = new Vacante(); vacante1.setId(1);
	 * vacante1.setNombre("Ingeniero Civil");
	 * vacante1.setDescripcion("Solicitamos Ing civil para diseño de puente");
	 * vacante1.setFecha(sdf.parse("08-02-2019")); vacante1.setSalario(8500.0);
	 * vacante1.setDestacado(1); vacante1.setImagen("empresa1.png");
	 * 
	 * Vacante vacante2 = new Vacante(); vacante2.setId(2);
	 * vacante2.setNombre("Contador Público");
	 * vacante2.setDescripcion("Solicitamos contador con 5 años de experiencia");
	 * vacante2.setFecha(sdf.parse("09-02-2019")); vacante2.setSalario(12000.0);
	 * vacante2.setDestacado(0); vacante2.setImagen("empresa2.png");
	 * 
	 * Vacante vacante3 = new Vacante(); vacante3.setId(3);
	 * vacante3.setNombre("Ingeniero Eléctrico"); vacante3.
	 * setDescripcion("Solicitamos Ing eléctrico para mantenimiento de instalación"
	 * ); vacante3.setFecha(sdf.parse("10-02-2019")); vacante3.setSalario(10500.0);
	 * vacante3.setDestacado(0);
	 * 
	 * Vacante vacante4 = new Vacante(); vacante4.setId(4);
	 * vacante4.setNombre("Diseñador gráfico"); vacante4.
	 * setDescripcion("Solicitamos Diseñador Gráfico Titulado para publicidad");
	 * vacante4.setFecha(sdf.parse("11-02-2019")); vacante4.setSalario(8500.0);
	 * vacante4.setDestacado(1); vacante4.setImagen("empresa3.png");
	 * 
	 * lista.add(vacante1); lista.add(vacante2); lista.add(vacante3);
	 * lista.add(vacante4);
	 * 
	 * 
	 * 
	 * 
	 * } catch (ParseException e){ System.out.println("Error: " + e.getMessage()); }
	 * 
	 * return lista; }
	 */

}
