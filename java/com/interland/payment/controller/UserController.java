package com.interland.payment.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.interland.payment.dto.ScreenBean;
import com.interland.payment.dto.UserDetailsDto;
import com.interland.payment.exception.ProcessingException;
import com.interland.payment.service.UserService;
import com.interland.payment.util.AesUtil;


@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = Logger.getLogger(UserController.class
			.getName());
	
	@Value("${MENU}")
	private String menu;
	   
	@Autowired UserService userService;


	@RequestMapping(value = "/home",method = RequestMethod.GET) 
	public String getHomepage() {  
		
		return "home";    
		}
	
	
	@RequestMapping(value = "/loginPage",method = RequestMethod.GET) 
	public String reDirectLogin() {  
		
		return "login";    
		}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public  String authenticate(Model model,
			RedirectAttributes redirectAttributes,
			@RequestParam(value = "cipher") String cipher,
			@RequestParam(value = "hash") String hash,
			@RequestParam(value = "iv") String iv,
			@RequestParam(value = "salt") String salt,
			HttpServletRequest request, HttpServletResponse response)
			throws ProcessingException {
		
		 HttpSession session = request.getSession(); 
		 logger.info("Inside login methode In Login Controller"
		 		+ ""
		 		+ ""
		 		+ "er ");
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy hh.mm.ss");
		Date lastLogin = null;
		long diffMinutes = 0;
		Date CurrentTime = new Date();
		int iterationCount = 1000;
		int keySize = 128;
		String passphrase = "1234567abcdef";
		AesUtil aesUtil = new AesUtil(keySize, iterationCount);
		String userId = aesUtil.decrypt(salt, iv, passphrase, cipher);
		String password = aesUtil.decrypt(salt, iv, passphrase, hash);
		boolean ldapLoginStatus = false;
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (StringUtils.isEmpty(ipAddress)) {
			logger.info("IP Address Is empty in login() of UserController");
			ipAddress = request.getRemoteAddr();
		}
		try {
			boolean autheticateUser = userService.authenticateUser(userId,password);
			if (autheticateUser) {
				logger.info(userId+ " Authenticating user in login() of UserController");
				UserDetailsDto loggedUser = userService.loggedUserDetails(userId);
			     Map<String, List<ScreenBean>> screenPermissions = userService.getScreensforUser(userId, menu);
			    	logger.info(userId + "Logged In Successfully at"+ new Date());
			    	
					UserListener listener = new UserListener(userId);
					session.setAttribute("UserContext", listener);
					session.setAttribute("userId", userId);
					session.setAttribute("userName", loggedUser.getUserName());
					session.setAttribute("group", loggedUser.getGroupId());
					session.setAttribute("screenPermission", screenPermissions);
					session.setAttribute("withOutSession", 1);
					 logger.info("Redirecting to homeUrl");
//					 userService.saveUserLoginAttempt(userId, "S", ipAddress, "Logged In Successfully at"+ new Date());
					 model.addAttribute("status", "Sucess");
					 model.addAttribute("message", "Welcome  "+userId);
					
					 return  "redirect:/user/home";
									
			} else {
				
				logger.info(userId + "Invalid UserName or Password");
//				userService.saveUserLoginAttempt(userId, "F", ipAddress,"Invalid User ID Or Password");
				logger.info("Return from login() in UserController to login");
			 
				 redirectAttributes.addFlashAttribute("status", "fail");
		         redirectAttributes.addFlashAttribute("message",  "Invalid user ID Or Password");
				
				
				return  "redirect:/user/loginPage";
			
			}

		} catch (Exception e) {
			
			model.addAttribute("status", "fail");
			model.addAttribute("message", "Server is busy, Please try after some time");
			
		}
    return "login";	
    }
	@RequestMapping(value = "/logOut", method = RequestMethod.GET)
	
	 public String logOut(HttpServletRequest request,RedirectAttributes redirectAttributes,Model model) {
	     String loginTypeString = "";
	     String ipAddress = request.getHeader("X-FORWARDED-FOR"); 
	        if(StringUtils.isEmpty(ipAddress))
	            ipAddress = request.getRemoteAddr();        
	  HttpSession session = request.getSession();
	  String userId = (String) session.getAttribute("userId");
	  try{
//	   userService.saveUserLoginAttempt(userId, "S", ipAddress, "Logged Out Successfully");
	  }catch(ProcessingException e){
	         logger.error(e.getMessage(),e);
	            throw e;
	        }
	  session.removeAttribute("UserContext");
	  session.invalidate();
	  model.addAttribute("status","Success");
	  model.addAttribute("message","Your account has been logged out successfully");
	  return "login";

	 }
	
	@RequestMapping("/mailbox")
	public String mailbox(Model model, HttpServletRequest request)
			throws ProcessingException {
		HttpSession session = request.getSession();
		return "mailbox";
	}
	
	@RequestMapping("/compose")
	public String compose(Model model, HttpServletRequest request)
			throws ProcessingException {
		HttpSession session = request.getSession();
		return "compose";
	}
	
	@RequestMapping(value = "/readMail")
	public String readMail(Model model, HttpServletRequest request,@RequestParam(value = "messageId") String messageId)
			throws ProcessingException {
		HttpSession session = request.getSession();
		model.addAttribute("messageId",messageId);
		System.out.println(messageId);
		return "readMail";
	}
	@RequestMapping("/trash")
	public String trash(Model model, HttpServletRequest request)
			throws ProcessingException {
		HttpSession session = request.getSession();
		return "Trash";
	}
	@RequestMapping("/sentMail")
	public String sentMail(Model model, HttpServletRequest request)
			throws ProcessingException {
		HttpSession session = request.getSession();
		return "sentMail";
	}
	
	@RequestMapping("/viewMail")
	public String viewMail(Model model, HttpServletRequest request)
			throws ProcessingException {
		HttpSession session = request.getSession();
		return "viewMail";
	}
	
}
