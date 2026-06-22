public class FinancialForecast {

    // calculates future value recursively
    // FV = PV * (1 + rate) after n years
    static double futureValue(double presentValue, double rate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return futureValue(presentValue * (1 + rate), rate, years - 1);
    }

    // memoized version so we dont recalculate
    static double[] memo;

    static double futureValueMemo(double pv, double rate, int years) {
        if (years == 0) return pv;
        if (memo[years] != -1) return memo[years];
        memo[years] = futureValueMemo(pv, rate, years - 1) * (1 + rate);
        return memo[years];
    }

    public static void main(String[] args) {
        double pv = 1000.0;
        double rate = 0.08; // 8% growth rate
        int years = 10;

        System.out.println("Initial investment: $" + pv);
        System.out.println("Growth rate: " + (rate * 100) + "%");
        System.out.println("Years: " + years);

        double fv = futureValue(pv, rate, years);
        System.out.printf("Future Value (recursive): $%.2f%n", fv);

        memo = new double[years + 1];
        for (int i = 0; i <= years; i++) memo[i] = -1;

        double fv2 = futureValueMemo(pv, rate, years);
        System.out.printf("Future Value (memoized): $%.2f%n", fv2);

        System.out.println("\nYear-by-year breakdown:");
        for (int i = 1; i <= years; i++) {
            System.out.printf("Year %d: $%.2f%n", i, futureValue(pv, rate, i));
        }
    }
}
