package errdiffuse;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ToGrayscale {
      
      public ToGrayscale(){
            
      }
      
      public static void cvtGray(){
            BufferedImage img = null;
            File f = null;
            
            //read image
            try{
            f = new File("S:\\Download\\Document\\CSCU y3\\OS\\ErrDiffuse\\src\\pics\\spaceship.jpg");
            img = ImageIO.read(f);
            }catch(IOException e){
                  System.out.println(e);
            }
            
            //get width and height
            int width = img.getWidth();
            int height = img.getHeight();
            
            //convert to grayscale
            for(int x = 0; x<height; x++){
                  for(int y = 0; y<width; y++){
                        int px = img.getRGB(y, x);
                        int a = (px>>24)&0xff;
                        int r = (px>>16)&0xff;
                        int g = (px>>8)&0xff;
                        int b = px&0xff;
                        
                        //calculate average of RGB
                        int avg = (r+g+b)/3;
                        
                        //replace RGB value with avg
                        px = (a<<24) | (avg<<16) | (avg<<8) | avg;
                        img.setRGB(y, x, px);
                        //System.out.println(px&0xff);
                  }
            }
            
            //write image
            try{
                  f = new File("S:\\Download\\Document\\CSCU y3\\OS\\ErrDiffuse\\src\\pics\\spaceshipgray.jpg");
                  ImageIO.write(img, "jpg", f);
            }catch(IOException e){
                  System.out.println(e);
            }
      }
      
}
