package com.aistgroup.controller;


import com.aistgroup.entity.Book;
import com.aistgroup.entity.BookReservation;
import com.aistgroup.entity.BookStatus;
import com.aistgroup.entity.User;
import com.aistgroup.enums.BookStatusEnum;
import com.aistgroup.form.BookForum;
import com.aistgroup.form.BookReservationForum;
import com.aistgroup.security.MySessionInfo;
import com.aistgroup.service.inter.BookReservationServiceInter;
import com.aistgroup.service.inter.BookServiceInter;
import com.aistgroup.service.inter.BookStatusServiceInter;
import com.aistgroup.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping
public class BookController {

    java.sql.Date currentDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());

    @Autowired
    private MySessionInfo mySessionInfo;

    @Autowired
    private BookServiceInter bookServiceInter;

    @Autowired
    private BookReservationServiceInter bookReservationServiceInter;

    @Autowired
    private UserServiceInter userServiceInter;

    @Autowired
    private BookStatusServiceInter bookStatusServiceInter;


    @RequestMapping(method = RequestMethod.GET, value="/userDashboard/bookSearch")
    public ModelAndView indexM(@ModelAttribute("book") BookForum book){
        List<Book> bookList=null;

        ModelAndView mv = new ModelAndView("userDashboard");

        if(book!=null){
            bookList=bookServiceInter.getByPartOfName(book.getName());
        }

        mv.addObject("bookObj",bookList);
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value="adminDashboard/bookSearch")
    public ModelAndView indexAdminBookSearch(@ModelAttribute("book") BookForum book){
        List<Book> bookList=null;

        ModelAndView mv = new ModelAndView("adminDashboard");

        if(book!=null){
            bookList=bookServiceInter.getByPartOfName(book.getName());
        }

        mv.addObject("bookObj",bookList);
        return mv;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/userDashboard/user/reserve/book")
    public String indexUserReserveBook(
            @RequestParam(name ="id",required = false) Integer id,
            @ModelAttribute("book") BookForum book
    ){

        Book bookObj=bookServiceInter.getById(id);
        if(bookObj.getBookStatusId().getId()==BookStatusEnum.AVAILABLE.getValue()){

            BookReservation bkReservation=new BookReservation();
            User user=mySessionInfo.getCurrentUser();

            bkReservation.setUserId(user);
            bkReservation.setBookId(bookObj);
            bkReservation.setVisible((short) 1);// 1 equals to true

            bkReservation.setDate(currentDate);

            //Book Reservation table was filled
            bookReservationServiceInter.addBookReservation(bkReservation);

            //Book status was changed from Available to Reserved
            BookStatus bkStatus=bookStatusServiceInter.getById(BookStatusEnum.RESERVED.getValue());
            bookObj.setBookStatusId(bkStatus);
            bookServiceInter.updateBook(bookObj);
        }

        return "userDashboard";
    }



}
