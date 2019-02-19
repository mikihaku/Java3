public class Main {

    int[] getTail(int[] seq) {

        if(seq.length == 0) throw new RuntimeException();

        int i = seq.length - 1;

        while(i != 0 || seq[i] == 4) {

            if(seq[i] == 4) {

                if(i == seq.length - 1) {

                    return new int[]{};

                }

                int[] tail = java.util.Arrays.copyOfRange(seq, i + 1, seq.length);
                return tail;
            }

            i -= 1;
        }

        throw new RuntimeException();

    }

    boolean checkOneFour(int[] seq) {

        if(seq.length < 2) return false;

        boolean hasOne  = false;
        boolean hasFour = false;
        boolean hasElse = false;

        for(int num: seq) {

            if(num == 1)      hasOne = true;
            else if(num == 4) hasFour = true;
            else              hasElse = true;

        }

        if(hasOne && hasFour && !hasElse)
            return true;
        else
            return false;
    }
}
