package cap1_analiseExtratosBancarios.SRP;

import java.time.Month;
import java.util.List;

public class BankStatementProcessor {
	private List<BankTransaction> bankTransactions;

	public BankStatementProcessor(List<BankTransaction> bankTransactions) {
		this.bankTransactions = bankTransactions;
	}

	public double calculateTotalAmount() {
		double total = 0;

		for (BankTransaction bank : bankTransactions) {
			total += bank.getAmount();
		}

		return total;
	}

	public double calculateTotalInMonth(Month mes) {
		double total = 0;

		for (BankTransaction bank : bankTransactions) {
			if (bank.getDate().getMonth() == mes) {
				total += bank.getAmount();
			}
		}
		return total;

	}

	
	public double calculateTotalForCategory(String Categoria) {
		double total = 0;

		for (BankTransaction bank : bankTransactions) {
			if (bank.getDescription().equalsIgnoreCase(Categoria)) {
				total += bank.getAmount();
			}
		}
		return total;
		
	}
	
	
}
