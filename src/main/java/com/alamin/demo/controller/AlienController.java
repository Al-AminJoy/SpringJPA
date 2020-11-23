package com.alamin.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alamin.demo.dao.AlienRepo;
import com.alamin.demo.dao.AlienRepoJson;
import com.alamin.demo.model.Alien;
@Controller
//Used when only used rest operations for not writing ResponseBody every time
//@RestController
public class AlienController {
@Autowired
AlienRepo repo;
@Autowired
AlienRepoJson jsonRepo;
 @RequestMapping("/")
	public String home()
{
		
		return "home.jsp";
}
 @RequestMapping("/addAlien")
 public String home(Alien alien) {
	 repo.save(alien);
	 return "home.jsp";
 }
 @RequestMapping("/getAlien")
 public ModelAndView home(@RequestParam int aId) {
	 ModelAndView mv=new ModelAndView("alien.jsp");
	 Alien alien=repo.findById(aId).orElse(new Alien());
	 /*
	  * Checking Complex Query
	   System.out.println(repo.findByaName("Al-Amin"));
	 System.out.println(repo.findByaIdGreaterThan(102));
	 System.out.println(repo.findByaNameSorted("Al-Amin"));
	  */
	
	 mv.addObject(alien);
	 return mv;
 }
 @RequestMapping("/delAlien")
 public String deleteOp(@RequestParam int aId) {
	 //ModelAndView mv=new ModelAndView("home.jsp");
	 repo.deleteById(aId);
	 return "home.jsp";
 }
 @RequestMapping("/updateAlien")
 public String updateOp(Alien alien) {
	 repo.save(alien); 
	 return "home.jsp";
 }
 //Rest Get All Data
 @RequestMapping("/aliens")
 @ResponseBody
 public List<Alien> getAliens() {
	 
	 return jsonRepo.findAll();
 }
 //Rest get Single Data
 @RequestMapping("/aliens/{aId}")
 @ResponseBody
 public Optional<Alien> getAlien(@PathVariable("aId") int aId) {
	 
	 return jsonRepo.findById(aId);
 }
 //Rest Post Data
 @PostMapping("/alien")
 @ResponseBody
 public Alien postAlien(@RequestBody Alien alien) {
	 jsonRepo.save(alien);
	 return alien;
 }
//Rest Put Data
@PutMapping("/alien")
@ResponseBody
public Alien updateAlien(@RequestBody Alien alien) {
	 jsonRepo.save(alien);
	 return alien;
}
 
 //Rest Delete Data
 @DeleteMapping("/alien/{aId}")
 @ResponseBody
 public String delAlien(@PathVariable("aId") int aId) {
	 Alien a=jsonRepo.getOne(aId);
	 jsonRepo.delete(a);
	 return "deleted";
 }
 
}
