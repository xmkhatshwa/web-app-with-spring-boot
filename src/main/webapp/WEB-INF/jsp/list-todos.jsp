<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	<div class="container">
		<h1>Your Todos ${username}</h1>

		<table class="table table-striped">
			<caption>Your Todos are</caption>
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is it Done?</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.desc}</td>
						<td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"/></td>
						<td>${todo.done}</td>
						<td><a type="button" class="btn btn-success"
							href="/update-todo?id=${todo.id}&user=${todo.user}">Update</a> </td>
						<td><a class="btn btn-danger" href="/delete-todo?id=${todo.id}">Delete</a> </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


		<br>
		<br>
        <div class="button">
            <a class="btn-block" href="/add-todo">Add Todo Task</a>
        </div>
	</div>
<%@ include file="common/footer.jspf" %>