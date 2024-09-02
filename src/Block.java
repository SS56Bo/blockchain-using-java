import java.util.Date;

public class Block {
    public String hash;
    public String previousHash;
    public String Data;
    public long timeStamp;
    public int Nonce;

    public Block(String prevHash, String dataF){
        this.previousHash=prevHash;
        this.Data=dataF;
        this.timeStamp = new Date().getTime();
        this.hash=CalculateHash();
    }

    public String CalculateHash(){
        String calcHash = EncryptStuff.applySHA256(previousHash+Long.toString(timeStamp)+Data);
        return calcHash;
    }

    public void mineBlock(int difficulty){
        //create a string with difficulty
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!hash.substring(0, difficulty).equals(target)){
            Nonce++;
            hash=CalculateHash();
        }
        System.out.println("Block Mined! : " + hash);
    }
}
