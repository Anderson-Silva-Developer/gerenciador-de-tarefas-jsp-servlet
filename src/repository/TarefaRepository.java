package repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		
		tarefas
				.stream()
				.map(t->t.isDone()==false)				
				.collect(Collectors.toList());	
		ordemList();
		
		return tarefas;		
	}
	public Tarefa findById(Long id) {
			
			 return  tarefas
					.stream()
					.filter(t->t.getId()==id).findFirst().get();
	}
	
	public void update(Tarefa tarefa) {		
		
		 tarefas=tarefas.stream()
		.filter(t->t.getId()==tarefa.getId())			
		.map(filtered->filtered=tarefa)
		.collect(Collectors.toList());
		 ordemList();
						
	}
	public void delete(Long id) {
		tarefas.removeIf(t->t.getId()==id);	
		ordemList();
		
		// TODO Auto-generated method stub
		
	}
	public void markAsDone(Long id) {
		Tarefa tarefa=tarefas.stream().filter(t->t.getId()==id).findFirst().get();
		tarefa.setDone(true);
		tarefa.setDataConclusao(LocalDate.now());
		ordemList();
		
		
	}	
	public void markAsNotDone(Long id) {
		Tarefa tarefa=tarefas.stream().filter(t->t.getId()==id).findFirst().get();
		tarefa.setDone(false);	
		tarefa.setDataConclusao(null);
		ordemList();
		
		
	}
	private void ordemList() {
		List<Tarefa> l1=tarefas
				.stream()
				.filter(t->t.isDone()==false)				
				.collect(Collectors.toList());	

		List<Tarefa> l2=tarefas
				.stream()
				.filter(t->t.isDone()==true)				
				.collect(Collectors.toList());	
		tarefas.clear();		
		tarefas.addAll(l1);
		tarefas.addAll(l2);
		
	}
	

}
