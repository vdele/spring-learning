<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title><spring:message code="titre.personnes"/></title>
    </head>
    <body>
        <form:form method="post" modelAttribute="modificationPersonne" action="modifierPersonne">
        <table border="1">
            <thead>
                <tr>
                    <th><spring:message code="colonne.identifiant"/></th>
                    <th><spring:message code="colonne.nom"/></th>
                    <th><spring:message code="colonne.prenom"/></th>
                    <th><spring:message code="colonne.age"/></th>
                    <th><spring:message code="colonne.sexe"/></th>
                        <th></th>
                        
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${personnes}" var="personne" varStatus="status">
	                    <tr>
	                        <td><c:out value="${personne.id}"/></td>
	                        <td><c:out value="${personne.nom}"/></td>
	                        <td><c:out value="${personne.prenom}"/></td>
	                        <td>
	                        	<input type="hidden" name="listePersonnes[${status.index}].id" value="${personne.id}"/>
	                        	<input type="text" size="5" name="listePersonnes[${status.index}].age" value="${modificationPersonne.listePersonnes[status.index].age}"/><br/>
                              <b><i><form:errors path="listePersonnes[${status.index}].age" /></i></b>
	                        </td>
	                        <td><c:out value="${personne.sexe}"/></td>
	                        <td>
	                        	<c:url value="/supprimerPersonne" var="url">
	                                <c:param name="idPersonne" value="${personne.id}"/>
	                            </c:url>
	                            <a href="${url}">
	                                <spring:message code="suppression.supprimer.libelle" />
	                            </a>
	                        
	                        </td>
	                    </tr>
                </c:forEach>
            </tbody>
        </table>
           							<input type="submit"/>
        </form:form>
        
        <form:form method="post" modelAttribute="creationPersonne" action="creerPersonne">
            <spring:message code="colonne.nom" />
            <form:input path="nom"/>
            <b><form:errors path="nom" cssclass="error"/></b><br>
            <spring:message code="colonne.prenom"/>
            <form:input path="prenom"/>
            <b><form:errors path="prenom" cssclass="error"/></b><br>
            <spring:message code="colonne.age"/>
            <form:input path="age"/>
            <b><form:errors path="age" cssclass="error"/></b><br>
            <spring:message code="colonne.sexe"/>
            <form:radiobutton path="sexe" value="H"/>H
            <form:radiobutton path="sexe" value="F"/>F
            <b><form:errors path="sexe" cssclass="error"/></b><br>
            
            
            <input type="submit"/>
        </form:form>
    </body>
</html>