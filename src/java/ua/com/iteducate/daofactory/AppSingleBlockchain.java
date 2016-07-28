/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.daofactory;

import org.ethereum.util.blockchain.ApplicationBlockchain;
import ua.com.iteducate.entities.Membership;

/**
 *
 * @author anbo1015
 */
public class AppSingleBlockchain {
    
    public static ApplicationBlockchain bc = new ApplicationBlockchain();
    public static Membership credentialsGroup = new Membership();

}
