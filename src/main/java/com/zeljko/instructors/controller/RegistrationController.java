package com.zeljko.instructors.controller;

import com.zeljko.instructors.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	private UserDetailsManager userDetailsManager;

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	private Logger logger = Logger.getLogger(getClass().getName());

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/showRegistrationForm")
	public String showMyLoginPage(Model theModel) {

		theModel.addAttribute("users", new Users());

		return "registration_form";

	}
	
	@GetMapping("/showDeleteForm")
	public String showMyLoginPage2(Model theModel) {

		theModel.addAttribute("users", new Users());

		return "delete_form";

	}

	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(@Valid @ModelAttribute("users") Users theUsers,
                                          BindingResult theBindingResult, Model theModel) {

		String username = theUsers.getUsername();

		logger.info("Processing registration form for: " + username);

		// form validation
		if (theBindingResult.hasErrors()) {

			theModel.addAttribute("users", new Users());
			theModel.addAttribute("registrationError", "User name/password can not be empty.");

			logger.warning("User name/password can not be empty.");

			return "registration_form";
		}

		// check the database if user already exists
		boolean userExists = doesUserExist(username);

		if (userExists) {
			theModel.addAttribute("users", new Users());
			theModel.addAttribute("registrationError", "Username already exists.");

			logger.warning("Username already exists.");

			return "registration_form";
		}


		// encrypt the password
		String encodedPassword = passwordEncoder.encode(theUsers.getPassword());

		// prepend the encoding algorithm id
		encodedPassword = "{bcrypt}" + encodedPassword;

		// give user default role of "employee"
		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER");

		// create user object (from Spring Security framework)
		User tempUser = new User(username, encodedPassword, authorities);

		// save user in the database
		userDetailsManager.createUser(tempUser);

		logger.info("Successfully created user: " + username);

		return "registration_confirmation";
	}
	
	@PostMapping("/processDeleteForm")
	public String processDeleteForm(@Valid @ModelAttribute("users") Users theUsers,
                                    BindingResult theBindingResult, Model theModel) {

		String username = theUsers.getUsername();

		logger.info("Processing delete form for: " + username);

		// form validation
		if (theBindingResult.hasErrors()) {

			theModel.addAttribute("users", new Users());
			theModel.addAttribute("registrationError", "User name/password can not be empty.");

			logger.warning("User name/password can not be empty.");

			return "delete_form";
		}

		// check the database if user already exists
		boolean userExists = doesUserExist(username);

		if (!userExists) {
		
			theModel.addAttribute("registrationError", "User does not exist.");

			logger.warning("User does not exist.");

			return "delete_form";
		}

		userDetailsManager.deleteUser(username);;

		logger.info("Successfully deleted user: " + username);

		return "delete_confirmation";
	}

	private boolean doesUserExist(String username) {

		logger.info("Checking if user exists: " + username);

		// check the database if the user already exists
		boolean exists = userDetailsManager.userExists(username);

		logger.info("User: " + username + ", exists: " + exists);

		return exists;
	}

}
