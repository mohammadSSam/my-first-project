package com.example.mo3amlat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;




@RestController
public class admin {

	@Autowired
    userService userservices;
	@PostMapping(
            value = "/admin/addUser")
  public ArrayList<String>  addUser(@RequestBody user usr){
      ArrayList<String> registrationerrors = new ArrayList<String>();
      Object[] userarray = userservices.getAllUsers().toArray();
      for (int i = 0; i < userarray.length; i++) {
          if(usr.getEmail().equals(((user) userarray[i]).getEmail())) {
              registrationerrors.add("this email is alredy in databes");
              break;
          }
      }

if(!isValidEmailAddress(usr.getEmail())) {
  registrationerrors.add("invalid email");

}
      if(usr.getPassword().length()<8) {
          registrationerrors.add("the password have to be more than 8 chars");
      }

      if(!usr.getPassword().equals(usr.getPassword2()) ) {
          registrationerrors.add("the password dousent match");
      }

      if(registrationerrors.size()==0) {

          usr.setPassword(passencoder.passcoder(usr.getPassword()));
          usr.setPassword2(passencoder.passcoder(usr.getPassword2()));
          registrationerrors.add("true");
          registrationerrors.add(usr.getEmail());
          userservices.saveUser(usr);
      }


      return registrationerrors;
  }
	public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^ `{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
 }
	@PostMapping(
            value = "/admin/login")
  public ArrayList<String>  login(@RequestBody user usr){
      ArrayList<String> loginerrors = new ArrayList<String>();
      int indexofemail = -1;
      Object[] userarray = userservices.getAllUsers().toArray();
      for (int i = 0; i < userarray.length; i++) {
          if(usr.getEmail().equals(((user) userarray[i]).getEmail())) {
              indexofemail=i;
              break;
          }
      }
      if(indexofemail==-1) {
          loginerrors.add("this email doesnt exist");
      }
      else if(!(passencoder.passcoder(usr.getPassword())).equals(((user) userarray[indexofemail]).getPassword()))

      {
          loginerrors.add("the password is wrong");
      }
      if(loginerrors.size()==0) {
          loginerrors.add("true");
          loginerrors.add(usr.getEmail());

      }



      return loginerrors;
  }

	@Autowired
	moaamlehService moaamlehService;
	@PostMapping(value="/admin/addMoaamleh")
	public String addMoaamleh(@RequestBody moaamleh moaamleh) {
		
		
		moaamleh n = new moaamleh();
		n.setNumber(moaamleh.getNumber());
		n.setName(moaamleh.getName());
		n.setDate(moaamleh.getDate());
		n.setPlace(moaamleh.getPlace());
		n.setDetails(moaamleh.getDetails());
		n.setEmail_user(moaamleh.getEmail_user());
		
		moaamlehService.save(n);
		return "ew";
	}
	
	
	@PostMapping(value="/admin/updatmoamaleh")
	public String updatmo(@RequestBody moaamleh moaamleh) {
		
	     Object[] userarray = moaamlehService.listAll().toArray();
	      for (int i = 0; i < userarray.length; i++) {
	          if(moaamleh.getId()==((moaamleh) userarray[i]).getId()) {

	      		moaamleh n = (moaamleh) userarray[i];
	      		n.setNumber(moaamleh.getNumber());
	      		n.setName(moaamleh.getName());
	      		n.setDate(moaamleh.getDate());
	      		n.setPlace(moaamleh.getPlace());
	      		n.setDetails(moaamleh.getDetails());
	      		n.setEmail_user(moaamleh.getEmail_user());
	      		
	      		moaamlehService.save(n);
	              break;
	          }
	      }
		
		return "ew";
	}
	
	
	@GetMapping("/admin/getAll")
	public List<moaamleh> getAllUsers()
	{
		return moaamlehService.listAll();
	}
	
	
	@GetMapping("admin/deleteUser/{id}")
	public void removeById(@RequestParam(name="id") int id)
	{
		moaamlehService.removeMoaamleh(id);
	}
	@GetMapping("admin/updateUser/{id}")
	public void updateById(@RequestParam(name="id") int id)
	{
		moaamlehService.save(moaamlehService.get(id));
	}
	
	@PostMapping("admin/Splace/{place}")
	public ArrayList<moaamleh> Splace(@RequestParam(name="place") String place){
		return moaamlehService.Splace(place);
	}
	@PostMapping("admin/Snumber/{number}")
	public ArrayList<moaamleh> Snumber(@RequestParam(name="number") String number){
		return moaamlehService.Snumber(number);
	}
	@PostMapping("admin/Sname/{name}")
	public ArrayList<moaamleh> Sname(@RequestParam(name="name") String name){
		return moaamlehService.Sname(name);
	}
	@PostMapping("admin/Sdate/{date}")
	public ArrayList<moaamleh> Sdate(@RequestParam(name="date") String date){
		return moaamlehService.Sdate(date);
	}
	
	
	
	}
