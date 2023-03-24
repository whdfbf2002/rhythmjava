package rhythmJava;
public class Track {
	
	private String titleName;
	private String titleImage;
	private String selectedImage;
	private String gameImage;
	private String selectedMusic;
	private String gameMusic;
	private String composer;
	private int musicLevel;
	private int musicTime;


	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	
	public String getTitleImage() {
		return titleImage;
	}

	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}

	public String getSelectedImage() {
		return selectedImage;
	}

	public void setSelectedImage(String selectedImage) {
		this.selectedImage = selectedImage;
	}

	public String getGameImage() {
		return gameImage;
	}

	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}

	public String getSelectedMusic() {
		return selectedMusic;
	}

	public void setSelectedMusic(String selectedMusic) {
		this.selectedMusic = selectedMusic;
	}

	public String getGameMusic() {
		return gameMusic;
	}

	public void setGameMusic(String gameMusic) {
		this.gameMusic = gameMusic;
	}
	
	
	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	public int getMusicLevel() {
		return musicLevel;
	}

	public void setMusicLevel(int musicLevel) {
		this.musicLevel = musicLevel;
	}
	
	public int getMusicTime() {
		return musicTime;
	}

	public void setMusicTime(int musicTime) {
		this.musicTime = musicTime;
	}
	
	
	public Track(String titleName, String titleImage, String selectedImage, String gameImage, String selectedMusic, String gameMusic, String composer, int musicLevel, int musicTime) {
		super();
		this.titleName = titleName;
		this.titleImage = titleImage;
		this.selectedImage = selectedImage;
		this.gameImage = gameImage;
		this.selectedMusic = selectedMusic;
		this.gameMusic = gameMusic;
		this.composer = composer;
		this.musicLevel = musicLevel;
		this.musicTime = musicTime;
	}

}