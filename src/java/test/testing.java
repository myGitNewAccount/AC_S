/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import java.util.Arrays;
import org.ethereum.core.Transaction;
import org.spongycastle.util.encoders.Hex;
import static org.ethereum.util.ByteUtil.longToBytesNoLeadZeroes;
import org.ethereum.util.blockchain.ApplicationBlockchain;
import ua.com.iteducate.daofactory.DAOFactory;
import ua.com.iteducate.entities.Puser;


/**
 *
 * @author anbo1015
 */
public class testing {
    
    public static void main(String[] args) {

        byte[] gasPrice = longToBytesNoLeadZeroes(1_000_000_000_000L);
        byte[] gasLimit = longToBytesNoLeadZeroes(21000);

        byte[] toAddress = Hex.decode("9f598824ffa7068c1f2543f04efb58b6993db933");
        byte[] value = longToBytesNoLeadZeroes(10_000);
        
        String d = "{1,2,3}";
        
        Transaction tx = new Transaction(longToBytesNoLeadZeroes(1),
                gasPrice,
                gasLimit,
                toAddress,
                d.getBytes(),
                null);
        
        System.out.println(Arrays.toString(d.getBytes()));
        System.out.println(Arrays.toString(tx.getValue()));
        
    }
    
}
