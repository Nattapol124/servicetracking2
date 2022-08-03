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
							onclick="submitFormInit('showProject')">
							<i class="fa fa-users" aria-hidden="true"></i>
							&nbsp;ดูรายชื่อบัญชีทั้งหมด
						</button>
					</div>

				</div>
				<div class="col-sm-offset-3 col-sm-8 margin-right:50%;">
					<button class="btn btn-primary" type="button"
						onclick="submitFormInit('initAddUser')">
						<i class="fa fa-users" aria-hidden="true"></i> &nbsp;เพิ่มผู้ใช้
					</button>
				</div>
				<logic:present name="loginForm" property="resultProjectList">
					<logic:notEmpty name="loginForm" property="resultProjectList">
						<table cellspacing="0" width="100%"
							class="table align-middle mb-0 ">
							<a>
								<thead>
									<tr>
										<th class="text-center">ลำดับ</th>
										<th class="text-center">ชื่อโครงการ</th>
										<th class="text-center">บริษัทผู้ว่าจ้าง</th>
										<th class="text-center">บริษัทผู้รับจ้าง</th>
									</tr>
								</thead>
								<tbody>
									<logic:iterate id="item" name="loginForm" property="resultProjectList"
										indexId="index">
										<tr class="att">
											<td align="center" class="fw-normal mb-1 "><%=index + 1%></td>
											<td align="center" class="fw-normal mb-1 ">${item.project_name}</td>
											<td align="center" class="fw-normal mb-1 ">${item.id_customer.company_name}</td>
											<td align="center" class="fw-normal mb-1 ">${item.id_customer.company_name}</td>
										

											<td align="center">

												<button type="button" onclick="togglePopup('${item}');"
													class="btn btn-primary btn-xs">
													<i class="fa fa-plus">เพิ่มผู้เชี่ยวชาญ</i>
												</button>
												
											</td>
										<!-- 	<td>
											1
											<div class="popup" id="popup-1">
													<div class="content">
														<div class="close-btn" onclick="togglePopup()">×</div> -->

													<%-- 	<h1>Sign in</h1>
														<span align="left">ชื่อผู้ใช้</span>
														<div class="input-field" >
															<input placeholder='${item.username}'
																class="validate">
														</div>
														<span align="left">ชื่อผู้ใช้</span>
													
														<div class="input-field">
															<input placeholder="${item.user_firstname}" class="validate">
														</div>
														<span align="left">นามสกุล</span>
														<div class="input-field">
															<input placeholder="lastname" class="validate">
														</div>
														<span align="left">email</span>
														<div class="input-field">
															<input placeholder="email" class="validate">
														</div>
														<span align="left">เบอร์</span>
														<div class="input-field">
															<input placeholder="phone" class="validate">
														</div>
														<span align="left">ชื่อเล่น</span>
														<div class="input-field">
															<input placeholder="nickname" class="validate">
														</div>
														<span align="left">บริษัท</span>
														<div class="input-field">
															<input placeholder="company" class="validate">
														</div>
<!-- 														<button class="second-button">Sign in</button>
 -->

													</div> --%>
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
		<script>
 function togglePopup() {
 document.getElementById("popup-1")
  .classList.toggle("active");
}
</script>
		<!-- <table class="table align-middle mb-0 ">
  <thead class="bg-light">
    <tr>
       <th  class="text-center">ลำดับ</th>
       <th class="text-center">ชื่อผู้ใช้</th>								          
       <th class="text-center">ชื่อจริง</th>
       <th class="text-center">นามสกุล</th>
		<th class="text-center">เมล</th>
	   <th class="text-center">เบอร์</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>
        <div class="d-flex align-items-center">
          <img
              src="https://mdbootstrap.com/img/new/avatars/8.jpg"
              alt=""
              style="width: 45px; height: 45px"
              class="rounded-circle"
              />
          <div class="ms-3">
            <p class="fw-bold mb-1">John Doe</p>
            <p class="text-muted mb-0">john.doe@gmail.com</p>
          </div>
        </div>
      </td>
      <td>
        <p class="fw-normal mb-1">Software engineer</p>
        <p class="text-muted mb-0">IT department</p>
      </td>
      <td>
        <span class="badge badge-success rounded-pill d-inline">Active</span>
      </td>
      <td>Senior</td>
      <td>
        <button type="button" class="btn btn-link btn-sm btn-rounded">
          Edit
        </button>
      </td>
    </tr>
    
  </tbody>
</table>
   -->
</body>


<script src="js/jquery.min.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>

</html>
	