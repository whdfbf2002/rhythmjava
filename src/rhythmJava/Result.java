package rhythmJava;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Result extends JFrame implements ActionListener {
   private JPanel contentPane;
   JButton checkBtn = new JButton("확인");
   String Id;
   int nowSelected;
   int totalScore;
   /**
    * Launch the application.
    */

   public static Game game;

   /**
    * Create the frame.
    */
   public Result(String Id, int totalScore, int nowSelected) {
      this.Id = Id;
      this.nowSelected = nowSelected;
      this.totalScore = totalScore;
      String grade = null;
      
      int totalCnt = game.perfectCnt + game.greatCnt + game.coolCnt + game.missCnt;
      

      if (totalScore > (totalCnt * 5 * 8)) {
         grade = "S";
      } else if (totalScore > (totalCnt * 5 * 6.5)) {
         grade = "A";
      } else if (totalScore > (totalCnt * 5 * 5)) {
         grade = "B";
      } else if (totalScore >= 0) {
         grade = "C";
      }
      
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

//   Integer.toString(totalScore)

//      JLabel resultL = new JLabel("결과");
//      resultL.setForeground(Color.white);
//      resultL.setFont(resultL.getFont().deriveFont(60.0f));
//      resultL.setHorizontalAlignment(SwingConstants.CENTER);
//      resultL.setBounds(390, 15, 500, 119);
//      panel.add(resultL);

      JLabel scoreL = new JLabel("SCORE : " + Integer.toString(totalScore));
      scoreL.setForeground(Color.white);
      scoreL.setFont(scoreL.getFont().deriveFont(60.0f));
      scoreL.setBounds(30, 80, 500, 200);
      panel.add(scoreL);

      JLabel comboL = new JLabel("MAX COMBO          " + game.highCombo);
      comboL.setForeground(Color.white);
      comboL.setFont(scoreL.getFont().deriveFont(25.0f));
      comboL.setBounds(50, 200, 500, 119);
      panel.add(comboL);
      
      JLabel perpectL = new JLabel("PERPECT               " + game.perfectCnt);
      perpectL.setForeground(Color.white);
      perpectL.setFont(perpectL.getFont().deriveFont(25.0f));
      perpectL.setBounds(50, 240, 500, 119);
      panel.add(perpectL);
      
      JLabel greatL = new JLabel("GREAT                    " + game.greatCnt);
      greatL.setForeground(Color.white);
      greatL.setFont(greatL.getFont().deriveFont(25.0f));
      greatL.setBounds(50, 280, 500, 119);
      panel.add(greatL);
      
      JLabel coolL = new JLabel("COOL                      " + game.coolCnt);
      coolL.setForeground(Color.white);
      coolL.setFont(coolL.getFont().deriveFont(25.0f));
      coolL.setBounds(50, 320, 500, 119);
      panel.add(coolL);
      
      JLabel missL = new JLabel("MISS                       " + game.missCnt);
      missL.setForeground(Color.white); 
      missL.setFont(missL.getFont().deriveFont(25.0f));
      missL.setBounds(50, 360, 500, 119);
      panel.add(missL);

      JLabel rankL = new JLabel(grade);
      rankL.setForeground(Color.white);
      rankL.setFont(scoreL.getFont().deriveFont(300.0f));
      rankL.setHorizontalAlignment(SwingConstants.CENTER);
      rankL.setBounds(390, 50, 500, 500);
      panel.add(rankL);

      JLabel jBG = new JLabel("");
      jBG.setBounds(0, 0, 1264, 681);
      jBG.setIcon(new ImageIcon(Result.class.getResource("../Img/sBackgound.png")));
      panel.add(jBG);

      checkBtn.setIcon(new ImageIcon(Result.class.getResource("../Img/Return.png")));
      checkBtn.setBounds(540, 535, 200, 50);
      checkBtn.addActionListener(this);
      panel.add(checkBtn);

      setVisible(true);
      
      
   

//   System.out.println(totalScore);

   }

   @Override
   public void actionPerformed(ActionEvent e) {
      try {
         Object obj = e.getSource();
         if (obj == checkBtn) {
            dispose();
            new SelectGame(Id);
//         System.out.println(Id);
         }
      } catch (Exception e2) {
         System.out.println(e2.getMessage());
      }

   }
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Result frame = new Result("test",12000,3);
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }
}