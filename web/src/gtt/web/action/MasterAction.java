package gtt.web.action;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.upload.FormFile;

import com.gtt.server.user.entity.User;
import com.gtt.server.user.service.ProjectService;

import com.gtt.server.user.service.UserPrefixService;
import com.gtt.server.user.service.UserProjectService;
import com.gtt.server.user.service.UserService;
import com.gtt.server.user.service.UserTypeService;

import com.util.DateTimeUtil;

public class MasterAction extends CoreAction {

	private static String masterForm = "masterForm";
	private static String actionName = "master.htm";
	private UserService userService;
	

//	public ActionForward init(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		try {
//			DynaActionForm dynaForm = (DynaActionForm) form;
//			
//			dynaForm.set("resultList", null);
//
////			Constant constant = constantService.getItem(1);
////			setObjectSession(request, SESSION_PATH, constant.getUploadPath());
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return mapping.findForward("MA01");
//	}
//	public ActionForward showtable(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("asdasdas");
//		try {
//			DynaActionForm dynaForm = (DynaActionForm) form;
//			List<User> userList = userService.getAll();
//			request.setAttribute("SUserList", userList);
//			User user = userList.iterator().next();
//				
//			dynaForm.set("username", user.getUsername());
//			dynaForm.set("password", user.getPassword());
//			dynaForm.set("resultList", userList);
//			
//	
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return mapping.findForward("MA01");
//	}
//	

	

	



}
