package springinaction.cha1;

public class BraveKnight02 implements Knight{

	private Quest quest;
	public BraveKnight02(Quest quest){
		this.quest = quest;
	}
	
	public void embarkOnQuest(){
		quest.embark();
	}
}
// Compare the first one, BraveKnight02 only rely on interface Quest rather than RescureDamselQuest

