package Controller;

import View.Login_GUI;
import View.Menu_GUI;
import View.SplashScreenLogin_GUI;
import View.SplashScreenMenu_GUI;
// import View.Menu_GUI;
import javax.swing.SwingUtilities;

public class SplashScreen_DAO {
    
    // SPLASH SCREEN LOGIN
    
    public static void carrega(SplashScreenLogin_GUI splash) {
    new Thread() {
        public void run() {
            try {
                for (int i = 0; i <= 100; i++) {
                    splash.progressologin_bar.setValue(i);
                    Thread.sleep(10);
                }

                SwingUtilities.invokeLater(() -> {
                    new Login_GUI().setVisible(true);
                    splash.dispose();
                });

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }.start();
  }

    // SPLASH SCREEN MENU

    public static void carrega(SplashScreenMenu_GUI splash) {
    new Thread() {
        public void run() {
            try {
                for (int i = 0; i <= 100; i++) {
                    splash.progressomenu_bar.setValue(i);

                    if (i < 60) {
                        splash.splash_lbl.setText("CARREGANDO O SISTEMA...");
                    } else if (i < 85) {
                        splash.splash_lbl.setText("CARREGAMENTO QUASE COMPLETO...");
                    } else {
                        splash.splash_lbl.setText("BEM VINDO A TECH SOLUTIONS!");
                    }

                    Thread.sleep(50);
                }

                SwingUtilities.invokeLater(() -> {
                    new Menu_GUI().setVisible(true);
                    splash.dispose();
                });

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }.start();
  }
}