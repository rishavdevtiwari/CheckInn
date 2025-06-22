package checkinn.controller;

import checkinn.view.AboutUs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ACER NITRO
 */
public class AboutUsController {
    private AboutUs aboutUsView;

    public AboutUsController(AboutUs aboutUsView) {
        this.aboutUsView = aboutUsView;
        this.aboutUsView.addExitButtonListener(new ExitButtonListener());
    }
    
    class ExitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            aboutUsView.dispose();
        }
    }
}