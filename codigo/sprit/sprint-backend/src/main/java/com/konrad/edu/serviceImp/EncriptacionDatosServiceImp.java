package com.konrad.edu.serviceImp;

import com.konrad.edu.IService.IEncriptacionDatosService;
import com.konrad.edu.entity.ExamenFisicoEncriptacion;
import com.konrad.edu.entity.ExamenFisicoEntity;
import com.konrad.edu.entity.HistoriaGYMEntity;
import com.konrad.edu.entity.HistoriaGymEncriptacion;
import com.konrad.edu.entity.HistoriaOcupacionalEncriptacion;
import com.konrad.edu.entity.HistoriaOcupacionalEntity;

public class EncriptacionDatosServiceImp implements IEncriptacionDatosService {

	@Override
	public HistoriaOcupacionalEntity encriptacionHistoriaOcupacional(HistoriaOcupacionalEncriptacion historiaEntity) {
		HistoriaOcupacionalEntity historia = new HistoriaOcupacionalEntity();
		historia.setSeqHistoria(historiaEntity.getSeqHistoria());
		historia.setSeqTipoHistoria(historiaEntity.getSeqTipoHistoria());
		historia.setExamenFisico(this.encriptacionExamenFisico(historiaEntity.getExamenFisico()));
		historia.setHistoriaLaboral(historiaEntity.getHistoriaLaboral());
		historia.setAntecedentesHistoriaEntity(historiaEntity.getAntecedentesHistoriaEntity());
		historia.setParaclinicosEntity(historiaEntity.getParaclinicosEntity());
		historia.setTipoEvaluacionEntity(historiaEntity.getTipoEvaluacionEntity());
		historia.setCiudadHistoria(historiaEntity.getCiudadHistoria());
		historia.setConceptoConcepto(historiaEntity.getConceptoConcepto());
		historia.setDiagnosticoOcupacionalEntity(historiaEntity.getDiagnosticoOcupacionalEntity());
		historia.setDiaHistoria(historiaEntity.getDiaHistoria());
		historia.setDespMotivoConsulta(historiaEntity.getDespMotivoConsulta().getBytes());
		historia.setRevisionSistemas(historiaEntity.getRevisionSistemas().getBytes());
		historia.setRecomMedicas(historiaEntity.getRecomMedicas().getBytes());
		historia.setRecomOcupacionales(historiaEntity.getRecomOcupacionales().getBytes());
		historia.setRecomHabitos(historiaEntity.getRecomHabitos().getBytes());
		historia.setOtroEvaluacion(
				historiaEntity.getOtroEvaluacion() == null ? null : historiaEntity.getOtroEvaluacion().getBytes());
		historia.setAceptoCondiciones(historiaEntity.getAceptoCondiciones());
		historia.setPersona(historiaEntity.getPersona());
		historia.setPersonaMedico(historiaEntity.getPersonaMedico() == null ? null : historiaEntity.getPersonaMedico());
		return historia;
	}

	@Override
	public HistoriaGYMEntity encriptacionHistoriaGym(HistoriaGymEncriptacion historiaEntity) {
		HistoriaGYMEntity historianew = new HistoriaGYMEntity();
		historianew.setObservacionesHistoria(historiaEntity.getObservacionesHistoria().getBytes());
		historianew.setAceptoCondiciones(historiaEntity.getAceptoCondiciones());
		historianew.setConducta(historiaEntity.getConducta() == null ? null : historiaEntity.getConducta().getBytes());
		historianew.setSeqHistoriaGym(historiaEntity.getSeqHistoriaGym());
		historianew.setSeqTipoHistoria(historiaEntity.getSeqTipoHistoria());
		historianew.setExamenFisico(this.encriptacionExamenFisico(historiaEntity.getExamenFisico()));
		historianew.setCiudadHistoria(historiaEntity.getCiudadHistoria());
		historianew.setHistoriaPreguntasGyms(historiaEntity.getHistoriaPreguntasGyms());
		historianew.setDiagnosticoOcupacionalEntity(historiaEntity.getDiagnosticoOcupacionalEntity());
		historianew.setCondicionGymEntity(historiaEntity.getCondicionGymEntity());
		historianew.setFamiliarGymEntity(historiaEntity.getFamiliarGymEntity());
		historianew.setCuestionarioGymEntity(historiaEntity.getCuestionarioGymEntity());
		historianew.setPersona(historiaEntity.getPersona());
		historianew.setDiaHistoriaGym(historiaEntity.getDiaHistoriaGym());
		historianew.setOtraCondicion(
				historiaEntity.getOtraCondicion() == null ? null : historiaEntity.getOtraCondicion().getBytes());
		historianew.setOtraFamiliar(
				historiaEntity.getOtraFamiliar() == null ? null : historiaEntity.getOtraFamiliar().getBytes());
		historianew.setTipoCancer(
				historiaEntity.getTipoCancer() == null ? null : historiaEntity.getTipoCancer().getBytes());
		historianew.setConducta(historiaEntity.getConducta() == null ? null : historiaEntity.getConducta().getBytes());
		historianew.setPersonaMedico(historiaEntity.getPersonaMedico() == null ? null : historiaEntity.getPersonaMedico());
		return historianew;
	}

	@Override
	public ExamenFisicoEntity encriptacionExamenFisico(ExamenFisicoEncriptacion examenFisicoEntity) {
		ExamenFisicoEntity examen = new ExamenFisicoEntity();
		examen.setSeqExaFisico(examenFisicoEntity.getSeqExaFisico());
		examen.setNumTesion(examenFisicoEntity.getNumTesion());
		examen.setNumFreCar(examenFisicoEntity.getNumFreCar());
		examen.setNumSat(examenFisicoEntity.getNumSat());
		examen.setNumFrecResp(examenFisicoEntity.getNumFrecResp());
		examen.setNumPeso(examenFisicoEntity.getNumPeso());
		examen.setNumTalla(examenFisicoEntity.getNumTalla());
		examen.setNumImc(examenFisicoEntity.getNumImc());
		examen.setLateralidad(
				examenFisicoEntity.getLateralidad() == null ? null : examenFisicoEntity.getLateralidad().getBytes());
		examen.setDespCapCuello(examenFisicoEntity.getDespCapCuello().getBytes());
		examen.setDespTorax(
				examenFisicoEntity.getDespTorax() == null ? null : examenFisicoEntity.getDespTorax().getBytes());
		examen.setDespAdb(examenFisicoEntity.getDespAdb().getBytes());
		examen.setDespGenitourinario(examenFisicoEntity.getDespGenitourinario().getBytes());
		examen.setDespColumn(examenFisicoEntity.getDespColumn().getBytes());
		examen.setDespMiembros(
				examenFisicoEntity.getDespMiembros() == null ? null : examenFisicoEntity.getDespMiembros().getBytes());
		examen.setDespOsteomuscular(examenFisicoEntity.getDespOsteomuscular().getBytes());
		examen.setDespNeurologico(examenFisicoEntity.getDespNeurologico().getBytes());
		examen.setDespPielfan(examenFisicoEntity.getDespPielfan().getBytes());
		return examen;
	}

}