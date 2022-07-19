<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Gerenciador de Tarefas</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body class="container mt-5">
<h1>Gerenciador de Tarefas</h1>
<button class="btn btn-success mb-5" data-bs-toggle="modal" data-bs-target="#createModal">+ Adicionar Tarefa</button>
<table class="table">
	<thead>
		<tr>
			<th>Tarefa</th>	  
			<th>Data de Criação</th>	  
			<th>Data de Conclusão</th>	
			<th>Observações</th>	
		</tr>
		
	</thead>
	<tbody>
	<c:forEach items="${tarefas}" var="t">
		
		<tr>
			<td><c:out value="${t.title}"/></td>
			<td><c:out value="${t.dataCriacao}"/></td>
			<td><c:out value="${t.dataConclusao}"/></td>
			<td><c:out  value="${t.obTarefa}"/></td>
		</tr>		
	
	</c:forEach>
		
			
		
	</tbody>
</table>
<!-- Modal create-->
<div class="modal fade" id="createModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Adicionar tarefa</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        	<form action="/tarefas/" method="post">
				 <div class="mb-3">
				    <label for="title" class="form-label">Titulo da tarefa</label>
				    <input class="form-control" id="title" name="title">				  
				  </div>
				  <div class="mb-3">
				    <label for="obTarefa" class="form-label">Observação da Tarefa</label>
				    <input class="form-control" id="obTarefa" name="obTarefa">
				  </div>
				  <button type="submit" class="btn btn-success ">Adicionar</button>
			</form>
      </div>
      
    </div>
  </div>
</div>

</body>
</html>