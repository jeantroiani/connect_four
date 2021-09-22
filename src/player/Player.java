package player;

public abstract class Player {
    char id;

    public Player(char id) {
        this.id = id;
    }

    public char getId() {
        return id;
    }

    public abstract Integer getPlayerInput();
}
