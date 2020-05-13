package com.katmandu25.empleos.service;

import java.util.List;
import com.katmandu25.empleos.model.Vacante;

public interface IVacantesService {
	
	List<Vacante> buscarTodas();
	Vacante buscarPorId(Integer idVacante);
	void guardar(Vacante vacante);

}
