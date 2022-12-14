<!DOCTYPE html>
<%@page contentType="text/html; charset=utf-8"%>
<%@taglib uri="/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/tld/c.tld" prefix="c"%>
<%@taglib uri="/tld/fn.tld" prefix="fn"%>

<%@ include file="/page/inc_header_script.jsp"%>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<body>
<script type="text/javascript">
	
	function add(){
		document.forms[0].mode.value = "requestBtn";
		document.forms[0].submit();
	}
	
	function edit(id){
		  document.forms[0].mode.value = "editRequest";
		  document.forms[0].id.value = id;
		  document.forms[0].submit();
	}
	
	function del(id){
		Swal.fire({
			  title: 'Are you sure?',
			  text: "You want to delete!",
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'Yes'
			}).then((result) => {
				if(result.isConfirmed){
					document.forms[0].mode.value = "deleteRequest";
				  	document.forms[0].id.value = id;
				    document.forms[0].submit();
				}
			    
			  })
	}
	
	function save(){
		Swal.fire({
			  title: 'Are you sure?',
			  text: "You want to save change!",
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'Yes'
			}).then((result) => {
				if(result.isConfirmed){
					
				}
			    
			  })
	}
	
	
</script>

<style type="text/css">
h2{
	margin-top:10%;
}
</style>

	<html:form action="/index" styleId="eduForm">
	<html:hidden property="mode"/>
	<section class="ftco-section">
	<%@ include file="/page/inc_header.jsp"%>
		<div class="container">
		<div class="wrapper">
			<div class="row justify-content-center">
				<div class="text-center col-lg-12">
					
					<h2>ตารางการส่งคำร้องเรียน</h2>
				</div>
			</div>
			
			
				<div class="col-md-12">
					<div class="table-wrap">
					<logic:present name="indexForm" property="resultList">
					<logic:notEmpty name="indexForm" property="resultList">
						<table class="table table-striped">
						  <thead>
						    <tr>
						      <th class = "text-center">NO.</th>
						      <th class = "text-center">หัวข้อ</th>
						      <th class = "text-center">ผู้แจ้งเรื่อง</th>
						      
						      <th class = "text-center">สถานะ</th>
<!-- 						      <th>ประเภท</th> -->
<!-- 						      <th>โครงการ</th> -->

<!-- 						      <th>รายละเอียด</th> -->
<!-- 						      <th>วันที่ส่งคำร้อง</th> -->
<!-- 						      <th>ไฟล์</th> -->
						    </tr>
						  </thead>
						  <tbody>
						  	
								<logic:iterate id="item" name="indexForm" property="resultList" indexId="index">
								<tr>
								<td align="center"><%= index+1 %></td>
								<td align="center">${item.request_title }</td>
								<td align="center">${item.id_user.nickname }</td>
								<c:if test="${item.id_request_status.id eq '1' }">
									<td align="center"><a href="#" class="btn btn-warning" data-bs-toggle="modal"  data-bs-target="#exampleModal${item.id}">${item.id_request_status.status_name }</a></td>
								</c:if>
								
								<c:if test="${item.id_request_status.id eq '2' }">
									<td align="center"><a href="#" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#exampleModal${item.id}">${item.id_request_status.status_name }</a></td>
								</c:if>
								
								<c:if test="${item.id_request_status.id eq '3' }">
									<td align="center"><a href="#" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#exampleModal${item.id}">${item.id_request_status.status_name }</a></td>
								</c:if>
								
								<c:if test="${item.id_request_status.id eq '4' }">
									<td align="center"><a href="#" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#exampleModal${item.id}">${item.id_request_status.status_name }</a></td>
								</c:if>
								
								<c:if test="${item.id_request_status.id eq '5' }">
									<td align="center"><a href="#" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal${item.id}">${item.id_request_status.status_name }</a></td>
								</c:if>
								
								
<%-- 									<td align="center">${item.request_type.name }</td> --%>
<%-- 								<td>${item.id}</td> --%>
								
<%-- 								<td>${item.remark }</td> --%>
<%-- 								<td>${item.date }</td> --%>
<%-- 								<td>${item.file }</td> --%>
								<c:if test="${item.id_request_status.id eq '1' }">
									<td>
										<button type="button" data-bs-toggle="modal" data-bs-target="#editModal${item.id}" class="btn btn-primary btn-xs">edit</button>
										<button type="button" onclick="del('${item.id}')" class="btn btn-danger btn-xs">delete</button>
									</td>
								
								</c:if>
								<c:if test="${item.id_request_status.id ne '1' }">
									<td>
										<button type="button" onclick=""  class="btn btn-primary btn-xs" disabled>edit</button>
										<button type="button" onclick=""  class="btn btn-danger btn-xs" disabled>delete</button>
									</td>
								</c:if>
								</tr>
												<div class="modal fade" id="exampleModal${item.id}" tabindex="-1"
													role="dialog" aria-labelledby="exampleModalLabel"
													aria-hidden="true">
													<div class="modal-dialog" role="document">
														<div class="modal-content">
															<div class="modal-header">
																<h5 class="modal-title" id="exampleModalLabel">รายละเอียด : ${item.request_title }</h5>
															</div>
															<div class="modal-body">

																<p>ประเภท : ${item.id_request_type.type_name }</p>
																<p>โครงการ : ${item.id_project.project_name }</p>
																<p>รายละเอียด : ${item.request_remark }</p>
																<p>วันที่ส่งคำร้อง : ${item.request_date }</p>
																<p>ไฟล์ : ${item.request_file }</p>

															</div>
															<div class="modal-footer">
																<button type="button" class="btn btn-primary"
																	data-bs-dismiss="modal">OK</button>
															</div>
														</div>
													</div>
												</div>
												
												<div class="modal fade" id="editModal${item.id}" tabindex="-1"
													role="dialog" aria-labelledby="exampleModalLabel"
													aria-hidden="true">
													<div class="modal-dialog" role="document">
														<div class="modal-content">
															<div class="modal-header">
																<h5 class="modal-title" id="exampleModalLabel">แก้ไข : ${item.request_title }</h5>
															</div>
															<div class="modal-body">
																<label>หัวข้อ : </label>
																<input type="text" class="form-control" value="${item.request_title }" required>
																
																<label>โครงการ : </label>
																<html:select property="id_project" styleClass="form-control">	
																	<html:optionsCollection property="projectList" value="id" label="project_name" />
																</html:select>
																
																<label>รายละเอียด : </label>
																<input type="text"  class="form-control" value="${item.request_remark }" required>
																<label>วันที่ส่งคำร้อง : </label>
																<input type="Date"  class="form-control" value="${item.request_date }" required>
																<label>ไฟล์ : </label>
																<input type="file"  class="form-control" value="${item.request_file }" required>

															</div>
															<div class="modal-footer">
																<button type="button" class="btn btn-primary" onclick="save()">Save Change</button>
																<button type="button" class="btn btn-cancel" data-bs-dismiss="modal">Cancel</button>
															</div>
														</div>
													</div>
												</div>

								</logic:iterate>
						    	
						  </tbody>
						</table>
					</logic:notEmpty>
					</logic:present>
					</div>
					<button class="btn-blue btn-sm" onclick="add()">รายงานปัญหา</button>
				</div>
				
			</div>
		</div>
	
	</section>
	

	<script src="js/jquery.min.js"></script>
  <script src="js/popper.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/main.js"></script>
  

	
	</html>
	</html:form>
</section>
</body>