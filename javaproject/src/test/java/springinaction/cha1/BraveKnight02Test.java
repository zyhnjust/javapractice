package springinaction.cha1;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

public class BraveKnight02Test {

	@Test
	public void knightShouldEmbarkOnQUest() {
		Quest mockQuest = mock(Quest.class);
		BraveKnight02 knight= new BraveKnight02(mockQuest);
		knight.embarkOnQuest();
		verify(mockQuest, times(1)).embark();
	}

}
