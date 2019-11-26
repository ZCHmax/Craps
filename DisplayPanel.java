// Represents a display panel for a Craps table

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class DisplayPanel extends JPanel
{
    private JTextField wonText, lostText, pointText, betText, creditText;
    private int wonCount, lostCount, bet, credit;

    // Constructor
    public DisplayPanel()
    {
        super(new GridLayout(3, 2, 10, 0));
        setBorder(new EmptyBorder(0, 0, 5, 0));
        Font displayFont = new Font("Monospaced", Font.BOLD, 16);

        add(new JLabel("    Bet:"));
        betText = new JTextField("0", 5);
        betText.setFont(displayFont);
        betText.setEditable(true);
        betText.setBackground(Color.WHITE);
        add(betText);
        add(new JLabel("    Credit:"));

        creditText = new JTextField("1000", 5);
        creditText.setFont(displayFont);
        creditText.setEditable(false);
        creditText.setBackground(Color.WHITE);
        add(creditText);

        add(new JLabel("    Won:"));
        add(new JLabel("    Lost:"));
        add(new JLabel("    Point:"));
        add(new JLabel(""));



        wonText = new JTextField("  0", 5);
        wonText.setFont(displayFont);
        wonText.setEditable(false);
        wonText.setBackground(Color.WHITE);
        add(wonText);

        lostText = new JTextField("  0", 5);
        lostText.setFont(displayFont);
        lostText.setEditable(false);
        lostText.setBackground(Color.WHITE);
        add(lostText);

        pointText = new JTextField(5);
        pointText.setFont(displayFont);
        pointText.setEditable(false);
        pointText.setBackground(Color.DARK_GRAY);
        add(pointText);
    }
  
    public JTextField getBet()
    {
        return betText;
    }
  
    public JTextField getCredit()
    {
        return creditText;
    }

    // Updates this display, based on the result and
    // "point" in the previous roll
    public void update(int result, int point)
    {
        bet = Integer.parseInt(getBet().getText());
        credit = Integer.parseInt(getCredit().getText());
        if (credit == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "Sorry, you cannot play anymore");
        } else {
            if (result == 1) {
                credit = credit + bet;
                wonCount += 1;
                pointText.setBackground(Color.DARK_GRAY);
                betText.setEditable(true);
            } else if (result == -1) {
                credit = credit - bet;
                lostCount += 1;
                pointText.setBackground(Color.DARK_GRAY);
                betText.setEditable(true);
            } else if (result == 0) {
                pointText.setBackground(Color.ORANGE);
                betText.setEditable(false);
            }
            wonText.setText("" + wonCount);
            lostText.setText("" + lostCount);
            creditText.setText("" + credit);
            pointText.setText("" + point);
        }
    }
}
