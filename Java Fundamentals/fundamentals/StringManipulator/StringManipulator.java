public class StringManipulator {
    public String trimAndConcat(String a, String b) {
        return a.trim() + b.trim();
    }
    public Integer getIndexOrNull(String word, char letter){
        int index= word.indexOf(letter);
        if (index<0)
            return null;
        return index;
    }
    public Integer getIndexOrNull(String word, String subString){
        int index= word.indexOf(subString);
        if (index<0)
            return null;
        return index;
    }
    public String concatSubstring(String ToSub, int start, int end, String wordToCancat){
        String sub =ToSub.substring(start,end);
        return sub.concat(wordToCancat);
    }
}
