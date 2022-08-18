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
n	
	.backplane {
	/* Rectangle 4283 */
	position: absolute;
	width: 80%;
	height: 100%;
	left: 0px;
	top: 0px;
	background: linear-gradient(136.16deg, #042153 5.45%, #1DA1B0 60.18%);
}
	
<script>
$( '#topheader .navbar-nav a' ).on( 'click', function () {
	$( '#topheader .navbar-nav' ).find( 'li.active' ).removeClass( 'active' );
	$( this ).parent( 'li' ).addClass( 'active' );
});
</script>

</style>
<div class="backplane">
<!--sidebar start-->
	<div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-faded" style="height:100%;">
    <a href="#" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
      <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"></use></svg>
      <img src="https://www.gtt2004.com/img/GTT_WHITE.png" width=16%;  ></img	>
    </a>
    
    <c:if test="${SSUser.id_user_type.id eq 1}">
			<hr>
			<ul class="nav nav-pills flex-column mb-auto">

				<li class="nav-item"><a href="login.htm?mode=login"
					class="nav-link text-white " aria-current="page"> <svg
							xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-people" viewBox="0 0 16 16">
 							<path
								d="M15 14s1 0 1-1-1-4-5-4-5 3-5 4 1 1 1 1h8zm-7.978-1A.261.261 0 0 1 7 12.996c.001-.264.167-1.03.76-1.72C8.312 10.629 9.282 10 11 10c1.717 0 2.687.63 3.24 1.276.593.69.758 1.457.76 1.72l-.008.002a.274.274 0 0 1-.014.002H7.022zM11 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4zm3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0zM6.936 9.28a5.88 5.88 0 0 0-1.23-.247A7.35 7.35 0 0 0 5 9c-4 0-5 3-5 4 0 .667.333 1 1 1h4.216A2.238 2.238 0 0 1 5 13c0-1.01.377-2.042 1.09-2.904.243-.294.526-.569.846-.816zM4.92 10A5.493 5.493 0 0 0 4 13H1c0-.26.164-1.03.76-1.724.545-.636 1.492-1.256 3.16-1.275zM1.5 5.5a3 3 0 1 1 6 0 3 3 0 0 1-6 0zm3-2a2 2 0 1 0 0 4 2 2 0 0 0 0-4z" />
							</svg> USER
				</a></li>
				<li><a href="login.htm?mode=showRequest"
					class="nav-link text-white"> <svg class="bi me-2" width="16"
							height="16">
							<use xlink:href="#speedometer2"></use></svg> REQUEST
				</a></li>
				<li><a href="login.htm?mode=showProject"
					class="nav-link text-white"> <svg class="bi me-2" width="16"
							height="16">
							<use xlink:href="#table"></use></svg> PROJECT
				</a></li>

			</ul>
			<hr>	
    
    	</c:if>
    	<c:if test="${SSUser.id_user_type.id eq 2}">
    		<hr>
    		
    		<ul class="nav nav-pills flex-column mb-auto">
    		<li><a href="index.htm?mode=getRequest"
					class="nav-link text-white"> <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-calendar" viewBox="0 0 16 16">
  					<path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z"/>
					</svg>
							<use xlink:href="#speedometer2"></use></svg> REQUEST TABLE
			</a></li>
    		<li><a href="index.htm?mode=getProject"
					class="nav-link text-white"> <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-calendar-plus" viewBox="0 0 16 16">
  					<path d="M8 7a.5.5 0 0 1 .5.5V9H10a.5.5 0 0 1 0 1H8.5v1.5a.5.5 0 0 1-1 0V10H6a.5.5 0 0 1 0-1h1.5V7.5A.5.5 0 0 1 8 7z"/>
  					<path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z"/>
					</svg>
							<use xlink:href="#speedometer2"></use></svg>ADD REQUEST
			</a></li>
    		</ul>
			<hr>	
    	</c:if>
    	
    
    <div class="dropdown" >
 		<a href="login.htm?mode=index" class="nav-link text-white">LOGOUT</a>
    </div>
  </div>
</div>