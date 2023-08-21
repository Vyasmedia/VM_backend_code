package com.vm.Vyas_Media.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import  java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.core.io.*;
import com.vm.Vyas_Media.Entity.CMSEmployee;
import com.vm.Vyas_Media.Entity.CMSMain;
import com.vm.Vyas_Media.Entity.CMSRequest;
import com.vm.Vyas_Media.Repository.CMSEmployeeRepository;
import com.vm.Vyas_Media.Repository.CMSMainRepository;
import com.vm.Vyas_Media.Service.CMSMainService;

@RestController
public class CMSMainController {

	@Autowired
	CMSMainService cmsMainService;

	@Autowired
	private CMSEmployeeRepository cmeRepo;

	@Autowired
	private CMSMainRepository cmsRepo;

	@GetMapping("/cmsmain")
	private List<CMSMain> getAllCMSMain() {
		return cmsMainService.getAllCMSMain();
	}

	@GetMapping("/cmsmain/{id}")
	private CMSMain getCMSMains(@PathVariable("id") int id) {
		return cmsMainService.getCMSMainById(id);
	}

	@DeleteMapping("/cmsmain/{id}")
	private void deleteCMSMain(@PathVariable("id") int id) {
		cmsMainService.delete(id);
	}

	@PostMapping("/cmsmains")
	private int saveCMSMain(@RequestBody CMSMain cmsmain) {
		cmsMainService.saveOrUpdate(cmsmain);
		return cmsmain.getId();
	}

	@PutMapping("/cmsmains")
	private CMSMain update(@RequestBody CMSMain cmsmain) {
		cmsMainService.saveOrUpdate(cmsmain);
		return cmsmain;
	}

	@PostMapping("/empwithpost/save")
	public ResponseEntity<CMSMain> saveData(@RequestBody CMSRequest req) {

		CMSEmployee ce = new CMSEmployee();
		ce.setName(req.getName());
		ce.setDepartment(req.getDepartment());
		ce = cmeRepo.save(ce);

		CMSMain laptop = new CMSMain(req);
		laptop.setCmsEmployee(ce);

		laptop = cmsRepo.save(laptop);

		return new ResponseEntity<CMSMain>(laptop, HttpStatus.CREATED);

	}

	@GetMapping(value = "/welcome", produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String welcomeAsHTML() {
		/*
		 * return "<html>\n" + "<header><title>Welcome</title></header>\n" + "<body>\n"
		 */ // + "Hello world\n" + "</body>\n" + "</html>";
		return "    <form>\r\n" + "      <div>\r\n" + "        <h1>Register</h1>\r\n"
				+ "        <p>Kindly fill in this form to register.</p>\r\n"
				+ "        <label for=\"username\"><b>Username</b></label>\r\n" + "        <input\r\n"
				+ "          type=\"text\"\r\n" + "          placeholder=\"Enter username\"\r\n"
				+ "          name=\"username\"\r\n" + "          id=\"username\"\r\n" + "          required\r\n"
				+ "        />\r\n" + "\r\n" + "        <label for=\"email\"><b>Email</b></label>\r\n"
				+ "        <input\r\n" + "          type=\"text\"\r\n" + "          placeholder=\"Enter Email\"\r\n"
				+ "          name=\"email\"\r\n" + "          id=\"email\"\r\n" + "          required\r\n"
				+ "        />\r\n" + "\r\n" + "        <label for=\"pwd\"><b>Password</b></label>\r\n"
				+ "        <input\r\n" + "          type=\"password\"\r\n"
				+ "          placeholder=\"Enter Password\"\r\n" + "          name=\"pwd\"\r\n"
				+ "          id=\"pwd\"\r\n" + "          required\r\n" + "        />\r\n" + "\r\n"
				+ "        <label for=\"pwd-repeat\"><b>Repeat Password</b></label>\r\n" + "        <input\r\n"
				+ "          type=\"password\"\r\n" + "          placeholder=\"Repeat Password\"\r\n"
				+ "          name=\"pwd-repeat\"\r\n" + "          id=\"pwd-repeat\"\r\n" + "          required\r\n"
				+ "        />\r\n" + "\r\n" + "        <button type=\"submit\">Register</button>\r\n"
				+ "      </div>\r\n"
				+ "     <!-- wrapping the text inside the p tag with a tag for routing to the login page URL-->\r\n"
				+ "      <!-- the # must ideally be replaced by the login page URL -->\r\n" + "      <div>\r\n"
				+ "        <p>Already have an account? <a href=\"#\">Log in</a>.</p>\r\n" + "      </div>\r\n"
				+ "    </form>\r\n" + "";
	}

	@GetMapping("/home")
	public String loadHomePage() {
		Resource resource = new ClassPathResource("templates/index.html");
		try {
			InputStream inputStream = resource.getInputStream();
			byte[] byteData = FileCopyUtils.copyToByteArray(inputStream);
			String content = new String(byteData, StandardCharsets.UTF_8);
			System.out.print(content);
			// LOGGER.info(content);
			return content;
		} catch (IOException e) {
			e.printStackTrace();
			// LOGGER.error("IOException", e);
		}
		return null;
	}
	//https://stackoverflow.com/questions/11511875/how-to-force-spring-to-return-text-html-instead-of-application-json
	/*
	 * @RequestMapping(value="attachmentUpload", method=RequestMethod.POST)
	 * public @ResponseBody Map<String, String> attachmentUpload(
	 * 
	 * @ModelAttribute("fileUploadFB") @Valid final FileUploadFormBean fileUploadFB,
	 * BindingResult result, SessionStatus sessionStatus, HttpServletResponse
	 * response) {
	 * 
	 * final Map<String, String> resultMap = new HashMap<String, String>();
	 * 
	 * resultMap.put("success", "true");
	 * 
	 * // vain attempts to force text/html; do not work
	 * response.setContentType("text/html;charset=UTF-8");
	 * response.setHeader("Content-Type", "text/html");
	 * 
	 * return resultMap; }
	 */
}
