
<%@ page import="gameoverflow.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>

		<div id="list-user" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="lastname" title="${message(code: 'user.lastname.label', default: 'Lastname')}" />
					
						<g:sortableColumn property="firstname" title="${message(code: 'user.firstname.label', default: 'Firstname')}" />
					
						<g:sortableColumn property="username" title="${message(code: 'user.username.label', default: 'username')}" />
					
						<g:sortableColumn property="dateRegistration" title="${message(code: 'user.dateRegistration.label', default: 'Date Inscription')}" />
					
						<g:sortableColumn property="score" title="${message(code: 'user.score.label', default: 'Score')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${userInstanceList}" status="i" var="userInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${userInstance.id}">${fieldValue(bean: userInstance, field: "lastname")}</g:link></td>
					
						<td>${fieldValue(bean: userInstance, field: "firstname")}</td>
					
						<td>${fieldValue(bean: userInstance, field: "username")}</td>
					
						<td><g:formatDate date="${userInstance.dateRegistration}" /></td>
					
						<td>${fieldValue(bean: userInstance, field: "score")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${userInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
