<jsp:include page="/templates/header.jsp" />

<div class="container">
    <div>
        <h2>Clientes</h2>
        <p>Nombre de la Empresa: ${nombreEmpresa} - Nombre del Contacto: ${nombreContacto}</p>
        <c:forEach var="varName" begin="1" end="10" step="1">
            My ForEach ${varName}
        </c:forEach>
    </div>
</div>

<jsp:include page="/templates/footer.jsp" />