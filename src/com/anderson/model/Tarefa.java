package com.anderson.model;

import java.time.LocalDate;

/**
 * @author asc
 *
 */
public class Tarefa {
	
	private Long id;
	private String title;
	private String obTarefa;
	private boolean done=false;
	private LocalDate dataCriacao;
	private LocalDate dataConclusao;
	
	
	
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
	
	
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public LocalDate getDataConclusao() {
		return dataConclusao;
	}
	public void setDataConclusao(LocalDate dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	public Tarefa(String title, String obTarefa) {		
		this.title = title;
		this.obTarefa = obTarefa;
		this.dataCriacao=LocalDate.now();
		this.dataConclusao=null;
				
	}
		
	
	
}
