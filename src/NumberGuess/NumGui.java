
package NumberGuess;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;


public class NumGui extends JFrame implements ActionListener {
    private int low = 1,high=50, count=0;    
    private String defaultMessage="Click the button to start",
                   guessMessage="I'm guessing a number between 1 and 50. Guess.",
                   correctMessage="You guessed correctly!!",
                   incorrectMessage="Wrong guess again.";
    private NumberGuessServices serv = new NumberGuessServices();
    private JButton btnGuess;
    private JTextField txtGuess;
    private JLabel lblMessage, lblNum;
    private JCheckBox cbShowNum;
    
    public NumGui(){
        initComponents();
    }
    
        public void initComponents() {
        txtGuess = new javax.swing.JTextField();
        lblMessage = new javax.swing.JLabel(defaultMessage);
        btnGuess = new javax.swing.JButton();
        btnGuess.addActionListener(this);
        cbShowNum = new javax.swing.JCheckBox();
        cbShowNum.addActionListener(this);
        lblNum = new javax.swing.JLabel();
        lblNum.setVisible(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnGuess.setText("Start");

        cbShowNum.setText("Show Number");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbShowNum)
                        .addGap(18, 18, 18)
                        .addComponent(lblNum, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtGuess, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuess)
                    .addComponent(txtGuess, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbShowNum)
                    .addComponent(lblNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }
        
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btnGuess){
        count++;
        String num = txtGuess.getText();

        if(count == low){ 
            serv.setNum();
            lblMessage.setText(guessMessage);
            btnGuess.setText("Guess");
        }else if(count > low){
            if(serv.checkNum(num)){
                lblMessage.setText(correctMessage);
                btnGuess.setText("Start Over");
                txtGuess.setText(null);
                count = 0;
            }else{
                lblMessage.setText(incorrectMessage);
                txtGuess.setText(null);
            }
        }
        }
        if(ae.getSource() == cbShowNum){
            if(cbShowNum.isSelected() == true){
                lblNum.setText(serv.showNum());
                lblNum.setVisible(true);
            }
            
        }
        
        
    }
}
