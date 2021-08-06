public class OffByN implements CharacterComparator {

    private int diff;
    public  OffByN(int N){
        diff = N;
    }
    //diff是全局变量

    @Override
    public boolean equalChars(char x, char y){
        if (((int)x - (int)y == diff)||((int)y - (int)x == diff)){
            return true;
        }
        return false;
    }
}
