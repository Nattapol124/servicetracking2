package com.web.servlet.file;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ZipFileServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	public ZipFileServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ByteArrayOutputStream baos = null;
		ZipOutputStream zos = null;

		try {
			String path = request.getParameter("ppath");
			String fileid = request.getParameter("pname");
			String fileName = request.getParameter("pfname");

			if (fileName != null && !fileName.equals("")) {
			} else {
				fileName = fileid;
			}

			String fullPath = path + System.getProperty("file.separator") + fileid;

			request.getSession().setAttribute("SSByteArrayOutputStream", null);

			boolean isError = false;
			String msgError = "";

			File txtFile = new File(fullPath);
			if (txtFile.exists()) {
				baos = new ByteArrayOutputStream();
				zos = new ZipOutputStream(baos);

				byte bytes[] = new byte[4096];

				FileInputStream fis = new FileInputStream(fullPath);
				BufferedInputStream bis = new BufferedInputStream(fis);

				zos.putNextEntry(new ZipEntry(fileName));

				int bytesRead;
				while ((bytesRead = bis.read(bytes)) != -1) {
					zos.write(bytes, 0, bytesRead);
				}

				zos.closeEntry();
				bis.close();
				fis.close();
			} else {
				isError = true;
				msgError = "Invalid File !! (" + fullPath + ")";

				System.out.println(msgError);
			}

			if (isError) {
				out.println("[{\"error\": \"1\", \"message\": \"" + msgError + "\"}]");
			} else {
				request.getSession().setAttribute("SSByteArrayOutputStream", baos);

				out.println("[{\"error\": \"0\", \"message\": \"" + msgError + "\"}]");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (zos != null) {
				zos.flush();
				zos.close();
			}

			if (baos != null) {
				baos.flush();
				baos.close();
			}

			out.flush();
			out.close();
		}
	}
}