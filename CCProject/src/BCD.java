public class BCD {
    private int[] digits;

    BCD(int bcdDigits) {
        int copyNum = bcdDigits;
        int digit = copyNum % 10;
        copyNum /= 10;
        int[] theArray = {
                digit
        };
        BCD bcd = new BCD(theArray);
        while (copyNum > 0) {
            digit = copyNum % 10;
            bcd.addADigit(digit);
            copyNum /= 10;
        }
        int[] copy = new int[bcd.numberOfDigits()];
        for (int i = 0; i < bcd.numberOfDigits(); i++) {
            copy[i] = bcd.nthDigit(i);
        }
        digits = copy;
    }

    BCD(int[] bcdDigits) {
        int[] copy = new int[bcdDigits.length];
        for (int i = 0; i < bcdDigits.length; i++) {
            copy[i] = bcdDigits[i];
        }
        digits = copy;
    }

    public static void main(String[] args) {
        System.out.println(BCD.factorial(52));
    }

    public static BCD factorial(int num) {
        BCD answerBCD = new BCD(1);
        for (int i = 1; i <= num; i++) {
            answerBCD = answerBCD.multiplyBCDs(new BCD(i));
        }
        return answerBCD;
    }

    public int numberOfDigits() {
        return digits.length;
    }

    public int nthDigit(int n) {
        if (n < digits.length) {
            return digits[n];
        } else {
            return 0;
        }
    }

    public void addADigit(int newDigit) {
        int[] newDigits = new int[digits.length + 1];
        for (int i = 0; i < digits.length; i++) {
            newDigits[i] = digits[i];
        }
        newDigits[digits.length] = newDigit;
        digits = newDigits;
    }

    public String toString() {
        String output = "";
        for (int i = digits.length - 1; i >= 0; i--) {
            output += digits[i];
            if (i % 3 == 0 && i != 0) {
                output += ",";
            }
        }
        return output;
    }

    public BCD addBCDs(BCD other) {
        int[] emptyArray = {};
        BCD sum = new BCD(emptyArray);
        BCD digitBCD = new BCD(digits);
        int carry = 0;
        int maxDigits;
        if (digitBCD.numberOfDigits() > other.numberOfDigits()) {
            maxDigits = digits.length;
        } else {
            maxDigits = other.numberOfDigits();
        }
        for (int digitPos = 0; digitPos < maxDigits; digitPos++) {
            sum.addADigit((carry + digitBCD.nthDigit(digitPos) + other.nthDigit(digitPos)) % 10);
            if (carry + digitBCD.nthDigit(digitPos) + other.nthDigit(digitPos) >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
        }
        if (carry == 1) {
            sum.addADigit(1);
        }
        return sum;
    }

    public BCD multiplyBCDs(BCD other) {
        int[] emptyArray = {};
        BCD digitBCD = new BCD(digits);
        BCD answerBCD = new BCD(emptyArray);
        int[][] productArray = new int[digitBCD.numberOfDigits()][other.numberOfDigits()];
        for (int i = 0; i < digitBCD.numberOfDigits(); i++) {
            for (int j = 0; j < other.numberOfDigits(); j++) {
                productArray[i][j] = digitBCD.nthDigit(i) * other.nthDigit(j);
            }
        }
        int remaining = 0;
        boolean zeroes = true;
        for (int diagSum : addDiagonals(productArray)) {
            diagSum += remaining;
            int ones = diagSum % 10;
            remaining = diagSum / 10;
            answerBCD.addADigit(ones);
            if (ones != 0) {
                zeroes = false;
            }
        }
        while (remaining > 0) {
            int ones = remaining % 10;
            remaining = remaining / 10;
            answerBCD.addADigit(ones);
        }
        if (zeroes) {
            return new BCD(0);
        } else {
            return answerBCD;
        }
    }

    private int[] addDiagonals(int[][] lattice) {
        int height = lattice.length;
        int width = lattice[0].length;
        int diagonals = width + height - 1;
        int[] result = new int[diagonals];
        int diag = diagonals - 1;
        for (int col = width - 1; col >= 0; col--) {
            result[diag] = diagonalSum(lattice, col, height - 1);
            diag--;
        }
        for (int row = height - 2; row >= 0; row--) {
            result[diag] = diagonalSum(lattice, 0, row);
            diag--;
        }
        return result;
    }

    private int diagonalSum(int[][] lattice, int column, int row) {
        int sum = 0;
        for (int i = row; i >= 0 && (column + row - i) < lattice[0].length; i--) {
            sum += lattice[i][column + row - i];
        }
        return sum;
    }

    public BCD pow(int num) {
        BCD answerBCD = new BCD(digits);
        BCD digitBCD = new BCD(digits);
        for (int i = 0; i < num - 1; i++) {
            answerBCD = answerBCD.multiplyBCDs(digitBCD);
        }
        return answerBCD;
    }
}