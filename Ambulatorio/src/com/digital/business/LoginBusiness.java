package com.digital.business;

import com.digital.bean.LoginBean;
import com.digital.bean.UsuarioBean;
import com.digital.dao.LoginDAO;

public class LoginBusiness {

	public UsuarioBean loginUser(LoginBean bean) {
		
		LoginDAO dao = new LoginDAO();
		
		return dao.loginUser(bean);
	}

}
