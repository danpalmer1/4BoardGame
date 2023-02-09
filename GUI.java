import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;



public class GUI extends Frame {

  JPanel board = new JPanel(new GridLayout(4, 4, 10, 10));
  JPanel menu = new JPanel(new FlowLayout());
  JFrame main = new JFrame("4 Board Game");
  
  public GUI() {

    main.setSize(600, 1000);
    board.setSize(580, 600);
    menu.setSize(600, 400);
    
    main.setLayout(new BorderLayout(10, 10));
    
    JLabel prompt = new JLabel("Guess a number");
    main.add(board);
    menu.add(prompt);
    main.add(menu);

    ImageIcon icon = new ImageIcon("reddot.png", "Red dot");
    JButton aa = new JButton(icon);
    JButton ab = new JButton(icon);
    JButton ac = new JButton(icon);
    JButton ad = new JButton(icon);
    JButton ba = new JButton(icon);
    JButton bb = new JButton(icon);
    JButton bc = new JButton(icon);
    JButton bd = new JButton(icon);
    JButton ca = new JButton(icon);
    JButton cb = new JButton(icon);
    JButton cc = new JButton(icon);
    JButton cd = new JButton(icon);
    JButton da = new JButton(icon);
    JButton db = new JButton(icon);
    JButton dc = new JButton(icon);
    JButton dd = new JButton(icon);
    JButton[] arrJButton = new JButton[16];
    arrJButton[0] = aa;
    arrJButton[1] = ab;
    arrJButton[2] = ac;
    arrJButton[3] = ad;
    arrJButton[4] = ba;
    arrJButton[5] = bb;
    arrJButton[6] = bc;
    arrJButton[7] = bd;
    arrJButton[8] = ca;
    arrJButton[9] = cb;
    arrJButton[10] = cc;
    arrJButton[11] = cd;
    arrJButton[12] = da;
    arrJButton[13] = db;
    arrJButton[14] = dc;
    arrJButton[15] = dd;
    for (JButton button : arrJButton) {
      button.setSize(25, 25);
      board.add(button);
    }
    
    main.setVisible(true);
    addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent we) {
            dispose();
        }
    });
  }

  public static void main(String args[]){
    new GUI();
  }
}
