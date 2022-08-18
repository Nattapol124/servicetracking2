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

h1 {
	text-align: center;
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
	width: 90%;
	margin-top: 15%;
	left: 5%;
	margin: 5%;
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

.profilebox {
	left: 40%;
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
			$("#eduForm").validate({
				rules: {
					newfirstname: "required",
					newlastname: "required",
					newnickname: "required",
					newemail: "required",
					newphone: "required",
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
		      		document.forms[0].mode.value = 'saveProfile';
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
		function submitFormEdit(id, mode) {
			document.loginForm.mode.value = mode;
			document.loginForm.id.value = id;
			document.loginForm.submit();
		}
		function submitFormRemove(id) {
			bootbox.dialog({
				title : 'ยืนยันการลบข้อมูล',
				message : 'คุณต้องการยืนยันการลบข้อมูลนี้ใช่หรือไม่',
				buttons : {
					Cancel : {
						label : 'ยกเลิก',
						className : "btn-default",
						callback : function() {
						}
					},
					success : {
						label : 'ตกลง',
						className : "btn-danger",
						callback : function() {
							document.loginForm.mode.value = 'delete';
							document.loginForm.id.value = id;
							document.loginForm.submit();
						}
					}
				}
			});
		}
		function editDataBtn() {

			var btn = document.getElementById("editData");

			if (btn.value == "แก้ไขข้อมูล") {
				document.getElementById("firstName").disabled = false;
				document.getElementById("lastName").disabled = false;
				document.getElementById("email").disabled = false;
				document.getElementById("phone").disabled = false;
				btn.value = "บันทึกข้อมูล";
				btn.innerHTML = "บันทึกข้อมูล";
			} else {
				document.getElementById("firstName").disabled = true;
				document.getElementById("lastName").disabled = true;
				document.getElementById("email").disabled = true;
				document.getElementById("phone").disabled = true;
				btn.value = "แก้ไขข้อมูล";
				btn.innerHTML = "แก้ไขข้อมูล";
			}

		}
	</script>

	<%@ include file="/page/inc_menu.jsp"%>

	<div class="topbar">
		<!-- Navbar -->
		<%@ include file="/page/inc_header.jsp"%>

		<!-- Navbar -->
		<div class="inthebox">
			<div class="profilebox center">
				<html:form action="/login" styleId="eduForm"
					styleClass="form-horizontal form-validate">
					<html:hidden property="mode" />
					<html:hidden property="id" />

					<div class="form-group">
						<label class="control-label col-sm-3">ชื่อผู้ใช้ :</label>
						<div class="col-sm-3">
							<fieldset disabled>
								<html:text property="username" styleId="username"
									styleClass="form-control"></html:text>
							</fieldset>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">ชื่อ :</label>
						<div class="col-sm-3">
							<html:text property="newfirstname" styleId="newfirstname"
								styleClass="form-control"></html:text>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">นามสกุล :</label>
						<div class="col-sm-3">
							<html:text property="newlastname" styleId="newlastname"
								styleClass="form-control"></html:text>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">ชื่อเล่น :</label>
						<div class="col-sm-3">
							<html:text property="newnickname" styleId="newnickname"
								styleClass="form-control"></html:text>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">อีเมลล์ :</label>
						<div class="col-sm-3">
							<html:text property="newemail" styleId="newemail"
								styleClass="form-control"></html:text>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">มือถือ :</label>
						<div class="col-sm-3">
							<html:text property="newphone" styleId="newphone"
								styleClass="form-control"></html:text>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">ชื่อบริษัท :</label>
						<div class="col-sm-3">
							<fieldset disabled>
								<html:text property="company" styleId="company"
									styleClass="form-control"></html:text>
							</fieldset>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">ตำแหน่ง :</label>
						<div class="col-sm-3">
							<fieldset disabled>
								<html:text property="position" styleId="position"
									styleClass="form-control"></html:text>
							</fieldset>
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



				<!-- 			<h1 class="">ชื่อผู้ใช้:${SSUser.username}</h1>
				<h1 class="">ชื่อจริง:${SSUser.user_firstname}</h1>
				<h1 class="">นามสกุล${SSUser.user_lastname}</h1>
				<h1 class="">email:${SSUser.user_email}</h1>
				<h1 class="">เบอร์โทรศัพท์:${SSUser.user_phone}</h1>
				<h1 class="">id:${SSUser.id_company.id}</h1>
-->
				<%-- 				<td>ชื่อผู้ใช้: <input disabled type="text" id="userNmae" name="" value="${SSUser.username}"></td><br /> --%>
				<%-- 				<td>ชื่อจริง: <input disabled type="text" id="firstName" name="" value="${SSUser.user_firstname}"}></td><br /> --%>
				<%-- 				<td>นามสกุล: <input disabled type="text" id="lastName" name="" value="${SSUser.user_lastname}"}></td><br /> --%>
				<%-- 				<td>email: <input disabled type="text" id="email" name="" value="${SSUser.user_email}"}></td><br /> --%>
				<%-- 				<td>เบอร์โทรศัพท์: <input disabled type="text" id="phone" name="" value="${SSUser.user_phone}"}></td><br /> --%>

				<!-- 				<button onclick="editDataBtn()" id="editData" value="แก้ไขข้อมูล">แก้ไขข้อมูล</button> -->
			</div>



		</div>
</body>


<script src="js/jquery.min.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>

</html>
