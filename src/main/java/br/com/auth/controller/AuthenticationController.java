package br.com.auth.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpServerErrorException;

import br.com.auth.constant.ParamName;
import br.com.auth.security.UserAuthentication;
import br.com.auth.security.UserSession;
import br.com.auth.security.annotation.SessionUpdate;
import br.com.auth.security.service.AuthenticationService;
import br.com.auth.security.service.SessionCookieService;
import br.com.infra.commons.entity.Usuario;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AuthenticationService authService;

	@Autowired
	private SessionCookieService sessionCookieService;

	/**
	 * Temporary created to simulate site selection(multi-tenancy). To be remove once multi-tenancy is implemented.
	 * @param login
	 * @param password
	 * @param site
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@SessionUpdate
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "/login")
	public String login(Usuario usuario, @RequestParam(value = ParamName.URL, required = false) String url, Model model) throws IOException{
		
		if(StringUtils.isEmpty(usuario.getLogin()) || StringUtils.isEmpty(usuario.getSenha())){
			throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "Missing login and password");
		}

		logger.info("login user(" + usuario.getLogin() + ").");

		Usuario user = authService.login(usuario);
		if(user!=null){
			SecurityContext securityContext = SecurityContextHolder.getContext();
			UserSession userSession = new UserSession();
			userSession.setUser(user);
			securityContext.setAuthentication(new UserAuthentication(userSession));
		}else{
			model.addAttribute("ERROR_MESSAGE", "Login ou senha inválido");
			return "login";
		}
		
		if (url == null || url.equals("null"))
			throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "Não há serviço cadastrado");
			
		return "redirect:" + url;
	}

	/**
	 * This endpoint checks that the user is authenticated before redirecting to the index page
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "")
	public String landing(HttpServletRequest request, HttpServletResponse response){
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		String url = request.getParameter(ParamName.URL);
		
		if (authentication instanceof UserAuthentication && authentication.isAuthenticated()){
			logger.info("User(" + securityContext.getAuthentication().getPrincipal() + ") is logged in.");
			return "redirect:" + url;
		}

		logger.info("User(" + securityContext.getAuthentication().getPrincipal() + ") is redirected to login.");
		
		return "login";
	}
	
	/**
	 * This endpoint will return a login form view
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = {"logout"})
	@SessionUpdate
	public String logout(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = ParamName.URL, required = false) String url){
		SecurityContext securityContext = SecurityContextHolder.getContext();

		logger.info("Logging out user(" + securityContext.getAuthentication().getPrincipal()  + ").");

		securityContext.setAuthentication(new UserAuthentication(null));
		
		return "login" ;
	}
}
