public class Palindrome {

    public Deque<Character> wordToDeque(String word){
        Deque<Character> d = new LinkedListDeque<>();

        for (int i = 0; i < word.length(); i++) {
             char di = word.charAt(i);
             d.addLast(di);
        }
        return d;
    }

    public boolean isPalindrome(String word){
        Deque d = wordToDeque(word);
        if(d.size() <= 1) { //长度为1或者0的单词都是回文
            return true;
        }
        if(d.removeFirst() == d.removeLast()) {
            String actual = "";
            for (int i = 0; i < d.size(); i++) {
                actual += d.get(i);
            }
            return isPalindrome(actual);
        }
        return false;
     }


    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque d = wordToDeque(word);
        if(d.size() <= 1) { //长度为1或者0的单词都是回文
            return true;
        }

        if(cc.equalChars((char)d.removeFirst(),(char)d.removeLast())) {
            String actual = "";
            for (int i = 0; i < d.size(); i++) {
                actual += d.get(i);
            }
            return isPalindrome(actual, cc);
        }
        return false;

    }
}
