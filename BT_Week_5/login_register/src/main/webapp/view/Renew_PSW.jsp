<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<div class="main">
	<div class="container">


		<!-- BEGIN CONTENT -->
		<div class="col-md-9 col-sm-9">

			<h1>Renew Password</h1>
			<div class="content-form-page">
				<div class="row">
					<div class="col-md-7 col-sm-7">
						<form action="/login_register/forget" method="post">
							<div class="form-group">
								<label for="Password" class="col-lg-4 control-label">New Password <span class="require">*</span>
								</label>
								<div class="col-lg-8">
									<input type="password" class="form-control" id="password"
										name="password" required> </br>
								</div>

							</div>
								
						
							<div class="row">
								<div
									class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
									<button type="submit" class="btn btn-primary">Confirm</button>
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
