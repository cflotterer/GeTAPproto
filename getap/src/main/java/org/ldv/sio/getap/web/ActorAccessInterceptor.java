/**
 * Implémentation de la logique d'accès aux contrôleurs de cas d'utilisation
 *  
 * @author kpu
 */
package org.ldv.sio.getap.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ldv.sio.getap.app.User;
import org.ldv.sio.getap.utils.UtilSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ActorAccessInterceptor extends HandlerInterceptorAdapter {
	// private final Log logger = LogFactory.getLog(getClass());
	private final Logger logger = LoggerFactory
	    .getLogger(ActorAccessInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
	    HttpServletResponse response, Object handler) throws Exception {

		String controllerName = request.getRequestURI().split("/")[3];

		System.out.println("TEST  INTERCEPTOR 2:" + request.getContextPath()
		    + " servlet: " + controllerName);

		logger.info("TEST  INTERCEPTOR with LOGGER !:" + request.getContextPath()
		    + " servlet: " + controllerName);

		User userInSession = UtilSession.getUserInSession();
		String role = (userInSession != null) ? userInSession.getRole() : "";

		boolean ok = false;

		if (controllerName.equals("hotels") && role.equals("admin"))
			ok = true;
		else if (controllerName.equals("eleve") && role.equals("eleve"))
			ok = true;

		else if (controllerName.equals("login"))
			ok = true;

		if (ok)
			return true;
		else {
			response.sendRedirect(request.getContextPath() + "/app/login/index");
			return false;
		}

	}
}
