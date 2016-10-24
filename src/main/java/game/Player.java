package game;


public class Player {
    public Cell character;
    public  Player ( Cell character){
        this.character = character;
    }

    public Cell getCharacter() {
        return character;
    }

    public void setCharacter(Cell character) {
        this.character = character;
    }
}
