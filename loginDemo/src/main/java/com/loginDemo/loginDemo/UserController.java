package com.loginDemo.loginDemo;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;



import javax.transaction.Transactional;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	CustomRepositery customRepositery;
	@Autowired
	LocationDAO locationDAO;
	@Autowired
	EmployeeDAO employeeDAO;
	@Autowired
	UserDAO userDAO;
	
	
	
	@RequestMapping("/login")
	public String welcome(Map<String, Object> model) {
		System.out.println("User Controller ");
		//model.put("message", "Welcome");
		return "login";
	}
	@RequestMapping("/login1")
	public String welcome1(Map<String, Object> model) {
		System.out.println("User Controller ");
		//model.put("message", "Welcome");
		return "login2";
	}
	@RequestMapping(value ="/submit", method = RequestMethod.POST)
	public String submit(UserModel userModel,ModelMap map) {
		ModelAndView modelAndView=new ModelAndView("submit", "user", new UserModel());
		
		System.out.println("User Controller submit");
		System.out.println(userModel.getUserName());
		UserModel user=userRepository.getUserByNameAndPassword(userModel.getUserName(), userModel.getPassword());
		if(user !=null){
			System.out.println("user "+user.getUserName());
			map.put("message", user.getUserName());
			return "home";
			
			
		}else{
			map.put("message", "Invaid User Name Or Password");
			System.out.println("Invaild user");
			return "login";
		}
		
		//model.put("message", "Welcome");
	}
	@RequestMapping(value ="/submit1", method = RequestMethod.POST)
	
	public String submit1(HttpServletRequest request,ModelMap map) {
		
		//ModelAndView modelAndView=new ModelAndView("submit", "user", new UserModel());
		
		/*System.out.println("User Controller submit");
		System.out.println(request.getParameter("userName"));
		//System.out.println(username);*/
		//UserModel user=userRepository.getUserByNameAndPassword(username,passwort );
		//if(user !=null){
		//	System.out.println("user "+user.getUserName());
		//	map.put("message", user.getUserName());
		//	return "welcome";
			
			
		//}else{
			//map.put("message", "Invaid User Name Or Password");
		//	System.out.println("Invaild user");
			return "login";
	//	}
		
		//model.put("message", "Welcome");
	}
	@RequestMapping("/user")
	public String user(Map model) {
		
		return "search-user";
	}
	@RequestMapping("/userDetail")
	public String userDetail() {
		
		return "user";
	}
	@RequestMapping("/goToDetail")
	public String goToDetail() {
		
		return "user-detail";
	}
	
	@Transactional
	@RequestMapping(value ="/addUser", method = RequestMethod.POST)
	
	public String addUser(UserModel userModel,HttpServletRequest request,
            @RequestParam MultipartFile file) throws Exception{
		System.out.println("=== "+file.getOriginalFilename());
		file.getBytes();
		File firstPhoto = new File("test-file");
		InputStream inputStream = null;
		try {
			inputStream = file.getInputStream();
		if(inputStream.available()>0) {
				//firstPhoto = new File(schemeBusiness.getPhotoPath());
				if(!firstPhoto.exists()) {
					firstPhoto.mkdir();
				}
					firstPhoto = new File("D:/test-file/"+userModel.getUserName()+".png");	
					FileUtils.copyInputStreamToFile(inputStream, firstPhoto);
			}				  
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		userModel.setPhotoPath("D:/test-file/"+userModel.getUserName()+".png");
		/*LocationModel locationModel =new LocationModel();
		locationModel.setLocationName("Hyd");
		locationDAO.addLocationModel(locationModel);
		EmployeeModel employeeModel =new EmployeeModel();
		employeeModel.setEmployeeName("Ali");
		employeeModel.setLocationModel(locationModel);
		employeeDAO.addEmployee(employeeModel);
		userModel.setEmployeeModel(employeeModel);*/

		//throw new RuntimeException("");
		//ModelAndView modelAndView=new ModelAndView("submit", "user", new UserModel());
		userDAO.addUserModel(userModel);
		System.out.println(10/0);
		return "search-user";
		
		
		//model.put("message", "Welcome");
	}
	 @RequestMapping(path = "/getAllUsers", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	    public  @ResponseBody ResponseEntity<Map<String, Object>> getAllUsers(@RequestParam("jtSorting") String jtSorting,@RequestParam("jtPageSize") String jtPageSize,@RequestParam("jtStartIndex") String jtStartIndex,@RequestParam("userName") String userName) {
		
		 String property="";
			String order="";
			Sort sort=null;
			if(jtSorting!=null&& !jtSorting.equalsIgnoreCase("")){
				String[] propertyOrder= jtSorting.split(" ");
				property= propertyOrder[0];
				order= propertyOrder[1];
				
				
			}
			if(order.equalsIgnoreCase("ASC")){
				sort = new Sort(new Sort.Order(Direction.ASC, property));
			}else{
				sort = new Sort(new Sort.Order(Direction.DESC, property));
			}
		 System.out.println("call method");
		 System.out.println(jtSorting);
		String salary=null;
		Integer userId=null;
		Integer jInteger=Integer.parseInt(jtStartIndex);
		Integer jPage= Integer.parseInt(jtPageSize);
		int pageNumber=0;
		int division=jInteger/jPage;
		if(jInteger>0 ){
			pageNumber=division;
		}
		
		 Pageable pageable = new PageRequest(pageNumber, Integer.parseInt(jtPageSize), sort);
		 
	        Map<String, Object> resultMap = new HashMap<>();
	        resultMap.put("Result", "OK");
	       /* for (UserModel order2 : userRepository.findAll(pageable)) {
	        	order2.getClass();
			}*/
	        
	        //resultMap.put("Records", userRepository.findAll(pageable));
	        resultMap.put("TotalRecordCount", customRepositery.findByUserName(userName,pageable).getTotalElements());
	        ///List<UserModel> users=(customRepositery).findByUserName(userName,pageable).getContent();
	        resultMap.put("Records", customRepositery.findByUserName(userName,pageable).getContent());
	       /* for(UserModel  u: users){
	        	System.out.println(u.getUserName());
	        }*/
	        
			/*Long sizeOfList = 10;
			JTableList<UserDTO> jTableList = new JTableList<>();
			jTableList.setRecords(bookDTOs);
			jTableList.setResult("OK");
			jTableList.setTotalRecordCount(sizeOfList);
			return new Gson().toJson(jTableList);
	        */
	        
	      //	 List<Pageable> myList =userRepository.findAll(pageable);
	   

	        
	        return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	    }
	public LocationDAO getLocationDAO() {
		return locationDAO;
	}
	public void setLocationDAO(LocationDAO locationDAO) {
		this.locationDAO = locationDAO;
	}
	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	 
}
