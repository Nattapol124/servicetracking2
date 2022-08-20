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
	color: black;
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

.att:hover {
	background-color: #f5f5f9;
}

.inthebox {
	/* 	margin-left: 10%; */
	/* 	margin-right: 10%; */
	margin-top: 1%;
	margin-left: 1%;
	margin-right: 1%;
	background: #e8ffff;
	top: 20%;
	border-radius: 15px;
}

div.groupTitle {
	/* 	margin-top: 1%; */
	/* 	margin-left: 1%; */
	/* 	margin-right: 1%; */
	width: autu;
	height: 50px;
	background: #36D0FE;
}

div.b {
	/* 	margin-top: 1%; */
	margin-left: 1%;
	margin-right: 1%;
	position: absolute;
	left: 0px;
	width: auto;
	height: 50px;
	border: 3px solid #73AD21;
}

div.c {
	/* 	margin-top: 1%; */
	margin-left: 1%;
	margin-right: 1%;
	position: absolute;
	right: 0px;
	width: auto;
	height: 50px;
	border: 3px solid #73AD21;
}
</style>
<style type="text/css">
</style>

<body>
	<script type="text/javascript">
		$(document).ready(function () {
			  $('#dtBasicExample').DataTable();
			  $('.dataTables_length').addClass('bs-select');
			});

		function submitFormInit(mode) {
			document.loginForm.mode.value = mode;
			document.loginForm.submit();
			
		}
		function submitFormEdit(id, mode) {
			 Swal.fire({
			     title: 'Are you sure?',
			     text: "คุณต้องการจะรีเซ็ทรหัสผ่านหรือไม่?",
			     icon: 'warning',
			     showCancelButton: true,
			     confirmButtonColor: '#3085d6',
			     cancelButtonColor: '#d33',
			     confirmButtonText: 'Yes'
			   }).then((result) => {
			    if(result.isConfirmed){
			document.loginForm.mode.value = mode;
			document.loginForm.id.value = id;
			document.loginForm.submit();
			    }
			   })
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
						$(window).on('load',function(){
					        $('#exampleModal${item.id}').modal('show');
					    });
			
				    }
				       
				     })
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
				<div class="form-group"></div>
				<logic:present name="loginForm" property="resultList">
					<logic:notEmpty name="loginForm" property="resultList">

						<div class="groupTitle">
							<div class="b">
								<font size='5'><strong style="color: white;">ผู้ใช้งานทั้งหมด</strong></font>
							</div>

							<div class="c">
								<button class="btn btn-primary me-md-2"
									onclick="submitFormInit('initAddUser')">
									<i class="fa fa-user-plus" aria-hidden="true"></i>
									&nbsp;เพิ่มผู้ใช้
								</button>
							</div>
						</div>


						<!-- 		id = "id="dtBasicExample"			 -->
						<table id="dtBasicExample" class="table table-sm table-bordered"
							cellspacing="0">
							<thead>
								<tr>
									<th class="text-center" width="50"><font size='3'><strong>ลำดับ</strong></font></th>
									<th class="text-center" width="100"><font size='3'><strong>ชื่อผู้ใช้</strong></font></th>
									<th class="text-center" width="100"><font size='3'><strong>ชื่อจริง</strong></font></th>
									<th class="text-center" width="100"><font size='3'><strong>นามสกุล</strong></font></th>
									<th class="text-center" width="100"><font size='3'><strong>เมล</strong></font></th>
									<th class="text-center" width="100"><font size='3'><strong>เบอร์</strong></font></th>
									<th class="text-center" width="20%"></th>

								</tr>
							</thead>
							<tbody>
								<logic:iterate id="item" name="loginForm" property="resultList"
									indexId="index">
									<tr class="att">

										<td align="center" class="fw-normal mb-1 "
											data-bs-toggle="modal"
											data-bs-target="#exampleModal${item.id}"><%=index + 1%></td>
										<td align="center" class="fw-normal mb-1 "
											data-bs-toggle="modal"
											data-bs-target="#exampleModal${item.id}">${item.username}</td>
										<td align="center" class="fw-normal mb-1 "
											data-bs-toggle="modal"
											data-bs-target="#exampleModal${item.id}">${item.user_firstname}</td>
										<td align="center" class="fw-normal mb-1 "
											data-bs-toggle="modal"
											data-bs-target="#exampleModal${item.id}">${item.user_lastname}</td>
										<td align="center" class="fw-normal mb-1 "
											data-bs-toggle="modal"
											data-bs-target="#exampleModal${item.id}">${item.user_email}</td>
										<td align="center" class="fw-normal mb-1 "
											data-bs-toggle="modal"
											data-bs-target="#exampleModal${item.id}">${item.user_phone}</td>
										<td align="center">

											<button type="button"
												onclick="submitFormEdit('${item.id}', 'resetPassword')"
												class="btn btn-primary btn-xs">
												<i class="fa fa-edit">รีเซ็ทรหัส</i>
											</button>
											<button type="button"
												onclick="submitFormRemove('${item.id}');"
												class="btn btn-danger btn-xs">
												<i class="fa fa-trash-o">ลบบัญชี</i>
											</button>
										</td>
									</tr>

									<div class="modal fade" id="exampleModal${item.id}"
										tabindex="-1" role="dialog"
										aria-labelledby="exampleModalLabel" aria-hidden="true">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="exampleModalLabel">ข้อมูลบัญชีผู้ใช้</h5>
												</div>
												<div class="modal-body">
													<label>ชื่อผู้ใช้ : </label> <input type="text"
														class="form-control" value="${item.username }" disabled>
													<label>ชื่อจริง : </label> <input type="text"
														class="form-control" value="${item.user_firstname }"
														disabled> <label>นามสกุล: </label> <input
														type="text" class="form-control"
														value="${item.user_lastname }" disabled> <label>อีเมล
														: </label> <input type="text" class="form-control"
														value="${item.user_email }" disabled> <label>มือถือ
														: </label> <input type="text" class="form-control"
														value="${item.user_phone }" disabled> <label>บริษัท
														: </label> <input type="text" class="form-control"
														value="${item.id_customer.company_name }" disabled>
													<label>ตำแหน่ง : </label> <input type="text"
														class="form-control"
														value="${item.id_user_position.position_name }" disabled>
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-primary"
														data-bs-dismiss="modal">ออก</button>
												</div>
											</div>
										</div>
									</div>

								</logic:iterate>



							</tbody>

						</table>
					</logic:notEmpty>
				</logic:present>
			</html:form>
		</div>

	</div>

</body>

<script>
    if ( window.history.replaceState ) {
        window.history.replaceState( null, null, window.location.href );
    }
</script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/popper.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/mdb.min.js"></script>
<!-- Plugin file -->
<script src="./js/addons/datatables.min.js"></script>
</html>
