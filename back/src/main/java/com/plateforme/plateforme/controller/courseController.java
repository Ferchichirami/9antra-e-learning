package com.plateforme.plateforme.controller;

import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import  com.plateforme.plateforme.reposetry.courseReposetry;
import  com.plateforme.plateforme.model.course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200")
public class courseController {
    @Autowired
    private  courseReposetry CourseReposetry;

@GetMapping("/courses")
 public List<course> getAllCourses(){
    return  CourseReposetry.findAll();

 }


    @GetMapping("/courses/{id}")
    public ResponseEntity<course> getCoursesByID(@PathVariable Long id){
          course course=CourseReposetry.findById(id).orElseThrow(()->new RuntimeException("course does not exisit"));
          return  ResponseEntity.ok(course);

    }


@PostMapping("/courses")
 public course  createCourse(@RequestBody course course ){

  return  CourseReposetry.save(course);

}
@PutMapping("courses/{id}")
    public ResponseEntity<course> updateCourse(@PathVariable Long id ,@RequestBody course coursedDetails){


    course course=CourseReposetry.findById(id).orElseThrow(()->new RuntimeException("course does not exisit"));
    course.setTiltle(coursedDetails.getTiltle());
    course.setDescription(coursedDetails.getDescription());
    course.setPrice(coursedDetails.getPrice());
    course.setPeriod(coursedDetails.getPeriod());
    course.setImage(coursedDetails.getImage());

    course updatedCourse= CourseReposetry.save(course);
    return  ResponseEntity.ok(updatedCourse);

}
@DeleteMapping("courses/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCourse(@PathVariable Long id){

    course course=CourseReposetry.findById(id).orElseThrow(()->new RuntimeException("course does not exisit"));

    CourseReposetry.delete(course);
  Map<String, Boolean> Response=new HashMap<>();
    Response.put("DELETED",Boolean.TRUE);

    return  ResponseEntity.ok(Response);



}

}
