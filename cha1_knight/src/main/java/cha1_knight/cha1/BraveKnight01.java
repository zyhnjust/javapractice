package cha1_knight.cha1;


public class BraveKnight01 implements Knight{

	private RescureDamselQuest quest;
	public BraveKnight01(){
		this.quest = new RescureDamselQuest();
	}
	
	public void embarkOnQuest(){
		quest.embark();
	}
}
