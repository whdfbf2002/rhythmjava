package rhythmJava;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame implements ActionListener{

   private JPanel contentPane;
   private JTextField IDtextField;
   private JTextField PWtextField;
   DBConnectionMgr pool;
   JButton LoginBtn = new JButton("");
   JButton SignUp = new JButton("");
   boolean flag = false;
   

   public Login() {
	   
	  pool = DBConnectionMgr.getInstance();
 
	  setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(0, 0, 1280, 720);
      setLocationRelativeTo(null);
      setResizable(false);
      
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

      setContentPane(contentPane);
      contentPane.setLayout(null);

      JPanel panel = new JPanel();
      panel.setBounds(0, 0, 1264, 681);
      contentPane.add(panel);
      panel.setLayout(null);

      JLabel rjTitleImage = new JLabel("New label");
      rjTitleImage.setIcon(new ImageIcon(Login.class.getResource("../Img/title2_01.png")));
      rjTitleImage.setHorizontalAlignment(SwingConstants.CENTER);
      rjTitleImage.setBounds(382, 191, 500, 200);
      panel.add(rjTitleImage);

      LoginBtn.setIcon(new ImageIcon(Login.class.getResource("../Img/login.png")));
      LoginBtn.setBounds(499, 535, 120, 25);
      LoginBtn.addActionListener(this);
      panel.add(LoginBtn);

      SignUp.setIcon(new ImageIcon(Login.class.getResource("../Img/signup.png")));
      SignUp.setBounds(651, 535, 120, 25);
      SignUp.addActionListener(this);
      SignUp.setBorderPainted(true);        
      panel.add(SignUp);

      PWtextField = new JPasswordField();
      PWtextField.setColumns(20);
      PWtextField.setBounds(561, 494, 210, 25);
      panel.add(PWtextField);
      PWtextField.addActionListener(this);


      IDtextField = new JTextField();
      IDtextField.setColumns(20);
      IDtextField.setBounds(561, 459, 210, 25);
      panel.add(IDtextField);
      IDtextField.addActionListener(this);


      JLabel PWlabel = new JLabel("PW");
      PWlabel.setIcon(new ImageIcon(Login.class.getResource("../Img/loginpw.png")));
      PWlabel.setHorizontalAlignment(SwingConstants.CENTER);
      PWlabel.setBounds(499, 494, 50, 25);
      panel.add(PWlabel);

      JLabel IDlabel = new JLabel("ID");
      IDlabel.setIcon(new ImageIcon(Login.class.getResource("../Img/loginId.png")));
      IDlabel.setHorizontalAlignment(SwingConstants.CENTER);
      IDlabel.setBounds(499, 459, 50, 25);
      panel.add(IDlabel);

      JLabel LoginLabel = new JLabel("");
      LoginLabel.setIcon(new ImageIcon(Login.class.getResource("../Img/loginPanel.png")));
      LoginLabel.setHorizontalAlignment(SwingConstants.CENTER);
      LoginLabel.setBounds(457, 429, 350, 160);
      panel.add(LoginLabel);      

      JLabel BG = new JLabel("");
      BG.setBounds(0, 0, 1264, 681);
      BG.setHorizontalAlignment(SwingConstants.CENTER);
      BG.setIcon(new ImageIcon(Login.class.getResource("../Img/background.png")));
      panel.add(BG);
          
   }
   @Override
   public void actionPerformed(ActionEvent e) {
      try {
         Object obj = e.getSource();
         if (obj == LoginBtn || obj == PWtextField || obj == IDtextField) {
            loginChk();
         }
         else if (obj == SignUp) {
//            System.out.println("회원가입 버튼");
            new SignUp();
         }
      } catch (Exception e2) {
         System.out.println(e2.getMessage());
      }
   }
   
   public void loginChk() {
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      String sql = null;
      try {            
         con = pool.getConnection();
         sql = "SELECT userId, userPw, userName FROM tbluser WHERE userId = ? and userPw = ? ";
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, IDtextField.getText());
         pstmt.setString(2, PWtextField.getText());
         rs = pstmt.executeQuery();
         
         if(rs.next()) {
            JOptionPane.showMessageDialog(this,rs.getString("userName") + " 님 환영합니다.","Message",JOptionPane.INFORMATION_MESSAGE);
            dispose();
            new SelectGame(rs.getString("userId"));
             
         }
         else {
            JOptionPane.showMessageDialog(this,"아이디 & 비밀번호를 확인해주세요","Error",JOptionPane.ERROR_MESSAGE);
         }
      } catch (Exception e) {
         System.out.println(e.getMessage());
      } finally {
         pool.freeConnection(con, pstmt, rs);
      }

   }
   
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Login frame = new Login();
               frame.setTitle("Rhythem Java");
               frame.setVisible(true);

            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }
}