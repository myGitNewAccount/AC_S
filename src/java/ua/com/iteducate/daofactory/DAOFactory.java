/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.daofactory;

import ua.com.iteducate.dao.*;

/**
 *
 * @author Anton
 */
public class DAOFactory {

    public static PuserDAO getPuserDAO(){
        return new PuserDAO();
    }
}
