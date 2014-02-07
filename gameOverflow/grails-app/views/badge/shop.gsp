<%@ page import="gameoverflow.Question" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'shop.label', default: 'Shop')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<div id="badge-shop" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <div id="badge-shop-list">
        <g:each in="${badges}" status="i" var="currentBadge">
            <div>
                ${currentBadge}
            </div>
        </g:each>
    </div>
</div>
</body>
</html>


