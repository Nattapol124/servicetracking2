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

<<<<<<< HEAD
/* .table { */
/* 	margin-top: 4%; */
/* 	border-collapse: separate; */
/* 	border-radius: 20px; */
/* } */
=======
.table {
	margin-top: 4%;
	border-collapse: separate;
	border-radius: 20px;
}

>>>>>>> 1d7ed70bff8e3af5829783bd506632c8669d20a9
.att:hover {
	background-color: #f5f5f9;
}

.inthebox {
<<<<<<< HEAD
	margin-top: 1%;
	margin-left: 1%;
	margin-right: 1%;
	background: #e8ffff;
	top: 20%;
	border-radius: 15px;
	margin-left: 1%;
	margin-right: 1%;
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
=======
	margin-left: 10%;
	margin-right: 10%;
	width: 80%;
	background: #e8ffff;
	top: 20%;
	border-radius: 15px;
>>>>>>> 1d7ed70bff8e3af5829783bd506632c8669d20a9
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
					
					 $('#newproject').val('');
					 $('#newproject').val('');

					$("#eduForm").validate(
							{
								rules : {
									 newproject : {
										required: true,	
										minlength : 3,
					                },
					                id_customerSelected :{
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
									document.forms[0].mode.value = 'saveProject';
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
<<<<<<< HEAD

				<div class="groupTitle">
					<div class="b">
						<font size='5'><strong style="color: white;">โครงการทั้งหมด</strong></font>
					</div>

					<div class="c">
						<button type="button" data-bs-toggle="modal"
							data-bs-target="#addProjectModal" class="btn btn-primary btn-xs">
							<i class="fa fa-plus"></i> เพิ่มโครงการ
						</button>
					</div>
				</div>

				<!-- 				<button type="button" data-bs-toggle="modal" -->
				<!-- 					data-bs-target="#addProjectModal" class="btn btn-primary btn-xs"> -->
				<!-- 					<i class="fa fa-plus">เพิ่มโครงการ</i> -->
				<!-- 				</button> -->
=======
				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-8">
						<button class="btn btn-primary" type="button"
							onclick="submitFormInit('showProject')">
							<i class="fa fa-users" aria-hidden="true"></i>
							&nbsp;ดูรายชื่อบัญชีทั้งหมด
						</button>
					</div>


				</div>
				<button type="button" data-bs-toggle="modal"
					data-bs-target="#addProjectModal" class="btn btn-primary btn-xs">
					<i class="fa fa-plus">เพิ่มโครงการ</i>
				</button>
>>>>>>> 1d7ed70bff8e3af5829783bd506632c8669d20a9
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
								<html:text property="newproject" styleId="newproject"
									styleClass="form-control"></html:text>
								<label>บริษัทผู้ว่าจ้าง:</label>
								<html:select property="id_customerSelected"
									styleClass="form-control">
									<option value="" disabled selected>Select your project</option>
									<html:optionsCollection property="customerAddList" value="id"
										label="company_name" />
								</html:select>
<<<<<<< HEAD
								<logic:present name="loginForm" property="resultProjectList">
									<logic:notEmpty name="loginForm" property="resultProjectList">

										<table class="table table-sm table-bordered">

											<thead>
												<tr>
													<th class="text-center"><font size='3'><strong>ลำดับ</strong></font></th>
													<th class="text-center"><font size='3'><strong>ชื่อโครงการ</strong></font></th>
													<th class="text-center"><font size='3'><strong>บริษัทผู้ว่าจ้าง</strong></font></th>
													<th class="text-center"></th>

												</tr>
											</thead>
											<tbody>
												<logic:iterate id="item" name="loginForm"
													property="resultProjectList" indexId="index">
													<tr class="att">
														<td align="center" class="fw-normal mb-1 "><%=index + 1%></td>
														<td align="center" class="fw-normal mb-1 ">${item.project_name}</td>
														<td align="center" class="fw-normal mb-1 ">${item.id_customer.company_name}</td>
													</tr>
												</logic:iterate>

											</tbody>
										</table>
									</logic:notEmpty>
								</logic:present>
=======
								
>>>>>>> 1d7ed70bff8e3af5829783bd506632c8669d20a9
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



				<logic:present name="loginForm" property="resultProjectList">
					<logic:notEmpty name="loginForm" property="resultProjectList">
						<table cellspacing="0" width="100%"
							class="table align-middle mb-0 ">
<<<<<<< HEAD

							<thead>
								<tr>
									<th class="text-center">ลำดับ</th>
									<th class="text-center">ชื่อโครงการ</th>
									<th class="text-center">บริษัทผู้ว่าจ้าง</th>
									<th class="text-center"></th>

								</tr>
							</thead>
							<tbody>
								<logic:iterate id="item" name="loginForm"
									property="resultProjectList" indexId="index">
									<tr class="att">
										<td align="center" class="fw-normal mb-1 "><%=index + 1%></td>
										<td align="center" class="fw-normal mb-1 ">${item.project_name}</td>
										<td align="center" class="fw-normal mb-1 ">${item.id_customer.company_name}</td>


										<td align="center">

											<button type="button"
												onclick="submitFormInit('initUserProject')"
												class="btn btn-primary btn-xs">
												<i class="fa fa-plus">เพิ่มผู้เชี่ยวชาญ</i>
											</button>

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
															class="form-control" value="${item.project_name }"
															disabled> <label>ชื่อจริง : </label> <input
															type="text" class="form-control"
															value="${item.id_customer.company_name }" disabled>
														<div class="col-xl-6 mb-4">
															<%--     <div class="card">
=======
							<a>
								<thead>
									<tr>
										<th class="text-center">ลำดับ</th>
										<th class="text-center">ชื่อโครงการ</th>
										<th class="text-center">บริษัทผู้ว่าจ้าง</th>
										<th class="text-center"></th>

									</tr>
								</thead>
								<tbody>
									<logic:iterate id="item" name="loginForm"
										property="resultProjectList" indexId="index">
										<tr class="att">
											<td align="center" class="fw-normal mb-1 "><%=index + 1%></td>
											<td align="center" class="fw-normal mb-1 ">${item.project_name}</td>
											<td align="center" class="fw-normal mb-1 ">${item.id_customer.company_name}</td>


											<td align="center">

												<button type="button" onclick="submitFormEdit('${item.id}','showUserProject')"
													class="btn btn-primary btn-xs">
													<i class="fa fa-plus">เพิ่มผู้เชี่ยวชาญ</i>
												</button>

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
																class="form-control" value="${item.project_name }"
																disabled> <label>ชื่อจริง : </label> <input
																type="text" class="form-control"
																value="${item.id_customer.company_name }" disabled>
																<div class="col-xl-6 mb-4">
<%--     <div class="card">
>>>>>>> 1d7ed70bff8e3af5829783bd506632c8669d20a9
      <div class="card-body">
        <div class="d-flex justify-content-between align-items-center">
          <div class="d-flex align-items-center">
            <img
              src="https://mdbootstrap.com/img/new/avatars/8.jpg"
              alt=""
              style="width: 45px; height: 45px"
              class="rounded-circle"
            />
            <div class="ms-1">
               ${item.project_name }
            </div>
          </div>
        </div>
      </div>
     
    </div>
  </div> --%>
<<<<<<< HEAD



														</div>

=======
																			


														</div>
														
>>>>>>> 1d7ed70bff8e3af5829783bd506632c8669d20a9
														<div class="modal-footer">
															<button type="button" class="btn btn-primary"
																data-bs-dismiss="modal">ออก</button>
														</div>
													</div>
												</div>
											</div>
<<<<<<< HEAD
									</tr>

								</logic:iterate>

							</tbody>
=======
										</tr>

									</logic:iterate>

								</tbody>
>>>>>>> 1d7ed70bff8e3af5829783bd506632c8669d20a9
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
