/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remainder.ui;

import remainder.model.Remainder;
import remainder.model.Status;
import com.sun.jndi.toolkit.url.Uri;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Narayan G. Maharjan &lt;me@ngopal.com.np&gt;
 */
public class RemindNotification {
    public RemindNotification(final Remainder remainder) throws InterruptedException {

        System.out.println("remind date : " + remainder.getRemindDate());
        ExecutorService service = Executors.newFixedThreadPool(10);
        if (remainder.getStatus() == Status.REMIND_ON) {
            service.execute(new Runnable() {
                public void run() {
                    try {
                        remind(remainder);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            });
        }

    }

//Checks each remainder's date to current date
    public Remainder remind(Remainder r) throws InterruptedException {

        if (r.getRemindDate() == null) {
            return r;
        }

        while (true) {
            if (new Date().compareTo(r.getRemindDate()) >= 0) //_val is your boolean variable
            {
                popup(r);
                r.setStatus(Status.REMIND_OFF);

                break;
            }
            Thread.sleep(100);

        }
        return r;
    }
//Shows RemainderBoxGUI

    public void popup(Remainder remainder) throws InterruptedException {

        new RemainderBoxGUI(remainder);

    }

}
