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
		$(document).ready(
				function() {
					
					 $('#newcompanyname').val('');
					 $('#newcompanyaddress').val('');
					 $('#newcompanyphone').val('');
					 $('#newcompanyfax').val('');
					 $('#newcompanyemail').val('');

					$("#eduForm").validate(
							{
								rules : {
									newcompanyname : {
										required: true,	
										minlength : 3,
					                },
					                newcompanyaddress :{
					                	required: true,	
					                },
					                newcompanyphone :{
					                	required: true,	
					                }, newcompanyfax :{
					                	required: true,	
					                }, newcompanyemail :{
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
									document.forms[0].mode.value = 'saveCompany';
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
				<div class="form-group">
					


				</div>
				<button type="button" data-bs-toggle="modal"
					data-bs-target="#addProjectModal" class="btn btn-primary btn-xs">
					<i class="fa fa-plus">เพิ่มบริษัท</i>
				</button>
				<div class="modal fade" id="addProjectModal" tabindex="-1"
					role="dialog" aria-labelledby="addProjectModalLabel"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="addProjectModalLabel"></h5>
							</div>
							<div class="modal-body">
								<label class="control-label col-sm-3">ชื่อโครงการ :</label>
								<html:text property="newcompanyname" styleId="newcompanyname"
									styleClass="form-control"></html:text>
								<label class="control-label col-sm-3">ที่อยู่ :</label>
								<html:text property="newcompanyaddress" styleId="newcompanyaddress"
									styleClass="form-control"></html:text>
								<label class="control-label col-sm-3">โทรศัพท์ :</label>
								<html:text property="newcompanyphone" styleId="newcompanyphone"
									styleClass="form-control"></html:text>
								<label class="control-label col-sm-3">แฟกซ์ :</label>
								<html:text property="newcompanyfax" styleId="newcompanyfax"
									styleClass="form-control"></html:text>
								<label class="control-label col-sm-3">อีเมล :</label>
								<html:text property="newcompanyemail" styleId="newcompanyemail"
									styleClass="form-control"></html:text>
								
								
								
								<div class="modal-footer">
									<button type="button" class="btn btn-primary"
										data-bs-dismiss="modal">ออก</button>
									<button type="button" class="btn btn-primary"
										onclick="submitFormSave();">บันทึก</button>
								</div>
							</div>
						</div>
					</div>
				</div>



				<logic:present name="loginForm" property="customerAddList">
					<logic:notEmpty name="loginForm" property="customerAddList">
						<table cellspacing="0" width="100%"
							class="table align-middle mb-0 ">
							<a>
								<thead>
									<tr>
										<th class="text-center">ลำดับ</th>
										<th class="text-center">บริษัท</th>
										<th class="text-center">อีเมล</th>
										<th class="text-center">โทรศัพท์</th>

									</tr>
								</thead>
								<tbody>
									<logic:iterate id="item" name="loginForm"
										property="customerAddList" indexId="index">
										<tr class="att">
											<td align="center" class="fw-normal mb-1 " data-bs-toggle="modal" data-bs-target="#exampleModal${item.id}"><%=index + 1%></td>
											<td align="center" class="fw-normal mb-1 " data-bs-toggle="modal" data-bs-target="#exampleModal${item.id}">${item.company_name}</td>
											<td align="center" class="fw-normal mb-1 " data-bs-toggle="modal" data-bs-target="#exampleModal${item.id}">${item.company_email}</td>
											<td align="center" class="fw-normal mb-1 " data-bs-toggle="modal" data-bs-target="#exampleModal${item.id}">${item.company_phone}</td>
											


											<td align="center">

												<%-- <button type="button" onclick="submitFormEdit('${item.id}','showUserProject')"
													class="btn btn-primary btn-xs">
													<i class="fa fa-plus">เพิ่มผู้เชี่ยวชาญ</i>
												</button> --%>

											</td>
											
 
		
											<div class="modal fade" id="exampleModal${item.id}"
												tabindex="-1" role="dialog"
												aria-labelledby="exampleModalLabel" aria-hidden="true">
												<div class="modal-dialog" role="document">
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title" id="exampleModalLabel"></h5>
														</div>
														<div class="modal-body">
															<label>ชื่อผู้ใช้ : </label> <input type="text"
																class="form-control" value="${item.company_name}"
																disabled> 
															<label>ที่อยู่ : </label> <input
																type="text" class="form-control"
																value="${item.company_address }" disabled>
															<label>โทรศัพท์ : </label> <input
																type="text" class="form-control"
																value="${item.company_phone }" disabled>
															<label>อีเมล : </label> <input
																type="text" class="form-control"
																value="${item.company_email }" disabled>
															<label>แฟกซ์ : </label> <input
																type="text" class="form-control"
																value="${item.company_fax }" disabled>
	
																			


														</div>
														
														<div class="modal-footer">
															<button type="button" class="btn btn-primary"
																data-bs-dismiss="modal">ออก</button>
														</div>
													</div>
												</div>
											</div>
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
