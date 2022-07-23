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
		
		if(!repository.findById(tarefa.getId()).isDone()) {
			repository.update(tarefa);	
		}
		
			
	}
	public void delete(Long id) {
		repository.delete(id);		
	}
	public void markAsDone(Long id) {
		repository.markAsDone(id);
		
	}
	public void markAsNotDone(Long id) {
		if(repository.findById(id).isDone()) {
			repository.markAsNotDone(id);
		}	
				
	}
	
	public List<Tarefa> findAll() {		
			return repository.findAll();		
		}
	
	
	}
