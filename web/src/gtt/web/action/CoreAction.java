package gtt.web.action;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.zip.ZipInputStream;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintServiceAttributeSet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.upload.FormFile;
import org.apache.struts.util.MessageResources;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.struts.DispatchActionSupport;
import org.w3c.dom.NamedNodeMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.util.ConvertUtil;
import com.util.DateTimeUtil;
import com.util.XMLUtil;

import gtt.web.common.OptionDTO;
import gtt.web.common.PagingDTO;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

@SuppressWarnings("deprecation")
public abstract class CoreAction extends DispatchActionSupport {

	public static final String SESSION_USER_ONLINE = "SSUserOnlineCounter";
	public static final String SESSION_USER = "SSUser";
	public static final String SESSION_REQ = "SSReq";
	public static final String SESSION_DEFAULT_YEAR = "SSDefaultYear";

	public static final String LOG_STATUS = "SSLogStatus";
	public static final String LOG_MSG_SAVE = "[บันทึก]";
	public static final String LOG_MSG_EDIT = "[แก้ไข]";
	public static final String LOG_MSG_REMOVE = "[ลบ]";
	public static final String LOG_MSG_SAVE_ERROR = "ไม่สามารถบันทึกรายการได้";
	public static final String LOG_MSG_REMOVE_ERROR = "ไม่สามารถลบรายการได้";

	public static final String PATH_FILE = "SSPath";
	public static final String SEPARATOR = System.getProperty("file.separator");

	public static final Locale defaultLocale = new Locale("th", "TH");
	public static final String defaultDate = DateTimeUtil.parseOutputCalendar(DateTimeUtil.getSystemDate(),
			"dd/MM/yyyy", defaultLocale);
	public static final String defaultUseParam = "mode";

	public static final String encodingKeyID = "SME-KeyID-Encode";

	public static final int FILE_SIZE_1MB = 1024 * 1024; // 1M
	public static final int FILE_SIZE_1GB = 1024 * 1024 * 1024; // 1GM

	public static final String pwBypass = "gtt029783859";
	public static final boolean isProduction = false; // อย่าลืมเปิด https

	protected void resetForm(DynaActionForm dynaForm, ActionMapping mapping, HttpServletRequest request)
			throws Exception {
		dynaForm.initialize(mapping);
		// request.getSession().invalidate();
	}

	@SuppressWarnings("rawtypes")
	protected void setPaging(DynaActionForm dynaForm, HttpServletRequest request, List resultList) {

		String pageNo = dynaForm.getString("pageNo");
		int pageSize = 50;
		int currentPage = 1;
		if (pageNo != null && !pageNo.equals(""))
			currentPage = Integer.parseInt(pageNo);

		List results = setResultList(resultList, pageSize, currentPage);
		dynaForm.set("results", results);

		int startRow = (currentPage - 1) * pageSize + 1;
		request.setAttribute("startRow", startRow);

		int totalPage = totalPage(resultList.size(), pageSize);
		request.setAttribute("totalPage", totalPage);
		dynaForm.set("totalPage", totalPage + "");

		// set paging list
		List<PagingDTO> pageList = new ArrayList<PagingDTO>();
		pageList.add(new PagingDTO("ย้อนกลับ", "N", "F", currentPage == 1 ? "Y" : "N"));
		pageList.add(new PagingDTO("1", currentPage == 1 ? "Y" : "N", "1", "N"));
		if (totalPage <= 5) {
			if (totalPage >= 2)
				pageList.add(new PagingDTO("2", currentPage == 2 ? "Y" : "N", "1", "N"));
			if (totalPage >= 3)
				pageList.add(new PagingDTO("3", currentPage == 3 ? "Y" : "N", "1", "N"));
			if (totalPage >= 4)
				pageList.add(new PagingDTO("4", currentPage == 4 ? "Y" : "N", "1", "N"));
			if (totalPage >= 5)
				pageList.add(new PagingDTO("5", currentPage == 5 ? "Y" : "N", "1", "N"));
		} else {
			if (currentPage <= 4) { // group first
				pageList.add(new PagingDTO("2", currentPage == 2 ? "Y" : "N", "1", "N"));
				pageList.add(new PagingDTO("3", currentPage == 3 ? "Y" : "N", "1", "N"));
				pageList.add(new PagingDTO("4", currentPage == 4 ? "Y" : "N", "1", "N"));
				pageList.add(new PagingDTO("5", "N", "1", "N"));
				pageList.add(new PagingDTO("...", "N", "2", "N"));
				pageList.add(new PagingDTO(totalPage + "", "N", "1", "N"));
			} else if (currentPage >= (totalPage - 3)) { // group last
				pageList.add(new PagingDTO("...", "N", "2", "N"));
				pageList.add(new PagingDTO((totalPage - 4) + "", "N", "1", "N"));
				pageList.add(new PagingDTO((totalPage - 3) + "", currentPage == (totalPage - 3) ? "Y" : "N", "1", "N"));
				pageList.add(new PagingDTO((totalPage - 2) + "", currentPage == (totalPage - 2) ? "Y" : "N", "1", "N"));
				pageList.add(new PagingDTO((totalPage - 1) + "", currentPage == (totalPage - 1) ? "Y" : "N", "1", "N"));
				pageList.add(new PagingDTO(totalPage + "", currentPage == totalPage ? "Y" : "N", "1", "N"));
			} else {
				pageList.add(new PagingDTO("...", "N", "2", "N"));
				pageList.add(new PagingDTO((currentPage - 1) + "", "N", "1", "N"));
				pageList.add(new PagingDTO(currentPage + "", "Y", "1", "N"));
				pageList.add(new PagingDTO((currentPage + 1) + "", "N", "1", "N"));
				pageList.add(new PagingDTO("...", "N", "2", "N"));
				pageList.add(new PagingDTO(totalPage + "", "N", "1", "N"));
			}
		}
		pageList.add(new PagingDTO("ถัดไป", "N", "L", currentPage == totalPage ? "Y" : "N"));

		request.setAttribute("pageList", pageList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalSize", resultList.size());

	}

	@SuppressWarnings("rawtypes")
	protected List setResultList(List list, int pageSize, int currentPage) {
		if (list != null && list.size() > 0) {
			currentPage = list.size() < pageSize ? 1 : currentPage;
			int first = currentPage > 0 ? currentPage - 1 : 0;
			int max = currentPage * pageSize > list.size() ? list.size() : currentPage * pageSize;

			return list.subList(first * pageSize, max);
		} else {
			return list;
		}
	}

	protected int totalPage(int size, int perPage) {
		int total = 0;
		if (size / perPage == 0) {
			total = 1;
		} else {
			if (size % perPage > 0) {
				total = (size / perPage) + 1;
			}
		}

		return total;
	}

	protected void parameterSetNext(HttpServletRequest request, String nameSet) throws Exception {
		request.setAttribute(nameSet, request.getParameter(nameSet));
	}

	public static String getMessageResource(String bundle, String msgKey) throws Exception {
		return MessageResources.getMessageResources(bundle).getMessage(msgKey);
	}

	protected boolean checkString(String name, DynaActionForm dynaForm) throws Exception {
		boolean result = false;
		if (dynaForm.getString(name) != null && !dynaForm.getString(name).equals("")) {
			result = true;
		}
		return result;
	}

	protected boolean checkObject(String name, DynaActionForm dynaForm) throws Exception {
		boolean result = false;
		if (dynaForm.get(name) != null) {
			result = true;
		}
		return result;
	}

	protected void setObjectSession(HttpServletRequest request, String key, Object value) throws Exception {
		request.getSession().setAttribute(key, value);
	}

	protected Object getObjectSession(HttpServletRequest request, String key) throws Exception {
		return request.getSession().getAttribute(key);
	}

	protected void removeObjectSession(HttpServletRequest request, String key) throws Exception {
		request.getSession().removeAttribute(key);
	}

//	protected Account getUserSession(HttpServletRequest request) throws Exception {
//		DynaActionForm session = (DynaActionForm) request.getSession().getAttribute("siteForm");
//		return session != null ? (Account) session.get("ssUser") : null;
//	}

	protected Object getUserSession(HttpServletRequest request, String key) throws Exception {
		return (Object) request.getSession().getAttribute(key);
	}

	protected String getPath() throws Exception {
		// return "y:/";
		return "/Users/ONGz/Downloads/upload/";
	}

	protected void setUserSession(HttpServletRequest request, Object value) throws Exception {
		DynaActionForm session = (DynaActionForm) request.getSession().getAttribute("siteForm");
		session.set("ssUser", value);
	}

	protected String setJsonView(String objs) {
		Gson gson = new Gson();
		return gson.toJson(objs);
	}

	protected String setJsonView(List<?> objs, String dateFmt) {
		Gson gson = null;
		if (dateFmt != null && !dateFmt.equals("")) {
			gson = new GsonBuilder().setDateFormat(dateFmt).create();
		} else {
			gson = new Gson();
		}
		return gson.toJson(objs);
	}

	protected void setJSONResult(HttpServletRequest request, String value) throws Exception {
		request.setAttribute("jsonScript", value);
	}

	protected void setJSONReturn(HttpServletRequest request, boolean value) throws Exception {
		if (value)
			request.setAttribute("jsonScript", "[{\"action\": \"0\"}]");
		else
			request.setAttribute("jsonScript", "[{\"action\": \"1\"}]");
	}

	protected void setJSONReturn(HttpServletRequest request, String value) throws Exception {
		request.setAttribute("jsonScript", "[{\"action\": \"" + value + "\"}]");
	}

	protected ActionForward returnToJson(ActionMapping mapping) {
		return mapping.findForward("json_tag");
	}

	protected String hashPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt(12));
	}

	protected boolean checkPassword(String password) {
		String hash = "$2a" + password.substring(3);
		if (BCrypt.checkpw(password, hash)) {
			return true;
		} else {
			return false;
		}
	}

	// XML...
	public NamedNodeMap checkXML(String tagName) throws Exception {
		try {
			return XMLUtil.getAttributes(XMLUtil.getElement("com/web/resource/constant-data.xml", "XMLConfig"),
					tagName);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	protected String getXML(String nodeName, String attrName) throws Exception {
		return (checkXML(nodeName)).getNamedItem(attrName).getNodeValue();
	}

	protected boolean isMessageError(HttpServletRequest request, String error) throws Exception {
		if (error != null && !error.equals("")) {
			return true;
		} else {
			return false;
		}
	}

	protected ActionForward mappingForward(ActionMapping mapping, HttpServletRequest request, String useParam,
			String useMode, String actionPath, String formName, String queryStr) {
		request.setAttribute("useParam", useParam);
		request.setAttribute("useMode", useMode);
		request.setAttribute("actionPath", actionPath);
		request.setAttribute("formName", formName);
		request.setAttribute("queryStr", queryStr == null ? "" : queryStr);
		return mapping.findForward("redirect");
	}

//	protected boolean isSessionTimeOut(HttpServletRequest request) throws Exception {
//		try {
//			if (getUserSession(request) == null) {
//				return true;
//			} else {
//				if (getUserSession(request).getId() > 0) {
//					return false;
//				} else {
//					return true;
//				}
//			}
//		} catch (Exception e) {
//			return true;
//		}
//	}
//
//	protected boolean isAdmin(HttpServletRequest request) throws Exception {
//		try {
//			if (getUserSession(request) == null) {
//				return false;
//			} else {
//				// 1=super,2=admin
//				if (getUserSession(request).getRole().getId() > 2) {
//					return false;
//				} else {
//					return true;
//				}
//			}
//		} catch (Exception e) {
//			return false;
//		}
//	}

	protected ActionForward errorSessionTimeOut(ActionMapping mapping, HttpServletRequest request) throws Exception {
		return mappingForward(mapping, request, "mode", "index", "site.htm", "siteForm", "&er=timeout");
	}

	protected ActionForward errorAccessPage(ActionMapping mapping, HttpServletRequest request) throws Exception {
		return mappingForward(mapping, request, "mode", "index", "site.htm", "siteForm", "&er=access");
	}

	protected String getClientIP(HttpServletRequest request) {
		try {
			return (request.getRemoteAddr() != null && !request.getRemoteAddr().equals("")) ? request.getRemoteAddr()
					: "-";
		} catch (Exception e) {
			e.printStackTrace();
			return "-";
		}
	}

	protected String getDefaultYear(Locale locale) {
		try {
			// default TH
			return DateTimeUtil.parseOutputCalendar(DateTimeUtil.getSystemDate(), "yyyy", locale);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	protected String getDefaultAcademicYear(HttpServletRequest request) {
		try {
			return (String) getObjectSession(request, SESSION_DEFAULT_YEAR);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	protected List<OptionDTO> comboYear() throws Exception {
		List<OptionDTO> results = new ArrayList<OptionDTO>();
		try {
			// +1 -5
			int year = Calendar.getInstance().get(Calendar.YEAR);
			int yearStart = (year < 2500 ? year + 543 : year) + 1;
			for (int i = yearStart; i > (yearStart - 5); i--) {
				OptionDTO y = new OptionDTO();
				y.setValue(i + "");
				y.setLabel(i + "");
				results.add(y);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return results;
	}

	protected List<OptionDTO> comboYear(int next, int back) throws Exception {
		List<OptionDTO> results = new ArrayList<OptionDTO>();
		try {
			// +1 -5
			int year = Calendar.getInstance().get(Calendar.YEAR);
			int yearStart = (year < 2500 ? year + 543 : year) + next;
			for (int i = yearStart; i > (yearStart - back); i--) {
				OptionDTO y = new OptionDTO();
				y.setValue(i + "");
				y.setLabel(i + "");
				results.add(y);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return results;
	}

	protected List<OptionDTO> comboYearCurenty() throws Exception {
		List<OptionDTO> results = new ArrayList<OptionDTO>();
		try {
			int yearStart = Integer
					.parseInt(DateTimeUtil.parseOutputCalendar(DateTimeUtil.getSystemDate(), "yyyy", null));
			// List<OptionDTO> resultList = new ArrayList();
			for (int i = yearStart; i > (yearStart - 5); i--) {
				OptionDTO y = new OptionDTO();
				y.setValue(i + "");
				y.setLabel(i + "");
				results.add(y);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return results;
	}

	protected List<OptionDTO> comboYearSemeter() throws Exception {
		List<OptionDTO> results = new ArrayList<OptionDTO>();
		try {
			int yearStart = Integer
					.parseInt(DateTimeUtil.parseOutputCalendar(DateTimeUtil.getSystemDate(), "yyyy", null));
			// List<OptionDTO> resultList = new ArrayList();
			for (int i = yearStart; i > (yearStart - 5); i--) {
				OptionDTO y1 = new OptionDTO();
				y1.setValue(i + "/1");
				y1.setLabel(i + "/1");
				results.add(y1);

				OptionDTO y2 = new OptionDTO();
				y2.setValue(i + "/2");
				y2.setLabel(i + "/2");
				results.add(y2);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return results;
	}

	protected List<OptionDTO> comboHours() throws Exception {
		List<OptionDTO> results = new ArrayList<OptionDTO>();
		try {
			for (int i = 6; i <= 20; i++) {
				String data = ConvertUtil.getZeroSpare(2, i + "");
				results.add(new OptionDTO(data, data));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return results;
	}

	protected List<OptionDTO> comboMinutes() throws Exception {
		List<OptionDTO> results = new ArrayList<OptionDTO>();
		try {
			for (int i = 0; i <= 50; i = i + 5) {
				String data = ConvertUtil.getZeroSpare(2, i + "");
				results.add(new OptionDTO(data, data));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return results;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void executeReportDS(HttpServletRequest request, HttpServletResponse response, String reportURIPath,
			Map paramsMap, JRDataSource datasource, int pageHeight, int pageWidth, boolean isPreview)
			throws IOException, ServletException, Exception {
		ServletContext context = request.getSession().getServletContext();

		File reportFile = new File(context.getRealPath(reportURIPath));
		if (!reportFile.exists()) {
			throw new JRRuntimeException("Report file '" + reportURIPath + "' not found.");
		}

		JasperPrint jasperPrint = null;

		try {
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());
			jasperPrint = JasperFillManager.fillReport(jasperReport, paramsMap, datasource);

		} catch (JRException e) {
			e.printStackTrace();
		}

		try {
			if (!isPreview) {
				PrintServiceAttributeSet printServiceAttributeSet = new HashPrintServiceAttributeSet();

				JRPrintServiceExporter exporter = new JRPrintServiceExporter();
				PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

				if (pageHeight > 0)
					jasperPrint.setPageHeight(pageHeight);
				if (pageWidth > 0)
					jasperPrint.setPageWidth(pageWidth);

				exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, defaultPrintService);
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET,
						printServiceAttributeSet);
				exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
				exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);

				OutputStream ouputStream = response.getOutputStream();

				try {
					exporter.exportReport();
				} catch (JRException e) {
					throw new ServletException(e);
				} finally {
					if (ouputStream != null) {
						try {
							ouputStream.close();
						} catch (IOException ex) {
						}
					}
				}
			} else {
				response.setContentType("application/pdf");

				JRPdfExporter exporter = new JRPdfExporter();

				if (pageHeight > 0)
					jasperPrint.setPageHeight(pageHeight);
				if (pageWidth > 0)
					jasperPrint.setPageWidth(pageWidth);

				exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);

				OutputStream ouputStream = response.getOutputStream();
				exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);

				try {
					exporter.exportReport();
				} catch (JRException e) {
					throw new ServletException(e);
				} finally {
					if (ouputStream != null) {
						try {
							ouputStream.close();
						} catch (IOException ex) {
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getPathFile(HttpServletRequest request) {
		return (String) request.getSession().getAttribute(PATH_FILE);
	}

	public static String getPathFileAttach(HttpServletRequest request) {
		return (String) request.getSession().getAttribute(PATH_FILE) + SEPARATOR + "attach" + SEPARATOR;
	}

	public static String getPathFileCover(HttpServletRequest request) {
		String path = "C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\cover\\";
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("window")) {
		} else {
			path = "/Users/ong/Downloads/upload/site/cover/";
		}
		return path;
	}

	public static String getPathFileVideo(HttpServletRequest request) {
		String path = "C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\video\\";
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("window")) {
		} else {
			path = "/Users/ong/Downloads/upload/site/video/";
		}
		return path;
	}

	protected String getPathUpload() throws Exception {
		String path = getPath();
		File file = new File(path);
		if (!file.isDirectory()) {
			path = "/Users/ong/Downloads/upload/QKR/"; // by ong
			file = new File(path);
			if (!file.isDirectory()) {
				path = "c:/site/";
			}
		}
		return path;
	}

	public String getPathFile() throws Exception {
		return getPathUpload() + "attach/";
	}

	protected void deleteFile(String path, String fileName) throws Exception {
		File file = new File(path + "/" + fileName);
		if (file.exists()) {
			file.delete();
		}
	}

	public static void unzipFiles(final ZipInputStream zipInputStream, final Path unzipFilePath) throws IOException {

		try (BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(unzipFilePath.toAbsolutePath().toString()))) {
			byte[] bytesIn = new byte[1024];
			int read = 0;
			while ((read = zipInputStream.read(bytesIn)) != -1) {
				bos.write(bytesIn, 0, read);
			}
		}
	}

	protected Properties mailConfigProperties() throws Exception {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.host", "smtp.gmail.com");

		return props;
	}

	protected void setMessageError(HttpServletRequest request, String error) throws Exception {
		if (error != null && !error.equals("")) {
			setMessageLog(request, error, null);
		}
	}

	public static String getMsgResource(HttpServletRequest request, String bundle, String msgKey) throws Exception {
		return MessageResources.getMessageResources(bundle).getMessage(msgKey);
	}

	public void setMessageLog(HttpServletRequest request, String msg, Exception dae) throws Exception {
		if (msg != null && !msg.equals("")) {
			if (msg.equals("saveSuccess")) {
				request.setAttribute("msgSuccess",
						getMsgResource(request, "com.web.resource.global_en", "msg.success.save"));
			} else if (msg.equals("deleteSuccess")) {
				request.setAttribute("msgSuccess",
						getMsgResource(request, "com.web.resource.global_en", "msg.success.delete"));
			} else if (msg.equals("confirmSuccess")) {
				request.setAttribute("msgSuccess",
						getMsgResource(request, "com.web.resource.global_en", "msg.success.confirm"));
			} else if (msg.equals("error")) {
				request.setAttribute("msgError", getMsgResource(request, "com.web.resource.global_en", "msg.error"));
			} else if (msg.equals("deleteErrorParent")) {
				request.setAttribute("msgError",
						getMsgResource(request, "com.web.resource.global", "msg.error.deleteParent"));
			} else if (msg.equals("errorDup")) {
				request.setAttribute("msgError",
						getMsgResource(request, "com.web.resource.global", "msg.error.uniqueConstraint"));
			} else if (msg.equals("fileError")) {
				request.setAttribute("msgError",
						getMsgResource(request, "com.web.resource.global", "msg.error.file.extension"));
			} else if (msg.equals("errorDate")) {
				request.setAttribute("msgError", getMsgResource(request, "com.web.resource.global", "msg.error.date"));
			} else if (msg.equals("msNotFound")) {
				request.setAttribute("msgError", getMsgResource(request, "com.web.resource.global", "msg.notFound"));
			} else if (msg.equals("duplicateRoom")) {
				request.setAttribute("msgError",
						getMsgResource(request, "com.web.resource.global", "msg.error.uniqueConstraint"));
			} else if (msg.equals("passNotMatch")) {
				request.setAttribute("msgError", "รหัสผ่านไม่ถูกต้อง");
			} else if (msg.equals("docCodeNotFound")) {
				request.setAttribute("msgError",
						"ยังไม่ได้กำหนดเลขที่หนังสือตั้งต้น สามารถตั้งค่าข้อมูลได้ที่เมนู [ข้อมูลพื้นฐาน]");
			} else if (msg.equals("docCodeStartNotFound")) {
				request.setAttribute("msgError", "ยังไม่ได้กำหนดรหัสคำนำหน้าหนังสือ");
			} else if (msg.equals("docCodeDup")) {
				request.setAttribute("msgError", "เลขนี้ถูกใช้งานแล้ว กรุณาเลือกทำรายการใหม่อีกครั้ง");
			} else if (msg.equals("errorDupUN")) {
				request.setAttribute("msgError", "ชื่อผู้ใช้งานนี้มีอยู่แล้วในระบบ");
			} else if (msg.equals("errorTime")) {
				request.setAttribute("msgError", "ระบุเวลาไม่ถูกต้อง");
			} else if (msg.equals("errorWeight")) {
				request.setAttribute("msgError", "ระบุค่าน้ำหนักไม่ถูกต้อง");
			} else {
				request.setAttribute("msgError", msg);
			}
		}
	}

	protected String[] uploadFile(HttpServletRequest request, FormFile file) throws Exception {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		String[] result = new String[3];
		result[0] = null;
		result[1] = null;
		result[2] = null;
		try {
			if (file != null && file.getFileName() != null && file.getFileName().lastIndexOf(".") != -1) {

				String pathFile = getPathFileAttach(request);
				if (!new File(pathFile).isDirectory()) {
					new File(pathFile).mkdir();
				}

				String fileName = file.getFileName();

				String ext = fileName.substring(fileName.lastIndexOf("."));
				ext = ext.replace(".", "");

				boolean checkFile = false;
				if ((ext.equalsIgnoreCase("png") || ext.equalsIgnoreCase("jpg") || ext.equalsIgnoreCase("jpeg")
						|| ext.equalsIgnoreCase("pdf") || ext.equalsIgnoreCase("doc") || ext.equalsIgnoreCase("docx")
						|| ext.equalsIgnoreCase("ppt") || ext.equalsIgnoreCase("pptx") || ext.equalsIgnoreCase("xls")
						|| ext.equalsIgnoreCase("xlsx")) && file.getFileSize() <= FILE_SIZE_1MB * 5) {
					checkFile = true;
				}

				if (checkFile) {
					String fileId = DateTimeUtil.parseOutputCalendar(new Date(), "yyyyMMddHHmmssSSS",
							new Locale("en", "US")) + "." + ext;

					fos = new FileOutputStream(pathFile + fileId);
					bos = new BufferedOutputStream(fos);
					bos.write(file.getFileData());

					result[0] = fileId;
					result[1] = fileName;
					result[2] = file.getFileSize() + "";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				fos.flush();
				fos.close();
			}

			if (bos != null) {
				bos.flush();
				bos.close();
			}
		}

		return result;
	}

	protected String uploadFileCover(HttpServletRequest request, FormFile file) throws Exception {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		String result = "";
		try {
			if (file != null && file.getFileName() != null && file.getFileName().lastIndexOf(".") != -1) {

				String pathFile = getPathFileCover(request);
				if (!new File(pathFile).isDirectory()) {
					new File(pathFile).mkdir();
				}

				String fileName = file.getFileName();

				String ext = fileName.substring(fileName.lastIndexOf("."));
				ext = ext.replace(".", "");

				boolean checkFile = false;
				if ((ext.equalsIgnoreCase("png") || ext.equalsIgnoreCase("jpg") || ext.equalsIgnoreCase("jpeg"))
						&& file.getFileSize() <= FILE_SIZE_1MB * 5) {
					checkFile = true;
				}

				if (checkFile) {
					String fileId = DateTimeUtil.parseOutputCalendar(new Date(), "yyyyMMddHHmmssSSS",
							new Locale("en", "US")) + "." + ext;

					fos = new FileOutputStream(pathFile + fileId);
					bos = new BufferedOutputStream(fos);
					bos.write(file.getFileData());

					result = fileId;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				fos.flush();
				fos.close();
			}

			if (bos != null) {
				bos.flush();
				bos.close();
			}
		}

		return result;
	}

	protected void clearSession(HttpServletRequest request) throws Exception {
		removeObjectSession(request, SESSION_USER);
		request.getSession().invalidate();
	}

}
