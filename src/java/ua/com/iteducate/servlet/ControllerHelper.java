/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.servlet;

import ua.com.iteducate.commands.CommandMissing;
import ua.com.iteducate.commands.ICommand;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import ua.com.iteducate.commands.*;

/**
 *
 * @author Anton
 */
public class ControllerHelper {

    private static ControllerHelper instance = null;
    HashMap<String, ICommand> commands = new HashMap<String, ICommand>();

    public ControllerHelper() {
        commands.put("reg", new CommandReg());
        commands.put("login", new CommandLogin());
        commands.put("newtx", new CommandNewTx());
        commands.put("logout", new CommandLogout());
        commands.put("apprtx", new CommandApprTx());
    }

    public ICommand getCommand(HttpServletRequest request) {
        ICommand command = commands.get(request.getParameter("command"));
        if (command == null) {
            command = new CommandMissing();
        }
        return command;
    }

    public static ControllerHelper getInstance() {
        if (instance == null) {
            instance = new ControllerHelper();
        }
        return instance;
    }
}
