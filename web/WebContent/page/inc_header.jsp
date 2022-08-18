<%@page contentType="text/html; charset=utf-8"%>
<%@taglib uri="/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/tld/c.tld" prefix="c"%>
<%@taglib uri="/tld/fn.tld" prefix="fn"%>
<%@ include file="/page/inc_header_script.jsp"%>

<style>
.login-userpic img {
	width: 100%;
	height: 100%;
	-webkit-border-radius: 50% !important;
	-moz-border-radius: 50% !important;
	border-radius: 50% !important;
	border: 2px solid #337ab7;
}
.student-dialog .modal-dialog {
	width: 900px;
}
.header {
	position: fixed;
	left: 0;
	right: 0;
	z-index: 1002;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.176) !important;
	background-color: #00afda;
	background: -webkit-linear-gradient(left, #00afda, #1b5dab);
	background: -o-linear-gradient(right, #00afda, #1b5dab);
	background: -moz-linear-gradient(right, #00afda, #1b5dab);
	background: linear-gradient(to right, #00afda, #1b5dab);
}
</style>

<script type="text/javascript">
	function submitFormEdit(id, mode) {
		document.loginForm.mode.value = mode;
		document.loginForm.id.value = id;
		document.loginForm.submit();
	}
</script>


<style type="text/css">
<script src="https://example.com/fontawesome/v6.1.1/js/all.js" data-auto-replace-svg="nest"></script>

</style>
<nav class="navbar navbar-expand-lg navbar-light bg-light ">
  <!-- Container wrapper -->
  <div class="container">
    <!-- Navbar brand -->
    <!-- Search form -->
    <!-- Toggle button -->
    <button class="navbar-toggler" type="button" data-mdb-toggle="collapse"
      data-mdb-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
      aria-label="Toggle navigation">
      <i class="fas fa-bars"></i>
    </button>

    <!-- Collapsible wrapper -->
    <div class="collapse navbar-collapse" id="navbarSupportedContent" style="margin-right:30px;">
      <!-- Left links -->
      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
        
        
        <li class="nav-item dropdown">
          <a
            class="nav-link dropdown-toggle d-flex align-items-center"
            href="#"
            id="navbarDropdownMenuLink"
            role="button"
            data-mdb-toggle="dropdown"
            aria-expanded="false"
          >
            <span class="">${SSUser.username}</span>
            <img
              src="https://mdbootstrap.com/img/Photos/Avatars/img%20(9).jpg"
              class="rounded-circle"
              height="40"
              alt=""
              loading="lazy"
            />
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <li><a class="dropdown-item" href="login.htm?mode=initProfile" onclick="submitFormEdit('${SSUser.id}', 'initProfile')">My profile</a></li>
            <li><a class="dropdown-item" href="login.htm?mode=initChange">Change Password</a></li>
            <li><a class="dropdown-item" href="login.htm?mode=index">Logout</a></li>
          </ul>
        </li>
      </ul>
      <!-- Left links -->
    </div>
    <!-- Collapsible wrapper -->
  </div>
  <!-- Container wrapper -->
</nav>
	
<!--header end-->

