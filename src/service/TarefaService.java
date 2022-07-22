package service;

import java.util.List;

import com.anderson.model.Tarefa;

import repository.TarefaRepository;

public class TarefaService {
	
	private TarefaRepository repository=new TarefaRepository();
	
	public void create(Tarefa  tarefa) {
		repository.create(tarefa);		
	}
	public void update(Tarefa  tarefa) {		
		repository.update(tarefa);		
	}
	public void delete(Long id) {
		repository.delete(id);		
	}
	
	public List<Tarefa> findAll() {		
			return repository.findAll();		
		}
	
	
	}
