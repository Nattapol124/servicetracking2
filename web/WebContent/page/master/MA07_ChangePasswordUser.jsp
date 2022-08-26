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
	html, body {
		height: 100%;
		width: 100%;
	}
	.input-field .validate {
		padding: 20px;
		font-size: 16px;
		border-radius: 10px;
		border: none;
		margin-bottom: 15px;
		color: black;
		background: #f5f5f9;
		outline: none;
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
		background: #E5E7E9 ;
	}

	.inthebox {
		/* 	margin-left: 10%; */
		/* 	margin-right: 10%; */
		margin-top: 1%;
		margin-left: 1%;
		margin-right: 1%;
		
		
/* 		background: #e8ffff; */
		top: 20%;
		border-radius: 15px;
	}

</style>

<body>

	<%@ include file="/page/inc_menu.jsp"%>
	<div class="topbar">
		<%@ include file="/page/inc_header.jsp"%>
		
		<div class="container">
			<div class="inthebox" id="top-content">
				
				<div class="row">
					<div class="container">
						<div class="col-lg-12 bg-white">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item ">หน้าหลัก</li>
									<li class="breadcrumb-item ">ผู้ใช้งาน</li>
									<li class="breadcrumb-item active">เปลี่ยนรหัสผ่านผู้ใช้งาน</li>
								</ol>
							</nav>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="container">
						<div class="col-md-12 bg-white">
							<div class="panel panel-default">
								<div class="panel-body">
									<html:form action="/login" styleId="eduForm" styleClass="form-horizontal form-validate">
										<html:hidden property="mode" />
										<html:hidden property="id" />

										<div class="from-group">
										
											<div calss="mb-3 row">
												
												<label for="inputPassword" class="col-sm-2 col-form-label">รหัสผ่านใหม่ : </label>
												<div class="col-sm-9">
													<html:password property="newPassword" styleId="newPassword" styleClass="form-control" value=""></html:password>
												</div>
											</div>
											
											<div calss="mb-3 row">
												<label for="inputConfirmPassword" class="col-sm-2 col-form-label">ยืนยันรหัสผ่าน : </label>
												<div class="col-sm-9">
													<html:password property="newConfirmPassword" styleId="newConfirmPassword" styleClass="form-control" value=""></html:password>
												</div>
											</div>
											
										</div>

										<div class="form-group">
											<div class="col-sm-offset-3 col-sm-8">
												<button class="btn btn-primary" type="button"
													onclick="submitFormSave();">
													<i class="fa fa-save" aria-hidden="true"></i> &nbsp;บันทึก
												</button>
											</div>
										</div>
										
									</html:form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



	<script type="text/javascript">
		$(document).ready(

			function() {

				 
				$("#eduForm").validate({
					rules : {
						newPassword : {
							required: true,	
							minlength : 2,
				        }, newConfirmPassword : {
				          	minlength : 2,
				            equalTo : "#newPassword",
						}
					},
					highlight : function(element) {
						$(element).closest('.form-control').addClass('has-error-input');
					},
					unhighlight : function(element) {
						$(element).closest('.form-control').removeClass('has-error-input');
					},
					errorElement : 'span',
					errorClass : 'has-error-block',
					errorPlacement : function(error, element) {},
					submitHandler : function(form) {			
						document.forms[0].mode.value = 'changePasswordUser';
						document.forms[0].submit();
					}
				});
		});
		
		function submitFormInit(mode) {
			document.loginForm.mode.value = mode;
			document.loginForm.submit();

		}
		
		function submitFormEdit(id,mode) {
		    document.masterForm.mode.value = mode;
		  	document.masterForm.id.value = id;
		    document.masterForm.submit();
		}
		
		function submitFormSave() {
// 			document.masterForm.id.value = id;
			$("#eduForm").submit();		
		}
	</script>

	<link rel="stylesheet"
		href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
	<link rel="stylesheet"
		href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/mdb.min.css">

	<!-- Plugin file -->
	<link rel="stylesheet" href="./css/addons/datatables.min.css">
	<link rel="stylesheet" href="css/style.css">

</body>


<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/popper.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/mdb.min.js"></script>
<!-- Plugin file -->
<script src="./js/addons/datatables.min.js"></script>

</html>
