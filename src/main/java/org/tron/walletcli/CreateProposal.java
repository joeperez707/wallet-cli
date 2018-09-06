package org.tron.walletcli;

import java.io.File;
import java.io.IOException;
import org.bouncycastle.util.encoders.Hex;
import org.tron.core.exception.CancelException;
import org.tron.core.exception.CipherException;

public class CreateProposal {

  private WalletApiWrapper walletApiWrapper = new WalletApiWrapper();

  public void input(String str) {

  }

  public void autoLogout() {
    walletApiWrapper.logout();
  }

  public boolean autoApproveProposal() throws IOException, CipherException, CancelException {
    return walletApiWrapper.approveProposal(1, true);
  }

  public boolean autoLogin(String pass) throws IOException, CipherException {
    return walletApiWrapper.login(pass.toCharArray());
  }

  public void autoImportWallet(String pass, String prikey) throws CipherException, IOException {
    walletApiWrapper.importWallet(pass.toCharArray(), Hex.decode(prikey));
  }

  public void deleteDir(File dir){
    File[] files = dir.listFiles();
    for(File file : files ){
      if(file.isDirectory()){
        deleteDir(file);
      }else{
        file.delete();
      }
    }
    dir.delete();
  }

  public static void main(String[] args) throws CipherException, IOException, CancelException {
    CreateProposal c = new CreateProposal();
    String walletPath = "/Users/ashu/jproject/wallet-cli/Wallet";
    String []priKeys = {
        "e901ef62b241b6f1577fd6ea34ef8b1c4b3ddee1e3c051b9e63f5ff729ad47a1",
        "3a54ba30e3ee41b602eca8fb3a3ca1f99f49a3d3ab5d8d646a2ccdd3ffd9c21d",
        "af7c83e40cc67a355852b44051fc9e34452375ae569d5c18dd62e3859b9be229",
        "8e3edc3c34c6355cd1b2f0f11a672cddca4468da933813e052e38c93a971798a",
        "7b0b316f60cf3954f0c54c292001f6b59f4a80328a04feafef539f0824ba5078",
        "6ad99dfa554cb3bf424c0dcc6ba639808e1d67073788025e217386e60696bb10",
        "ba332373f31b239d03bfdf8783ca494dd2096c3e7e317cde4ba2e04eda2a97a2",
        "02446d70550a214d04d5216107b0785c542539301fe9d99ba6cbb3a376e6df98",
        "88c2e773e62dd57eee9498395b0d8fe3e05c9b5aafae148296fdcfd79dfb092c",
        "76410f5da07ba4e407ebeb4d7c2f1f88eb1220efe9e708e4edc7a3cadca63e5a",
        "82581d097f9e6e2394f1998de299479ce78f2a0a1bcc7bc59db98572700cbbc3",
        "0ce7b3d3b866adb331d55a67a7295206663b9370d60a78173d85e70e7fc8ec4e",
        "ecabff8ebb7b2fe13779c1673474fe46a8d995cacf170b36022b77bbfb4bf387",
        "398cd3ec0b55fba63c498ea9278586fe05361cd9ded844f17911ca68ee1bea53",
        "e6a2542ef6c55d5cf5d83891e5509dd21d154d26e1865616e89014d0655faec2",
        "42f7dac23dc1812897f9dc60b34bde381140f81c743c4b05c34fa90fb76b0319",
        "ebbc3284cf53602072680937d2b4f04a45f65565e31c6f718758cb1ae5c5a15f",
        "e0a3ba8df5f3cbd5372d1f97707080dd073acff7e77b4ce6e72f5c33c1ba7226",
        "89f81bc806542afbb37707c358cae145c5dc6237d696726042fd887bfd0eca25",
        "8bd4492922735f615e7b8c784d09a9f6a372bc53b82ba837bf33a0705e75d52d",
        "f6762cff57dcb276de3fa47892395c09b84812c49ad057b64c8fd672f11d167e",
        "aa298c95ba9887f1aa39f0b933fe798a2f3215fc15d48c1107ed8727c1eeedea",
        "5466eeb4565e5f07251d734d5f0d59af2163ad042c35cb9b1031abc8128db402",
        "3180d25af634b051a1590250effc892d41cbd5bb0c7978e85359500535d08c08",
        "b0fed61340c9e0d231ecc3aae81035a2ae2fe9b4e92f1e0dea7cea8f059ba1df",
        "40fa7d72f45e288c6812388b990a7f5f6d4b6f2e9c2f30c32bd17d8f289a8999"
    };

//    approveProposal 1 true
    File f1 = new File(walletPath);
    if (f1.isFile() || f1.isDirectory()) {
      c.deleteDir(f1);
/**/
    }
    int count = 0;
    for (String pri : priKeys) {
      c.autoImportWallet("Aashu123", pri);
      System.out.println("import");
      c.autoLogin("Aashu123" );

      c.autoApproveProposal();
//      c.autoLogout();
      System.out.println("cnt:" + count++);
      File f = new File(walletPath);
      c.deleteDir(f);
    }
  }
}
