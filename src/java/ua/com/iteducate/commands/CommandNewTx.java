
package ua.com.iteducate.commands;

import ua.com.iteducate.daofactory.DAOFactory;
import ua.com.iteducate.manager.Config;
import ua.com.iteducate.manager.Message;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.ethereum.core.Transaction;
import org.spongycastle.util.encoders.Hex;
import static org.ethereum.util.ByteUtil.longToBytesNoLeadZeroes;
import ua.com.iteducate.daofactory.AppSingleBlockchain;
import ua.com.iteducate.entities.Puser;

public class CommandNewTx implements ICommand {

    private static final String NAME = "username";
    private static final String PASSWORD = "password";

    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        String page = null;
        String name = request.getParameter(NAME);
        String password = request.getParameter(PASSWORD);
        Puser current = DAOFactory.getPuserDAO().selectUser(name, password);
        
        byte[] gasPrice = longToBytesNoLeadZeroes(1_000_000_000_000L);
        byte[] gasLimit = longToBytesNoLeadZeroes(21000);
        byte[] toAddress = Hex.decode("9f598824ffa7068c1f2543f04efb58b6993db933");

        Transaction tx = new Transaction(
                longToBytesNoLeadZeroes(1),
                gasPrice,
                gasLimit,
                toAddress,
                current.getEC().getBytes(),
                null);
        
        AppSingleBlockchain.credentialsGroup.addTransaction(tx, AppSingleBlockchain.bc);
        ArrayList<Transaction> userReq = AppSingleBlockchain.credentialsGroup.getUserTxs(current);
        
        if (DAOFactory.getPuserDAO().selectUser(name, password) != null) {
            HttpSession se = request.getSession(true);
            se.setMaxInactiveInterval(60*60);
            se.setAttribute("user", current);
            request.setAttribute("username", name);
            request.setAttribute("password", password);
            request.setAttribute("txscount", userReq.size());
            request.setAttribute("myreq", userReq);
            request.setAttribute("blocksamount", AppSingleBlockchain.bc.getBlockStorage().getBestBlock().getNumber() + 1);
            request.setAttribute("bestblock", AppSingleBlockchain.bc.getBlockStorage().getBestBlock().toString());
            request.setAttribute("mID", current.getMembershipID());
            page = Config.getInstance().getProperty(Config.CABINET);
        } else {
            request.setAttribute("error", Message.getInstance().getProperty(Message.LOGIN_ERROR));
            page = Config.getInstance().getProperty(Config.ERROR);
        }

        return page;
    }
}
