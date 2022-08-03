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
    text-align:center;
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
	margin-left:10%;
	margin-right:10%;
	
	width: 80%;
	background: #e8ffff;
	top:20%;
	border-radius:15px;
}

.profilebox {
	left:40%;
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
            }
            else {
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
<!-- 			<h1 class="">ชื่อผู้ใช้:${SSUser.username}</h1>
				<h1 class="">ชื่อจริง:${SSUser.user_firstname}</h1>
				<h1 class="">นามสกุล${SSUser.user_lastname}</h1>
				<h1 class="">email:${SSUser.user_email}</h1>
				<h1 class="">เบอร์โทรศัพท์:${SSUser.user_phone}</h1>
				<h1 class="">id:${SSUser.id_company.id}</h1>
-->
				<td>ชื่อผู้ใช้: <input disabled type="text" id="userNmae" name="" value="${SSUser.username}"></td><br />
				<td>ชื่อจริง: <input disabled type="text" id="firstName" name="" value="${SSUser.user_firstname}"}></td><br />
				<td>นามสกุล: <input disabled type="text" id="lastName" name="" value="${SSUser.user_lastname}"}></td><br />
				<td>email: <input disabled type="text" id="email" name="" value="${SSUser.user_email}"}></td><br />
				<td>เบอร์โทรศัพท์: <input disabled type="text" id="phone" name="" value="${SSUser.user_phone}"}></td><br />
				
				<button onclick="editDataBtn()" id="editData" value="แก้ไขข้อมูล">แก้ไขข้อมูล</button>
				
			</div>



		</div>
</body>


<script src="js/jquery.min.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>

</html>
