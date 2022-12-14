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
			
					function searchData() {
			var input, filter, table, tr, td, i, txtValue;
			input = document.getElementById("search");
			filter = input.value.toUpperCase();
			table = document.getElementById("userData");
			tr = table.getElementsByTagName("tr");
			for (i = 0; i < tr.length; i++) {
				td = tr[i].getElementsByTagName("td")[1];
				if (td) {
					txtValue = td.textContent || td.innerText;
					if (txtValue.toUpperCase().indexOf(filter) > -1) {
						tr[i].style.display = "";
					} else {
						tr[i].style.display = "none";
					}
				}
			}
		}		
				
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
							onclick="submitFormInit('showtable')">
							<i class="fa fa-users" aria-hidden="true"></i>
							&nbsp;???????????????????????????????????????????????????????????????
						</button>
					</div>

				</div>
				<%-- <div class="form-group">
					        		<label class="control-label col-sm-3">??????????????????????????? :</label>
									<div class="col-sm-4">
										<html:select property="projectindi" styleClass="form-control">
											<html:optionsCollection property="comboIndicator" value="id" label="nameShort"/>
										</html:select>
									</div>	
				</div>   --%>
				<input type="text" id="search" onkeyup="searchData()"
							placeholder="Search for names..">
				<div class="col-sm-offset-3 col-sm-8 margin-right:50%;">
					<button class="btn btn-primary" type="button"
						onclick="submitFormInit('initAddUser')">
						<i class="fa fa-user-plus" aria-hidden="true"></i> &nbsp;?????????????????????????????????
					</button>
				</div>
				<logic:present name="loginForm" property="resultList">
					<logic:notEmpty name="loginForm" property="resultList">
						<table cellspacing="0" width="100%"
							class="table align-middle mb-0 ">
							
								<thead>
									<tr>
										<th class="text-center">???????????????</th>
										<th class="text-center">??????????????????????????????</th>
										<th class="text-center">????????????????????????</th>
										<th class="text-center">?????????????????????</th>
										<th class="text-center">?????????</th>
										<th class="text-center">???????????????</th>
										<th class="text-center"></th>
										
									</tr>
								</thead>
								<tbody>
									<logic:iterate id="item" name="loginForm" property="resultList"
										indexId="index">
										<tr class="att" >
										
											<td align="center" class="fw-normal mb-1 " data-bs-toggle="modal" data-bs-target="#exampleModal${item.id}"><%=index + 1%></td>
											<td align="center" class="fw-normal mb-1 " data-bs-toggle="modal" data-bs-target="#exampleModal${item.id}">${item.username}</td>
											<td align="center" class="fw-normal mb-1 " data-bs-toggle="modal" data-bs-target="#exampleModal${item.id}">${item.user_firstname}</td>
											<td align="center" class="fw-normal mb-1 " data-bs-toggle="modal" data-bs-target="#exampleModal${item.id}">${item.user_lastname}</td>
											<td align="center" class="fw-normal mb-1 " data-bs-toggle="modal" data-bs-target="#exampleModal${item.id}">${item.user_email}</td>
											<td align="center" class="fw-normal mb-1 " data-bs-toggle="modal" data-bs-target="#exampleModal${item.id}">${item.user_phone}</td>
											</div>

											<td align="center" >

												<button type="button" data-bs-toggle="modal" data-bs-target="#exampleModal${item.id}"
													class="btn btn-primary btn-xs">
													<i class="fa fa-edit">??????????????????????????????????????????</i>
												</button>
												<button type="button"
													onclick="submitFormRemove('${item.id}');"
													class="btn btn-danger btn-xs">
													<i class="fa fa-trash-o">?????????????????????</i>
												</button>
											</td>
										
										
									
													
										</tr>
										
										<div class="modal fade" id="exampleModal${item.id}" tabindex="-1"
													role="dialog" aria-labelledby="exampleModalLabel"
													aria-hidden="true">
													<div class="modal-dialog" role="document">
														<div class="modal-content">
															<div class="modal-header">
																<h5 class="modal-title" id="exampleModalLabel">???????????????????????????????????????????????????</h5>
															</div>
															<div class="modal-body">
																<label>?????????????????????????????? : </label>
																<input type="text" class="form-control" value="${item.username }" disabled>
																<label>???????????????????????? : </label>
																<input type="text" class="form-control" value="${item.user_firstname }" disabled>
																<label>?????????????????????: </label>
																<input type="text" class="form-control" value="${item.user_lastname }" disabled>
																<label>??????????????? : </label>
																<input type="text" class="form-control" value="${item.user_email }" disabled>
																<label>?????????????????? : </label>
																<input type="text" class="form-control" value="${item.user_phone }" disabled>
																<label>?????????????????? : </label>
																<input type="text" class="form-control" value="${item.id_customer.company_name }" disabled>
																<label>????????????????????? : </label>
																<input type="text" class="form-control" value="${item.id_user_position.position_name }" disabled>
															</div>
															<div class="modal-footer">
																<button type="button" class="btn btn-primary"
																	data-bs-dismiss="modal">?????????</button>
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
	
		
		
		
									
											
		<script>
 function togglePopup(id) {
 document.getElementById("popup-"+id)
  .classList.toggle("active");
}
</script>
		<!-- <table class="table align-middle mb-0 ">
  <thead class="bg-light">
    <tr>
       <th  class="text-center">???????????????</th>
       <th class="text-center">??????????????????????????????</th>								          
       <th class="text-center">????????????????????????</th>
       <th class="text-center">?????????????????????</th>
		<th class="text-center">?????????</th>
	   <th class="text-center">???????????????</th>
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
