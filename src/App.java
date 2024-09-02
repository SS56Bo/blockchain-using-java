import java.util.ArrayList;

import com.google.gson.GsonBuilder;

public class App {

    public static ArrayList<Block> blockchain = new ArrayList<>();
    public static int difficulty = 2;
    public static void main(String[] args) {
        blockchain.add(new Block("0", "HI, from Coolchain"));
        System.out.println("Mining block 1........");
        blockchain.get(0).mineBlock(difficulty);

        blockchain.add(new Block(blockchain.get(blockchain.size()-1).hash, "HI! Coolio!"));
        System.out.println("Mining block 2........");
        blockchain.get(1).mineBlock(difficulty);

        blockchain.add(new Block(blockchain.get(blockchain.size()-1).hash, "SOHAM created me"));
        System.out.println("Mining block 3........");
        blockchain.get(2).mineBlock(difficulty);

        blockchain.add(new Block(blockchain.get(blockchain.size()-1).hash, "Coolio"));
        System.out.println("Mining block 4........");
        blockchain.get(3).mineBlock(difficulty);

        blockchain.add(new Block(blockchain.get(blockchain.size()-1).hash, "Micheal Scott"));
        System.out.println("Mining block 1........");
        blockchain.get(4).mineBlock(difficulty);


        String blockChainJSON = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockChainJSON);
    }    

    public static Boolean isValidChain(){
        Block currentBlock;
        Block previousBlock;

        //loop through each blocks 
        for (int i=0; i<blockchain.size(); i++){
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);
            //compare calculated hash & registered hash
            if(!currentBlock.hash.equals(currentBlock.CalculateHash())){
                System.out.println("Current hashes are not equal!");
                return false;
            } 
            if (!previousBlock.hash.equals(previousBlock.CalculateHash())){
                System.out.println("Previous hashes are not equal!");
                return false;
            }
        }
        return true;
    }
}