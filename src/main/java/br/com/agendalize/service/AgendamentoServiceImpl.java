package br.com.agendalize.service;

import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agendalize.entity.AgendaEntity;
import br.com.agendalize.entity.AgendamentoEntity;
import br.com.agendalize.repository.AgendaRepository;
import br.com.agendalize.repository.AgendamentoRepository;

@Service
public class AgendamentoServiceImpl implements AgendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoRepository;

	@Autowired
	private AgendaRepository agendaRepository;

	@Autowired
	private AgendaService agendaService;

	private String mensagem;

	@Override
	public AgendamentoEntity getOneByIdAgendamento(Long idAgendamento) {
		// TODO Auto-generated method stub
		return agendamentoRepository.getOneByIdAgendamento(idAgendamento);
	}

	@Override
	public String save(AgendamentoEntity agendamentoEntity) throws Exception {
		
		//VALIDAÇÃO SE A DATA É DISPONÍVEL
		AgendaEntity ag = new AgendaEntity();
		ag = agendaRepository.getOneByIdAgenda(agendamentoEntity.getAgenda().getIdAgenda());

		boolean dataIgual = false;

		for (int i = 0; i < ag.getDatasIndisponiveis().size(); i++) {

			if (ag.getDatasIndisponiveis().get(i).getData().equals(agendamentoEntity.getDataAgendamento())) {
				dataIgual = true;

			}
		}
		
		//VALIDAÇÃO SE O DIA DA SEMANA DA DATA É DISPONÍVEL
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(agendamentoEntity.getDataAgendamento());
		int indiceDiaSemana = gc.get(GregorianCalendar.DAY_OF_WEEK);
		String diaSemana;
		switch (indiceDiaSemana) {
		case 1:
			diaSemana = "Domingo";
			break;
		case 2:
			diaSemana = "Segunda";
			break;
		case 3:
			diaSemana = "Terça";
			break;
		case 4:
			diaSemana = "Quarta";
			break;
		case 5:
			diaSemana = "Quinta";
			break;
		case 6:
			diaSemana = "Sexta";
			break;
		case 7:
			diaSemana = "Sábado";
			break;
		default:
			diaSemana = "Dia inválido";
		}
		boolean dia = false;

		for (int i = 0; i < ag.getDiasDaSemana().size(); i++) {

			if (ag.getDiasDaSemana().get(i).getNomeDia().equals(diaSemana)) {
				dia = true;

			}
		}
		
		/*int hora;
		
		//VALIDAÇÃO DE O HORÁRIO DO DIA É DISPONÍVEL
		boolean horaDisponivel = false;
		for (int i = 0; i < ag.getDiasDaSemana().size(); i++) {

			if (ag.getDiasDaSemana().get(i).getHoraInicial().compareTo(agendamentoEntity.getHoraInicioAgendamento())) {
				

			}
		}*/
		
		

		if (dataIgual == true) {

			this.mensagem = "Esta data não está disponível para agendamento";
		} else if (dia == false) {

			this.mensagem = "O dia da semana desta data não está disponível.";
		} else {

			agendamentoRepository.saveAndFlush(agendamentoEntity);
			this.mensagem = "Agendamento cadastrado com sucesso";
		}
		return mensagem;
	}

	@Override
	public List<AgendamentoEntity> findAll() {
		// TODO Auto-generated method stub
		return agendamentoRepository.findAll();
	}

	@Override
	public String deleteById(Long idAgendamento) throws Exception {
		try {
			agendamentoRepository.deleteById(idAgendamento);
			this.mensagem = "Agendamento excluído com sucesso.";

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return mensagem;
	}

}
