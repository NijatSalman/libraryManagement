package com.aistgroup.controller;

import com.aistgroup.entity.*;
import com.aistgroup.enums.BookStatusEnum;
import com.aistgroup.form.BookReservationForum;
import com.aistgroup.form.BookedDetailsForum;
import com.aistgroup.security.MySessionInfo;
import com.aistgroup.service.inter.AdminUserActionServiceInter;
import com.aistgroup.service.inter.BookServiceInter;
import com.aistgroup.service.inter.BookStatusServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping
public class BookedDetailsController {

    java.sql.Date currentDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());

    @Autowired
    private MySessionInfo mySessionInfo;

    @Autowired
    private AdminUserActionServiceInter adminUserActionServiceInter;

    @Autowired
    private BookServiceInter bookServiceInter;

    @Autowired
    private BookStatusServiceInter bookStatusServiceInter;

    @RequestMapping(method = RequestMethod.GET, value="/adminDashboard/booking/details")
    public ModelAndView indexBookReservationListOfAllPeople(){

        ModelAndView mv = new ModelAndView("bookedDetails");
        User admin=mySessionInfo.getCurrentUser();


        List<AdminUserAction> adminUserActionListList=adminUserActionServiceInter.getAll();


        mv.addObject("bookedDetailsObj",adminUserActionListList);
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/adminDashboard/admin/receive/book")
    public ModelAndView indexAdminDeleteOrder(
            @RequestParam(name ="id",required = false) Integer id,
            @ModelAttribute("bookedDetailsForum") BookedDetailsForum bookedDetailsForum)
    {
        ModelAndView mv=new ModelAndView("/bookedDetails");


        AdminUserAction adminUserAction=adminUserActionServiceInter.getAdminUserActionById(id);
        adminUserAction.setReceivedDate(currentDate);


        //Book status was changed from Taken to Available
        Book book=bookServiceInter.getById(adminUserAction.getBookId().getId());
        BookStatus bkStatus=bookStatusServiceInter.getById(BookStatusEnum.AVAILABLE.getValue());
        book.setBookStatusId(bkStatus);
        bookServiceInter.updateBook(book);

        //AdminUserAction was updated
        adminUserActionServiceInter.updateAdminUserAction(adminUserAction);

        List<AdminUserAction> bkAdminUserActionList=adminUserActionServiceInter.getAll();
        mv.addObject("bookReservObj",bkAdminUserActionList);

        return mv;
    }

    @ModelAttribute("bookedDetailsForum")
    public BookedDetailsForum getEmptybookedDetailsForum(){
        return new BookedDetailsForum(null,null,null,null,null,null);
    }

}
