<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/templates/header.jsp" />

<div class="container mt-2">
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title">Mis Datos Personales</h5>
            <p class="card-text">${firstname} ${lastname}</p>
        </div>
    </div>
</div>

<jsp:include page="/templates/footer.jsp"></jsp:include>