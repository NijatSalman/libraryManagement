package com.aistgroup.controller;


import com.aistgroup.entity.Book;
import com.aistgroup.form.BookForum;
import com.aistgroup.form.BookReservationForum;
import com.aistgroup.security.MySessionInfo;
import com.aistgroup.service.inter.BookServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class DashboradController {

    @Autowired
    private MySessionInfo mySessionInfo;

    @Autowired
    private BookServiceInter bookServiceInter;


    @ModelAttribute("book")
    public BookForum getEmptyBookForm(){
        return new BookForum(null,null,null,null);
    }


    @RequestMapping(method={RequestMethod.GET}, value="/userDashboard")
    public String loginPost(){
        return "userDashboard";
    }

    @RequestMapping("/adminDashboard")
    public ModelAndView adminDashboard() {
        return new ModelAndView("adminDashboard");
    }


}
