<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form method="GET" action="/deposit" 
  modelAttribute="deposit">
    <form:label path="accountNumber">Account Number</form:label>
    <form:input path="accountNumber" />
    
    <form:label path="amountToTransfer">Amount</form:label>
    <form:input path="amountToTransfer" />

    <input type="submit" value="Submit" />
</form:form>