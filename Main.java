import java.awt.event.*;  
import javax.swing.*;  
import java.lang.*;  

public class Main {  

  public static void main(String[] args) { 
    // Create Frame, labels, TF's, and Buttons 
    JFrame f=new JFrame("Quadratic Calculator");
    ImageIcon icon = new ImageIcon("quadratic.png");
    JLabel quadLabel = new JLabel("",icon,JLabel.CENTER);
    // JLabel quadLabel = new JLabel("ax^2 + bx + c");
    quadLabel.setBounds(0, 25, 600,150);

    JLabel aLabel = new JLabel("Enter a");
    aLabel.setHorizontalTextPosition(JLabel.CENTER);
    aLabel.setBounds(50, 175, 150, 40);
    aLabel.setFont(aLabel.getFont().deriveFont(24.0f));
    // aLabel.setFont(new Font("Serif", Font.PLAIN, 24));

    JTextField aTF=new JTextField();
    aTF.setBounds(50,225, 150,40); 
    aTF.setFont(aTF.getFont().deriveFont(24.0f));
    aTF.setHorizontalAlignment(JTextField.CENTER);

    JLabel bLabel = new JLabel("Enter b");
    bLabel.setBounds(225, 175, 150, 40);
    bLabel.setFont(bLabel.getFont().deriveFont(24.0f));

    JTextField bTF=new JTextField();
    bTF.setBounds(225,225, 150,40);
    bTF.setFont(bTF.getFont().deriveFont(24.0f));
    bTF.setHorizontalAlignment(JTextField.CENTER);

    JLabel cLabel = new JLabel("Enter c");
    cLabel.setBounds(400, 175, 150, 40);
    cLabel.setFont(cLabel.getFont().deriveFont(24.0f));

    JTextField cTF=new JTextField();
    cTF.setBounds(400,225, 150,40);
    cTF.setFont(cTF.getFont().deriveFont(24.0f));
    cTF.setHorizontalAlignment(JTextField.CENTER);
    
    
    JLabel answerLabel = new JLabel("");
    answerLabel.setHorizontalTextPosition(JLabel.CENTER);
    answerLabel.setBounds(50,325,500,150);
    answerLabel.setFont(answerLabel.getFont().deriveFont(24.0f));
    
    JButton b=new JButton("Calculate");  
    b.setBounds(100,275,400,50); 
    b.setFont(b.getFont().deriveFont(24.0f)); 
    b.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e){  
        // get the data from aTF, bTF, and cTF... then compute solutions
        try
        {
          // the String to int conversion happens here from TF's
          double a = Double.parseDouble(aTF.getText().trim());
          double b = Double.parseDouble(bTF.getText().trim());
          double c = Double.parseDouble(cTF.getText().trim());

          double discriminant = b*b - 4 * a * c;
          if (discriminant < 0)
          {
            answerLabel.setText("non-real solutions");
          }else
          {
            double first = (-b + Math.sqrt(discriminant))/ (2*a);
            double second = (-b - Math.sqrt(discriminant))/ (2*a);

            answerLabel.setText("<html>Solutions are " + first + "\nand " + second + "</html>");
          }
        }
        catch (NumberFormatException nfe)
        {
          answerLabel.setText("<html>a, b, and c must be numbers line 3, -2, or 2.5</html>");
          System.out.println("NumberFormatException: " + nfe.getMessage());
        } 
      }  
    });  
    f.add(b);
    f.add(aTF);
    f.add(bTF);
    f.add(cTF); 
    f.add(aLabel);
    f.add(bLabel);
    f.add(cLabel); 
    f.add(quadLabel);
    f.add(answerLabel);
    f.setSize(600,600);  
    f.setLayout(null);  
    f.setVisible(true);   
}  
}  