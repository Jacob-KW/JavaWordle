
public class Tile {
	char letter;
	int state = 0;
	
	// 0 = not in word
	// 1 = in word but in wrong place
	// 2 = in word in right place
	
	public Tile(char letter, int state) {
		this.letter = letter;
		this.state = state;
	}
}
