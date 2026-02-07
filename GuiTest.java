import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GuiTest {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Swingだよ");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    
    JLabel label = new JLabel("こんにちは");
    frame.add(label);
    
    frame.setVisible(true);
  }
}
