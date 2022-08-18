package com.web.servlet.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoadImageServlet extends HttpServlet {

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
			String filetype = request.getParameter("filetype");

			String fullpath = rootpath + System.getProperty("file.separator");
			if (filepath != null && !filepath.equals("")) {
				fullpath += filepath + System.getProperty("file.separator");
			}

			if (filename != null && !filename.equals("")) {

				File downloadFile = new File(fullpath + filename);
				FileInputStream in = new FileInputStream(downloadFile);

				String[] ext = filename.split("\\.");
				if (ext[1].equalsIgnoreCase("jpg") || ext[1].equalsIgnoreCase("jpeg")) {
					response.setContentType("image/jpeg");
				} else if (ext[1].equalsIgnoreCase("png")) {
					response.setContentType("image/png");
				}

				response.setContentLength((int) downloadFile.length());

				OutputStream os = response.getOutputStream();

				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = in.read(buffer)) != -1) {
					os.write(buffer, 0, bytesRead);
				}

				in.close();
				os.close();

			} else {
				String none = "none.jpg";
				if (filetype != null && filetype.equals("profile"))
					none = "none-profile.jpg";
				if (filetype != null && filetype.equals("banner"))
					none = "none-banner.jpg";
				
				File file = new File(fullpath + none);
				FileInputStream in = new FileInputStream(file);

				response.setContentType("image/jpeg");
				response.setContentLength((int) file.length());

				OutputStream os = response.getOutputStream();

				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = in.read(buffer)) != -1) {
					os.write(buffer, 0, bytesRead);
				}

				in.close();
				os.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
