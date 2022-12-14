package gtt.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.gtt.server.user.entity.Company;
import com.gtt.server.user.entity.Project;
import com.gtt.server.user.entity.Request;
import com.gtt.server.user.entity.User;
import com.gtt.server.user.entity.UserPosition;
import com.gtt.server.user.entity.UserPrefix;
import com.gtt.server.user.entity.UserProject;
import com.gtt.server.user.entity.UserType;
import com.gtt.server.user.service.CompanyService;
import com.gtt.server.user.service.ProjectService;
import com.gtt.server.user.service.RequestService;
import com.gtt.server.user.service.UserPrefixService;
import com.gtt.server.user.service.UserProjectService;
import com.gtt.server.user.service.UserService;
import com.util.DateTimeUtil;

public class LoginAction extends CoreAction {

	private static String loginForm = "loginForm";
	private static String actionName = "login.htm";
	private UserService userService;
	private RequestService requestService;
	private UserPrefixService userPrefixService; 
	private ProjectService projectService;
	private UserProjectService userProjectService;
	private CompanyService companyService;
	public ActionForward init(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			DynaActionForm dynaForm = (DynaActionForm) form;

			User obj = (User) getObjectSession(request, SESSION_USER);
			String company = String.valueOf(obj.getId_company().getId());
			dynaForm.set("resultList", null);
			dynaForm.set("resultProjectList",null);
			dynaForm.set("resultRequestList",null);
			dynaForm.set("resultUserProjectList", null);
//			dynaForm.set("comboIndicator", projectService.getindicator(company));

//			Constant constant = constantService.getItem(1);
//			setObjectSession(request, SESSION_PATH, constant.getUploadPath());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapping.findForward("MA01");
	}
	
	public ActionForward index(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapping.findForward("FA01");
	}
	public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			DynaActionForm dynaForm = (DynaActionForm) form;
			List<User> users = userService.getLogin(dynaForm.getString("un"), dynaForm.getString("pw"));
			if (users != null && users.size() > 0)  {
				User user = users.iterator().next();
//				dynaForm.set("un",user.getUsername());
//				dynaForm.set("pw", user.getPassword());
//				dynaForm.set("firstname", user.getUser_firstname());
//				dynaForm.set("lastname", user.getUser_lastname());
//				dynaForm.set("email", user.getUser_email());
//				dynaForm.set("phone", user.getUser_phone());
//				String id_comp = String.valueOf(user.getId_company().getId());
//				String id_comp2 = Integer.toString(user.getId_company().getId());
//				String id_comp3 = String.format("%d",user.getId_company().getId());
//				System.out.println("id_comp : "+ id_comp + " , id_comp2 : " + id_comp2 + " id_comp3 : " + id_comp3);
//				dynaForm.set("company", "gggggg");

				setObjectSession(request, SESSION_USER, user);
			} else {
				return mapping.findForward("FA01");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		User obj = (User) getObjectSession(request, SESSION_USER);
		String func=null;
		String htm=null;
		String formString=null;
		if(obj.getId_user_type().getId()==1) {
			func = "showtable";
			htm = "login.htm";
			formString = "loginForm";
		}
		if(obj.getId_user_type().getId()==2) {
			func = "getRequest";
			htm = "index.htm";
			formString = "eduForm";
		}
		return mappingForward(mapping, request, "mode", func, htm, formString, null);
	}
	
	public ActionForward showtable(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		 User obj = (User) getObjectSession(request, SESSION_USER);
		 System.out.println(obj.getId_company().getId()+":sesssion");
		 System.out.println("getobject: "+getObjectSession(request, SESSION_USER));
		 String company = String.valueOf(obj.getId_company().getId());
		 try {
			DynaActionForm dynaForm = (DynaActionForm) form;
			List<User> userList = userService.getUserList(company);
			User user = userList.iterator().next();
//				
//			dynaForm.set("username", user.getUsername());
//			dynaForm.set("user_firstName", user.getUser_firstname());
//			dynaForm.set("user_lastName", user.getUser_lastname());
//			dynaForm.set("user_email", user.getUser_email());
//			dynaForm.set("user_phone", user.getUser_phone());

			dynaForm.set("resultList", userList);
			request.setAttribute("resultList", userList);

			System.out.println(String.valueOf(userList));
	

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapping.findForward("MA01");
	}
	public ActionForward initChange(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			DynaActionForm dynaForm = (DynaActionForm) form;
			

			// HttpSession session = request.getSession();
			// session.setAttribute(SESSION_PATH, constant.getUploadPath());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapping.findForward("MA04");
	}

	public ActionForward savePassword(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			DynaActionForm dynaForm = (DynaActionForm) form;
		
			 User obj = (User) getObjectSession(request, SESSION_USER);
			 String id = String.valueOf(obj.getId());
			 String username = String.valueOf(obj.getUsername());

			 System.out.println(id);
			User entity = null;
			if (id != null && !id.equals("")) {
				entity = userService.getItem(Integer.parseInt(id));
				entity.setUpdateBy(username);
				entity.setUpdateDate(DateTimeUtil.getSystemDate());
				entity.setPassword(dynaForm.getString("repass"));

			} else 
			{
//				entity = new ExamSuite();
//				entity.setCreateBy(getUserSession(request).getUsername());
//				entity.setCreateDate(DateTimeUtil.getSystemDate());
//				entity.setTotalQuestion(0);
			}

//			
			userService.saveOrUpdateItem(entity);

		}
			catch (Exception e) {
			e.printStackTrace();
		}

		return mappingForward(mapping, request, "mode", "showtable", "login.htm", "loginForm", null);
	}
	
	public ActionForward initAddUser(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			DynaActionForm dynaForm = (DynaActionForm) form;
			 User obj = (User) getObjectSession(request, SESSION_USER);

			//resetQuestionForm(dynaForm);

//			dynaForm.set("comboIndicator", indicatorService.getAll());

			// HttpSession session = request.getSession();
			// session.setAttribute(SESSION_PATH, constant.getUploadPath());

//			


		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapping.findForward("MA02");
	}
	
	
	public ActionForward saveUser(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			
			DynaActionForm dynaForm = (DynaActionForm) form;
//			System.out.println(dynaForm.getString("newuser"));
//			System.out.println(dynaForm.getString("newpassword"));
//			System.out.println(dynaForm.getString("newcon"));
//			System.out.println(dynaForm.getString("newfirstname"));
//			System.out.println(dynaForm.getString("newlastname"));
//			System.out.println(dynaForm.getString("newnickname"));
//			System.out.println(dynaForm.getString("newemail"));

			User obj = (User) getObjectSession(request, SESSION_USER);
			System.out.println(obj.getUsername());
			
//			UserPrefix entity = null;
//			entity = new UserPrefix();
//			entity.setPrefix_name(dynaForm.getString("newuser"));
//
			User entity = null;
			entity = new User();
			entity.setCreateBy(obj.getUsername());
			entity.setCreateDate(DateTimeUtil.getSystemDate());
			entity.setUpdateBy(obj.getUsername());
			entity.setUpdateDate(DateTimeUtil.getSystemDate());
			entity.setNickname(dynaForm.getString("newnickname"));
			entity.setUser_firstname(dynaForm.getString("newfirstname"));
			entity.setUser_lastname(dynaForm.getString("newlastname"));
			entity.setUser_email(dynaForm.getString("newemail"));
			entity.setUser_phone(dynaForm.getString("newphone"));
			entity.setUsername(dynaForm.getString("newuser"));
			entity.setPassword(dynaForm.getString("newpassword"));
////			

//
			Company com = new Company();
			
			com.setId(1);
			UserPosition position = new UserPosition();
			System.out.println(com);
			position.setId(1);
			UserPrefix prefix = new UserPrefix();
			prefix.setId(1);
			UserType type = new UserType();
			type.setId(1);
//		
			entity.setId_company(com);
			entity.setId_customer(com);
			entity.setId_user_position(position);
			entity.setId_user_prefix(prefix);
			entity.setId_user_type(type);
			UserType usertype = new UserType();
			usertype.setId(1);
			entity.setId_user_type(usertype);

//			User merge = UserService.mergeItem(entity);
			userService.saveOrUpdateItem(entity);
//			userPrefixService.saveOrUpdateItem(entity);
//			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mappingForward(mapping, request, "mode", "showtable", "login.htm", "loginForm", null);
	}
	
	public ActionForward initProfile(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			DynaActionForm dynaForm = (DynaActionForm) form;
			//resetQuestionForm(dynaForm);

//			dynaForm.set("comboIndicator", indicatorService.getAll());

			// HttpSession session = request.getSession();
			// session.setAttribute(SESSION_PATH, constant.getUploadPath());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapping.findForward("MA03");
	}
	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			DynaActionForm dynaForm = (DynaActionForm) form;
			userService.removeItem(Integer.parseInt(dynaForm.getString("id")));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mappingForward(mapping, request, "mode", "showtable", "login.htm", "loginForm", null);
	}
	
	public ActionForward projectpage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			DynaActionForm dynaForm = (DynaActionForm) form;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapping.findForward("MA05");
	}
	
	
	public ActionForward showProject(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		 User obj = (User) getObjectSession(request, SESSION_USER);
		 System.out.println("Hello Project!");
		 String company = String.valueOf(obj.getId_company().getId());
		 System.out.println("Hello Project!+com"+company);

		 try {
			DynaActionForm dynaForm = (DynaActionForm) form;
			List<Project> projectList = projectService.getProjectList(company);
			List<Company> customerAddList = companyService.getCustomerList(company);
		
			System.out.println("projectList = "+projectList);
			Project project = projectList.iterator().next();
//			System.out.println(project+"test project");	
//			dynaForm.set("id_project", project.getId());
//			dynaForm.set("id_customer", project.getId_customer());
//			dynaForm.set("project_name", project.getProject_name());
			dynaForm.set("customerAddList", customerAddList);
			request.setAttribute("customerAddList", customerAddList);
			dynaForm.set("resultProjectList", projectList);
			request.setAttribute("resultProjectList", projectList);
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapping.findForward("MA05");
	}
	
	public ActionForward showRequest(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		DynaActionForm dynaForm = (DynaActionForm) form;
		
		
		User obj = (User) getObjectSession(request, SESSION_USER);
		String company = String.valueOf(obj.getId_company().getId());
//		dynaForm.set("comboIndicator", projectService.getindicator(company));
//		System.out.println(dynaForm.getString("comboIndicator"));
		 try {
			List<Request> requestList = requestService.getRequestList(company);
			System.out.println("projectList = "+requestList);
			Request req = requestList.iterator().next();
////			System.out.println(project+"test project");	
////			dynaForm.set("id_project", project.getId());
////			dynaForm.set("id_customer", project.getId_customer());
////			dynaForm.set("project_name", project.getProject_name());
//
			dynaForm.set("resultRequestList", requestList);
			request.setAttribute("resultRequestList", requestList);
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapping.findForward("MA06");
	}

	
	public ActionForward saveProject(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			
			DynaActionForm dynaForm = (DynaActionForm) form;


			User obj = (User) getObjectSession(request, SESSION_USER);
			System.out.println(obj.getUsername());
			
//			UserPrefix entity = null;
//			entity = new UserPrefix();
//			entity.setPrefix_name(dynaForm.getString("newuser"));
//
			Project entity = null;
			entity = new Project();
			entity.setCreateBy(obj.getUsername());
			entity.setCreateDate(DateTimeUtil.getSystemDate());
			entity.setUpdateBy(obj.getUsername());
			entity.setUpdateDate(DateTimeUtil.getSystemDate());
			entity.setProject_name(dynaForm.getString("newproject"));
			Company customer = new Company();
			customer.setId(1);
			entity.setId_customer(customer);

////			

//
			
//		
			
//			User merge = UserService.mergeItem(entity);
			projectService.saveOrUpdateItem(entity);
//			userPrefixService.saveOrUpdateItem(entity);
//			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mappingForward(mapping, request, "mode", "showProject", "login.htm", "loginForm", null);
	}
	
	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public UserPrefixService getUserPrefixService() {
		return userPrefixService;
	}

	public void setUserPrefixService(UserPrefixService userPrefixService) {
		this.userPrefixService = userPrefixService;
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

	public UserProjectService getUserProjectService() {
		return userProjectService;
	}

	public void setUserProjectService(UserProjectService userProjectService) {
		this.userProjectService = userProjectService;
	}

	public CompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}
	
	
}	
