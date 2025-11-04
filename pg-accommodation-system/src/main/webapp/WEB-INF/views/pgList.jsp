<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Available PGs</title></head>
<body>
<h2>Available PG Places</h2>
<c:forEach var="pg" items="${pgList}">
    <div>
        <p><strong>Registration:</strong> ${pg.registrationNumber}</p>
        <p><strong>Rent:</strong> ${pg.rentAmount}</p>
        <p><strong>Status:</strong> ${pg.availabilityStatus ? 'Available' : 'Occupied'}</p>
        <p>/pg/details/${pg.pgId}View Details</a></p>
    </div>
    <hr/>
</c:forEach>
</body>
</html>