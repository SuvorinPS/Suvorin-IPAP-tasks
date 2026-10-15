package robot;

enum Direction {
    UP,
    RIGHT,
    DOWN,
    LEFT;

    Direction left() {
        return values()[(ordinal() + 3) % 4];
    }

    Direction right() {
        return values()[(ordinal() + 1) % 4];
    }
}