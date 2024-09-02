import java.util.Date;

public class Block {
    public String hash;
    public String previousHash;
    public String Data;
    public long timeStamp;

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
}
