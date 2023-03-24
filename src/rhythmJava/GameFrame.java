package rhythmJava;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameFrame extends JFrame {

	public static final int SCREEN_WIDTH = 1280; // 창, 이미지 사이즈
	public static final int SCREEN_HEIGHT = 720;
	public static final int NOTE_SPEED = 10; // 노트가 떨어지는 속도
	public static final int SLEEP_TIME = 10; // 노트가 떨어지는 주기
	public static final int REACH_TIME = 1; // 노트가 생성 된 후 판정바에 도달하기까지 시간

	private Image screenImage;
	private Image introBackground;
	private Graphics screenGraphic;

	
	private JLabel menuBar = new JLabel(new ImageIcon(getClass().getResource("../Img/menuBar.png")));

	private ImageIcon exitButtonImage = new ImageIcon(getClass().getResource("../Img/exit.png"));
	private ImageIcon exitButtonEnteredImage = new ImageIcon(getClass().getResource("../Img/exit_entered.png"));
	private ImageIcon backButtonBasic = new ImageIcon(getClass().getResource("../Img/backButtonBasic.png"));
	private ImageIcon backButtonEntered = new ImageIcon(getClass().getResource("../Img/backButtonEntered.png"));

	// 노트 찍기 모드

	private JButton exitButton = new JButton(exitButtonImage);
	private JButton backButton = new JButton(backButtonBasic);

	private int MouseX, MouseY;
	private boolean isGameScreen = false;

	public static Game game;

	DBConnectionMgr pool;
	String Id;
	int totalScore;
	int nowSelected;
	
	public GameFrame(int nowSelected, String Id) {
		
		pool = DBConnectionMgr.getInstance();
		
		this.Id = Id;
		this.nowSelected = nowSelected;
		setUndecorated(true);
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		addKeyListener(new KeyListener());

		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);

		exitButton.addMouseListener(new MouseAdapter() {
			@Override // 버튼에 마우스 올렸을 때 이벤트
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override // 버튼에 마우스 뗐을 때 이벤트
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override // 마우스 눌렀을 때 이벤트
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});

		add(exitButton);
		

		menuBar.setBounds(0, 0, 1280, 30); // menuBar 의 위치와 크기
		menuBar.addMouseListener(new MouseAdapter() {

			@Override // 마우스 버튼을 눌렀을 때 발생하는 이벤트
			public void mouseClicked(MouseEvent e) {
				MouseX = e.getX();
				MouseY = e.getY();
			}
		});

		menuBar.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// 현재 스크린에서 마우스 위치 가져옴
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();

				// 드래그할때 그 순간순간마다 x좌표와 y 좌표를 얻어와서 JFrame 위치를 바꿔줌
				setLocation(x - MouseX, y - MouseY);
			}
		});

		add(menuBar);

		isGameScreen = true;
		introBackground = new ImageIcon(
				getClass().getResource("../Img/" + SelectGame.trackList.get(nowSelected).getGameImage())).getImage();

		// 게임 시작 시 해당 선택된 곡 이름 가져옴
		game = new Game(SelectGame.trackList.get(nowSelected).getTitleName(),
				SelectGame.trackList.get(nowSelected).getGameMusic());
		game.start();

		setFocusable(true);
		requestFocus();

		java.util.Timer timer = new Timer();

		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				totalScore();
				new Result(Id, totalScore, nowSelected);
				dispose();
			}
		};

		timer.schedule(task, SelectGame.trackList.get(nowSelected).getMusicTime());
		

		// back 버튼
		backButton.setVisible(true);
		backButton.setBounds(20, 50, 60, 60);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override // 버튼에 마무스 올렸을 때 이벤트
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonBasic);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override // 버튼에 마우스 뗐을 때 이벤트
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonEntered);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override // 마우스 눌렀을 때 이벤트
			public void mousePressed(MouseEvent e) {
				// 메인 화면으로 돌아가는 이벤트
				game.close();
				task.cancel();
				dispose();
				new SelectGame(Id);
			}
		});
		add(backButton);
	}

	public void paint(Graphics g) {
		screenImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D) screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(introBackground, 0, 0, null);

		if (isGameScreen) {
			game.screenDraw(g);
		}

		paintComponents(g);
		this.repaint();
	}

	public void totalScore() {
		totalScore = game.score;
//		   System.out.println(totalScore);
		
		String sql = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = pool.getConnection();
			sql = "insert into tblscore (musicNum,score,userId) VALUES(?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, nowSelected);
			pstmt.setInt(2, totalScore);
			pstmt.setString(3, Id);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			pool.freeConnection(con, pstmt);

		}
	}

}
