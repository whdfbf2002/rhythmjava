package rhythmJava;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SignUp extends JFrame implements ActionListener {
	JTextField tf1, tf2, tf3;
	JLabel jl1, jl2, jl3;
	JButton jb1, jb2, jb3;
	private DBConnectionMgr pool;
	Dimension frameSize = getSize();
	Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
	JFrame fr = new JFrame();

	public SignUp() {
		fr.setTitle("ȸ������");
		fr.setBounds(0, 0, 350, 400);
		fr.setLayout(null);
		fr.setLocationRelativeTo(null);

		jl1 = new JLabel("����� ���̵� ");
		jl1.setBounds(20, 50, 100, 30);
		fr.add(jl1);

		tf1 = new JTextField();
		tf1.setBounds(110, 50, 100, 30);
		fr.add(tf1);

		jl2 = new JLabel("��й�ȣ");
		jl2.setBounds(40, 110, 100, 30);
		fr.add(jl2);

		tf2 = new JTextField();
		tf2.setBounds(110, 110, 100, 30);
		fr.add(tf2);

		jl3 = new JLabel("�г���");
		jl3.setBounds(50, 170, 100, 30);
		fr.add(jl3);

		tf3 = new JTextField();
		tf3.setBounds(110, 170, 100, 30);
		fr.add(tf3);

		jb1 = new JButton("�����ϱ�");
		jb1.setBounds(60, 300, 90, 40);
		fr.add(jb1);

		setLocationRelativeTo(null);
		jb2 = new JButton("����ϱ�");
		jb2.setBounds(180, 300, 90, 40);
		fr.add(jb2);

		jb3 = new JButton("�ߺ�Ȯ��");
		jb3.setBounds(230, 50, 90, 30);
		fr.add(jb3);

		fr.setVisible(true);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);

		pool = DBConnectionMgr.getInstance();
	}

	public static void main(String[] args) {
		new SignUp();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(jb1)) {
			pool = DBConnectionMgr.getInstance();
			try {
				Connection con = null;
				PreparedStatement pstmt = null;
				String sql = null;

				con = pool.getConnection();
				sql = "insert into tbluser Values(?,?,?) ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, tf1.getText());
				pstmt.setString(2, tf2.getText());
				pstmt.setString(3, tf3.getText());
//  pstmt.setString(4, tf1.getText());
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(this, "ȸ�������� ���ϵ帳�ϴ�.", "Message", JOptionPane.INFORMATION_MESSAGE);
				fr.dispose();

			} catch (Exception e2) {
				System.out.println(e2.getMessage());

			}

		} else if (e.getSource().equals(jb2)) {

			fr.dispose();
		} else if (e.getSource().equals(jb3)) {
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = null;
			ResultSet rs = null;

			try {
				con = pool.getConnection();
				sql = "select * from tbluser where userId = ? ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, tf1.getText());
				rs = pstmt.executeQuery();

				if (rs.next()) {
					JOptionPane.showMessageDialog(this, "�ߺ��� ���̵� �����մϴ�.", "Message", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(this, "��밡���� ���̵��Դϴ�..", "Message", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e3) {
				System.out.println(e3.getMessage());
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
		}

	}
}