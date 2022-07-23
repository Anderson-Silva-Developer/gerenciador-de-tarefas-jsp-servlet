package com.anderson.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anderson.model.Tarefa;

import service.TarefaService;
import validationData.ValidationTarefa;


@WebServlet("/")
public class TarefasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TarefaService tarefaService = new TarefaService();
	private ValidationTarefa validationTarefa=new  ValidationTarefa();
   
    public TarefasController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/index.jsp");
		request.setAttribute("tarefas",tarefaService.findAll());		
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		
		String action=req.getParameter("action");			
		
		String title=validationTarefa.validationTitle(req.getParameter("title"));
		String obTarefa=validationTarefa.validationObTarefa(req.getParameter("obTarefa"));
		String idTarefa=req.getParameter("id");		
		
		switch (action) {
		case "createTarefa":				
			tarefaService.create(new Tarefa(title,obTarefa));				
			break;
		case "updateTarefa":			
			Tarefa tarefa=new Tarefa(title,obTarefa);
			tarefa.setId(Long.parseLong(idTarefa));
			tarefaService.update(tarefa);				
			
			break;
		case "deleteTarefa":
			tarefaService.delete(Long.parseLong(idTarefa));
			break;
			
		case "done":
			tarefaService.markAsDone(Long.parseLong(idTarefa));
			break;
		case "notDone":
			tarefaService.markAsNotDone(Long.parseLong(idTarefa));
			break;		

		default:
			break;
		}
		RequestDispatcher dispatcher= req.getRequestDispatcher("/WEB-INF/index.jsp");
		req.setAttribute("tarefas",tarefaService.findAll());
		dispatcher.forward(req , response);				

		
	}
	
}
