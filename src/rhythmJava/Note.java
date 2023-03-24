package rhythmJava;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {

	private Image noteBasicImage = new ImageIcon(getClass().getResource("../Img/noteEx.png")).getImage();
	private int x, y = 602 - 1000 / GameFrame.SLEEP_TIME * GameFrame.NOTE_SPEED;	//��Ʈ�� �����ǰ� 1�ʵڿ� �������ο� �ٴٸ�
	private String noteType;
	
	// ���� ��Ʈ�� ���� ���� -> ��Ʈ�� ������ �ʿ��� ������ �Ѿ���� Ȯ���� �� �ֵ���
    private boolean proceeded = true;
    
    // ��Ʈ ���� -> ���� ��Ʈ Ÿ�� - Ű���� � ��ư���� - ��ȯ
    public String getNoteType(){
        return noteType;
    }

    public boolean isProceeded(){
        return proceeded;
    }

    // ��Ʈ�� ���̻� ����� �ʿ䰡 ���ٸ� false
    public void close(){
        proceeded = false;
    }
    
	public Note(String noteType) {
		if(noteType.equals("A")) x = 459;
		else if(noteType.equals("S")) x = 539;
		else if(noteType.equals("D")) x = 619;
		else if(noteType.equals("F")) x = 699;
		this.noteType = noteType;
		
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(noteBasicImage, x, y, null);
	}
	
	// ��Ʈ�� ���������� ����� �Լ�
	// ��Ʈ�� �������� -> ��Ʈ�� �Ʒ��� �����δ� -> y ������ ������ ��ǥ��ŭ �����δ�
	public void drop() {
		y += GameFrame.NOTE_SPEED;	//��Ʈ�ӵ�
        if(y>630){ // y ��ǥ�� 630 �̻��̶�� Miss ����
          close();
      }
	}
	
	// ������ �����Լ�
   @Override
    public void run(){
        try{
            // ��Ʈ �������°��� ���ѹݺ�
            // 1�ʿ� Main.NOTE_SPEED * 100 ������ŭ ������
            while(true) {
                    drop();
                if (proceeded == true) {
                    // �������� GameFrame.Sleep_Time �� ������ �ð���ŭ �����̸� �ָ鼭 ������
                    // ���� ��Ʈ�� ����ؼ� �����̰� �ִٸ� �ݺ������� ������
                    // �ش� ��Ʈ������ �۾�ó���� ������ proceeded �� false �� ����
                    Thread.sleep(GameFrame.SLEEP_TIME);
                }else{
                    // ��Ʈ�� ���� ������ �۾� - ����, �Է� ��- ������
                    // ���̻� �ش� ��Ʈ�� �ʿ�������� ������ ����(interrupt)
                    // proceeded = false
                    interrupt();
                    break;
                }
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
   
   //  574    614 	654
   public String judge() {
       
       if(y >= 640){
           close();
           return "Good";

       }else if(y>= 630){
           close();
           return "Great";

       }else if(y>= 590){
           close();
           return "Perfect";

       }else if(y>= 530){
           close();
           return "Great";

       }else if(y >= 500){
           close();
           return "cool";

       }else{
           return "Miss";
       }

   }

   public int getY(){
       return y;
   }
	
}
