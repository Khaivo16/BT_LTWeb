<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<div class="main">
	<div class="container">


		<!-- BEGIN CONTENT -->
		<div class="col-md-9 col-sm-9">

			<h1>Enter information</h1>
			<div class="content-form-page">
				<div class="row">
					<div class="col-md-7 col-sm-7">
						<form action="/login_register/Info/home" method="post" enctype="multipart/form-data">
							<div class="form-group">
								<label for="Fullname" class="col-lg-4 control-label">Full
									name <span class="require">*</span>
								</label>
								<div class="col-lg-8">
									<input type="text" class="form-control" id="fullname"
										name="fullname" required> </br>
								</div>

							</div>
							<div class="form-group">
								<label for="phone" class="col-lg-4 control-label">Phone
									Number <span class="require">*</span>
								</label>
								<div class="col-lg-8">
									<input type="text" class="form-control" id="phone" name="phone"
										required> </br>
								</div>
							</div>

							

							<!-- Section for uploading file -->
							<div class="form-group">
								<label for="file" class="col-lg-4 control-label">Choose
									a file</label>
								<div class="col-lg-8">
										<input type="file" name="multiPartServlet"
											class="form-control" required /> <br /> 
								</div>
							</div>

							<div class="row">
								<div
									class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
									<button type="submit" class="btn btn-primary">Update</button>
								</div>
							</div>
							<div class="row">
								<div
									class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-10 padding-right-30">
									<hr>
									<div class="login-socio">
										<p class="text-muted">or login using:</p>
										<ul class="social-icons">
											<li><a href="#" data-original-title="facebook"
												class="facebook" title="facebook"></a></li>
											<li><a href="#" data-original-title="Twitter"
												class="twitter" title="Twitter"></a></li>
											<li><a href="#" data-original-title="Google Plus"
												class="googleplus" title="Google Plus"></a></li>
											<li><a href="#" data-original-title="Linkedin"
												class="linkedin" title="LinkedIn"></a></li>
										</ul>
									</div>
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

