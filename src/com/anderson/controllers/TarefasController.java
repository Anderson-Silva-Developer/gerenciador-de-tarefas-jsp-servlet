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


@WebServlet("/")
public class TarefasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TarefaService tarefaService = new TarefaService();
   
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
		
		String title=req.getParameter("title").trim().length()>0?req.getParameter("title"):"sem titulo";
		String obTarefa=req.getParameter("obTarefa").trim().length()>0?req.getParameter("obTarefa"):"sem observações";
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

		default:
			break;
		}
		RequestDispatcher dispatcher= req.getRequestDispatcher("/WEB-INF/index.jsp");
		req.setAttribute("tarefas",tarefaService.findAll());
		dispatcher.forward(req , response);				

		
	}
	
}
