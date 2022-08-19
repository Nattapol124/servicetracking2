package com.gtt.server.user.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import com.core.dao.impl.CoreDaoImpl;
import com.gtt.server.user.dao.UserDao;
import com.gtt.server.user.entity.Company;
import com.gtt.server.user.entity.User;
import com.gtt.server.user.entity.UserPosition;
import com.gtt.server.user.entity.UserType;


public class UserDaoImpl extends CoreDaoImpl<User, Serializable>
		implements UserDao {

	public UserDaoImpl(Class<User> entityClass) {
		super(entityClass);
	}
	@Override
	public List findLogin(String username, String password) throws DataAccessException {
		String sql = "SELECT user.id_user, user.username, user.password, user.user_firstname, "
				+ "user.user_lastname, user.user_email, user.user_phone, user.id_customer, "
				+ "user.user_nickname, user.id_company, user.id_user_position, company.company_name, "
				+ "userposition.position_name FROM user "
				+ "inner join company on user.id_customer = company.id_company inner "
				+ "join userposition on user.id_user_position = userposition.id_user_position "
				+ "WHERE username="+"'"+username+"' AND password='"+password+"';";
		List<User> results = new ArrayList<User>();
		Company customer_results = new Company();
		Company Company_results = new Company();
		UserPosition UserPosition_results = new UserPosition();
		
		List<Object[]> objectList = getSession().createSQLQuery(sql).list();
		if(objectList != null && objectList.size()>0 ) {
			for(Object[] obj : objectList){
				System.out.println(String.valueOf(obj[6]));
			User item = new User(Integer.parseInt(String.valueOf(obj[0])));
			item.setUsername(String.valueOf(obj[1]));
			item.setPassword(String.valueOf(obj[2]));
			item.setUser_firstname(String.valueOf(obj[3]));
			item.setUser_lastname(String.valueOf(obj[4]));
			item.setUser_email(String.valueOf(obj[5]));
			item.setUser_phone(String.valueOf(obj[6]));
			customer_results.setId(Integer.parseInt(String.valueOf(obj[7])));
			item.setId_customer(customer_results);
			item.setNickname(String.valueOf(obj[8]));
			
			Company_results.setId(Integer.parseInt(String.valueOf(obj[9])));
			Company_results.setCompany_name(String.valueOf(obj[11]));
			item.setId_company(Company_results);
			
			
			UserPosition_results.setId(Integer.parseInt(String.valueOf(obj[10])));
			UserPosition_results.setPosition_name(String.valueOf(obj[12]));
			item.setId_user_position(UserPosition_results);
			
			
			results.add(item);
		}
	}
		return results;
}

	@Override
	public List	findUserList(String company) throws DataAccessException {
		System.out.println(company+" :test passvalue");
		String sql = "SELECT id_user,username,user_firstname,user_lastname,user_email,user_phone,user.id_company,user_nickname,user.id_customer,company.company_name,user.id_user_position,userposition.position_name FROM user INNER JOIN company ON user.id_customer=company.id_company INNER JOIN userposition ON user.id_user_position=userposition.id_user_position WHERE user.id_company='"+company+"'";

		List<User> results = new ArrayList<User>();

		List<Object[]> objectList = getSession().createSQLQuery(sql).list();
		if(objectList != null && objectList.size()>0 ) {
			for(Object[] obj : objectList){
			Company customer_results = new Company();
			Company Company_results = new Company();
			UserPosition position_results = new UserPosition();
			User item = new User(Integer.parseInt(String.valueOf(obj[0])));
			item.setUsername(String.valueOf(obj[1]));
			item.setUser_firstname(String.valueOf(obj[2]));
			item.setUser_lastname(String.valueOf(obj[3]));
			item.setUser_email(String.valueOf(obj[4]));
			item.setUser_phone(String.valueOf(obj[5]));
			
			Company_results.setId(Integer.parseInt(String.valueOf(obj[6])));
			item.setNickname(String.valueOf(obj[7]));
			customer_results.setId(Integer.parseInt(String.valueOf(obj[8])));
			customer_results.setCompany_name(String.valueOf(obj[9]));
			item.setId_customer(customer_results);
			item.setId_company(Company_results);
			position_results.setId(Integer.parseInt(String.valueOf(obj[10])));
			position_results.setPosition_name(String.valueOf(obj[11]));
			item.setId_user_position(position_results);

			results.add(item);
		}
	}
		return results;
}
	
<<<<<<< HEAD
=======
	@Override
	public List	findAddUserList(String company,String id_company) throws DataAccessException {
		System.out.println(company+" :test passvalue");
		String sql = "SELECT  user.id_user,user.username,user.user_firstname,user.user_lastname from user left JOIN userproject ON user.id_user=userproject.id_user AND userproject.id_project='"+company+"' WHERE userproject.id_user IS null and user.id_customer='99' AND user.id_company='"+id_company+"' ";
		List<User> results = new ArrayList<User>();

		List<Object[]> objectList = getSession().createSQLQuery(sql).list();
		if(objectList != null && objectList.size()>0 ) {
			for(Object[] obj : objectList){
			User item = new User(Integer.parseInt(String.valueOf(obj[0])));
			item.setUsername(String.valueOf(obj[1]));
			item.setUser_firstname(String.valueOf(obj[2]));
			item.setUser_lastname(String.valueOf(obj[3]));
			

			results.add(item);
		}
	}
		return results;
}
>>>>>>> 1d7ed70bff8e3af5829783bd506632c8669d20a9
}
