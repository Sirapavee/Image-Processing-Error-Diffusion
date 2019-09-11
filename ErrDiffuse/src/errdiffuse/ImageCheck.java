package errdiffuse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImageCheck implements Runnable {
      ImageCheckRead main;
      ImageCheckRead two;
      ImageCheckRead three;
      ImageCheckRead four;
      int id;
      int count = 0;
      int totalPx;
      
      public ImageCheck(int id){
            this.id = id;
            
            try{
                  FileInputStream path1 = new FileInputStream("S:\\Download\\Document\\CSCU y3\\OS\\ErrDiffuse\\src\\pics\\viewbw1t.jpg");
                  FileInputStream path2 = new FileInputStream("S:\\Download\\Document\\CSCU y3\\OS\\ErrDiffuse\\src\\pics\\viewbw2t.jpg");
                  FileInputStream path3 = new FileInputStream("S:\\Download\\Document\\CSCU y3\\OS\\ErrDiffuse\\src\\pics\\viewbw3t.jpg");
                  FileInputStream path4 = new FileInputStream("S:\\Download\\Document\\CSCU y3\\OS\\ErrDiffuse\\src\\pics\\viewbw4t.jpg");
                  main = new ImageCheckRead(1, path1);
                  two = new ImageCheckRead(2, path2);
                  three = new ImageCheckRead(3, path3);
                  four = new ImageCheckRead(4, path4);
            }catch(FileNotFoundException e){
                  System.out.println(e);
            }
            
            main.readImage();
            
            totalPx = main.getHeight()*main.getWidth();
      }
      
      @Override
      public void run(){
            switch(id){
                  case 2 :
                        two.readImage();
                        for (int i = 0; i < main.getHeight(); i++) {
                              for (int j = 0; j < main.getWidth(); j++) {
                                    if(main.getPxVal(j, i)!=two.getPxVal(j, i)){
                                          //two.upCount();
                                          count++;
                                    }
                              }
                        }
                        System.out.println("Error of "+id+" threads from 1 thread is "+(count/totalPx)+"%");
                        break;
                  case 3 :
                        three.readImage();
                        for (int i = 0; i < main.getHeight(); i++) {
                              for (int j = 0; j < main.getWidth(); j++) {
                                    if(main.getPxVal(j, i)!=three.getPxVal(j, i)){
                                          //three.upCount();
                                          count++;
                                    }
                              }
                        }
                        System.out.println("Error of "+id+" threads from 1 thread is "+(count/totalPx)+"%");
                        break;
                  case 4 :
                        four.readImage();
                        for (int i = 0; i < main.getHeight(); i++) {
                              for (int j = 0; j < main.getWidth(); j++) {
                                    if(main.getPxVal(j, i)!=four.getPxVal(j, i)){
                                          //four.upCount();
                                          count++;
                                    }
                              }
                        }
                        System.out.println("Error of "+id+" threads from 1 thread is "+(count/totalPx)+"%");
                        break;
            }
      }
}
