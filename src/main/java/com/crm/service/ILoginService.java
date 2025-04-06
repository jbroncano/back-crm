package com.crm.service;

import com.crm.dto.InfoUsuarioDTO;

public interface ILoginService {

	 InfoUsuarioDTO inicioSession(String usuario,String password);
}
