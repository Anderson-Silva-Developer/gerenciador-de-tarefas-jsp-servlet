package com.anderson.model;

/**
 * @author asc
 *
 */
public class Tarefa {
	
	private Long id;
	private String title;
	private String obTarefa;
	private boolean done=false;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getObTarefa() {
		return obTarefa;
	}
	public void setObTarefa(String obTarefa) {
		this.obTarefa = obTarefa;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	public Tarefa(String title, String obTarefa) {		
		this.title = title;
		this.obTarefa = obTarefa;
				
	}
	
	
	
	
}
