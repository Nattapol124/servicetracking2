<!DOCTYPE html>
<%@page contentType="text/html; charset=utf-8"%>
<%@taglib uri="/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/tld/c.tld" prefix="c"%>
<%@taglib uri="/tld/fn.tld" prefix="fn"%>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<%@ include file="/page/inc_header_script.jsp"%>

<style type="text/css">
@import
	url('https://fonts.googleapis.com/css2?family=Raleway:wght@400&display=swap')
	;

.popup .content {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -150%) scale(0);
	width: 300px;
	height: 450px;
	z-index: 2;
	text-align: center;
	padding: 20px;
	border-radius: 20px;
	background: white;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
	z-index: 1;
}

.popup .close-btn {
	position: absolute;
	right: 20px;
	top: 20px;
	width: 30px;
	height: 30px;
	color: black;
	font-size: 30px;
	border-radius: 50%;
	padding: 2px 5px 7px 5px;
	background: white;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
}

.popup.active .content {
	transition: all 300ms ease-in-out;
	transform: translate(-50%, -50%) scale(1);
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
}

h1 {
	text-align: center;
	font-size: 32px;
	font-weight: 600;
	padding-top: 20px;
	padding-bottom: 10px;
}

a {
	font-weight: 600;
	color: white;
}

.input-field .validate {
	padding: 20px;
	font-size: 16px;
	border-radius: 10px;
	border: none;
	margin-bottom: 15px;
	color: #bfc0c0;
	background: #f5f5f9;
	outline: none;
}

.first-button {
	color: white;
	font-size: 18px;
	font-weight: 500;
	padding: 30px 50px;
	border-radius: 40px;
	border: none;
	position: absolute;
	top: 50%;
	left: 20%;
	transform: translate(-50%, -50%);
	background: white;
	transition: box-shadow .35s ease !important;
	outline: none;
}

.first-button:active {
	background: linear-gradient(145deg, #222222, #292929);
	border: none;
}

.second-button {
	color: white;
	font-size: 18px;
	font-weight: 500;
	margin-top: 20px;
	padding: 20px 30px;
	border-radius: 40px;
	border: none;
	background: white;
	transition: box-shadow .35s ease !important;
	outline: none;
}

.second-button:active {
	background: linear-gradient(145deg, #222222, #292929);
	border: none;
	outline: none;
}

p {
	color: #f5f5f9;
	padding: 20px;
}

html, body {
	height: 100%;
	width: 100%;
}

.backplane {
	/* Rectangle 4283 */
	position: absolute;
	width: 80%;
	height: 100%;
	left: 0px;
	top: 0px;
	background: linear-gradient(136.16deg, #042153 5.45%, #1DA1B0 60.18%);
}

.topbar {
	/* Rectangle 4284 */
	position: absolute;
	width: 85%;
	height: 100%;
	left: 15%;
	background: #f5f5f9;
}

.table {
	margin-top: 4%;
	border-collapse: separate;
	border-radius: 20px;
}

.att:hover {
	background-color: #f5f5f9;
}

.inthebox {
	margin-left: 10%;
	margin-right: 10%;
	width: 80%;
	background: #e8ffff;
	top: 20%;
	border-radius: 15px;
}

/* Color of the links BEFORE scroll */
.navbar-scroll .nav-link, .navbar-scroll .navbar-toggler-icon,
	.navbar-scroll .navbar-brand {
	color: #262626;
}

/* Color of the navbar BEFORE scroll */
.navbar-scroll {
	background-color: #FFC017;
}

/* Color of the links AFTER scroll */
.navbar-scrolled .nav-link, .navbar-scrolled .navbar-toggler-icon,
	.navbar-scroll .navbar-brand {
	color: #262626;
}

/* Color of the navbar AFTER scroll */
.navbar-scrolled {
	background-color: #fff;
}

/* An optional height of the navbar AFTER scroll */
.navbar.navbar-scroll.navbar-scrolled {
	padding-top: auto;
	padding-bottom: auto;
}

.navbar-brand {
	font-size: unset;
	height: 3.5rem;
}
</style>
<style type="text/css">
</style>

<body>
	<script type="text/javascript">
	$(document).ready(function() {
		$("#requestStatusFormID").validate({
			rules: {
				id_request_status: "required",

			},
			highlight: function(element) {
	            $(element).closest('.form-control').addClass('has-error-input');
	        },
	        unhighlight: function(element) {
	            $(element).closest('.form-control').removeClass('has-error-input');
	        },
	        errorElement: 'span',
	        errorClass: 'has-error-block',
	        errorPlacement: function(error, element) {},
	      	submitHandler: function(form) {
	      		document.forms[0].mode.value = 'editRequest';
		   	 	document.forms[0].submit();
			}
		});
	});
		function submitFormInit(mode) {
			document.loginForm.mode.value = mode;
			document.loginForm.submit();

		}
		function submitFormEdit(id, mode) {
			document.loginForm.mode.value = mode;
			document.loginForm.id.value = id;
			document.loginForm.submit();
		}
		function submitFormRemove(id) {
			 
			  Swal.fire({
				     title: 'Are you sure?',
				     text: "YOU WANT TO DELETE THIS USER?",
				     icon: 'warning',
				     showCancelButton: true,
				     confirmButtonColor: '#3085d6',
				     cancelButtonColor: '#d33',
				     confirmButtonText: 'Yes'
				   }).then((result) => {
				    	if(result.isConfirmed){
				    		document.loginForm.mode.value = 'delete';
							document.loginForm.id.value = id;
							document.loginForm.submit();
			
				    	}
				       
				     })	
		}
		
		 function togglePopup() {
			 document.getElementById("popup-1")
			 .classList.toggle("active");
		}
		 
		 function submitFormEditStatus() {
			$("#requestStatusFormID").submit();
		}
		
	</script>

	<%@ include file="/page/inc_menu.jsp"%>

	<div class="topbar">
		<!-- Navbar -->
		<%@ include file="/page/inc_header.jsp"%>

		<!-- Navbar -->

		<div class="inthebox">

			<html:form action="/login" styleId="eduForm"
				styleClass="form-horizontal form-validate">
				<html:hidden property="mode" />
				<html:hidden property="id" />
				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-8">
						<button class="btn btn-primary" type="button"
							onclick="submitFormInit('showRequest')">
							<i class="fa fa-users" aria-hidden="true"></i>
							&nbsp;ดูรายชื่อบัญชีทั้งหมด
						</button>
					</div>

				</div>
				<logic:present name="loginForm" property="resultRequestList">
					<logic:notEmpty name="loginForm" property="resultRequestList">
						<table cellspacing="0" width="100%"
							class="table align-middle mb-0 ">
							<a>
								<thead>
									<tr>
										<th class="text-center">ลำดับ</th>
										<th class="text-center">ชื่อโครงการ</th>
										<th class="text-center">หัวข้อ</th>

										<th class="text-center">คำอธิบาย</th>
										<th class="text-center">สถานะ</th>
									</tr>
								</thead>
								<tbody>
									<logic:iterate id="item" name="loginForm"
										property="resultRequestList" indexId="index">
										<tr class="att">

											<td align="center" class="fw-normal mb-1 "
												data-bs-toggle="modal"
												data-bs-target="#exampleModal${item.id}"><%=index + 1%></td>
											<td align="center" class="fw-normal mb-1 "
												data-bs-toggle="modal"
												data-bs-target="#exampleModal${item.id}">${item.id_project.project_name}</td>
											<td align="center" class="fw-normal mb-1 "
												data-bs-toggle="modal"
												data-bs-target="#exampleModal${item.id}">${item.request_title}</td>
											<td align="center" class="fw-normal mb-1 "
												data-bs-toggle="modal"
												data-bs-target="#exampleModal${item.id}">${item.request_remark}</td>
											<td align="center" class="fw-normal mb-1 "
												data-bs-toggle="modal"
												data-bs-target="#exampleModal${item.id}">${item.id_request_status.status_name}</td>


											<td align="center">

												<button type="button" data-bs-toggle="modal"
													data-bs-target="#exampleModal${item.id}"
													class="btn btn-primary btn-xs">
													<i class="fa fa-edit"></i>
												</button>
												<button type="button"
													onclick="submitFormRemove('${item.id}');"
													class="btn btn-danger btn-xs">
													<i class="fa fa-trash-o"></i>
												</button>
											</td>

											<div class="modal fade" id="exampleModal${item.id}"
												tabindex="-1" role="dialog"
												aria-labelledby="exampleModalLabel" aria-hidden="true">
												<div class="modal-dialog" role="document">
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title" id="exampleModalLabel">แก้ไขสถานะ</h5>
														</div>
														<div class="modal-body">
															<label>ชื่อโครงการ : </label> 
															<input type="text" class="form-control" value="${item.id_project.project_name}" disabled>
															<label>หัวข้อ : </label> 
															<input type="text" class="form-control" value="${item.request_title}" disabled> 
															<label>คำอธิบาย : </label> 
															<input type="text" class="form-control" value="${item.request_remark}" disabled> 
															<label>สถานะ : </label> 
<%-- 															<input type="text" class="form-control" value="${item.id_request_status.status_name}" disabled> --%>
															<html:select property="id_request_status" styleClass="form-control">
																<html:optionsCollection property="comboRequestStatus" value="id" label="status_name"/>
															</html:select>
															
<!-- 															<div class="form-group"> -->
<!-- 																<label class="control-label col-sm-3">หัวข้อ :</label> -->
<!-- 																<div class="col-sm-3"> -->
<!-- 																	<fieldset disabled> -->
<%-- 																		<html:text property="projectName" styleId="projectName" styleClass="form-control"></html:text> --%>
<!-- 																	</fieldset> -->
<!-- 																</div> -->
<!-- 															</div> -->
															
														</div>
						

														<div class="modal-footer">
															<button class="btn btn-primary" type="button" onclick="submitFormEditStatus()"><i class="fa fa-save" aria-hidden="true"></i> &nbsp;บันทึก</button>
															<button type="button" class="btn btn-primary" data-bs-dismiss="modal">ออก</button>
														</div>

													</div>

												</div>

											</div>

											</div>
											</td>
										</tr>
									</logic:iterate>

								</tbody>
						</table>
					</logic:notEmpty>
				</logic:present>
			</html:form>
		</div>
</body>


<script src="js/jquery.min.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>

</html>
