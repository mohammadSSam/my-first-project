package com.example.mo3amlat;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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
	@PostMapping(
            value = "/admin/moamle")
	public void addmoamlef(user usr) {
		  int indexofemail = -1;
	      Object[] userarray = userservices.getAllUsers().toArray();
	      for (int i = 0; i < userarray.length; i++) {
	          if(usr.getEmail().equals(((user) userarray[i]).getEmail())) {
	              indexofemail=i;
	              break;
	          }
	      }
	 user updateusr = (user) userarray[indexofemail];
	 ArrayList<moaamleh> list = updateusr.getMoamalat();
	 list.add(usr.getSendmoamala());
	 updateusr.setMoamalat(list);
	 userservices.saveUser(updateusr);
	 
	}
	
	@PostMapping(value="gettable")
	public ArrayList<moaamleh> gettable(@RequestBody user usr){
		Object[] userarray =userservices.getAllUsers().toArray();
		
		for (int i = 0; i < userarray.length; i++) {
		     if(usr.getEmail().equals(((user) userarray[i]).getEmail())) {
	            return ((user) userarray[i]).getMoamalat();
	              
		
		     }	
	}
	
	return null;
	}}
