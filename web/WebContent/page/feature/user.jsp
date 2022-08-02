<!DOCTYPE html>
<%@page contentType="text/html; charset=utf-8"%>
<%@taglib uri="/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/tld/c.tld" prefix="c"%>
<%@taglib uri="/tld/fn.tld" prefix="fn"%>

<%@ include file="/page/inc_header_script.jsp"%>

<body>
	<%@ include file="/page/inc_header.jsp"%>
		<div class="container">
		<div class="wrapper">
			<h2>ข้อมูลบัญชี</h2>
			<p>ชื่อบัญชี : ${SSUser.username }</p>
			<p>ตำแหน่ง : ${SSUser.userPosition.name }</p>
			<p>ชื่อ : ${SSUser.firstname }</p>
			<p>นามสกุล : ${SSUser.lastname }</p>
			<p>ชื่อเล่น : ${SSUser.nickname }</p>
			<p>โทรศัพท์ : ${SSUser.phone }</p>
			<p>อีเมลล์ : ${SSUser.email }</p>
		</div>
		</div>
</body>
</html>