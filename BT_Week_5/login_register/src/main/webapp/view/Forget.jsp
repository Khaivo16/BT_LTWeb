<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<div class="main">
	<div class="container">


		<!-- BEGIN CONTENT -->
		<div class="col-md-9 col-sm-9">

			<h1>Enter Information</h1>
			<div class="content-form-page">
				<div class="row">
					<div class="col-md-7 col-sm-7">
						<form action="/login_register/forget" method="get">
							<c:if test="${alert != null}">
								<h3 class="alert alert danger">${alert}</h3>
							</c:if>
							<div class="form-group">
								<label for="Username" class="col-lg-4 control-label">User
									name <span class="require">*</span>
								</label>
								<div class="col-lg-8">
									<input type="text" class="form-control" id="username"
										name="user_name" required> </br>
								</div>

							</div>
							<div class="form-group">
								<label for="email" class="col-lg-4 control-label">Email
									<span class="require">*</span>
								</label>
								<div class="col-lg-8">
									<input type="text" class="form-control" id="email"
										name="email" required> 
								</div>
							</div>
								
						
							<div class="row">
								<div
									class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
									<button type="submit" class="btn btn-primary">Continue</button>
								</div>
							</div>
							
						</form>
					</div>
					<div class="col-md-4 col-sm-4 pull-right">
						<div class="form-info">
							<h2>
								<em>Important</em> Information
							</h2>
							<p>Duis autem vel eum iriure at dolor vulputate velit esse
								vel molestie at dolore.</p>

							<button type="button" class="btn btn-default">More
								details</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- END CONTENT -->
	</div>
</div>
</br>



