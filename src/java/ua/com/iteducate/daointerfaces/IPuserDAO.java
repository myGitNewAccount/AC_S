/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.daointerfaces;

import ua.com.iteducate.entities.*;

/**
 *
 * @author Anton
 */
public interface IPuserDAO {
    public int insertUser(String name, String surname, String patronymic, String password);
    public boolean deleteUser(int id);
    public boolean updateUser(int id, String...namefields);
    public Puser selectUser(int id);
}
