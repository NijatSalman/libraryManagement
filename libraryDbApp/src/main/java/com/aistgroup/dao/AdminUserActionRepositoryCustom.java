package com.aistgroup.dao;


import com.aistgroup.entity.AdminUserAction;
import com.aistgroup.entity.BookReservation;

import java.util.List;

public interface AdminUserActionRepositoryCustom {

    public List<AdminUserAction> getAll();

    public AdminUserAction getAdminUserActionById(int id);

    public List<AdminUserAction> getAdminUserActionByUserId(int id);

    public List<AdminUserAction> getAdminUserActionByBookId(int id);

    public  List<AdminUserAction> getAdminUserActionByAdminId(int id);

    public boolean addAdminUserAction(AdminUserAction adminUserAction);

    public boolean updateAdminUserAction(AdminUserAction adminUserAction);

    public boolean visibleAdminUserAction(AdminUserAction adminUserAction);

    public boolean removeAdminUserAction(int id);

}
