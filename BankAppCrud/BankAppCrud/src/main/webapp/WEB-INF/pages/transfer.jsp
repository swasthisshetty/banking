<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form method="GET" action="/transfer" 
  modelAttribute="deposit">
    <form:label path="depositerAccNo">Debitor Account Number</form:label>
    <form:input path="depositerAccNo" />
    
    <form:label path="creditorAccNo">Creditor Account Number</form:label>
    <form:input path="creditorAccNo" />
    
    <form:label path="amountToTransfer">Amount</form:label>
    <form:input path="amountToTransfer" />

    <input type="submit" value="Submit" />
</form:form>