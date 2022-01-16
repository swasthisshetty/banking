<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<html>
<head>
<title>Account User Page</title>
<style type="text/css">
.empTable {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #abc;
}

.empTable td {
	font-family: Arial, sans-serif;
	font-size: 16px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 2px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #000000;
	background-color: #fffff;
}

.empTable th {
	font-family: Arial, sans-serif;
	font-size: 16px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 2px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #000;
	background-color: #f88b12;
}

.empTable .empTable-4eph {
	background-color: #C0C0C0
}
</style>
</head>
<body>


	<c:if test="${empty user.accountNumber}">
		<h1>
			<spring:message code="CreateUserAccount" />
		</h1>
	</c:if>



	<c:url var="addAction" value="/users/add"></c:url>

	<form:form action="${addAction}" modelAttribute="user">
		<table>
			<c:if test="${not empty user.accountNumber}">
				<%-- <h1><spring:message code="NewAccountDetails"/></h1> --%>
				<h1 style="color: #f88b12">
					<spring:message code="NewAccountDetails" />
				</h1>
				<tr>
					<td><form:label path="accountNumber">
							<spring:message code="AccountNumber" />
						</form:label></td>
					<td><form:input path="accountNumber" readonly="true" size="8"
							disabled="true" /></td>
				</tr>
			</c:if>

			<tr>
				<td><form:label path="name">
						<spring:message code="Name" />
					</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="contactNumber">
						<spring:message code="ContactNumber" />


					</form:label></td>
				<td>
					<%-- <form:input path="contactNumber" /> --%> <input type="tel"
					name="contactNumber" placeholder="Enter the 10 digit number"
					pattern="[8-9][0-9]{9}" required>
				</td>
			</tr>


			<tr>
				<td><form:label path="bankBranch">
						<spring:message code="BankBranch" />
					</form:label></td>
				<td><form:select path="bankBranch">
						<option value="Bangalore">Bangalore</option>
						<option value="Mangalore">Mangalore</option>
						<option value="Mysore">Mysore</option>
						<option value="Mumbai">Mumbai</option>
						<option value="Shimoga">Shimoga</option>
						<option value="Other">Other</option>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="accountType">
						<spring:message code="AccountType" />


					</form:label></td>
				<td><form:select path="accountType">
						<option value="Savings">Savings</option>
						<option value="Current">Current</option>
						</select>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="balance">
						<spring:message code="Balance" />
					</form:label></td>
				<td><form:input path="balance" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message code="Submit"/>" /></td>
			</tr>
		</table>
	</form:form>
	<br>

	<c:if test="${not empty userList}">
		<h3>
			<spring:message code="userList" />
		</h3>
		<table class="empTable">
			<tr>
				<th width="80">AccountNumber</th>
				<th width="120">Name</th>
				<th width="120">BankBranch</th>
				<th width="120">AccountType</th>
				<th width="120">Balance</th>

				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td>${user.accountNumber}</td>
					<td>${user.name}</td>
					<td>${user.bankBranch}</td>
					<td>${user.accountType}</td>
					<td>${user.balance}</td>

					<td><a
						href="<c:url value='/user/edit/${user.accountNumber}' />">Edit</a></td>
					<td><a
						href="<c:url value='/user/remove/${user.accountNumber}' />">Delete</a></td>
				</tr>
				
			</c:forEach>
		</table>
	</c:if>
</body>
</html>