class Score{
private int Lscore;
private int Rscore;

	public Score(){
		Lscore=0;
		Rscore=0;
	}

	public void rScore(){
		Rscore+=1;
	}
	public void lScore(){
		Lscore+=1;
	}

	public int getRScore(){
		return Rscore;
	}
	public int getLScore(){
		return Lscore;
	}
	public String toString(){
		return "Left:: "+Lscore+ "\nRight:: "+Rscore;
	}
}
