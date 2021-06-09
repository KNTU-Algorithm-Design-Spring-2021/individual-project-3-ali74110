import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        BondsCode bondsCode = new BondsCode();
        bondsCode.searchForValid(0, 1);

        while (bondsCode.getCodeLen()!=0){
            bondsCode.scanBondCode();
            bondsCode.searchForValid(0, 1);
        }
    }
}
