package com.web.servlet.file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.util.DateTimeUtil;

public class UploadSignServlet extends HttpServlet implements Servlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UploadSignServlet() {
		super();
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);

		try {
			List items = upload.parseRequest(request);

			Iterator i = items.iterator();

			String fileId = "";
			// String fileNames = "";
			while (i.hasNext()) {
				FileItem fileItem = (FileItem) i.next();

				if (!fileItem.isFormField()) {

					String ext = fileItem.getName().substring(fileItem.getName().lastIndexOf("."));
					ext = ext.replace(".", "");

					boolean checkFile = false;
					if ((ext.equalsIgnoreCase("png") || ext.equalsIgnoreCase("jpg") || ext.equalsIgnoreCase("jpeg"))
							&& fileItem.getSize() <= 1024 * 1024 * 2) {
						checkFile = true;
					}

					if (checkFile) {
						String fileName = DateTimeUtil.parseOutputCalendar(new Date(), "yyyyMMddHHmmssSSS",
								new Locale("en", "US")) + "." + ext;

						String separator = System.getProperty("file.separator");
						String rootpath = (String) request.getSession().getAttribute("SSPath");
						String pathFile = rootpath + separator + "sign" + separator;

						fileItem.write(new File(pathFile, fileName));

						fileId = fileName;
					}

				} else {
					// ...
				}
			}

			if (!fileId.equals(""))
				out.println("[{\"error\": \"0\", \"fildId\": \"" + fileId + "\"}]");
			else
				out.println("[{\"error\": \"1\", \"fildId\": \"\"}]");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}
}
