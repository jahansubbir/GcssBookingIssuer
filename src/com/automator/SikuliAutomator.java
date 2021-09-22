package com.automator;

import java.util.LinkedList;

import com.models.Bl;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

public class SikuliAutomator extends Robot {
    Screen screen;

    public SikuliAutomator() {
        super();

        screen = new Screen();

    }

    public void printBls(LinkedList<Bl> bls) {
     try {
            for (Bl bl : bls) {
               screen.wait(pendingTray,2).click();
               
               //screen.wait(2);
               screen.type("o",Key.CTRL);
               //screen.wait(4);
               screen.type(bl.getBlNo().substring(0, 9));
               //screen.wait(3);
               screen.type(Key.TAB);
               screen.type(Key.ENTER);
              // screen.wait(openOk,9);
               if(screen.exists(validationFailed,5)!=null){
                   screen.wait(invalidOk,4).click();
                   screen.wait(2);
                   screen.wait(cancel,5).click();
               }else{
                   if(screen.exists(issue.exact(),2)!=null){
                       screen.wait(issue,3).click();
                //       screen.wait(2);
                       if(screen.exists(issueOk,2)!=null){
                           screen.wait(issueOk,2).click();
                       }
                   }
               }
               screen.wait(file,2).click();
               screen.wait (close).click();

            }
        } catch (FindFailed findFailed) {

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
