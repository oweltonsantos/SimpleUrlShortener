<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:useBean id="urlViewer" class="br.com.logique.urlshortener.View.UrlViewer"></jsp:useBean> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logique - URL_Shortener</title>
<style type="text/css">
	.main{
		width: 700px;
		margin: auto;
	}
	form{
		margin: 1rem 0;
	}
	table{
		width: 100%;
	}
</style>
</head>
<body>
<div class="main">
	<h1>Logique - URL_Shortener</h1>
	<form action="InserirUrlController"method="POST">
		<input type="url" required="required" name="url" placeholder="URL">
		<input type="submit" value="Create URL"/>
	</form>
		
	<table border="1">
		<thead>
			<tr>
					<th>Id</th>
					<th>URL</th>
					<th>Data</th>
					<th>URL Encurtada</th> 
			</tr>
		</thead>
		<tbody>
		
			
			<c:forEach items="${urlViewer.getUrls()}" var="url">
				
				<tr>
					<td>${url.getId()}</td>
					<td>${url.getUrl()}</td>
					<td>${url.getInsert_date()}</td>
					<td><a href="http://localhost:8080/LogiqueUrlShortener/@${url.getCode()}">${url.getCode()}</a><c:if test="${url.getCode()} != null"><c:redirect url="${url.getUrl()}"/></c:if></td>
				</tr>
			</c:forEach>
		
		</tbody>			
	</table>

</div>


</body>
</html>