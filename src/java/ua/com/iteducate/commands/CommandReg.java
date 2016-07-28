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

/**
 *
 * @author Anton
 */
public class CommandReg implements ICommand {

    private static final String NAME = "username";
    private static final String PASSWORD = "password";
    private static final String SURNAME = "usersurname";
    private static final String PATRONYMIC = "userpatronymic";
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        String page = null;
        String name = request.getParameter(NAME);
        String password = request.getParameter(PASSWORD);
        String surname = request.getParameter(SURNAME);
        String patronymic = request.getParameter(PATRONYMIC);

        if (DAOFactory.getPuserDAO().selectUser(name, password) == null && DAOFactory.getPuserDAO().insertUser(name, surname, patronymic, password) != -1) {
            request.setAttribute("name", name);
            page = Config.getInstance().getProperty(Config.LOGIN);
        } else {
            request.setAttribute("error", Message.getInstance().getProperty(Message.REG_ERROR));
            page = Config.getInstance().getProperty(Config.ERROR);
        }

        return page;
    }
}
