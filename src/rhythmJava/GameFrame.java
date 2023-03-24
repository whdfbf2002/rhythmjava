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

	public static final int SCREEN_WIDTH = 1280; // â, �̹��� ������
	public static final int SCREEN_HEIGHT = 720;
	public static final int NOTE_SPEED = 10; // ��Ʈ�� �������� �ӵ�
	public static final int SLEEP_TIME = 10; // ��Ʈ�� �������� �ֱ�
	public static final int REACH_TIME = 1; // ��Ʈ�� ���� �� �� �����ٿ� �����ϱ���� �ð�

	private Image screenImage;
	private Image introBackground;
	private Graphics screenGraphic;

	
	private JLabel menuBar = new JLabel(new ImageIcon(getClass().getResource("../Img/menuBar.png")));

	private ImageIcon exitButtonImage = new ImageIcon(getClass().getResource("../Img/exit.png"));
	private ImageIcon exitButtonEnteredImage = new ImageIcon(getClass().getResource("../Img/exit_entered.png"));
	private ImageIcon backButtonBasic = new ImageIcon(getClass().getResource("../Img/backButtonBasic.png"));
	private ImageIcon backButtonEntered = new ImageIcon(getClass().getResource("../Img/backButtonEntered.png"));

	// ��Ʈ ��� ���

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
			@Override // ��ư�� ���콺 �÷��� �� �̺�Ʈ
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override // ��ư�� ���콺 ���� �� �̺�Ʈ
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override // ���콺 ������ �� �̺�Ʈ
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});

		add(exitButton);
		

		menuBar.setBounds(0, 0, 1280, 30); // menuBar �� ��ġ�� ũ��
		menuBar.addMouseListener(new MouseAdapter() {

			@Override // ���콺 ��ư�� ������ �� �߻��ϴ� �̺�Ʈ
			public void mouseClicked(MouseEvent e) {
				MouseX = e.getX();
				MouseY = e.getY();
			}
		});

		menuBar.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// ���� ��ũ������ ���콺 ��ġ ������
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();

				// �巡���Ҷ� �� ������������ x��ǥ�� y ��ǥ�� ���ͼ� JFrame ��ġ�� �ٲ���
				setLocation(x - MouseX, y - MouseY);
			}
		});

		add(menuBar);

		isGameScreen = true;
		introBackground = new ImageIcon(
				getClass().getResource("../Img/" + SelectGame.trackList.get(nowSelected).getGameImage())).getImage();

		// ���� ���� �� �ش� ���õ� �� �̸� ������
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
		

		// back ��ư
		backButton.setVisible(true);
		backButton.setBounds(20, 50, 60, 60);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override // ��ư�� ������ �÷��� �� �̺�Ʈ
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonBasic);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override // ��ư�� ���콺 ���� �� �̺�Ʈ
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonEntered);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override // ���콺 ������ �� �̺�Ʈ
			public void mousePressed(MouseEvent e) {
				// ���� ȭ������ ���ư��� �̺�Ʈ
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
