import java.util.ArrayList;

import com.google.gson.GsonBuilder;

public class App {

    public static ArrayList<Block> blockchain = new ArrayList<>();
    public static void main(String[] args) {
        blockchain.add(new Block("0", "HI, from Coolchain"));
        blockchain.add(new Block(blockchain.get(blockchain.size()-1).hash, "HI! Coolio!"));
        blockchain.add(new Block(blockchain.get(blockchain.size()-1).hash, "SOHAM created me"));
        blockchain.add(new Block(blockchain.get(blockchain.size()-1).hash, "Coolio"));

        String blockChainJSON = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockChainJSON);
    }    
}