import java.io.FileNotFoundException;
import java.util.Scanner;

public class BondsCode {
    private String bondCode;
    private int codeLen;
    private DictionaryLoader dictLoader;
    private Scanner scanner;

    public BondsCode() throws FileNotFoundException {
        scanner = new Scanner(System.in);
        scanBondCode();
        dictLoader = new DictionaryLoader();
    }

    public void scanBondCode(){
        chosen = false;
        System.out.println("\nBond code to MI6:");
        bondCode = scanner.nextLine();
        bondCode = bondCode.toLowerCase();
        codeLen = bondCode.length();
    }

    public int getCodeLen() {
        return codeLen;
    }

    static boolean chosen = false;

    void searchForValid(int from, int to){
        if (from==to || to==codeLen+1) return;

        if (chosen) return;

        if (isValidWord(bondCode.substring(from, to))){
            searchForValid(from, to+1);
            if (chosen){
                return;
            }
            System.out.print(bondCode.substring(from, to) + " ");
            if (to == codeLen){
                chosen = true;
            }
            searchForValid(to, to+1);
        }else {
            searchForValid(from, to+1);
        }
    }

    boolean isValidWord(String word){
        return dictLoader.contains(word);
    }

}
