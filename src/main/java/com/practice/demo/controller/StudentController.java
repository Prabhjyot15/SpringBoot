package com.practice.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.practice.demo.model.Student;
import com.practice.demo.repository.StudentRepo;

@Controller
public class StudentController {
@Autowired
private StudentRepo studentRepo;
@GetMapping("/addForm")
public ModelAndView getForm() {
	ModelAndView mv = new ModelAndView();
	mv.addObject("student", new Student());
	mv.setViewName("addStudent");
	return mv;
}

@PostMapping("/addStudent")
public ModelAndView addStudent(@ModelAttribute("student") Student student) {
	studentRepo.save(student);
	ModelAndView mv = new ModelAndView();
	
	List<Student> students =studentRepo.findAll();
//	Iterator itr = students.iterator();
//	List<Student> studentList = new ArrayList();
//	while(itr.hasNext()) {
//		System.out.println(itr.next());
//	}
//	System.out.println(students);
//	for(Student obj :students) {
//		System.out.println(obj.getName());
//	}
	mv.addObject("students", students);
	mv.setViewName("viewStudents");
	return mv;
}
@GetMapping("/editStudent")
public ModelAndView gStudent() {
	ModelAndView mv = new ModelAndView();
	mv.setViewName("home2");
	return mv;
}
@GetMapping("/allStudents")
public ModelAndView getAllStudents() {
	ModelAndView mv = new ModelAndView();
	List<Student> students =studentRepo.findAll();
//	Iterator itr = students.iterator();
//	List<Student> studentList = new ArrayList();
//	while(itr.hasNext()) {
//		System.out.println(itr.next());
//	}
//	System.out.println(students);
//	for(Student obj :students) {
//		System.out.println(obj.getName());
//	}
	mv.addObject("students", students);
	mv.setViewName("viewStudents");
	return mv;
}
@RequestMapping(value="/deleteStudent/{id}",method = RequestMethod.GET)
public String deleteStudent(@PathVariable("id") int id,Model model) {
	Student student = null;
	Optional<Student> obj =studentRepo.findById(id);
	if(obj.isPresent()) {
	 student = obj.get();
	}
	studentRepo.delete(student);
	List<Student> students =studentRepo.findAll();
//	mv.addObject("students", students);
//	mv.setViewName("viewStudents.jsp");
//	for(Student obj1 :students) {
//		System.out.println(obj1.getName());
//	}
	model.addAttribute("students", students);
	return "redirect:/allStudents";
}

@RequestMapping(value="/editStudent/{id}",method = RequestMethod.GET)   
public String editStudentForm(@PathVariable int id,Model model){
	
	Student student=null;
  Optional<Student> studentValue=studentRepo.findById(id);  
  if(studentValue.isPresent()) {
  	student=studentValue.get();
  }
model.addAttribute("student", student);

//	//
System.out.println(student.getEmail());
return "editForm";

} 
@RequestMapping("/editStudentEntry")
public String editStudent(@ModelAttribute("student") Student student) {
	studentRepo.save(student);
	return "redirect:/allStudents";
}


}
