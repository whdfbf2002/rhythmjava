package rhythmJava;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


import javax.swing.ImageIcon;

public class Game extends Thread {
	

    private Image judgementLine = new ImageIcon(getClass().getResource("../Img/judgeLine.png")).getImage(); 
    private Image noteRouteAImage = new ImageIcon(getClass().getResource("../Img/railLine.png")).getImage(); 
    private Image noteRouteSImage = new ImageIcon(getClass().getResource("../Img/railLine.png")).getImage(); 
    private Image noteRouteDImage = new ImageIcon(getClass().getResource("../Img/railLine.png")).getImage(); 
    private Image noteRouteFImage = new ImageIcon(getClass().getResource("../Img/railLine.png")).getImage(); 
    private Image blueFlareImage;
    private Image judgeImage;
    
    private boolean miss = true;
  
    
    private String titleName;
    private String musicTitle;
    private Music gameMusic;
    
    FileWriter fw;

    // ����, �޺� ���
    int score = 0;
    int combo = 0;
    public static int highCombo = 0;
    public static int missCnt, coolCnt, greatCnt, perfectCnt = 0;
    

    private Image comboImage = new ImageIcon(getClass().getResource("../Img/combo.png")).getImage();
    
    public Game(String titleName, String musicTitle) {
        this.titleName = titleName;
        this.musicTitle = musicTitle;
        gameMusic = new Music(this.musicTitle, false);
        gameMusic.start();
        

    }
    
    ArrayList<Note> noteList = new ArrayList<Note>();
    
	public void screenDraw(Graphics2D g) {
//        g.drawImage(gameBackground, 0, 0, null); //gameBackground�� 0,0�� ��ġ�� �׷��ش�.
//  	  UI���� png ����, �⺻ ���� �ҷ�����
//        g.drawImage(healthBar, 350, 318, null);
//    	g.drawImage(noteLine, 390, 30, null);
       
        g.drawImage(noteRouteAImage, 459, 30, 80, 681, null);
        g.drawImage(noteRouteSImage, 539, 30, 80, 681, null);
        g.drawImage(noteRouteDImage, 619, 30, 80, 681, null);
        g.drawImage(noteRouteFImage, 699, 30, 80, 681, null);
          
        g.drawImage(judgementLine, 459, 602, 320, 20,null);
        
    	
        for (int i = 0; i < noteList.size(); i++) {
            Note note = noteList.get(i);

            // ��Ʈ ������ �����뼱�� 654 �̱� ������ 654 �� �Ѿ�� note �鿡 ���ؼ��� miss �̹��� ���
            if (note.getY() > 630) {
            	judgeImage = new ImageIcon(getClass().getResource("../Img/miss.png")).getImage();
                combo = 0;
//                miss = true;

            }
            // ���� ��Ʈ�� ���� ���°� �ƴ϶�� - Proceeded �� false ��� -
            // ������ ���� ��Ʈ�� ȭ�鿡�� ������ -> �ش� i ��° ��Ʈ�� ����
            if (!note.isProceeded()) {
                noteList.remove(i);
                i--;
            } else {
                note.screenDraw(g);
            }
        }

        g.setColor(Color.darkGray);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("A", 490, 673);
        g.drawString("S", 571, 673);
        g.drawString("D", 652, 673);
        g.drawString("F", 733, 673);
        g.setColor(Color.white);
        g.setFont(new Font("Elephant", Font.BOLD, 40));
        g.drawString("SCORE : " + String.valueOf(score),995, 85);
       

        // ���� �޺� ���
        if(combo != 0) {
        	g.setFont(new Font("Arial", Font.BOLD , 45));
            g.drawImage(comboImage, 576, 262, null);
            g.setColor(Color.WHITE);
            g.drawString(String.valueOf(combo), 530, 298);
        }
        
        if(!miss) {
        	g.drawImage(blueFlareImage, 236, 250, null);
        }
       
        g.drawImage(judgeImage, 570, 390, null);
    	
        
        if(highCombo < combo){
            highCombo = combo;
        }

	}
	
//  Ű�Է½� ��Ʈ���� ȿ��
	public void pressA() { 
		noteRouteAImage = new ImageIcon(getClass().getResource("../Img/noteRoutePressed.png")).getImage();
		new Music("fleek.mp3", false).start();
        judge("A");
	}
	
	public void pressS() {
		noteRouteSImage = new ImageIcon(getClass().getResource("../Img/noteRoutePressed.png")).getImage();
		new Music("fleek.mp3", false).start();
        judge("S");
	}
	
	
	public void pressD() {
		noteRouteDImage = new ImageIcon(getClass().getResource("../Img/noteRoutePressed.png")).getImage();
        new Music("fleek.mp3", false).start();
        judge("D");
	}
	
	public void pressF() {
		noteRouteFImage = new ImageIcon(getClass().getResource("../Img/noteRoutePressed.png")).getImage();
        new Music("fleek.mp3", false).start();
        judge("F");
	}
	
	

	public void releaseA() { noteRouteAImage = new ImageIcon(getClass().getResource("../Img/railLine.png")).getImage(); }
	public void releaseS() { noteRouteSImage = new ImageIcon(getClass().getResource("../Img/railLine.png")).getImage(); }
	public void releaseD() { noteRouteDImage = new ImageIcon(getClass().getResource("../Img/railLine.png")).getImage(); }
	public void releaseF() { noteRouteFImage = new ImageIcon(getClass().getResource("../Img/railLine.png")).getImage(); }
	
	@Override
	public void run() {
		dropNote();
	}
	
    public void close() {
        // ���� ���� ����
        gameMusic.close();
        // ������ ����
        this.interrupt();

    }

    public void dropNote() {
    	Beat[] beats = null; // beat ��ü�� �迭��
    	ArrayList<Integer> time = new ArrayList<>();
        ArrayList<String> noteType = new ArrayList<>();
        InputStream is;
        BufferedReader br;
        String readfile = "";
            // �� ��
            try {
                is = getClass().getResourceAsStream("../readNote/" + titleName + ".txt");
                br = new BufferedReader(new InputStreamReader((is)));

                while ((readfile = br.readLine()) != null) {
                    StringTokenizer note_stk = new StringTokenizer(readfile, " ");
                    time.add(Integer.parseInt(note_stk.nextToken()));
                    noteType.add(note_stk.nextToken());
                }

                
                // ��Ʈ �������� �ð� ��
                int gap = 660/(GameFrame.NOTE_SPEED) * (GameFrame.SLEEP_TIME) - (GameFrame.REACH_TIME);

                beats = new Beat[time.size()];
               

                for (int j = 0; j < time.size(); j++) {
                    // beat �迭�� ������ �Ű������� time �� noteType�� ������
                    beats[j] = new Beat(time.get(j)-gap, noteType.get(j));
                }


            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            };

            int i = 0;

            while (true) {
                boolean dropped = false;
                if (beats[i].getTime() <= gameMusic.getTime()) {
                    Note note = new Note(beats[i].getNoteName());
                    note.start();
                    noteList.add(note);
                    i++;

                    dropped = true;
                }
                if (dropped) {
                    try {
                        Thread.sleep(5);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        
    }



	 public void judge(String input) {

	        for (int i = 0; i < noteList.size(); i++) {

	            Note nowNote = noteList.get(i);

	            if (input.equals(nowNote.getNoteType())) {
	                judgeEvent(nowNote.judge());
	                break;
	            }
	        }
	    }
	 
	 
	 public void judgeEvent(String judge) {
		 System.out.println(judge); 

	     if (judge.equals("Miss")) {
	    	 judgeImage = new ImageIcon(getClass().getResource("../Img/miss.png")).getImage();
	         combo = 0;
	         missCnt += 1;
	         miss = true;
	     } else if (judge.equals("Cool")) {
	         judgeImage = new ImageIcon(getClass().getResource("../Img/cool.png")).getImage();
	         blueFlareImage = new ImageIcon(getClass().getResource("../Img/blue_flare.png")).getImage();
	         score += 10;
	         combo += 1;
	         coolCnt += 1;
	         miss = false;
	     } else if (judge.equals("Great")) {
	         judgeImage = new ImageIcon(getClass().getResource("../Img/great.png")).getImage();
	         blueFlareImage = new ImageIcon(getClass().getResource("../Img/blue_flare.png")).getImage();
	         score += 30;
	         combo += 1;
	         greatCnt += 1;
	         miss = false;
	     } else if (judge.equals("Perfect")) {
	         judgeImage = new ImageIcon(getClass().getResource("../Img/perfect.png")).getImage();
	         blueFlareImage = new ImageIcon(getClass().getResource("../Img/blue_flare.png")).getImage();
	         score += 50;
	         combo += 1;
	         perfectCnt += 1;
	         miss = false;
	         
	     }
	     
	 }
	
}