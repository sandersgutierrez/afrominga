<jsp:include page="/templates/header.jsp" />

<div class="container">
    <h3>Datos Personales</h3>
    <form action="home" method="post">
        <div class="form-group">
            <label for="firstname">Nombre</label>
            <input type="text" class="form-control" aria-describedby="emailHelp" name="firstname">
        </div>
        <div class="form-group">
            <label for="lastname">Apellido</label>
            <input type="text" class="form-control" aria-describedby="emailHelp" name="lastname">
        </div>
        <button type="submit" class="btn btn-primary">Mostrar datos</button>
    </form>
</div>

<jsp:include page="/templates/footer.jsp" />
