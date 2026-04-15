package Doctor;

public abstract class Page extends javax.swing.JFrame {
     // shared method for opening a page
    public void openPage() {
        this.setVisible(true);
    }

    // shared method for closing a page
    public void closePage() {
        this.dispose();
    }
}