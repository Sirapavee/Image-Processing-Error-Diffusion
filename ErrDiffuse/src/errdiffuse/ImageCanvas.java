package errdiffuse;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ImageCanvas {
      volatile boolean[][] stateArr = new boolean[15001][15001];
      volatile int[][] pixelArr = new int[15001][15001];
      int width,height;
      
      public ImageCanvas(){
            
      }
      
      public void init(){
            for(int j = 0; j<stateArr.length; j++){
                  for(int i = 0; i<stateArr.length; i++){
                        if(j == 0){
                              stateArr[i][j] = true;
                        }
                  }
            }
      }
      
      public void readImage(){
            BufferedImage img = null;
            File f = null;
            
            //read image
            try{
                  f = new File("S:\\Download\\Document\\CSCU y3\\OS\\ErrDiffuse\\src\\pics\\usagray.jpg");
                  img = ImageIO.read(f);
            }catch(IOException e){
                  System.out.println(e);
            }
            
            width = img.getWidth();
            height = img.getHeight();
            
            //get pixel value into pixel array
            for(int y = 0; y<img.getHeight(); y++){
                  for(int x = 0; x<img.getWidth(); x++){
                        pixelArr[x+1][y+1] = img.getRGB(x, y);
                  }
            }
      }
      
      public void createImage(){
            BufferedImage newImg = null;
            File f = null;
            
            try{
                  newImg = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_INDEXED);
                  
                  //apply rgb
                  Color cr;
                  for(int y = 0; y<height; y++){
                        for(int x = 0; x<width; x++){
                              int pxVal = pixelArr[x+1][y+1];
                              if(pxVal<0 || pxVal>255){
                                    if(pxVal < 0){
                                          pxVal = 0;
                                    }
                                    else if(pxVal > 255){
                                          pxVal = 255;
                                    }
                              }
                              cr = new Color(pxVal, pxVal, pxVal);
                              newImg.setRGB(x, y, cr.getRGB());
                        }
                  }
                  
                  //write image
                  f = new File("S:\\Download\\Document\\CSCU y3\\OS\\ErrDiffuse\\src\\pics\\out.jpg");
                  ImageIO.write(newImg, "jpg", f);
                  System.out.println("Finished!");
            }catch(IOException e){
                  System.out.println(e);
            }
      }
      
      public int getPxVal(int x, int y){
            return pixelArr[x][y];
      }
      public void setPxVal(int x, int y, int val){
            pixelArr[x][y] = val;
      }
      
      public boolean getState(int x, int y){
            return stateArr[x][y];
      }
      public void setState(int x, int y, boolean b){
            stateArr[x][y] = b;
      }
      
      public int getWidth(){
            return width;
      }
      public int getHeight(){
            return height;
      }
      
      public int[][] getPixelArr(){
            return pixelArr;
      }
      public boolean[][] getStateArr(){
            return stateArr;
      }
}
