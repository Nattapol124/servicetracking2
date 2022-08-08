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
	width: 600px;
	height: 900px;
	z-index: 2;
	text-align: center;
	padding: 20px;
	border-radius: 20px;
	background: white;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
	z-index: 1;
	backdrop-filter: blur(5px);

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


</style>
<style type="text/css">
</style>

<body>
	<script type="text/javascript">
	function add() {
// 		Swal.fire({
// 			  title: 'Are you sure?',
// 			  text: "You want to logout!",
// 			  icon: 'warning',
// 			  showCancelButton: true,
// 			  confirmButtonColor: '#3085d6',
// 			  cancelButtonColor: '#d33',
// 			  confirmButtonText: 'Yes'
// 			}).then((result) => {
// 				if(result.isConfirmed){
// 					document.forms[0].mode.value = "addRequest";
// 					document.forms[0].submit();
// 				}
			    
// 			  })
			document.forms[0].mode.value = "addRequest";
			document.forms[0].submit();
	}
	function back() {
		document.forms[0].mode.value = "getRequest";
		document.forms[0].submit();
	}
	function submitEnter() {
		if (checkKeyEnter() == true) submitFormLogin();
	}
	
	function checkKeyEnter(){
		   if(event.keyCode==13) return true;
	}
		
	</script>

	<%@ include file="/page/inc_menu.jsp"%>

	<div class="topbar">
		<!-- Navbar -->
		<%@ include file="/page/inc_header.jsp"%>

		
		<div class="inthebox">

			<html:form action="/index" styleId="eduForm">
<html:hidden property="mode"/>
	<div class="topbar">
		<!-- Navbar -->
		<%@ include file="/page/inc_header.jsp"%>

	
		<section id="main-content">
		<section class="wrapper">
         <div>
         	<h2>รายงานปัญหา</h2>
         	<label>ชื่อโครงการ</label>
         	<html:select property="id" styleClass="form-control">
         		<option value="" disabled selected>Select your project</option> 
				<html:optionsCollection property="projectList" value="id" label="project_name" />
			</html:select> 
         </div>
         
         <div>
         	<label>หัวข้อปัญหา</label>
         	<html:text property="request_title" onkeypress="submitEnter();" styleClass="form-control" styleId="title" placeHolder="หัวข้อปัญหา" />
         </div>
         
        <div>
        <label>Select a file to upload: </label>
         <input property="request_file" type = "file" accept=".pdf, .png, .jpg, .jpeg"/>
        </div>
        
        <div>
        <label>ปัญหาที่เกิด</label>
         <html:text property="request_remark" onkeypress="submitEnter();" styleClass="form-control" styleId="remark" placeHolder="ปัญหาที่เกิด" />
        </div>
         
         <button class="btn-blue btn-sm" onClick="add()">add</button>
         <button class="btn-blue btn-sm" onclick="back()">back</button>
         
         
		</section>
		</section>
</div>
 </html>
</html:form>   
		</div>
	
		
		
		
									
											
		
</body>


<script src="js/jquery.min.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>

</html>
