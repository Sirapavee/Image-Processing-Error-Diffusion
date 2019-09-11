package errdiffuse;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageCheckRead {
      
      int[][] pixelArr;
      int width,height,id;
      FileInputStream path;
      int count;
      
      public ImageCheckRead(int id, FileInputStream path){
            this.id = id;
            this.path = path;
      }
      
      public void readImage(){
            BufferedImage img = null;
            
            //read image
            try{
                  img = ImageIO.read(path);
            }catch(IOException e){
                  System.out.println(e);
            }
            
            width = img.getWidth();
            height = img.getHeight();
            pixelArr = new int[width][height];
            
            //get pixel value into pixel array
            for(int y = 0; y<img.getHeight(); y++){
                  for(int x = 0; x<img.getWidth(); x++){
                        pixelArr[x][y] = img.getRGB(x, y)&0xff;
                  }
            }
      }
      
      public int getWidth(){
            return width;
      }
      public int getHeight(){
            return height;
      }
      public int getId(){
            return id;
      }
      public int getPxVal(int x, int y){
            return pixelArr[x][y];
      }
      public void upCount(){
            count++;
      }
      public int getCount(){
            return count;
      }
}
