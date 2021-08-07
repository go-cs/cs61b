public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        if (((int) x - (int) y == 1) || ((int) y - (int) x == 1)) {
            return true;
        }
        return false;
    }


}
