package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.anderson.model.Tarefa;

public class TarefaRepository {
	private static Long  AUTO_INCREMENT=0L;
	private static List<Tarefa> tarefas=new ArrayList<Tarefa>();
	
	public void create(Tarefa tarefa) {
		AUTO_INCREMENT++;
		tarefa.setId(AUTO_INCREMENT);
		tarefas.add(tarefa);		
	}
	public List<Tarefa> findAll() {
		
		return tarefas;		
	}
	public void update(Tarefa tarefa) {		
		
		 tarefas=tarefas.stream()
		.filter(t->t.getId()==tarefa.getId())			
		.map(filtered->filtered=tarefa)
		.collect(Collectors.toList());
						
	}
	public void delete(Long id) {
		tarefas.removeIf(t->t.getId()==id);		
		
		// TODO Auto-generated method stub
		
	}	
	

}
