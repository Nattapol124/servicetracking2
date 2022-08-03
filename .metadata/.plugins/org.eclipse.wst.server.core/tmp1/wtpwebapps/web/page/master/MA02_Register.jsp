<!DOCTYPE html>
<%@page contentType="text/html; charset=utf-8"%>
<%@taglib uri="/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/tld/c.tld" prefix="c"%>
<%@taglib uri="/tld/fn.tld" prefix="fn"%>
<%@ include file="/page/inc_header_script.jsp"%>


<style type="text/css">
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
		function submitEnter() {
			if (checkKeyEnter() == true)
				submitFormLogin();
		}
		function checkKeyEnter() {
			if (event.keyCode == 13)
				return true;
		}

		function submitFormEdit(id, mode) {
			document.loginForm.mode.value = mode;
			document.loginForm.id.value = id;
			document.loginForm.submit();
		}
		

		$(document).ready(
			
				function() {
					 $('#newuser').attr('autocomplete','off');
					 $('#newpassword').attr('autocomplete','off'); 
					 $('#newuser').val('');
					 $('#newpassword').val('');
					 $('#newcon').val('');
					 $('#newfirstname').val('');
					 $('#newlastname').val('');
					 $('#newnickname').val('');
					 $('#newemail').val('');
					 $('#newphone').val('');
					$("#eduForm").validate(
							{
								rules : {
									newuser: "required",
									newpassword : {
										required: true,	
										minlength : 2
					                },
					                newcon : {
					                    minlength : 2,
					                    equalTo : "#newpassword"
					                },
									newfirstname: "required",
									newlastname: "required",
									newemail: "required",
									newphone: "required",
								},
								highlight : function(element) {
									$(element).closest('.form-control').addClass('has-error-input');
								},
								unhighlight : function(element) {
									$(element).closest('.form-control').removeClass('has-error-input');
								},
								errorElement : 'span',
								errorClass : 'has-error-block',
								errorPlacement : function(error, element) {
								},
								submitHandler : function(form) {
									document.forms[0].mode.value = 'saveUser';
									document.forms[0].submit();
								}
							});
				});

		function submitFormSave() {
			$("#eduForm").submit();
		}

		function submitFormInit(mode) {
			document.loginForm.mode.value = mode;
			document.loginForm.submit();
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

							<div class="row">
								<div class="col-md-12">
									<a href="login.htm?mode=showtable" class="btn btn-default"
										onclick="submitFormInit('init');"><i
										class="fa fa-undo" aria-hidden="true"></i> &nbsp;ย้อนกลับ</a>
								</div>
							</div>
							<hr />

							<div class="form-group">
								<label class="control-label col-sm-3">ชื่อผู้ใช้ :</label>
								<div class="col-sm-3">
									<html:text property="newuser" styleId="newuser" 
										styleClass="form-control"></html:text>
								</div>
							</div>

						 	<div class="form-group">
								<label class="control-label col-sm-3">password :</label>
								<div class="col-sm-3">
									<html:password  property="newpassword" styleId="newpassword"
										styleClass="form-control"></html:password	>
								</div>
								<div class="col-sm-3">
								</div>
							</div> 
								<div class="form-group">
								<label class="control-label col-sm-3">Confirm password :</label>
								<div class="col-sm-3">
									<html:password  property="newcon" styleId="newcon"
										styleClass="form-control"></html:password	>
								</div>
								<div class="col-sm-3">
								</div>
							</div> 
								<div class="form-group">
								<label class="control-label col-sm-3">ชื่อจริง :</label>
								<div class="col-sm-3">
									<html:text  property="newfirstname" styleId="newfirstname"
										styleClass="form-control"></html:text	>
								</div>
								<div class="col-sm-3">
								</div>
							</div> 
								<div class="form-group">
								<label class="control-label col-sm-3">นามสกุล :</label>
								<div class="col-sm-3">
									<html:text  property="newlastname" styleId="newlastname"
										styleClass="form-control"></html:text	>
								</div>
								<div class="col-sm-3">
								</div>
							</div> 
								<div class="form-group">
								<label class="control-label col-sm-3">ชื่อเล่น :</label>
								<div class="col-sm-3">
									<html:text  property="newnickname" styleId="newnickname"
										styleClass="form-control"></html:text	>
								</div>
								<div class="col-sm-3">
								</div>
							</div> 
								<div class="form-group">
								<label class="control-label col-sm-3">email :</label>
								<div class="col-sm-3">
									<html:text  property="newemail" styleId="newemail"
										styleClass="form-control"></html:text	>
								</div>
								<div class="col-sm-3">
								</div>
							</div> 
								<div class="form-group">
									<label class="control-label col-sm-3">phone :</label>
									<div class="col-sm-3">
										<html:text  property="newphone" styleId="newphone"
											styleClass="form-control"></html:text	>
									</div>
									<div class="col-sm-3">
									</div>
									
								</div> 

							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-8">
									<button class="btn btn-primary" type="button" 
										onclick="submitFormSave();" >
										<i class="fa fa-save" aria-hidden="true"></i> &nbsp;บันทึก
									</button>
								</div>
							</div>
							</div> 
								
							
							

						</html:form>

					</div>
				</div>
			</div>
		</div>
		</div>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.12.1/datatables.min.css"/>
 

		</div>


</body>


<script src="js/jquery.min.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>

</html>
