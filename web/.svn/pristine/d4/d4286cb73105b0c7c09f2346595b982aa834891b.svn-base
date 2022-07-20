package com.web.servlet.file;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DateTimeUtil;

public class DownloadZipServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse) throws ServletException, IOException {
		doPost(httpservletrequest, httpservletresponse);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ByteArrayOutputStream baos = null;

		try {
			String fileName = request.getParameter("filename");

			baos = (ByteArrayOutputStream) request.getSession().getAttribute("SSByteArrayOutputStream");

			if (fileName != null && !fileName.equals("")) {
			} else {
				fileName = DateTimeUtil.parseOutputCalendar(new Date(), "yyyy-MM-dd-HH-mm", new Locale("en", "US"));
			}

			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + ".zip\"");
			response.setCharacterEncoding("UTF-8");

			if (baos != null) {
				ServletOutputStream os = response.getOutputStream();
				os.write(baos.toByteArray());

				// Clear session..
				request.getSession().removeAttribute("SSByteArrayOutputStream");

				os.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (baos != null) {
				baos.flush();
				baos.close();
			}
		}
	}
}
