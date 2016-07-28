
package org.ethereum.util.blockchain;

import com.google.common.primitives.Longs;
import static java.lang.Math.pow;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javafx.util.Pair;
import org.ethereum.core.Block;
import org.ethereum.core.Blockchain;
import org.ethereum.core.Genesis;
import org.ethereum.core.Transaction;
import org.ethereum.crypto.ECKey;
import org.ethereum.datasource.HashMapDB;
import org.ethereum.db.IndexedBlockStore;
import static org.ethereum.util.ByteUtil.longToBytesNoLeadZeroes;
import org.spongycastle.util.encoders.Hex;


public class ApplicationBlockchain {

    private Block genesis;
    private byte[] coinbase;
    private ECKey txSender;
    private long gasPrice;
    private long gasLimit;
    private boolean autoBlock;
    private ArrayList<Transaction> unblockedTxs;
    private List<Pair<byte[], BigInteger>> initialBallances;
    private IndexedBlockStore blockstore;
    
    public ApplicationBlockchain() {
        
        coinbase = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gasPrice = 1;
        gasLimit = 1000000;
        autoBlock = false;
        initialBallances = new ArrayList<>();
        blockstore = new IndexedBlockStore();
        blockstore.init(new HashMapDB(), new HashMapDB());
        unblockedTxs = new ArrayList<>();

        byte[] parentHash = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        byte[] unclesHash = new byte[]{29, -52, 77, -24, -34, -57, 93, 122, -85, -123, -75, 103, -74, -52, -44, 26, -45, 18, 69, 27, -108, -118, 116, 19, -16, -95, 66, -3, 64, -44, -109, 71};
        byte[] coinbasegen = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        byte[] logbloom = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        byte[] difficulty = new byte[]{0, 0, 0, 0, 0, 0, 0, 1};
        byte[] gaslimitBytes = new byte[]{16, 0, 0, 0, 0};
        long number = 0;
        long gasused = 0;
        long timestamp = 0;
        byte[] extradata = new byte[]{17, -69, -24, -37, 78, 52, 123, 78, -116, -109, 124, 28, -125, 112, -28, -75, -19, 51, -83, -77, -37, 105, -53, -37, 122, 56, -31, -27, 11, 27, -126, -6};
        byte[] mixhash = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        byte[] nonce = new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
        genesis = new Block(parentHash, 
                            unclesHash, 
                            coinbasegen, 
                            logbloom,
                            difficulty,
                            number,
                            gaslimitBytes,
                            gasused,
                            timestamp,
                            extradata,
                            mixhash,
                            nonce,
                            null,
                            null);
        blockstore.saveBlock(genesis, genesis.getCumulativeDifficulty(), true);
    }
    
    public ApplicationBlockchain withGenesis (Genesis genesis) {
        this.genesis = genesis;
        return this;
    }
    
    public Block createBlock() {
        if(unblockedTxs.isEmpty()){
            return null;
        }
        else{
            Random RANDOM = new SecureRandom();
            byte[] unclesHash = new byte[]{29, -52, 77, -24, -34, -57, 93, 122, -85, -123, -75, 103, -74, -52, -44, 26, -45, 18, 69, 27, -108, -118, 116, 19, -16, -95, 66, -3, 64, -44, -109, 71};
            byte[] coinbasegen = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            byte[] logbloom = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            byte[] gaslimitBytes = new byte[]{16, 0, 0, 0, 0};
            long gasused = 0;
            byte[] extradata = new byte[]{17, -69, -24, -37, 78, 52, 123, 78, -116, -109, 124, 28, -125, 112, -28, -75, -19, 51, -83, -77, -37, 105, -53, -37, 122, 56, -31, -27, 11, 27, -126, -6};
            byte[] mixhash = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            byte[] nonce = new byte[]{0, 0, 0, 0, 0, 0, 0, 1};
            RANDOM.nextBytes(nonce);
            byte[] stateSys = new byte[32]; 
            RANDOM.nextBytes(stateSys);
            byte[] stateTx = new byte[32]; 
            RANDOM.nextBytes(stateTx);
            byte[] stateRcp = new byte[32]; 
            RANDOM.nextBytes(stateRcp);
            
            Block newBlock = null; 
            
            while(newBlock == null || pow(Longs.fromByteArray(newBlock.getHeader().getEncodedWithoutNonce()),
            Longs.fromByteArray(nonce)) > pow(2, 256) / Longs.fromByteArray(blockstore.getBestBlock().getDifficulty())){
                RANDOM.nextBytes(nonce);
                RANDOM.nextBytes(mixhash);
                newBlock = new Block(blockstore.getBestBlock().getHash(),
                                     unclesHash,
                                     coinbasegen,
                                     logbloom,
                                     blockstore.getBestBlock().getDifficulty(),
                                     blockstore.getBestBlock().getNumber() + 1,
                                     gaslimitBytes,
                                     gasused,
                                     System.currentTimeMillis() / 1000,
                                     extradata,
                                     mixhash,
                                     nonce,
                                     stateRcp,
                                     stateTx,
                                     stateSys,
                                     unblockedTxs,
                                     null);
            };
            
            blockstore.saveBlock(newBlock, newBlock.getCumulativeDifficulty(), true);
            this.unblockedTxs = new ArrayList<>();
            return newBlock;
        }
    }
    
    public void addTransaction(Transaction tx){
        unblockedTxs.add(tx);
    }

    public ArrayList<Transaction> getAllTransactions() {
        ArrayList<Transaction> allTxs = new ArrayList<>();
        for(int i = 0; i <= blockstore.getMaxNumber(); i++){
            allTxs.addAll(blockstore.getChainBlockByNumber(i).getTransactionsList());
        }
        return allTxs;
    }

    public void setSender(ECKey eckey) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void sendEther(byte[] bytes, BigInteger bi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public IndexedBlockStore getBlockStorage() {
        return this.blockstore;
    }

    
}
