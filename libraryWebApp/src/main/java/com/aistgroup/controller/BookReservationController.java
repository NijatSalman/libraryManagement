package com.aistgroup.controller;

import com.aistgroup.entity.*;
import com.aistgroup.enums.BookStatusEnum;
import com.aistgroup.form.BookForum;
import com.aistgroup.form.BookReservationForum;
import com.aistgroup.security.MySessionInfo;
import com.aistgroup.service.inter.AdminUserActionServiceInter;
import com.aistgroup.service.inter.BookReservationServiceInter;
import com.aistgroup.service.inter.BookServiceInter;
import com.aistgroup.service.inter.BookStatusServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping
public class BookReservationController {


    java.sql.Date currentDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());

    @Autowired
    private MySessionInfo mySessionInfo;

    @Autowired
    private BookReservationServiceInter bookReservationServiceInter;

    @Autowired
    private BookServiceInter bookServiceInter;

    @Autowired
    private BookStatusServiceInter bookStatusServiceInter;

    @Autowired
    private AdminUserActionServiceInter adminUserActionServiceInter;

    @RequestMapping(method = RequestMethod.GET, value="/userDashboard/user/reservations")
    public ModelAndView indexM(){

        ModelAndView mv = new ModelAndView("userBookReservation");
        User user=mySessionInfo.getCurrentUser();

        List<BookReservation> bookReservationList=bookReservationServiceInter.getBookReservationByUserId(user.getId());

        mv.addObject("bookReservObj",bookReservationList);
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value="/adminDashboard/booking/list")
    public ModelAndView indexBookReservationListOfAllPeople(){

        ModelAndView mv = new ModelAndView("allReservations");
        User admin=mySessionInfo.getCurrentUser();

        List<BookReservation> bookReservationList=bookReservationServiceInter.getAll();


        mv.addObject("bookReservObj",bookReservationList);
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/userDashboard/user/book/reserve/dismiss")
    public ModelAndView indexUserDeleteOrder(
            @RequestParam(name ="id",required = false) Integer id,
            @ModelAttribute("bookReservationForum") BookReservationForum bookReservationForum)
    {
        User user=mySessionInfo.getCurrentUser();
        ModelAndView mv=new ModelAndView("userBookReservation");

        //Book Reservation was deleted
        BookReservation bkReservation=bookReservationServiceInter.getBookReservationById(id);
        bookReservationServiceInter.removeBookReservation(id);

        //Book status was changed from Reserved to Available

        Book book=bookServiceInter.getById(bkReservation.getBookId().getId());
        BookStatus bkStatus=bookStatusServiceInter.getById(BookStatusEnum.AVAILABLE.getValue());
        book.setBookStatusId(bkStatus);
        bookServiceInter.updateBook(book);

        List<BookReservation> bkReservationList=bookReservationServiceInter.getBookReservationByUserId(user.getId());
        mv.addObject("bookReservObj",bkReservationList);

        return mv;
    }


    @RequestMapping(method = RequestMethod.POST, path = "/adminDashboard/admin/dismiss/order")
    public ModelAndView indexAdminDeleteOrder(
            @RequestParam(name ="id",required = false) Integer id,
            @ModelAttribute("bookReservationForum") BookReservationForum bookReservationForum)
    {
        ModelAndView mv=new ModelAndView("allReservations");

        //Book Reservation was deleted
        BookReservation bkReservation=bookReservationServiceInter.getBookReservationById(id);
        bookReservationServiceInter.removeBookReservation(id);

        //Book status was changed from Reserved to Available

        Book book=bookServiceInter.getById(bkReservation.getBookId().getId());
        BookStatus bkStatus=bookStatusServiceInter.getById(BookStatusEnum.AVAILABLE.getValue());
        book.setBookStatusId(bkStatus);
        bookServiceInter.updateBook(book);

        List<BookReservation> bkReservationList=bookReservationServiceInter.getAll();
        mv.addObject("bookReservObj",bkReservationList);

        return mv;
    }


    @RequestMapping(method = RequestMethod.POST, path = "/adminDashboard/admin/approve/order")
    public ModelAndView indexAdminApprovedOrder(
            @RequestParam(name ="id",required = false) Integer id,
            @ModelAttribute("bookReservationForum") BookReservationForum bookReservationForum)
    {
        ModelAndView mv=new ModelAndView("allReservations");


        User admin= mySessionInfo.getCurrentUser();
        BookReservation bkReservation=bookReservationServiceInter.getBookReservationById(id);
        //Book Reservation was deleted
        bookReservationServiceInter.removeBookReservation(id);

        AdminUserAction adminUserAction=new AdminUserAction();
        adminUserAction.setAdminId(admin);
        adminUserAction.setUserId(bkReservation.getUserId());
        adminUserAction.setBookId(bkReservation.getBookId());
        adminUserAction.setTakenDate(currentDate);
        adminUserAction.setVisible((short) 1);//1 equals true

        //Book status was changed from Reserved to Available
        Book book=bookServiceInter.getById(bkReservation.getBookId().getId());
        BookStatus bkStatus=bookStatusServiceInter.getById(BookStatusEnum.TAKEN.getValue());
        book.setBookStatusId(bkStatus);
        bookServiceInter.updateBook(book);

        //book details was filled
        adminUserActionServiceInter.addAdminUserAction(adminUserAction);

        List<BookReservation> bkReservationList=bookReservationServiceInter.getAll();
        mv.addObject("bookReservObj",bkReservationList);

        return mv;
    }

    @ModelAttribute("bookReservationForum")
    public BookReservationForum getEmptyBookReservationForm(){
        return new BookReservationForum(null,null,null,null);
    }
}
