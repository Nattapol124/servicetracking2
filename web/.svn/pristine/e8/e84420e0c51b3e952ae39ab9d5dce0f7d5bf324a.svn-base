package com.web.servlet.file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.util.RandomUtil;

public class UploadVideoServlet extends HttpServlet implements Servlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UploadVideoServlet() {
		super();
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);

		try {

			String path = "C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\video\\";
			String os = System.getProperty("os.name").toLowerCase();
			if (os.contains("window")) {
			} else {
				path = "/Users/ong/Downloads/upload/sphere/video/";
			}
			
			String path2 = "C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\cover\\";
			if (os.contains("window")) {
			} else {
				path2 = "/Users/ong/Downloads/upload/sphere/cover/";
			}

			List items = upload.parseRequest(request);

			Iterator i = items.iterator();

			String files = "";
			String sizes = "";
			while (i.hasNext()) {
				FileItem fileItem = (FileItem) i.next();

				if (!fileItem.isFormField()) {
					long maxFileSize = 1024 * 1024 * 1024; // 1GB
					if (fileItem.getSize() > 0 && fileItem.getSize() <= maxFileSize) {

						String fullName = fileItem.getName(), myFileName = "",
								slashType = (fullName.lastIndexOf("\\") > 0) ? "\\" : "/";

						int startIndex = fullName.lastIndexOf(slashType);
						myFileName = fullName.substring(startIndex + 1, fullName.length());

						String fileExt = myFileName.substring(myFileName.lastIndexOf("."));

						String fileName = RandomUtil.passwordGenerator(10, true, false) + fileExt;

						if (fileExt.equalsIgnoreCase(".mp4")) {
							fileItem.write(new File(path, fileName));

							files += fileName + ",";
							sizes += fileItem.getSize() + ",";
						} else if (fileExt.equalsIgnoreCase(".png") || fileExt.equalsIgnoreCase(".jpg") || fileExt.equalsIgnoreCase(".jpeg")) {
							fileItem.write(new File(path2, fileName));

							files += fileName + ",";
							sizes += fileItem.getSize() + ",";
						}
					}
				} else {
					// ...
				}
			}

			files = !files.equals("") ? files.substring(0, files.length() - 1) : "";
			sizes = !sizes.equals("") ? sizes.substring(0, sizes.length() - 1) : "0";

			out.println("[{\"error\": \"0\", \"fileId\": \"" + files + "\", \"size\": \"" + sizes + "\"}]");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}
}
