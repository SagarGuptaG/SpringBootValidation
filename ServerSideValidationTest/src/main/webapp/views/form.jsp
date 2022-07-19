
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Client Details</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
</head>

<style type="text/css">
.error {
	color: red;
	text-align: left;
	margin-left: 30px;
	font-size: 14px;
	font-family: "Copperplate, Papyrus, fantasy";
}
</style>
<body style="background: #e2e2e2;">
	<div class="content-wrapper">

		<section class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<h1 class="text-center">Fill Client Detail</h1>
					</div>
				</div>
			</div>
			<!--section content-header closed-->
		</section>

		<!--div container start-->
		<div class="container text-center" id="msg">
			<c:choose>
				<c:when test="${not empty message}">
					<div class="alert alert-success">
						<c:out value="${message}"></c:out>
					</div>
				</c:when>
			</c:choose>

			<!--section content mt-1 start-->

			<div class="container">
				<div class="row mt-5">
					<div class="col-md-6 offset-md-3">
						<form method="post" action="addRecord" class="bg-white p-4">

							<!--div row start-->
							<div class="row">

								<div class="mb-3">

									<label>Client Name</label>

									<div class="form-floating">

										<input type="text" class="form-control" 
											name="clientName" placeholder="Client Name" />
									</div>
									<label class="error"><c:out value="${clientName}"></c:out></label>
								</div>

								<div class="mb-3">

									<label>Client Project Price</label>

									<div class="form-floating">

										<input type="text" class="form-control" 
											name="clientProjectPrice" placeholder="Client Project Price" />

									</div>
									<label class="error"><c:out
											value="${clientProjectPrice}"></c:out></label>
								</div>


								<div class="mb-3">

									<label> Client Contact</label>

									<div class="form-floating">
										<input type="text" class="form-control" 
											name="clientContact" placeholder="Client Contact" />

									</div>
									<label class="error"><c:out value="${clientContact}"></c:out></label>
								</div>

								<div class="mb-3">

									<label>Client Email</label>

									<div class="form-floating">

										<input type="text" class="form-control" 
											name="clientEmail" placeholder="Client Email" />
									</div>
									<label class="error"><c:out value="${clientEmail}"></c:out></label>
								</div>

							</div>

							<div class="container text-center">
								<button type="submit" class="btn btn-primary">Submit</button>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>