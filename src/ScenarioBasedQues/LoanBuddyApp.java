package ScenarioBasedQues;

public class LoanBuddyApp {
    public static void main(String[] args) {
        Applicant applicant1 = new Applicant("John Doe", 750, 60000, 250000);
        Applicant applicant2 = new Applicant("Jane Smith", 680, 85000, 150000);

        HomeLoan homeLoan = new HomeLoan(applicant1, 15, 7.5);
        AutoLoan autoLoan = new AutoLoan(applicant2, 5, 9.0);

        System.out.println("Home Loan Approval Status: " + (homeLoan.approveLoan() ? "Approved" : "Rejected"));
        if (homeLoan.approveLoan()) {
            System.out.printf("Home Loan EMI: %.2f\n", homeLoan.calculateEMI());
        }

        System.out.println("Auto Loan Approval Status: " + (autoLoan.approveLoan() ? "Approved" : "Rejected"));
        if (autoLoan.approveLoan()) {
            System.out.printf("Auto Loan EMI: %.2f\n", autoLoan.calculateEMI());
        }
    }
}

interface IApprovable {
    boolean approveLoan();
    double calculateEMI();
}

class Applicant {
    private String name;
    private int creditScore;
    private double income;
    private double loanAmount;

    public Applicant(String name, int creditScore, double income, double loanAmount) {
        this.name = name;
        this.creditScore = creditScore;
        this.income = income;
        this.loanAmount = loanAmount;
    }

    public String getName() {
        return name;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public double getIncome() {
        return income;
    }

    public double getLoanAmount() {
        return loanAmount;
    }
}

abstract class LoanApplication implements IApprovable {
    protected Applicant applicant;
    protected int termInYears;
    protected double interestRate; // annual interest rate in percentage
    protected String loanType;
    protected String loanStatus = "Pending";

    public LoanApplication(Applicant applicant, int termInYears, double interestRate, String loanType) {
        this.applicant = applicant;
        this.termInYears = termInYears;
        this.interestRate = interestRate;
        this.loanType = loanType;
    }

    public String getLoanType() {
        return loanType;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    protected void setLoanStatus(String status) {
        this.loanStatus = status;
    }

    protected boolean basicEligibilityCheck() {
        return applicant.getCreditScore() >= 650 && applicant.getIncome() > 20000;
    }

    protected abstract boolean customEligibilityCheck();

    @Override
    public boolean approveLoan() {
        boolean eligible = basicEligibilityCheck() && customEligibilityCheck();
        setLoanStatus(eligible ? "Approved" : "Rejected");
        return eligible;
    }

    // EMI formula: P × R × (1+R)^N / ((1+R)^N – 1)
    @Override
    public double calculateEMI() {
        double principal = applicant.getLoanAmount();
        double monthlyInterestRate = (interestRate / 100) / 12;
        int months = termInYears * 12;
        double emi = (principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, months)) /
                (Math.pow(1 + monthlyInterestRate, months) - 1);
        return emi;
    }
}

class HomeLoan extends LoanApplication {
    public HomeLoan(Applicant applicant, int termInYears, double interestRate) {
        super(applicant, termInYears, interestRate, "Home Loan");
    }

    @Override
    protected boolean customEligibilityCheck() {
        return applicant.getIncome() > 50000 && applicant.getLoanAmount() <= 500000;
    }

    @Override
    public double calculateEMI() {
        // Slightly discounted interest rate for home loans
        this.interestRate -= 0.5;
        return super.calculateEMI();
    }
}

class AutoLoan extends LoanApplication {
    public AutoLoan(Applicant applicant, int termInYears, double interestRate) {
        super(applicant, termInYears, interestRate, "Auto Loan");
    }

    @Override
    protected boolean customEligibilityCheck() {
        return applicant.getIncome() > 30000 && applicant.getLoanAmount() <= 100000;
    }

    @Override
    public double calculateEMI() {
        // Higher interest rate for auto loans due to higher risk
        this.interestRate += 0.5;
        return super.calculateEMI();
    }
}

