<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<h1>
	<acme:message code="inventor.chimpum-dashboard.form.title"/>
</h1>

<h3>
	<acme:message code="inventor.chimpum-dashboard.form.chimpum-ratio"/>
	<acme:print value="${chimpumRatio} %"/>
</h3>

<h3>
	<acme:message code="inventor.chimpum-dashboard.form.average-budget"/>
</h3>

<table class="table table-sm">
	<caption>
		<acme:message code="inventor.chimpum-dashboard.form.average-budget-caption"/>
	</caption>
	<jstl:forEach var="averageBudgets" items="${ averageBudgetOfChimpumpsByCurrency }">
		<tr>
			<th scope="row">
				<acme:print value="${averageBudgets.key}"/>
			</th>
			<td>
				<acme:print value="${averageBudgets.value}"/>
			</td>
		</tr>
	</jstl:forEach>
	
</table>

<h3>
	<acme:message code="inventor.chimpum-dashboard.form.deviation-budget"/>
</h3>
<table class="table table-sm">
	<caption>
		<acme:message code="inventor.chimpum-dashboard.form.deviation-budget-caption"/>
	</caption>
	<jstl:forEach var="deviationBudgets" items="${ deviationBudgetOfChimpumpsByCurrency }">
		<tr>
			<th scope="row">
				<acme:print value="${deviationBudgets.key}"/>
			</th>
			<td>
				<acme:print value="${deviationBudgets.value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<h3>
	<acme:message code="inventor.chimpum-dashboard.form.minimum-budget"/>
</h3>
<table class="table table-sm">
	<caption>
		<acme:message code="inventor.chimpum-dashboard.form.minimum-budget-caption"/>
	</caption>
	<jstl:forEach var="minimumBudgets" items="${ minimumBudgetOfChimpumpsByCurrency }">
		<tr>
			<th scope="row">
				<acme:print value="${minimumBudgets.key}"/>
			</th>
			<td>
				<acme:print value="${minimumBudgets.value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<h3>
	<acme:message code="inventor.chimpum-dashboard.form.maximum-budget"/>
</h3>
<table class="table table-sm">
	<caption>
		<acme:message code="inventor.chimpum-dashboard.form.maximum-budget-caption"/>
	</caption>
	<jstl:forEach var="maximumBudgets" items="${ maximumBudgetOfChimpumpsByCurrency }">
		<tr>
			<th scope="row">
				<acme:print value="${maximumBudgets.key}"/>
			</th>
			<td>
				<acme:print value="${maximumBudgets.value}"/>
			</td>
		</tr>
	</jstl:forEach>
</table>

<acme:return/>

