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
		function submitFormRemove(ids) {
			 
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
				    	document.loginForm.mode.value = 'deleteUserProject';
						document.loginForm.ids.value = ids;
						document.loginForm.submit();
								
				    }
				       
				     })
			
					
				
		}
		$(document).ready(
				function() {
					
					$("#eduForm").validate(
							{
								rules : {
									 
									userAddToProjectSelect :{
					                	required: true,	
					                },
					               
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
									document.forms[0].mode.value = 'saveUserAddToProject';
									document.forms[0].submit();
								}
							});
				});
		
		function submitFormSave() {
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
				<html:hidden property="ids" />

				<div class="form-group">
					<html:select property="userAddToProjectSelect"
						styleClass="form-control">
						<option value="" disabled selected>เลือกผู้ใช้</option>
						<html:optionsCollection property="userAddToProjectList" value="id"
							label="fullName" />
					</html:select>
					<button type="button" class="btn btn-primary"
						onclick="submitFormSave();">บันทึก</button>


				</div>



				<logic:present name="loginForm" property="resultUserProjectList">
					<logic:notEmpty name="loginForm" property="resultUserProjectList">
						<table id="dtBasicExample" class="table" cellspacing="0"
							width="100%">



							<thead>
								<tr>
									<th class="text-center">ลำดับ</th>
									<th class="text-center">ชื่อผู้ใช้</th>
									<th class="text-center">ชื่อจริง</th>
									<th class="text-center">นามสกุล</th>

									<th class="text-center"></th>

								</tr>
							</thead>
							<tbody>
								<logic:iterate id="item" name="loginForm"
									property="resultUserProjectList" indexId="index">
									<tr class="att">

										<td align="center" class="fw-normal mb-1 "
											data-bs-toggle="modal"
											data-bs-target="#exampleModal${item.id}"><%=index + 1%></td>
										<td align="center" class="fw-normal mb-1 "
											data-bs-toggle="modal"
											data-bs-target="#exampleModal${item.id}">${item.id_user.username}</td>
										<td align="center" class="fw-normal mb-1 "
											data-bs-toggle="modal"
											data-bs-target="#exampleModal${item.id}">${item.id_user.user_firstname}</td>
										<td align="center" class="fw-normal mb-1 "
											data-bs-toggle="modal"
											data-bs-target="#exampleModal${item.id}">${item.id_user.user_lastname}</td>

										</div>

										<td align="center">

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
														class="form-control"
														value="${item.id_user.user_firstname}" disabled> <label>ชื่อจริง
														: </label> <input type="text" class="form-control"
														value="${item.id_user.user_lastname}" disabled>

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
