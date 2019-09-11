package errdiffuse;

import java.awt.Color;
import java.lang.Thread;

public class ErrorDiffusion implements Runnable {
      
      int n;
      ImageCanvas ic;
      Color cr;
      
      public ErrorDiffusion(ImageCanvas ic, int n){
            this.ic = ic;
            this.n = n;
      }
      
      @Override
      public void run(){
            int y = 1;
            while(y<=ic.getWidth()){
                  if(y==ic.getWidth()-1 || y==ic.getWidth()){
                        int px = ic.getPxVal(y, n);
                        int err;

                        // set Black(0) or White(255) and calculate error
                        if(px<128){
                              err = px;
                              ic.setPxVal(y, n, 0);
                              ic.setState(y, n, true);
                        }
                        else{
                              err = px - 255;
                              ic.setPxVal(y, n, 255);
                              ic.setState(y, n, true);
                        }

                        int err1 = (ic.getPxVal(y+1, n))+((err*7)/16);
                        int err2 = (ic.getPxVal(y, n+1))+((err*5)/16);
                        int err3 = (ic.getPxVal(y-1, n+1))+((err*3)/16);
                        int err4 = (ic.getPxVal(y+1, n+1))+((err*1)/16);
                        
                        ic.setPxVal(y+1, n, err1);
                        ic.setPxVal(y, n+1, err2);
                        ic.setPxVal(y-1, n+1, err3);
                        ic.setPxVal(y+1, n+1, err4);
                  }
                  else{
                        if(ic.getState(y+2, n-1)== true){
                              int px = ic.getPxVal(y, n);
                              int err;

                              // set Black(0) or White(255) and calculate error
                              if(px<128){
                                    err = px;
                                    ic.setPxVal(y, n, 0);
                                    ic.setState(y, n, true);
                              }
                              else{
                                    err = px - 255;
                                    ic.setPxVal(y, n, 255);
                                    ic.setState(y, n, true);
                              }

                              int err1 = (ic.getPxVal(y+1, n))+((err*7)/16);
                              int err2 = (ic.getPxVal(y, n+1))+((err*5)/16);
                              int err3 = (ic.getPxVal(y-1, n+1))+((err*3)/16);
                              int err4 = (ic.getPxVal(y+1, n+1))+((err*1)/16);

                              ic.setPxVal(y+1, n, err1);
                              ic.setPxVal(y, n+1, err2);
                              ic.setPxVal(y-1, n+1, err3);
                              ic.setPxVal(y+1, n+1, err4);
                        }
                        else{
                              y--;
                        }
                  }
                  y++;
            }
      }
}