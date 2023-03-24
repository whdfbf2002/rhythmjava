package rhythmJava;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SelectGame extends JFrame {
	

	JPanel contentPane = new JPanel();
	public static JPanel panel = new JPanel();
	public static JPanel settingPanel = new JPanel();
	
	private JLabel titleImage = new JLabel();
	private JLabel selectedImage = new JLabel();
	private JLabel highScoreLabel = new JLabel();
	private JLabel highScore = new JLabel();
	private JLabel rankScoreLabel = new JLabel();
	private JLabel firstRank = new JLabel();
	private JLabel secondRank = new JLabel();
	private JLabel thirdRank = new JLabel();
	private JLabel composer = new JLabel();
	private JLabel musicTime = new JLabel();

	public static ArrayList<Track> trackList = new ArrayList<Track>();

	private Music selectedMusic;
	private int nowSelected = 0;

	String Id;
	int score;

	DBConnectionMgr pool;
	Game game;
	
	public SelectGame(String Id) {
		this.Id = Id;


		pool = DBConnectionMgr.getInstance();

		setVisible(true);
		setTitle("Rhythm Java");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1280, 720);
		setLocationRelativeTo(null);
		setResizable(false);

		myScore(nowSelected);
		ranking(nowSelected);

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			con = pool.getConnection();
			sql = "SELECT musicNum, musicTitle, musicTime, musicLevel, composer FROM tblmusic ";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String titleName = rs.getString("musicTitle");
				String composer = rs.getString("composer");
				int musicTime = rs.getInt("musicTime");
				int musicLevel = rs.getInt("musicLevel");

				trackList.add(new Track(titleName, titleName + " TitleImage.png", titleName + ".png",
						titleName + " Background.png", titleName + " Highlight.mp3", titleName + ".mp3", composer,
						musicLevel, (musicTime * 1000)));
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}

		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel.setBounds(0, 0, 1264, 681);
		contentPane.add(panel);
		panel.setLayout(null);
		
//////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
//		技泼何盒														
		
		settingPanel.setBounds(0, 0, 1264, 681);
		contentPane.add(settingPanel);
		settingPanel.setLayout(null);
		
		settingPanel.setVisible(false);
		
	
//////////////////////////////////////////////////////////////////////////
		
		JButton startBtn = new JButton("");
		startBtn.setIcon(new ImageIcon(SelectGame.class.getResource("../Img/gameStartBtn.png")));
		startBtn.setBounds(970, 446, 80, 40);
		startBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				if (selectedMusic != null)
					selectedMusic.close();
				new GameFrame(nowSelected, Id);
				dispose();
			}
		});
		panel.add(startBtn);

		JButton rBtn = new JButton("");
		rBtn.setIcon(new ImageIcon(SelectGame.class.getResource("../Img/RBtn.png")));
		rBtn.setBounds(928, 306, 50, 50);
		rBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				selectRight();
			}
		});
		panel.add(rBtn);

		JButton leftBtn = new JButton("");
		leftBtn.setIcon(new ImageIcon(SelectGame.class.getResource("../Img/LBtn.png")));
		leftBtn.setBounds(298, 306, 50, 50);
		leftBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				selectLeft();
			}
		});
		panel.add(leftBtn);

		JButton settingBtn = new JButton("");
		settingBtn.setSelectedIcon(new ImageIcon(SelectGame.class.getResource("../Img/settingBtn.png")));
		settingBtn.setIcon(new ImageIcon(SelectGame.class.getResource("../Img/settingBtn.png")));
		settingBtn.setBounds(1174, 68, 40, 40);
		settingBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				panel.setVisible(false);
				new Setting();
			}
		});
		panel.add(settingBtn);

		JButton backBtn = new JButton("");
		backBtn.setSelectedIcon(new ImageIcon(SelectGame.class.getResource("../Img/LBtn.png")));
		backBtn.setIcon(new ImageIcon(SelectGame.class.getResource("../Img/LBtn.png")));
		backBtn.setBounds(55, 68, 40, 40);
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (selectedMusic != null)
					selectedMusic.close();
				new Login();
				dispose();
			}
		});
		panel.add(backBtn);

//		蜡历 沥焊
		JLabel neonText = new JLabel();
		neonText.setBounds(307, 68, 650, 40);
		panel.add(neonText);

//		傈眉珐欧
		rankScoreLabel.setText("RANKING");
		rankScoreLabel.setFont(new Font("墨其24 绊款广", Font.PLAIN, 25));
		rankScoreLabel.setForeground(Color.WHITE);
		rankScoreLabel.setBounds(46, 545, 200, 50);
		panel.add(rankScoreLabel);

//		firstRank.setText(firstStr);
		firstRank.setFont(new Font("墨其24 绊款广", Font.PLAIN, 20));
		firstRank.setForeground(Color.WHITE);
		firstRank.setBounds(45, 573, 200, 50);
		panel.add(firstRank);

//		secondRank.setText(secondStr);
		secondRank.setFont(new Font("墨其24 绊款广", Font.PLAIN, 20));
		secondRank.setForeground(Color.WHITE);
		secondRank.setBounds(46, 596, 200, 50);
		panel.add(secondRank);

//		thirdRank.setText(thirdStr);
		thirdRank.setFont(new Font("墨其24 绊款广", Font.PLAIN, 20));
		thirdRank.setForeground(Color.WHITE);
		thirdRank.setBounds(46, 619, 200, 50);
		panel.add(thirdRank);

//		俺牢珐欧
		highScoreLabel.setText("MY SCORE");
		highScoreLabel.setForeground(Color.WHITE);
		highScoreLabel.setFont(new Font("墨其24 绊款广", Font.PLAIN, 25));
		highScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		highScoreLabel.setBounds(1011, 555, 200, 50);
		panel.add(highScoreLabel);

//		俺牢珐欧
		highScore.setText(Integer.toString(score));
		highScore.setForeground(Color.WHITE);
		highScore.setFont(new Font("墨其24 绊款广", Font.PLAIN, 30));
		highScore.setHorizontalAlignment(SwingConstants.CENTER);
		highScore.setBounds(1016, 600, 200, 50);
		panel.add(highScore);

//		邦 沥焊
		composer.setFont(new Font("墨其24 绊款广", Font.PLAIN, 20));
		composer.setForeground(Color.WHITE);
		composer.setText(trackList.get(nowSelected).getComposer());
		composer.setBounds(482, 568, 460, 70);
		panel.add(composer);

		musicTime.setFont(new Font("墨其24 绊款广", Font.PLAIN, 20));
		musicTime.setForeground(Color.WHITE);
		String min = Integer.toString((trackList.get(nowSelected).getMusicTime() / 1000) / 60);
		String sec = Integer.toString((trackList.get(nowSelected).getMusicTime() / 1000) % 60);
		musicTime.setText(min + ":" + sec);
		musicTime.setBounds(710, 568, 460, 70);
		panel.add(musicTime);

		titleImage.setIcon(new ImageIcon(getClass().getResource("../Img/" + trackList.get(nowSelected).getTitleImage())));
		titleImage.setBounds(402, 460, 460, 120);
		panel.add(titleImage);

		selectedImage.setIcon(
				new ImageIcon(getClass().getResource("../Img/" + trackList.get(nowSelected).getSelectedImage())));
		selectedImage.setBounds(432, 131, 400, 400);
		panel.add(selectedImage);

		JLabel BTMLine = new JLabel("");
		BTMLine.setIcon(new ImageIcon(SelectGame.class.getResource("../Img/InfoBackgound.png")));
		BTMLine.setBounds(0, 541, 1264, 140);
		panel.add(BTMLine);

		JLabel sMemuLine = new JLabel("");
		sMemuLine.setIcon(new ImageIcon(SelectGame.class.getResource("../Img/Untitled-1.png")));
		sMemuLine.setBounds(0, 68, 1264, 40);
		panel.add(sMemuLine);

		JLabel sBG = new JLabel("");
		sBG.setIcon(new ImageIcon(SelectGame.class.getResource("../Img/sBackgound.png")));
		sBG.setBounds(0, 0, 1264, 681);
		panel.add(sBG);

		selectedMusic = new Music(trackList.get(nowSelected).getSelectedMusic(), true);
		selectedMusic.start();

	}

	public void selectTrack(int nowSelected) {
		if (selectedMusic != null)
			selectedMusic.close();
		
		titleImage.setIcon(new ImageIcon(getClass().getResource("../Img/" + trackList.get(nowSelected).getTitleImage())));
		selectedImage.setIcon(new ImageIcon(getClass().getResource("../Img/" + trackList.get(nowSelected).getSelectedImage())));
		composer.setText(trackList.get(nowSelected).getTitleName());
		selectedMusic = new Music(trackList.get(nowSelected).getSelectedMusic(), true);
		selectedMusic.start();
		
		String min = Integer.toString((trackList.get(nowSelected).getMusicTime() / 1000) / 60);
		String sec = Integer.toString((trackList.get(nowSelected).getMusicTime() / 1000) % 60);
		musicTime.setText(min + ":" + sec);
		

	}

	public void selectLeft() {
		if (nowSelected == 0)
			nowSelected = trackList.size() - 1;
		else
			nowSelected--;
		selectTrack(nowSelected);
		myScore(nowSelected);
		ranking(nowSelected);
	}

	public void selectRight() {
		if (nowSelected == trackList.size() - 1)
			nowSelected = 0;
		else
			nowSelected++;
		selectTrack(nowSelected);
		myScore(nowSelected);
		ranking(nowSelected);
	}

	public void myScore(int nowselected) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			con = pool.getConnection();
			sql = "SELECT musicNum, userId, Max(score) from tblscore ";
			sql += "WHERE musicNum = ? AND userId= ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, nowSelected);
			pstmt.setString(2, Id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				score = rs.getInt("Max(score)");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}

		highScore.setText(Integer.toString(score));

	}

	public void ranking(int nowselected) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String firstStr = "";
		String secondStr = "";
		String thirdStr = "";

		try {
			con = pool.getConnection();
			sql = "SELECT musicNum, userId, score FROM tblscore ";
			sql += "WHERE musicNum = ? ORDER BY score DESC limit 3";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, nowSelected);
			rs = pstmt.executeQuery();

			int i = 0;

			while (rs.next()) {
				if (i == 0) { firstStr = "1st   " + rs.getString("userId") + " : " + rs.getInt("score"); }
				if (i == 1) { secondStr = "2nd  " + rs.getString("userId") + " : " + rs.getInt("score"); }
				if (i == 2) { thirdStr = "3th   " + rs.getString("userId") + " : " + rs.getInt("score"); }
				i++;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}

		firstRank.setText(firstStr);
		secondRank.setText(secondStr);
		thirdRank.setText(thirdStr);

	}
	
	
//	private class SwingAction extends AbstractAction {
//		public SwingAction() {
//			putValue(NAME, "SwingAction");
//			putValue(SHORT_DESCRIPTION, "Some short description");
//		}
//
//		public void actionPerformed(ActionEvent e) {
//		}
//	}

}
