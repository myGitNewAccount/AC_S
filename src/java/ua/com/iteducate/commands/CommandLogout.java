/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.commands;

import ua.com.iteducate.daofactory.DAOFactory;
import ua.com.iteducate.manager.Config;
import ua.com.iteducate.manager.Message;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Anton
 */
public class CommandLogout implements ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        String page = null;
        HttpSession se = request.getSession();
        se.invalidate();
        page = Config.getInstance().getProperty(Config.LOGIN);
        return page;
    }
}
