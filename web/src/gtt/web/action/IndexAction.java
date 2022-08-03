package gtt.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.gtt.server.user.entity.Project;
import com.gtt.server.user.entity.Request;
import com.gtt.server.user.entity.RequestStatus;
import com.gtt.server.user.entity.User;
import com.gtt.server.user.service.ProjectService;
import com.gtt.server.user.service.RequestService;
import com.gtt.server.user.service.UserService;
import com.util.DateTimeUtil;


public class IndexAction extends CoreAction {
	private static String loginForm = "indexForm";
	private static String actionName = "index.htm";
	private UserService userService;
	private RequestService requestService;
	private ProjectService projectService;

	

	public ActionForward index(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			DynaActionForm dynaForm = (DynaActionForm) form;
			resetForm(dynaForm, mapping, request);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapping.findForward("Index");
	}
	
	
	public ActionForward request(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			DynaActionForm dynaForm = (DynaActionForm) form;
			resetForm(dynaForm, mapping, request);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapping.findForward("Request");
	}
	
	public ActionForward user(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			DynaActionForm dynaForm = (DynaActionForm) form;
			resetForm(dynaForm, mapping, request);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapping.findForward("UserDetail");
	}

	public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			DynaActionForm dynaForm = (DynaActionForm) form;
			List<User> users = userService.getLogin(dynaForm.getString("un"), dynaForm.getString("pw"));
			if (users != null && users.size() > 0) {
				User user = users.iterator().next();
				dynaForm.set("un",user.getUsername());
				dynaForm.set("pw", user.getPassword());
				setObjectSession(request, SESSION_USER, user);
			} else {
				
				return mapping.findForward("Index");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mappingForward(mapping, request, "mode", "getRequest", "index.htm", "eduForm", null);
	}
	
		
	
	public ActionForward requestBtn(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			DynaActionForm dynaForm = (DynaActionForm) form;
			resetForm(dynaForm, mapping, request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mappingForward(mapping, request, "mode", "getProject", "index.htm", "eduForm", null);
	}
	
	public ActionForward getProject(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			DynaActionForm dynaForm = (DynaActionForm) form;
			User user = (User) getObjectSession(request, SESSION_USER);
			List<Project> projectList = projectService.getProject(String.valueOf(user.getId_customer().getId()), String.valueOf(user.getId()));
			dynaForm.set("projectList", projectList);
			request.setAttribute("projectList", projectList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapping.findForward("AddRequest");
	}
	public ActionForward getRequest(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			DynaActionForm dynaForm = (DynaActionForm) form;
			User user = (User) getObjectSession(request, SESSION_USER);
			List<Request> requestList = requestService.getReqByCustomer(String.valueOf(user.getId_customer().getId()));
			dynaForm.set("resultList", requestList);;
			request.setAttribute("resultList", requestList);
			
			List<Project> projectList = projectService.getProject(String.valueOf(user.getId_customer().getId()), String.valueOf(user.getId()));
			dynaForm.set("projectList", projectList);
			request.setAttribute("projectList", projectList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapping.findForward("Request");
	}
	
	
	public ActionForward addRequest(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {
			DynaActionForm dynaForm = (DynaActionForm) form;
			Request entity = null;
			User user = (User) getObjectSession(request, SESSION_USER);
			entity.setId_user(user);
			RequestStatus status = new RequestStatus();
			status.setId(1);
			entity.setId_request_status(null);
			
			Project project = new Project();
			project.setProject_name(dynaForm.getString("project"));
			entity.setId_project(null);
			
			entity.setRequest_title(dynaForm.getString("title"));
			entity.setRequest_remark(dynaForm.getString("remark"));
			entity.setRequest_date(null);
			entity.setRequest_file(dynaForm.getString("file"));
			entity.setCreateBy(user.getUsername());
			entity.setCreateDate(DateTimeUtil.getSystemDate());
			
			requestService.saveItem(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapping.findForward("AddRequest");
	}
	public ActionForward deleteRequest(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {
			DynaActionForm dynaForm = (DynaActionForm) form;
			requestService.removeItem(Integer.parseInt(dynaForm.getString("id")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mappingForward(mapping, request, "mode", "getRequest", "index.htm", "eduForm", null);
	}
	public ActionForward editRequest(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {
			DynaActionForm dynaForm = (DynaActionForm) form;
			User user = (User) getObjectSession(request, SESSION_USER);
			Request req = requestService.getItem(Integer.parseInt(dynaForm.getString("id")));
			req.setRequest_title(dynaForm.getString("title"));
			req.setRequest_file(dynaForm.getString("file"));
			req.setRequest_remark(dynaForm.getString("remark"));
			req.setUpdateBy(user.getUsername());
			req.setUpdateDate(DateTimeUtil.getSystemDate());
			
			requestService.saveOrUpdateItem(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mappingForward(mapping, request, "mode", "getRequest", "index.htm", "eduForm", null);
	}
	
	
	
	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public RequestService getRequestService() {
		return requestService;
	}

	public void setRequestService(RequestService requestService) {
		this.requestService = requestService;
	}


	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	
	
	

}
