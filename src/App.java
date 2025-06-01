
import UserInterface.Form.MainJFrame;
import UserInterface.Form.Splash;

public class App {
    public static void main(String[] args) throws Exception {
        Runnable mRun = ejecutarSplash(1);
        Thread mHiloSplash = new Thread(mRun);
        mHiloSplash.start();

        try {
            Thread.sleep(6000);
        } catch (InterruptedException ex) {
            System.out.println("Fallo Ejecucion");
        }
        
        mRun = ejecutarSplash(2);
        mHiloSplash = new Thread(mRun);
        mHiloSplash.start();

        try {
            Thread.sleep(6000);
        } catch (InterruptedException ex) {
            System.out.println("Fallo Ejecucion");
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });

        //Controles.Presentacion();
        //Opciones();
        //System.exit(0);;
    }

    private static Runnable ejecutarSplash(int n) {
        Runnable mRun = () -> {
            Splash mSplash;
            if(n == 1){
                mSplash = new Splash(1);
            }else {
                mSplash = new Splash(2);
            }
            mSplash.setVisible(true);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                System.out.println("Fallo Splash");
            }
            mSplash.dispose();
        };
        return mRun;
    }
}
