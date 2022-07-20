package com.web.servlet.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
			throws ServletException, IOException {
		doPost(httpservletrequest, httpservletresponse);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String rootpath = (String) request.getSession().getAttribute("SSPath");
			String filepath = request.getParameter("filepath");
			String filename = request.getParameter("filename");

			String fullpath = rootpath + System.getProperty("file.separator");
			if (filepath != null && !filepath.equals("")) {
				fullpath += filepath + System.getProperty("file.separator");
			}

			File downloadFile = new File(fullpath + filename);
			FileInputStream in = new FileInputStream(downloadFile);

			// modifies response
			response.setContentType("application/octet-stream");
			response.setContentLength((int) downloadFile.length());

			// forces download
			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
			response.setHeader(headerKey, headerValue);
			response.setCharacterEncoding("UTF-8");

			OutputStream os = response.getOutputStream();

			byte[] buffer = new byte[4096];
			int bytesRead = -1;

			while ((bytesRead = in.read(buffer)) != -1) {
				os.write(buffer, 0, bytesRead);
			}

			in.close();
			os.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
