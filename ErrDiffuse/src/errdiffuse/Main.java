package errdiffuse;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

      public static void main(String[] args) {
            //ToGrayscale.cvtGray();
            //Error Diffusion section
            /*System.out.println("Preparing Image . . .");
            ExecutorService executor = Executors.newFixedThreadPool(1);
            ImageCanvas ic = new ImageCanvas();
            ic.readImage();
            ic.init();
            
            System.out.println("Initiate Error Diffusion . . .");
            //error diffusing
            for(int i = 1; i<=ic.getHeight(); i++){
                  ErrorDiffusion ed = new ErrorDiffusion(ic, i);
                  //prepare queue
                  executor.execute(ed);
            }
            //initiate
            executor.shutdown();
            //wait for it
            try{
                  if(executor.awaitTermination(1, TimeUnit.DAYS)){
                        ic.createImage();
                  }
            }catch(InterruptedException e){
                              System.out.println(e);
            }*/
            
            //Error checking section
            ExecutorService exe = Executors.newFixedThreadPool(3);
            for(int i = 2;i<=4;i++){
                  ImageCheck chk = new ImageCheck(i);
                  exe.execute(chk);
            }
            exe.shutdown();
      }
}