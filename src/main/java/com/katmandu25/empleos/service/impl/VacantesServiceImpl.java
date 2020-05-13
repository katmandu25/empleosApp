package com.katmandu25.empleos.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.katmandu25.empleos.model.Vacante;
import com.katmandu25.empleos.service.IVacantesService;

@Service
public class VacantesServiceImpl implements IVacantesService {
	
	private List<Vacante> lista =  null;
	
	public VacantesServiceImpl() {
		
		this.lista =  new LinkedList<>();
		SimpleDateFormat sdf =  new SimpleDateFormat("dd-MM-yyyy");
		
		
		try {			
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero Civil");
			vacante1.setDescripcion("Solicitamos Ing civil para diseño de puente");
			vacante1.setFecha(sdf.parse("08-02-2019"));
			vacante1.setSalario(14000.0);
			vacante1.setDestacado(1);
			vacante1.setImagen("logo1.png");
			
			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Contador Público");
			vacante2.setDescripcion("Solicitamos contador con 5 años de experiencia");
			vacante2.setFecha(sdf.parse("09-02-2019"));
			vacante2.setSalario(12000.0);
			vacante2.setDestacado(0);
			vacante2.setImagen("logo2.png");
			
			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Ingeniero Eléctrico");
			vacante3.setDescripcion("Solicitamos Ing eléctrico para mantenimiento de instalación");
			vacante3.setFecha(sdf.parse("10-02-2019"));
			vacante3.setSalario(10500.0);
			vacante3.setDestacado(0);
			
			Vacante vacante4 = new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Diseñador gráfico");
			vacante4.setDescripcion("Solicitamos Diseñador Gráfico Titulado para publicidad");
			vacante4.setFecha(sdf.parse("11-02-2019"));
			vacante4.setSalario(8500.0);
			vacante4.setDestacado(1);
			vacante4.setImagen("logo3.png");
			
			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);
				
		}
		catch	(ParseException e){
			System.out.println("Error: " + e.getMessage());
		}
	}

	@Override
	public List<Vacante> buscarTodas() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		
		for (Vacante v: lista) {
			
			if (v.getId()==idVacante)	{
				return v;
			}
		}
		
		return null;
	}

	@Override
	public void guardar(Vacante vacante) {
		this.lista.add(vacante);
		
	}

}
