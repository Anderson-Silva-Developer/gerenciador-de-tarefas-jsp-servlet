package repository;

import java.util.ArrayList;
import java.util.List;

import com.anderson.model.Tarefa;

public class TarefaRepository {
	private static Long  AUTO_INCREMENT=0L;
	private static ArrayList<Tarefa> tarefas=new ArrayList<Tarefa>();
	
	public void create(Tarefa tarefa) {
		AUTO_INCREMENT++;
		tarefa.setId(AUTO_INCREMENT);
		tarefas.add(tarefa);		
	}
	public List<Tarefa> findAll() {
		
		return tarefas;		
	}
	
	
	
	
	

}
