package gtt.web.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.gtt.server.user.entity.Project;
import com.gtt.server.user.entity.Request;
import com.gtt.server.user.entity.RequestStatus;
import com.gtt.server.user.entity.RequestType;
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
	
	public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			DynaActionForm dynaForm = (DynaActionForm) form;
			resetForm(dynaForm, mapping, request);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapping.findForward("EditRequest");
	}

	
	public ActionForward getProject(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			DynaActionForm dynaForm = (DynaActionForm) form;
			User user = (User) getObjectSession(request, SESSION_USER);
			List<Project> projectList = projectService.getProject(String.valueOf(user.getId()));
			dynaForm.set("projectList", projectList);
			request.setAttribute("projectList", projectList);
//			dynaForm.set("projectList", projectService.getAllItems());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapping.findForward("AddRequest");
	}
	public ActionForward getRequest(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			DynaActionForm dynaForm = (DynaActionForm) form;
			User user = (User) getObjectSession(request, SESSION_USER);
			List<Request> requestList = requestService.getReqByCustomer(String.valueOf(user.getId()));
			dynaForm.set("resultList", requestList);
			request.setAttribute("resultList", requestList);
			
			List<Project> projectList = projectService.getProject(String.valueOf(user.getId()));
			dynaForm.set("projectList", projectList);
			request.setAttribute("projectList", projectList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapping.findForward("Request");
	}
	
	public ActionForward getEdit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			DynaActionForm dynaForm = (DynaActionForm) form;
			User user = (User) getObjectSession(request, SESSION_USER);
			
			List<Project> projectList = projectService.getProject(String.valueOf(user.getId()));
			dynaForm.set("projectList", projectList);
			request.setAttribute("projectList", projectList);
			
			Request req = requestService.getItem(Integer.parseInt(dynaForm.getString("ids")));
			Integer id = req.getId_project().getId();
			dynaForm.set("id_project", req.getId_project().getId());
			dynaForm.set("edit_title", req.getRequest_title());
			dynaForm.set("edit_file",req.getRequest_file() );
			dynaForm.set("edit_remark", req.getRequest_remark());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapping.findForward("EditRequest");
	}
	
	
	
	
	public ActionForward addRequest(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {
			DynaActionForm dynaForm = (DynaActionForm) form;
			String requestTitle = dynaForm.getString("request_title");
			String requestRemark = dynaForm.getString("request_remark");
			Request entity = new Request();
			User user = (User) getObjectSession(request, SESSION_USER);
			entity.setId_user(user);
			
			User userP = new User();
			userP.setId(1);
			entity.setId_user_process(userP);
			
			
			RequestStatus status = new RequestStatus();
			status.setId(1);
			entity.setId_request_status(status);
			
			RequestType type = new RequestType();
			type.setId(5);
			entity.setId_request_type(type);
			
			
			Project project = new Project();
			project.setId(1);
			entity.setId_project(project);
			
			entity.setRequest_title(dynaForm.getString("request_title"));
			entity.setRequest_remark(dynaForm.getString("request_remark"));
			entity.setRequest_date(DateTimeUtil.getSystemDate());
			entity.setRequest_file(dynaForm.getString("request_file"));
			entity.setCreateBy(user.getUsername());
			entity.setCreateDate(DateTimeUtil.getSystemDate());
			
			requestService.saveItem(entity);
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
		return mappingForward(mapping, request, "mode", "getRequest", "index.htm", "indexForm", null);
	}
	public ActionForward deleteRequest(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {
			DynaActionForm dynaForm = (DynaActionForm) form;
			requestService.removeItem(Integer.parseInt(dynaForm.getString("ids")));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mappingForward(mapping, request, "mode", "getRequest", "index.htm", "indexForm", null);
	}
	
	public ActionForward editRequest(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {
			DynaActionForm dynaForm = (DynaActionForm) form;
			User user = (User) getObjectSession(request, SESSION_USER);
			String id = dynaForm.getString("ids");
			Request req = requestService.getItem(Integer.parseInt(id));
			Project project = projectService.getItem(dynaForm.getString("id_project"));
			req.setId_project(project);
			req.setRequest_title(dynaForm.getString("edit_title"));
			req.setRequest_file(dynaForm.getString("edit_file"));
			req.setRequest_remark(dynaForm.getString("edit_remark"));
			req.setUpdateBy(user.getUsername());
			req.setUpdateDate(DateTimeUtil.getSystemDate());
			requestService.updateItem(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mappingForward(mapping, request, "mode", "getRequest", "index.htm", "indexForm", null);
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
