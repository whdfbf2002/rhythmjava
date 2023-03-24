package rhythmJava;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Setting extends JFrame{
	
	public int speed = 10;
	public int keyType = 1;
	public int SoundVolume = 10;
	public int KeySoundVolume = 10;
	public int SystemSoundVolume = 10;
	

	SelectGame sg;
	
	public Setting() {

		sg.settingPanel.setVisible(true);

		
		JPanel soundPanel = new JPanel();
		soundPanel.setBounds(250, 80, 887, 527);
		sg.settingPanel.add(soundPanel);
		soundPanel.setLayout(null);
		soundPanel.setVisible(true);

		JPanel keyPanel = new JPanel();
		keyPanel.setBounds(250, 80, 887, 527);
		sg.settingPanel.add(keyPanel);
		keyPanel.setLayout(null);
		keyPanel.setVisible(false);

		JPanel keypanel2 = new JPanel();
		keypanel2.setBounds(250, 80, 887, 527);
		sg.settingPanel.add(keypanel2);
		keypanel2.setLayout(null);
		keypanel2.setVisible(false);

		JPanel syncPanel = new JPanel();
		syncPanel.setBounds(250, 80, 887, 527);
		sg.settingPanel.add(syncPanel);
		syncPanel.setLayout(null);
		syncPanel.setVisible(false);

		JButton btnChangeKey1_1 = new JButton("A");
		btnChangeKey1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnChangeKey1_1.setBackground(new Color(223, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnChangeKey1_1.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnChangeKey1_1.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnChangeKey1_1.setBackground(new Color(223, 0, 0));
			}
		});

		JButton keySetting2_2 = new JButton("");
		keySetting2_2.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/keyType2.png")));

		keySetting2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				keyType = 2;
				keyPanel.setVisible(false);
				keypanel2.setVisible(true);

			}
		});
		
		JButton keySetting2_1 = new JButton("");
		keySetting2_1.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/keyType1.png")));
		keySetting2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				keyType = 1;
				keyPanel.setVisible(true);
				keypanel2.setVisible(false);

			}
		});
		
		keySetting2_1.setBounds(757, 39, 100, 35);
		keypanel2.add(keySetting2_1);
		keySetting2_2.setBounds(757, 83, 100, 35);
		keypanel2.add(keySetting2_2);
		btnChangeKey1_1.setBounds(275, 435, 45, 45);
		btnChangeKey1_1.setForeground(Color.WHITE);
		btnChangeKey1_1.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btnChangeKey1_1.setBackground(Color.BLACK);
		keypanel2.add(btnChangeKey1_1);
		
		JButton btnChangeKey2_1 = new JButton("S");
		btnChangeKey2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnChangeKey1_1.setBackground(new Color(223, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnChangeKey2_1.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnChangeKey2_1.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnChangeKey2_1.setBackground(new Color(223, 0, 0));
			}
		});
		btnChangeKey2_1.setBounds(375, 435, 45, 45);
		btnChangeKey2_1.setForeground(Color.WHITE);
		btnChangeKey2_1.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btnChangeKey2_1.setBackground(Color.BLACK);
		keypanel2.add(btnChangeKey2_1);

		JButton btnChangeKey3_1 = new JButton(":");
		btnChangeKey3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnChangeKey3_1.setBackground(new Color(223, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnChangeKey3_1.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnChangeKey3_1.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnChangeKey3_1.setBackground(new Color(223, 0, 0));
			}
		});
		btnChangeKey3_1.setBounds(475, 435, 45, 45);
		btnChangeKey3_1.setForeground(Color.WHITE);
		btnChangeKey3_1.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btnChangeKey3_1.setBackground(Color.BLACK);
		keypanel2.add(btnChangeKey3_1);

		
		JButton btnChangeKey4_1 = new JButton("\"");
		btnChangeKey4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnChangeKey4_1.setBackground(new Color(223, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnChangeKey4_1.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnChangeKey4_1.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnChangeKey4_1.setBackground(new Color(223, 0, 0));
			}
		});
		btnChangeKey4_1.setBounds(575, 435, 45, 45);
		btnChangeKey4_1.setForeground(Color.WHITE);
		btnChangeKey4_1.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btnChangeKey4_1.setBackground(Color.BLACK);
		keypanel2.add(btnChangeKey4_1);

		JLabel lblNewLabel_4_2_1 = new JLabel("");
		lblNewLabel_4_2_1.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/keysettingBG.png")));
		lblNewLabel_4_2_1.setBounds(0, 0, 887, 527);
		keypanel2.add(lblNewLabel_4_2_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 887, 527);
		lblNewLabel_2.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/settingPNGG.png")));
		keypanel2.add(lblNewLabel_2);
		
		JButton btnSoundSelect_1 = new JButton("");
		btnSoundSelect_1.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/SoundBtn.png")));

		btnSoundSelect_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSoundSelect_1.setIcon(new ImageIcon(getClass().getResource("/Img/LSound.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnSoundSelect_1.setIcon(new ImageIcon(getClass().getResource("/Img/SoundBtn.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnSoundSelect_1.setIcon(new ImageIcon(getClass().getResource("/Img/SoundBtn.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnSoundSelect_1.setIcon(new ImageIcon(getClass().getResource("/Img/LSound.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				syncPanel.setVisible(false);
				keyPanel.setVisible(false);
				keypanel2.setVisible(false);
				soundPanel.setVisible(true);
			}

		});
		btnSoundSelect_1.setFont(new Font("±¼¸²", Font.BOLD, 18));
		btnSoundSelect_1.setBounds(75, 167, 117, 37);
		sg.settingPanel.add(btnSoundSelect_1);
		
		JButton btnKeySelect = new JButton("");
		btnKeySelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnKeySelect.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/KeyBtn.png")));
		btnKeySelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnKeySelect.setIcon(new ImageIcon(getClass().getResource("/Img/LKeyBtn.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnKeySelect.setIcon(new ImageIcon(getClass().getResource("/Img/KeyBtn.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnKeySelect.setIcon(new ImageIcon(getClass().getResource("/Img/KeyBtn.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnKeySelect.setIcon(new ImageIcon(getClass().getResource("/Img/LKeyBtn.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				syncPanel.setVisible(false);
				keyPanel.setVisible(true);
				keypanel2.setVisible(false);
				soundPanel.setVisible(false);
			}

		});
		btnKeySelect.setFont(new Font("±¼¸²", Font.BOLD, 18));
		btnKeySelect.setBounds(75, 325, 117, 37);
		sg.settingPanel.add(btnKeySelect);
		
		JButton btnSyncSelect = new JButton("");
		btnSyncSelect.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/SyncBtn.png")));

		btnSyncSelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSyncSelect.setIcon(new ImageIcon(getClass().getResource("/Img/LSync.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnSyncSelect.setIcon(new ImageIcon(getClass().getResource("/Img/SyncBtn.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnSyncSelect.setIcon(new ImageIcon(getClass().getResource("/Img/SyncBtn.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnSyncSelect.setIcon(new ImageIcon(getClass().getResource("/Img/LSync.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				syncPanel.setVisible(true);
				keyPanel.setVisible(false);
				keypanel2.setVisible(false);
				soundPanel.setVisible(false);
			}

		});
		btnSyncSelect.setFont(new Font("±¼¸²", Font.BOLD, 18));
		btnSyncSelect.setBounds(75, 487, 117, 37);
		sg.settingPanel.add(btnSyncSelect);
		
		JLabel lblNewLabel_5 = new JLabel("SETTING");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("±¼¸²", Font.BOLD, 25));
		lblNewLabel_5.setBounds(108, 0, 661, 527);
		sg.settingPanel.add(lblNewLabel_5);
		
		JButton btnSave = new JButton("");
		btnSave.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/saveBtn.png")));
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSave.setIcon(new ImageIcon(getClass().getResource("/Img/LSaveBtn.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnSave.setIcon(new ImageIcon(getClass().getResource("/Img/saveBtn.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnSave.setIcon(new ImageIcon(getClass().getResource("/Img/saveBtn.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnSave.setIcon(new ImageIcon(getClass().getResource("/Img/LSaveBtn.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				sg.settingPanel.setVisible(false);
				sg.panel.setVisible(true);			
			}

		});
		btnSave.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btnSave.setBounds(500, 630, 80, 30);
		sg.settingPanel.add(btnSave);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/MusicSoundText.png")));
		lblNewLabel_1.setBounds(75, 80, 130, 50);
		soundPanel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/KeySoundText.png")));
		lblNewLabel_1_1.setBounds(75, 245, 130, 50);
		soundPanel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("±¼¸²", Font.BOLD, 15));

		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/SystemSoundText.png")));
		lblNewLabel_1_2.setBounds(75, 407, 130, 50);
		soundPanel.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("±¼¸²", Font.BOLD, 15));
		
		JLabel soundVolumeImg = new JLabel("");
		soundVolumeImg.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/10.png")));
		soundVolumeImg.setBounds(500, 82, 45, 45);
		soundPanel.add(soundVolumeImg);

		JLabel keySoundVolumeImg = new JLabel("");
		keySoundVolumeImg.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/10.png")));
		keySoundVolumeImg.setBounds(500, 243, 45, 45);
		soundPanel.add(keySoundVolumeImg);

		JLabel systemSoundVolumeImg = new JLabel("");
		systemSoundVolumeImg.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/10.png")));
		systemSoundVolumeImg.setBounds(500, 405, 45, 45);
		soundPanel.add(systemSoundVolumeImg);
		
		
		JButton musicSoundDown = new JButton("");
		musicSoundDown.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/settingBtnL.png")));

		musicSoundDown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				musicSoundDown.setIcon(new ImageIcon(getClass().getResource("/img/LBtn.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				musicSoundDown.setIcon(new ImageIcon(getClass().getResource("/img/settingBtnL.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				musicSoundDown.setIcon(new ImageIcon(getClass().getResource("/img/settingBtnL.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				musicSoundDown.setIcon(new ImageIcon(getClass().getResource("/img/LBtn.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				SoundVolume = SoundVolume - 1;
				if (SoundVolume > 20) SoundVolume = 20;
				if (SoundVolume < 1) SoundVolume = 1;
				
				for(int i=1; i<21; i++) {
					if(SoundVolume == i) soundVolumeImg.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/" + i +".png")));
				}
			}

		});
		musicSoundDown.setBounds(307, 82, 40, 40);
		soundPanel.add(musicSoundDown);
		
		JButton keySoundDown = new JButton("");
		keySoundDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		keySoundDown.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/settingBtnL.png")));

		keySoundDown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				keySoundDown.setIcon(new ImageIcon(getClass().getResource("/img/LBtn.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				keySoundDown.setIcon(new ImageIcon(getClass().getResource("/img/settingBtnL.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				keySoundDown.setIcon(new ImageIcon(getClass().getResource("/img/settingBtnL.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				keySoundDown.setIcon(new ImageIcon(getClass().getResource("/img/LBtn.png")));
			}

			public void mouseClicked(MouseEvent e) {
				KeySoundVolume = KeySoundVolume - 1;

				if (KeySoundVolume > 20) KeySoundVolume = 20;
				if (KeySoundVolume < 1) KeySoundVolume = 1;		
				for(int i=1; i<21; i++) {
					if(KeySoundVolume == i) keySoundVolumeImg.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/" + i +".png")));
				}
			}
		});
		
		JButton musicSoundUp = new JButton("");
		musicSoundUp.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/settingBtnR.png")));

		musicSoundUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				musicSoundUp.setIcon(new ImageIcon(getClass().getResource("/img/RBtn.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				musicSoundUp.setIcon(new ImageIcon(getClass().getResource("/img/settingBtnR.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				musicSoundUp.setIcon(new ImageIcon(getClass().getResource("/img/settingBtnR.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				musicSoundUp.setIcon(new ImageIcon(getClass().getResource("/img/RBtn.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				SoundVolume = SoundVolume + 1;

				if (SoundVolume > 20) KeySoundVolume = 20;
				if (SoundVolume < 1) KeySoundVolume = 1;
				
				for(int i=1; i<21; i++) {
					if(SoundVolume == i) soundVolumeImg.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/" + i +".png")));
				}
			}

		});
		musicSoundUp.setBounds(694, 82, 40, 40);
		soundPanel.add(musicSoundUp);
		keySoundDown.setBounds(307, 243, 40, 40);
		soundPanel.add(keySoundDown);
		
		
		JButton keySoundUp = new JButton("");
		keySoundUp.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/settingBtnR.png")));

		keySoundUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				keySoundUp.setIcon(new ImageIcon(getClass().getResource("/img/RBtn.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				keySoundUp.setIcon(new ImageIcon(getClass().getResource("/img/settingBtnR.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				keySoundUp.setIcon(new ImageIcon(getClass().getResource("/img/settingBtnR.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				keySoundUp.setIcon(new ImageIcon(getClass().getResource("/img/RBtn.png")));
			}

			public void mouseClicked(MouseEvent e) {
				KeySoundVolume = KeySoundVolume + 1;
				if (KeySoundVolume > 20) { KeySoundVolume = 20; }
				if (KeySoundVolume < 1) { KeySoundVolume = 1; }

				for(int i=1; i<21; i++) {
					if(KeySoundVolume == i) keySoundVolumeImg.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/" + i +".png")));
				}
			}

		});
		keySoundUp.setBounds(694, 243, 40, 40);
		soundPanel.add(keySoundUp);
		
		JButton systemSoundDown = new JButton("");
		systemSoundDown.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/settingBtnL.png")));

		systemSoundDown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				systemSoundDown.setIcon(new ImageIcon(getClass().getResource("/img/LBtn.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				systemSoundDown.setIcon(new ImageIcon(getClass().getResource("/img/settingBtnL.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				systemSoundDown.setIcon(new ImageIcon(getClass().getResource("/img/settingBtnL.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				systemSoundDown.setIcon(new ImageIcon(getClass().getResource("/img/LBtn.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				SystemSoundVolume = SystemSoundVolume - 1;
				if (SystemSoundVolume > 20) SystemSoundVolume = 20;
				if (SystemSoundVolume < 1) SystemSoundVolume = 1;

				for(int i=1; i<21; i++) {
					if(SystemSoundVolume == i) systemSoundVolumeImg.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/" + i +".png")));
				}
			}

		});

		systemSoundDown.setBounds(307, 405, 40, 40);
		soundPanel.add(systemSoundDown);
		
		JButton systemSoundUp = new JButton("");
		systemSoundUp.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/settingBtnR.png")));

		systemSoundUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				systemSoundUp.setIcon(new ImageIcon(getClass().getResource("/img/RBtn.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				systemSoundUp.setIcon(new ImageIcon(getClass().getResource("/img/settingBtnR.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				systemSoundUp.setIcon(new ImageIcon(getClass().getResource("/img/settingBtnR.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				systemSoundUp.setIcon(new ImageIcon(getClass().getResource("/img/RBtn.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				SystemSoundVolume = SystemSoundVolume + 1;
				if (SystemSoundVolume > 20) SystemSoundVolume = 20;
				if (SystemSoundVolume < 1) SystemSoundVolume = 1;
				
				for(int i=1; i<21; i++) {
					if(SystemSoundVolume == i) systemSoundVolumeImg.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/" + i +".png")));
				}

			}

		});
		systemSoundUp.setBounds(694, 405, 40, 40);
		soundPanel.add(systemSoundUp);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/settingPNGG.png")));
		lblNewLabel_4.setBounds(0, 0, 887, 527);
		soundPanel.add(lblNewLabel_4);
		
		JButton btnChangeKey1 = new JButton("A");
		btnChangeKey1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnChangeKey1.setBackground(new Color(223, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnChangeKey1.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnChangeKey1.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnChangeKey1.setBackground(new Color(223, 0, 0));
			}
		});
		
		JButton keySetting1_2 = new JButton("");
		keySetting1_2.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/keyType2.png")));
		keySetting1_2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				keySetting1_2.setIcon(new ImageIcon(getClass().getResource("/Img/LkeyType2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				keySetting1_2.setIcon(new ImageIcon(getClass().getResource("/Img/keyType2.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				keySetting1_2.setIcon(new ImageIcon(getClass().getResource("/Img/keyType2.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				keySetting1_2.setIcon(new ImageIcon(getClass().getResource("/Img/LkeyType2.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				keyType = 2;
				keyPanel.setVisible(false);
				keypanel2.setVisible(true);
				System.out.println(keyType);

			}
		});
		
		JButton keySetting1_1 = new JButton("");
		keySetting1_1.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/keyType1.png")));
		keySetting1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				keySetting1_1.setIcon(new ImageIcon(getClass().getResource("/Img/LkeyType1.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				keySetting1_1.setIcon(new ImageIcon(getClass().getResource("/Img/keyType1.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				keySetting1_1.setIcon(new ImageIcon(getClass().getResource("/Img/keyType1.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				keySetting1_1.setIcon(new ImageIcon(getClass().getResource("/Img/LkeyType1.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				keyPanel.setVisible(true);
				keypanel2.setVisible(false);

			}

		});

		keySetting1_1.setBounds(757, 39, 100, 35);
		keyPanel.add(keySetting1_1);
		keySetting1_2.setBounds(757, 83, 100, 35);
		keyPanel.add(keySetting1_2);

		btnChangeKey1.setBounds(275, 435, 45, 45);
		btnChangeKey1.setForeground(new Color(255, 255, 255));
		btnChangeKey1.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btnChangeKey1.setBackground(new Color(0, 0, 0));
		keyPanel.add(btnChangeKey1);
		
		JButton btnChangeKey2 = new JButton("S");
		btnChangeKey2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnChangeKey2.setBackground(new Color(223, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnChangeKey2.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnChangeKey2.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnChangeKey2.setBackground(new Color(223, 0, 0));
			}
		});
		btnChangeKey2.setBounds(375, 435, 45, 45);
		btnChangeKey2.setForeground(new Color(255, 255, 255));
		btnChangeKey2.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btnChangeKey2.setBackground(Color.BLACK);
		keyPanel.add(btnChangeKey2);
		
		
		JButton btnChangeKey3 = new JButton("D");
		btnChangeKey3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnChangeKey3.setBackground(new Color(223, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnChangeKey3.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnChangeKey3.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnChangeKey3.setBackground(new Color(223, 0, 0));
			}
		});

		btnChangeKey3.setBounds(475, 435, 45, 45);
		btnChangeKey3.setForeground(new Color(255, 255, 255));
		btnChangeKey3.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btnChangeKey3.setBackground(Color.BLACK);
		keyPanel.add(btnChangeKey3);
		
		
		JButton btnChangeKey4 = new JButton("F");
		btnChangeKey4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnChangeKey4.setBackground(new Color(223, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnChangeKey4.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnChangeKey4.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnChangeKey4.setBackground(new Color(223, 0, 0));
			}
		});
		btnChangeKey4.setBounds(575, 435, 45, 45);
		btnChangeKey4.setForeground(new Color(255, 255, 255));
		btnChangeKey4.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btnChangeKey4.setBackground(Color.BLACK);
		keyPanel.add(btnChangeKey4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/keysettingBG.png")));
		lblNewLabel.setBounds(0, 0, 887, 527);
		keyPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_4_2 = new JLabel("");
		lblNewLabel_4_2.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/settingPNGG.png")));
		lblNewLabel_4_2.setBounds(0, 0, 887, 527);
		keyPanel.add(lblNewLabel_4_2);
		
		JLabel noteSpeedImg = new JLabel("");
		noteSpeedImg.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/10.png")));
		noteSpeedImg.setBounds(506, 239, 45, 45);
		syncPanel.add(noteSpeedImg);
		
		JButton btnSyncUp = new JButton("");

		btnSyncUp.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/settingBtnR.png")));

		btnSyncUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSyncUp.setIcon(new ImageIcon(getClass().getResource("/img/RBtn.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnSyncUp.setIcon(new ImageIcon(getClass().getResource("/img/settingBtnR.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnSyncUp.setIcon(new ImageIcon(getClass().getResource("/img/settingBtnR.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnSyncUp.setIcon(new ImageIcon(getClass().getResource("/img/RBtn.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				speed = speed + 1;
				
				for(int i=1; i<21; i++) {
					if(speed == i) noteSpeedImg.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/" + i +".png")));
				}

			}

		});
		btnSyncUp.setBounds(775, 239, 40, 40);
		syncPanel.add(btnSyncUp);
		
		JButton btnSyncDown = new JButton();
		btnSyncDown.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/settingBtnL.png")));

		btnSyncDown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSyncDown.setIcon(new ImageIcon(getClass().getResource("/img/LBtn.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnSyncDown.setIcon(new ImageIcon(getClass().getResource("/img/settingBtnL.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnSyncDown.setIcon(new ImageIcon(getClass().getResource("/img/settingBtnL.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnSyncDown.setIcon(new ImageIcon(getClass().getResource("/img/LBtn.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				speed = speed - 1;
				
				for(int i=1; i<21; i++) {
					if(speed == i) noteSpeedImg.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/" + i +".png")));
				}
			}
		});

		btnSyncDown.setBounds(270, 239, 40, 40);
		syncPanel.add(btnSyncDown);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("SYNC");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/SyncText.png")));
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(61, 241, 117, 37);
		syncPanel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/settingPNGG.png")));
		lblNewLabel_4_1.setBounds(0, 0, 887, 527);
		syncPanel.add(lblNewLabel_4_1);
		
		JButton btnReset_1 = new JButton("");
		btnReset_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnReset_1.setIcon(new ImageIcon(getClass().getResource("/Img/LResetBtn.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnReset_1.setIcon(new ImageIcon(getClass().getResource("/Img/resetBtn.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnReset_1.setIcon(new ImageIcon(getClass().getResource("/Img/resetBtn.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnReset_1.setIcon(new ImageIcon(getClass().getResource("/Img/LResetBtn.png")));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				 speed = 10;
				 keyType = 1;
				 SoundVolume = 10;
				 KeySoundVolume = 10;
				 SystemSoundVolume = 10;
				 keySoundVolumeImg.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/10.png")));
				 soundVolumeImg.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/10.png")));
				 systemSoundVolumeImg.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/10.png")));
				 noteSpeedImg.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/10.png")));
			}

		});
		btnReset_1.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/resetBtn.png")));
		btnReset_1.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btnReset_1.setBounds(700, 630, 80, 30);
		sg.settingPanel.add(btnReset_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(SelectGame.class.getResource("/Img/settingBG.png")));
		lblNewLabel_3_1.setBounds(0, 0, 1264, 681);
		sg.settingPanel.add(lblNewLabel_3_1);
		
	}
}
